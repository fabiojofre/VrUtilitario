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

import util.EnumColunasMercadologicos;

public class ExportarMercadologico {
	// criando arquivo
	private String caminhoArquivo = "C:\\vr\\Mercadologico.csv";
	
	

	public void exportar() throws SQLException, IOException {
		String sql = "select\r\n"
				+ "	m.mercadologico1 cod_mercadologico1,\r\n"
				+ "	(select descricao from mercadologico where mercadologico1 = m.mercadologico1 and nivel = 1) mercadologico1,\r\n"
				+ "	m.mercadologico2 cod_mercadologico2,\r\n"
				+ "	(select descricao from mercadologico where mercadologico1 = m.mercadologico1 and mercadologico2 = m.mercadologico2 and nivel = 2) mercadologico2,\r\n"
				+ "	m.mercadologico3 cod_mercadologico3,\r\n"
				+ "	(select descricao from mercadologico where mercadologico1 = m.mercadologico1 and mercadologico2 = m.mercadologico2 and mercadologico3 = m.mercadologico3 and nivel = 3) mercadologico3,\r\n"
				+ "	m.mercadologico4 cod_mercadologico4,\r\n"
				+ "	(select descricao from mercadologico where mercadologico1 = m.mercadologico1 and mercadologico2 = m.mercadologico2 and mercadologico3 = m.mercadologico3 and mercadologico4 = m.mercadologico4 and nivel = 4) mercadologico4,\r\n"
				+ "	m.mercadologico5 cod_mercadologico5,\r\n"
				+ "	(select descricao from mercadologico where mercadologico1 = m.mercadologico1 and mercadologico2 = m.mercadologico2 and mercadologico3 = m.mercadologico3 and mercadologico4 = m.mercadologico4 and mercadologico5 = m.mercadologico5 and nivel = 5) mercadologico5\r\n"
				+ "from\r\n"
				+ "	mercadologico m\r\n"
				+ "where \r\n"
				+ "	nivel = (select valor::integer from public.parametrovalor where id_loja = 1 and id_parametro = 1)\r\n"
				+ "order by\r\n"
				+ "	1,3,5,7,9";
		Statement stm = AcessoBD.conexao.createStatement();
		ResultSet rs = stm.executeQuery(sql);
		

		
		// definir as colunas com a enumera��o do select
		String[] colunas = new String[EnumColunasMercadologicos.getTamanho()];
		for(int i = 0; i< colunas.length; i++) {
			colunas[i] = EnumColunasMercadologicos.toEnum(i).getDescricao();		
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
