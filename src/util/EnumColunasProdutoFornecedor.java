package util;

public enum EnumColunasProdutoFornecedor {
	ID_FORNECEDOR(0, "id_fornecedor"), 
	ID_PRODUTO(1, "id_produto"),
	CODIGOEXTERNO(2, "codigoexterno"),
	QTDEMBALAGEM(3, "qtdembalagem"),
	DATAALTERACAO(4, "dataalteracao"),
	PESOEMBALAGEM(5, "pesoembalagem");

	private int cod;
	private String descricao;

	private EnumColunasProdutoFornecedor() {
	}

	private EnumColunasProdutoFornecedor(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}

	public static EnumColunasProdutoFornecedor toEnum(Integer cod) {

		if (cod == null) {
			return null;
		}
		for (EnumColunasProdutoFornecedor x : EnumColunasProdutoFornecedor.values()) {
			if (cod == (x.getCod())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Id inv�lido: " + cod);
	}
	public static int getTamanho() {
		int valor = 0;
		EnumColunasProdutoFornecedor[] values = EnumColunasProdutoFornecedor.values();
		for (int i = 0; i < values.length; i++) {
			valor = valor + 1;
		}
		return valor;
	}

}
