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

import util.EnumColunasClientePreferencial;

public class ExportarClientePreferencial {
	// criando arquivo
	private String caminhoArquivo = "C:\\vr\\ClientePreferencial.csv";
	
	

	public void exportar() throws SQLException, IOException {
		String sql = "select\r\n"
				+ "	c.id id,\r\n"
				+ "	c.cnpj,\r\n"
				+ "	c.inscricaoestadual,\r\n"
				+ "	c.orgaoemissor,\r\n"
				+ "	c.nome razao,\r\n"
				+ "	c.nome fantasia,\r\n"
				+ "	case c.id_situacaocadastro when 1 then 'S' else 'N' end ativo,\r\n"
				+ "	case when c.bloqueado then 'S' else 'N' end bloqueado,\r\n"
				+ "	to_char(c.datarestricao, 'DD/MM/YYYY') databloqueio,\r\n"
				+ "	c.endereco,\r\n"
				+ "	c.numero,\r\n"
				+ "	c.complemento,\r\n"
				+ "	c.bairro,\r\n"
				+ "	c.id_municipio municipioIBGE,\r\n"
				+ "	mun.descricao municipio,\r\n"
				+ "	c.id_estado ufIBGE,\r\n"
				+ "	est.sigla uf,\r\n"
				+ "	c.cep,\r\n"
				+ "	coalesce(substring(civil.descricao,1,3), 'NAO') estadocivil,\r\n"
				+ "	to_char(c.datanascimento, 'DD/MM/YYYY') datanascimento,\r\n"
				+ "	to_char(c.datacadastro, 'DD/MM/YYYY') datacadastro,\r\n"
				+ "	case c.sexo when 0 then 'F' else 'M' end sexo,\r\n"
				+ "	c.empresa,\r\n"
				+ "	c.enderecoempresa empresaendereco,\r\n"
				+ "	c.numeroempresa empresanumero,\r\n"
				+ "	c.complementoempresa empresacomplemento,\r\n"
				+ "	c.bairroempresa empresabairro,\r\n"
				+ "	c.id_municipioempresa empresamunicipioIBGE,\r\n"
				+ "	mun_emp.descricao empresamunicipio,\r\n"
				+ "	c.id_estadoempresa empresaufIBGE,\r\n"
				+ "	est_emp.sigla empresauf,\r\n"
				+ "	c.cepempresa empresacep,\r\n"
				+ "	c.telefoneempresa empresatelefone,\r\n"
				+ "	to_char(c.dataadmissao, 'DD/MM/YYYY') dataadmissao,\r\n"
				+ "	c.cargo,\r\n"
				+ "	to_char(c.salario, '999999990D00') salario,\r\n"
				+ "	to_char(c.valorlimite, '999999990D00') valorlimite,\r\n"
				+ "	c.nomeconjuge,\r\n"
				+ "	c.nomepai,\r\n"
				+ "	c.nomemae,\r\n"
				+ "	regexp_replace(c.observacao2,'[\\\\n\\\\r]+',' ','g') observacao,\r\n"
				+ "	c.vencimentocreditorotativo diavencimento,\r\n"
				+ "	case when c.permitecreditorotativo then 'S' else 'N' end permitecreditorotativo,\r\n"
				+ "	case when c.permitecheque then 'S' else 'N' end permitecheque,	\r\n"
				+ "	c.telefone,\r\n"
				+ "	c.celular,\r\n"
				+ "	c.email,\r\n"
				+ "	null fax,\r\n"
				+ "	c.telefone cobrancaTelefone,\r\n"
				+ "	0 prazopagamento,\r\n"
				+ "	c.endereco cobrancaendereco,\r\n"
				+ "	c.numero cobrancanumero,\r\n"
				+ "	c.complemento cobrancacomplemento,\r\n"
				+ "	c.bairro cobrancabairro,\r\n"
				+ "	c.id_municipio cobrancamunicipioibge,\r\n"
				+ "	mun.descricao cobrancamunicipio,\r\n"
				+ "	c.id_estado cobrancaufibge,\r\n"
				+ "	est.sigla cobrancauf,\r\n"
				+ "	c.cep cobrancacep,\r\n"
				+ "	'NENHUM'::varchar tipoorgaopublico,\r\n"
				+ "	0 limitecompra,\r\n"
				+ "	''::varchar inscricaomunicipal,\r\n"
				+ "	'NAO CONTRIBUINTE'::varchar tipoindicadorie,\r\n"
				+ "	contatos.*	\r\n"
				+ "from \r\n"
				+ "	clientepreferencial c\r\n"
				+ "	left join municipio mun on\r\n"
				+ "		c.id_municipio = mun.id\r\n"
				+ "	left join estado est on\r\n"
				+ "		c.id_estado = est.id\r\n"
				+ "	left join municipio mun_emp on\r\n"
				+ "		c.id_municipioempresa = mun_emp.id\r\n"
				+ "	left join estado est_emp on\r\n"
				+ "		c.id_estadoempresa = est_emp.id\r\n"
				+ "	left join tipoestadocivil civil on\r\n"
				+ "		c.id_tipoestadocivil = civil.id\r\n"
				+ "	left join clientepreferencialcontato contatos on\r\n"
				+ "		c.id = contatos.id_clientepreferencial\r\n"
				+ "order by\r\n"
				+ "	c.id";
                
		Statement stm = AcessoBD.conexao.createStatement();
		ResultSet rs = stm.executeQuery(sql);


		
		// definir as colunas com a enumera��o do select
		String[] colunas = new String[EnumColunasClientePreferencial.getTamanho()];
		for(int i = 0; i< colunas.length; i++) {
			colunas[i] = EnumColunasClientePreferencial.toEnum(i).getDescricao();		
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
