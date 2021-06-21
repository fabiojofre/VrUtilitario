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

import util.EnumColunasCreditoRotativo;

public class ExportarCreditoRotativo {
	// criando arquivo
	private String caminhoArquivo = "C:\\vr\\CreditoRotativo.csv";

	public void exportar() throws SQLException, IOException {
		String sql = "select\n" +
"	c.id id,\n" +
"	c.cnpj,\n" +
"	c.inscricaoestadual,\n" +
"	c.orgaoemissor,\n" +
"	c.nome razao,\n" +
"	c.nome fantasia,\n" +
"	case c.id_situacaocadastro when 1 then 'S' else 'N' end ativo,\n" +
"	case when c.bloqueado then 'S' else 'N' end bloqueado,\n" +
"	to_char(c.datarestricao, 'DD/MM/YYYY') databloqueio,\n" +
"	c.endereco,\n" +
"	c.numero,\n" +
"	c.complemento,\n" +
"	c.bairro,\n" +
"	c.id_municipio municipioIBGE,\n" +
"	mun.descricao municipio,\n" +
"	c.id_estado ufIBGE,\n" +
"	est.sigla uf,\n" +
"	c.cep,\n" +
"	coalesce(substring(civil.descricao,1,3), 'NAO') estadocivil,\n" +
"	to_char(c.datanascimento, 'DD/MM/YYYY') datanascimento,\n" +
"	to_char(c.datacadastro, 'DD/MM/YYYY') datacadastro,\n" +
"	case c.sexo when 0 then 'F' else 'M' end sexo,\n" +
"	c.empresa,\n" +
"	c.enderecoempresa empresaendereco,\n" +
"	c.numeroempresa empresanumero,\n" +
"	c.complementoempresa empresacomplemento,\n" +
"	c.bairroempresa empresabairro,\n" +
"	c.id_municipioempresa empresamunicipioIBGE,\n" +
"	mun_emp.descricao empresamunicipio,\n" +
"	c.id_estadoempresa empresaufIBGE,\n" +
"	est_emp.sigla empresauf,\n" +
"	c.cepempresa empresacep,\n" +
"	c.telefoneempresa empresatelefone,\n" +
"	to_char(c.dataadmissao, 'DD/MM/YYYY') dataadmissao,\n" +
"	c.cargo,\n" +
"	to_char(c.salario, '999999990D00') salario,\n" +
"	to_char(c.valorlimite, '999999990D00') valorlimite,\n" +
"	c.nomeconjuge,\n" +
"	c.nomepai,\n" +
"	c.nomemae,\n" +
"	regexp_replace(c.observacao2,'[\\\\n\\\\r]+',' ','g') observacao,\n" +
"	c.vencimentocreditorotativo diavencimento,\n" +
"	case when c.permitecreditorotativo then 'S' else 'N' end permitecreditorotativo,\n" +
"	case when c.permitecheque then 'S' else 'N' end permitecheque,	\n" +
"	c.telefone,\n" +
"	c.celular,\n" +
"	c.email,\n" +
"	null fax,\n" +
"	c.telefone cobrancaTelefone,\n" +
"	0 prazopagamento,\n" +
"	c.endereco cobrancaendereco,\n" +
"	c.numero cobrancanumero,\n" +
"	c.complemento cobrancacomplemento,\n" +
"	c.bairro cobrancabairro,\n" +
"	c.id_municipio cobrancamunicipioibge,\n" +
"	mun.descricao cobrancamunicipio,\n" +
"	c.id_estado cobrancaufibge,\n" +
"	est.sigla cobrancauf,\n" +
"	c.cep cobrancacep,\n" +
"	'NENHUM'::varchar tipoorgaopublico,\n" +
"	0 limitecompra,\n" +
"	''::varchar inscricaomunicipal,\n" +
"	'NAO CONTRIBUINTE'::varchar tipoindicadorie,\n" +
"	contatos.*	\n" +
"from \n" +
"	clientepreferencial c\n" +
"	left join municipio mun on\n" +
"		c.id_municipio = mun.id\n" +
"	left join estado est on\n" +
"		c.id_estado = est.id\n" +
"	left join municipio mun_emp on\n" +
"		c.id_municipioempresa = mun_emp.id\n" +
"	left join estado est_emp on\n" +
"		c.id_estadoempresa = est_emp.id\n" +
"	left join tipoestadocivil civil on\n" +
"		c.id_tipoestadocivil = civil.id\n" +
"	left join clientepreferencialcontato contatos on\n" +
"		c.id = contatos.id_clientepreferencial\n" +
"order by\n" +
"	c.id";
		Statement stm = AcessoBD.conexao.createStatement();
		ResultSet rs = stm.executeQuery(sql);


		
		// definir as colunas com a enumera��o do select
		String[] colunas = new String[EnumColunasCreditoRotativo.getTamanho()];
		for(int i = 0; i< colunas.length; i++) {
			colunas[i] = EnumColunasCreditoRotativo.toEnum(i).getDescricao();		
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
