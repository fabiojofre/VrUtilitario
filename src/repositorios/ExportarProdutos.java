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

import util.EnumColunasProdutos;public class ExportarProdutos {
	// criando arquivo
	private String caminhoArquivo = "C:\\vr\\Produtos.csv";

	public void exportar() throws SQLException, IOException {
		//parametros da consulta
		String loja = "where id_loja = "+AcessoBD.loja;
		String atividade = "where vend.id_situacaocadastro ="+AcessoBD.ativos;
		
		String sql = "with \r\n"
				+ "lj as (select loja.id, f.id_estado from loja join fornecedor f on loja.id_fornecedor = f.id where loja.id = 1),\r\n"
				+ "merc as (\r\n"
				+ "select\r\n"
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
				+ "	nivel = (select valor::integer from public.parametrovalor "+loja+" and id_parametro = 1)\r\n"
				+ ")\r\n"
				+ "select\r\n"
				+ "	p.id,\r\n"
				+ "	to_char(p.datacadastro, 'DD/MM/YYYY') datacadastro,\r\n"
				+ "	ean.codigobarras,\r\n"
				+ "	p.qtdembalagem qtdembalagemcotacao,\r\n"
				+ "	ean.qtdembalagem,\r\n"
				+ "	ean_un.descricao unidade,\r\n"
				+ "	case when p.id_tipoembalagem = 4 or p.pesavel then 'S' else 'N' end balanca,\r\n"
				+ "	p.validade,\r\n"
				+ "	p.descricaocompleta,\r\n"
				+ "	p.descricaoreduzida,\r\n"
				+ "	p.descricaogondola,\r\n"
				+ "	p.margem,\r\n"
				+ "	merc.*,\r\n"
				+ "	p.id_familiaproduto,\r\n"
				+ "	fam.descricao familiaproduto,\r\n"
				+ "	to_char(p.pesobruto, '999999990D00') pesobruto,\r\n"
				+ "	to_char(p.pesoliquido, '999999990D00') pesoliquido,\r\n"
				+ "	to_char(vend.estoquemaximo, '999999990D00') estoquemaximo,\r\n"
				+ "	to_char(vend.estoqueminimo, '999999990D00') estoqueminimo,\r\n"
				+ "	to_char(vend.estoque, '999999990D00') estoque,\r\n"
				+ "	to_char(vend.custosemimposto, '999999990D00') custosemimposto,\r\n"
				+ "	to_char(vend.custocomimposto, '999999990D00') custocomimposto,\r\n"
				+ "	to_char(vend.precovenda, '999999990D00') precovenda,\r\n"
				+ "	case vend.id_situacaocadastro when 1 then 'S' else 'N' end as ativo,\r\n"
				+ "	case when vend.descontinuado then 'S' else 'N' end as descontinuado,\r\n"
				+ "	lpad(p.ncm1::varchar,4,'0') || lpad(p.ncm2::varchar,2,'0') || lpad(p.ncm3::varchar,2,'0') ncm,\r\n"
				+ "	lpad(cest.cest1::varchar,2,'0') || lpad(cest.cest2::varchar,3,'0') || lpad(cest.cest3::varchar,2,'0') cest,\r\n"
				+ "	piscofdeb.cst piscofins_cst_debito,\r\n"
				+ "	piscofcred.cst piscofins_cst_credito,\r\n"
				+ "	p.tiponaturezareceita piscofins_natureza_receita,\r\n"
				+ "	icms.situacaotributaria icms_cst,\r\n"
				+ "	to_char(icms.porcentagem, '999999990D00') icms_aliquota,\r\n"
				+ "	to_char(icms.reduzido, '999999990D00') icms_reduzido,\r\n"
				+ "	case when p.sugestaocotacao then 'S' else 'N' end as sugestaocotacao,\r\n"
				+ "	case when p.sugestaopedido then 'S' else 'N' end as sugestaopedido,\r\n"
				+ "	pad.desconto atacadodesconto\r\n"
				+ "from\r\n"
				+ "	produto p\r\n"
				+ "	join lj on true\r\n"
				+ "	left join produtoautomacao ean on ean.id_produto = p.id\r\n"
				+ "	left join tipoembalagem ean_un on ean_un.id = ean.id_tipoembalagem\r\n"
				+ "	left join merc on\r\n"
				+ "		merc.cod_mercadologico1 = p.mercadologico1 and\r\n"
				+ "		merc.cod_mercadologico2 = p.mercadologico2 and\r\n"
				+ "		merc.cod_mercadologico3 = p.mercadologico3 and\r\n"
				+ "		merc.cod_mercadologico4 = p.mercadologico4 and\r\n"
				+ "		merc.cod_mercadologico5 = p.mercadologico5\r\n"
				+ "	left join familiaproduto fam on p.id_familiaproduto = fam.id\r\n"
				+ "	join produtocomplemento vend on p.id = vend.id_produto and vend.id_loja = lj.id\r\n"
				+ "	left join cest on cest.id = p.id_cest\r\n"
				+ "	left join tipopiscofins piscofcred on \r\n"
				+ "		p.id_tipopiscofinscredito = piscofcred.id\r\n"
				+ "	left join tipopiscofins piscofdeb on \r\n"
				+ "		p.id_tipopiscofins = piscofdeb.id\r\n"
				+ "	join produtoaliquota aliq on p.id = aliq.id_produto and aliq.id_estado = lj.id_estado\r\n"
				+ "	join aliquota icms on icms.id = aliq.id_aliquotadebito\r\n"
				+ "	left join produtoautomacaodesconto pad on pad.codigobarras = ean.codigobarras and pad.id_loja = lj.id\r\n"
				+ atividade
				+ "order by\r\n"
				+ "	p.id;\r\n"
				+ "";
		Statement stm = AcessoBD.conexao.createStatement();
		ResultSet rs = stm.executeQuery(sql);
		

		
		// definir as colunas com a enumeração do select
		String[] colunas = new String[EnumColunasProdutos.getTamanho()];
		for(int i = 0; i< colunas.length; i++) {
			colunas[i] = EnumColunasProdutos.toEnum(i).getDescricao();		
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
