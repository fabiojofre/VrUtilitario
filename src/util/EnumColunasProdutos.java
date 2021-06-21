package util;

public enum EnumColunasProdutos {
	ID(0, "id"), 
	DATACADASTRO(1, "datacadastro"), 
	CODIGOBARRAS(2, "codigobarras"),
	QTDEMBALAGEMCOTACAO(3, "qtdembalagemcotacao"), 
	QTDEMBALAGEM(4, "qtdembalagem"), 
	UNIDADE(5, "unidade"),
	BALANCA(6, "balanca"), 
	VALIDADE(7, "validade"), 
	DESCRICAOCOMPLETA(8, "descricaocompleta"),
	DESCRICAOREDUZIDA(9, "descricaoreduzida"), 
	DESCRICAOGONDOLA(10, "descricaogondola"), 
	MARGEM(11, "margem"),
	COD_MERCADOLOGICO1(12, "cod_mercadologico1"), 
	MERCADOLOGICO1(13, "mercadologico1"),
	COD_MERCADOLOGICO2(14, "cod_mercadologico2"), 
	MERCADOLOGICO2(15, "mercadologico2"),
	COD_MERCADOLOGICO3(16, "cod_mercadologico3"), 
	MERCADOLOGICO3(17, "mercadologico3"),
	COD_MERCADOLOGICO4(18, "cod_mercadologico4"), 
	MERCADOLOGICO4(19, "mercadologico4"),
	COD_MERCADOLOGICO5(20, "cod_mercadologico5"), 
	MERCADOLOGICO5(21, "mercadologico5"),
	ID_FAMILIAPRODUTO(22, "id_familiaproduto"), 
	FAMILIAPRODUTO(23, "familiaproduto"), 
	PESOBRUTO(24, "pesobruto"),
	PESOLIQUIDO(25, "pesoliquido"), 
	ESTOQUEMAXIMO(26, "estoquemaximo"), 
	ESTOQUEMINIMO(27, "estoqueminimo"),
	ESTOQUE(28, "estoque"), 
	CUSTOSEMIMPOSTO(29, "custosemimposto"), 
	CUSTOCOMIMPOSTO(30, "custocomimposto"),
	PRECOVENDA(31, "prcovenda"), 
	ATIVO(32, "ativo"), 
	DESCONTINUADO(33, "descontinuado"), 
	NCM(34, "ncm"),
	CEST(35, "cst"), 
	PISCOFINS_CEST_DEBITO(36, "piscofins_cest_debito"),
	PISCOFINS_CEST_CREDITO(37, "piscofins_cest_credito"), 
	PISCOFINS_NATUREZA_RECEITA(38, "piscofins_natureza_receita"),
	ICMS_CEST(39, "icms_cest"), 
	ICMS_ALIQUOTA(40, "icms_aliquota"), 
	ICMS_REDUZIDO(41, "icms_reduzido"),
	SUGESTAOCOTACAO(42, "sugestaocotacao"), 
	SUGESTAOPEDIDO(43, "sugestaopedido"),
	ATACADODESCONTO(44, "atacadodesconto");

	private int cod;
	private String descricao;

	private EnumColunasProdutos() {
	}

	private EnumColunasProdutos(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}

	public static EnumColunasProdutos toEnum(Integer cod) {

		if (cod == null) {
			return null;
		}
		for (EnumColunasProdutos x : EnumColunasProdutos.values()) {
			if (cod == (x.getCod())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Id inválido: " + cod);
	}

	public static int getTamanho() {
		int valor = 0;
		EnumColunasProdutos[] values = EnumColunasProdutos.values();
		for (int i = 0; i < values.length; i++) {
			valor = valor + 1;
		}
		return valor;
	}
}
