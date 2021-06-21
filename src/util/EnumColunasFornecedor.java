package util;

public enum EnumColunasFornecedor {
	ID(0, "id"), 
	RAZAO(1, "razao"),
	FANTASIA(2, "fantasia"),
	CNPJ_CPF(3, "cnpj_cpf"),
	IE_RG(4, "ie_rg"),
	INSC_MUNICIPAL(5, "insc_municipal"),
	SUFRAMA(6, "suframa"),
	ATIVO(7,"ativo"),
	ENDERECO(8, "enderedo"),
	NUMERO(9, "numero"),
	COMPLEMENTO(10, "complemento"),
	BAIRRO(11, "bairro"),
	IBGE_MUNICIPIO(12, "ibge_municipio"),
	MUNICIPIO(13, "municipio"),
	IBGE_UF(14, "ibge_uf"),
	UF(15,"uf"),
	CEP(16, "cep"),
	COB_ENDERECO(17, "cob_endereco"),
	COB_NUMERO(18, "cob_numero"),
	COB_COMPLEMENTO(19, "cob_complemento"),
	COB_BAIRRO(20, "cob_bairro"),
	COB_IBGE_MUNICIPIO(21, "cob_ibge_municipio"),
	COB_MUNICIPIO(22, "cob_municipio"),
	COB_IBGE_UF(23, "cob_ibge_uf"),
	COB_UF(24, "cob_uf"),
	COB_CEP(25, "cob_cep"),
	TEL_PRINCIPAL(26, "tel_principal"),
	QTD_MINIMA_PEDIDO(27, "qtd_minima_pedido"),
	VALOR_MINIMO_PEDIDO(28, "valor_minimo_pedido"),
	DATACADASTRO(29, "datacadastro"),
	OBSERVACAO(30, "observacao");
	

	private int cod;
	private String descricao;

	private EnumColunasFornecedor() {
	}

	private EnumColunasFornecedor(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}

	public static EnumColunasFornecedor toEnum(Integer cod) {

		if (cod == null) {
			return null;
		}
		for (EnumColunasFornecedor x : EnumColunasFornecedor.values()) {
			if (cod == (x.getCod())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Id inv�lido: " + cod);
	}
	public static int getTamanho() {
		int valor = 0;
		EnumColunasFornecedor[] values = EnumColunasFornecedor.values();
		for (int i = 0; i < values.length; i++) {
			valor = valor + 1;
		}
		return valor;
	}

}
