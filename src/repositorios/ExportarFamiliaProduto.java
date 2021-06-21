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

import util.EnumColunasFamiliaProduto;

public class ExportarFamiliaProduto {
	// criando arquivo
	private String caminhoArquivo = "C:\\vr\\FamiliaProduto.csv";
	

	public void exportar() throws SQLException, IOException {
		String sql = "select	\r\n"
				+ "	id id_familiaproduto,\r\n"
				+ "	descricao familiaproduto,\r\n"
				+ "	case id_situacaocadastro when 0 then 'N' else 'S' end familiaativo\r\n"
				+ "from\r\n"
				+ "	familiaproduto\r\n"
				+ "order by\r\n"
				+ "	1";
		
		Statement stm = AcessoBD.conexao.createStatement();
		ResultSet rs = stm.executeQuery(sql);
		
		
		// definir as colunas com a enumera��o do select
		String[] colunas = new String[EnumColunasFamiliaProduto.getTamanho()];
		for(int i = 0; i< colunas.length; i++) {
			colunas[i] = EnumColunasFamiliaProduto.toEnum(i).getDescricao();		
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
