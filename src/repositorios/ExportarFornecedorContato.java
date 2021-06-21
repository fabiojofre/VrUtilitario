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
import util.EnumColunasFornecedorContato;


public class ExportarFornecedorContato {
	// criando arquivo
	private String caminhoArquivo = "C:\\vr\\FornecedorContato.csv";
	
	

	public void exportar() throws SQLException, IOException {
		String sql = "select\r\n"
				+ "	f.id_fornecedor id,\r\n"
				+ "	f.nome cont1_nome,\r\n"
				+ "	f.telefone cont1_telefone,\r\n"
				+ "	f.celular cont1_celular,\r\n"
				+ "	f.email cont1_email,\r\n"
				+ "	t.descricao cont1_tipo\r\n"
				+ "from\r\n"
				+ "	fornecedorcontato f\r\n"
				+ "	join tipocontato t on\r\n"
				+ "		f.id_tipocontato = t.id\r\n"
				+ "order by\r\n"
				+ "	f.id_fornecedor,\r\n"
				+ "	f.nome \r\n"
				+ "";
		Statement stm = AcessoBD.conexao.createStatement();
		ResultSet rs = stm.executeQuery(sql);
		


		
		// definir as colunas com a enumera��o do select
		String[] colunas = new String[EnumColunasFornecedorContato.getTamanho()];
		for(int i = 0; i< colunas.length; i++) {
			colunas[i] = EnumColunasFornecedorContato.toEnum(i).getDescricao();		
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
