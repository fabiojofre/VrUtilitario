package repositorios;

import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVWriter;

import util.EnumColunasProdutoFornecedor;

public class ExportarProdutoFornecedor {
	// criando arquivo
	private String caminhoArquivo = "C:\\vr\\ProdutoFornecedor.csv";
	

	public void exportar() throws SQLException, IOException {
		String atividade;
		if(AcessoBD.ativos == 'S') {
			atividade = "join produtocomplemento pc on pf.id_produto = pc.id_produto\r\n"
					+ "	where pc.id_situacaocadastro = 1 and pc.id_loja = "+AcessoBD.loja;
		}else atividade = "";
		
		String sql = "select\r\n"
				+ "	pf.id_fornecedor,\r\n"
				+ "	pf.id_produto,\r\n"
				+ "	pf.codigoexterno,\r\n"
				+ "	pf.qtdembalagem,\r\n"
				+ "	to_char(pf.dataalteracao, 'DD/MM/YYYY') dataalteracao,\r\n"
				+ "	to_char(pf.pesoembalagem, '999999990D0000') pesoembalagem\r\n"
				+ "from\r\n"
				+ "	produtofornecedor pf\r\n"
				+ atividade
				+ "order by\r\n"
				+ "	id_fornecedor,\r\n"
				+ "	id_produto,\r\n"
				+ "	codigoexterno";
		Statement stm = AcessoBD.conexao.createStatement();
		ResultSet rs = stm.executeQuery(sql);
		
		// definir as colunas com a enumera��o do select
		String[] colunas = new String[EnumColunasProdutoFornecedor.getTamanho()];
		for(int i = 0; i< colunas.length; i++) {
			colunas[i] = EnumColunasProdutoFornecedor.toEnum(i).getDescricao();		
		}
		

		List<String[]> linhas = new ArrayList<>();
		while (rs.next()) {
			//povoando as linhas com os dados do banco
			String[] linha = new String[colunas.length];
			for(int i =1; i< colunas.length; i++) {
				linha[i]= rs.getString(i);
			}
			linhas.add(linha);

		}
		Writer writer = Files.newBufferedWriter(Paths.get(caminhoArquivo));
        try (CSVWriter csvWriter = new CSVWriter(writer)) {
			csvWriter.writeNext(colunas);
			csvWriter.writeAll(linhas);

			csvWriter.flush();
		}

        writer.close();
	}

}
