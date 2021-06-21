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

import util.EnumColunasFornecedor;

public class ExportarFornecedor {
	// criando arquivo
	private String caminhoArquivo = "C:\\vr\\Fornecedor.csv";
	
	public void exportar() throws SQLException, IOException {
		String sql = "select\r\n"
				+ "	f.id,\r\n"
				+ "	f.razaosocial razao,\r\n"
				+ "	f.nomefantasia fantasia,\r\n"
				+ "	f.cnpj cnpj_cpf,\r\n"
				+ "	f.inscricaoestadual ie_rg,\r\n"
				+ "	f.inscricaomunicipal insc_municipal,\r\n"
				+ "	f.inscricaosuframa suframa,\r\n"
				+ "	case f.id_situacaocadastro when 1 then 'S' else 'N' end ativo,\r\n"
				+ "	f.endereco,\r\n"
				+ "	f.numero,\r\n"
				+ "	f.complemento,\r\n"
				+ "	f.bairro,\r\n"
				+ "	f.id_municipio ibge_municipio,\r\n"
				+ "	m.descricao municipio,\r\n"
				+ "	f.id_estado ibge_uf,\r\n"
				+ "	e.sigla uf,\r\n"
				+ "	f.cep,\r\n"
				+ "	f.enderecocobranca cob_endereco,\r\n"
				+ "	f.numerocobranca cob_numero,\r\n"
				+ "	f.complementocobranca cob_complemento,\r\n"
				+ "	f.bairrocobranca cob_bairro,\r\n"
				+ "	f.id_municipiocobranca cob_ibge_municipio,\r\n"
				+ "	cm.descricao cob_municipio,\r\n"
				+ "	f.id_estadocobranca cob_ibge_uf,\r\n"
				+ "	ce.sigla cob_uf,\r\n"
				+ "	f.cepcobranca cob_cep,		\r\n"
				+ "	f.telefone tel_principal,\r\n"
				+ "	to_char(f.pedidominimoqtd, '999999990D00') qtd_minima_pedido,\r\n"
				+ "	to_char(f.pedidominimovalor, '999999990D00') valor_minimo_pedido,\r\n"
				+ "	to_char(f.datacadastro, 'DD/MM/YYYY') datacadastro,\r\n"
				+ "	f.observacao\r\n"
				+ "from \r\n"
				+ "	fornecedor f\r\n"
				+ "	left join municipio m on f.id_municipio = m.id\r\n"
				+ "	left join estado e on f.id_estado = e.id\r\n"
				+ "	left join municipio cm on f.id_municipiocobranca = cm.id\r\n"
				+ "	left join estado ce on f.id_estadocobranca = ce.id\r\n"
				+ "order by id";
		Statement stm = AcessoBD.conexao.createStatement();
		ResultSet rs = stm.executeQuery(sql);
		
		// definir as colunas com a enumera��o do select
		String[] colunas = new String[EnumColunasFornecedor.getTamanho()];
		for(int i = 0; i< colunas.length; i++) {
			colunas[i] = EnumColunasFornecedor.toEnum(i).getDescricao();		
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
