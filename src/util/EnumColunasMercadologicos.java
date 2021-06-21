package util;

public enum EnumColunasMercadologicos {
	COD_MERCADOLOGICO1(0, "cod_mercadologico1"),
	MERCADOLOGICO1(1, "mercadologico1"),
	COD_MERCADOLOGICO2(2, "cod_mercadologico2"),
	MERCADOLOGICO2(3, "mercadologico2"),
	COD_MERCADOLOGICO3(4, "cod_mercadologico3"),
	MERCADOLOGICO3(5, "mercadologico3"),
	COD_MERCADOLOGICO4(6, "cod_mercadologico4"),
	MERCADOLOGICO4(7, "mercadologico4"),
	COD_MERCADOLOGICO5(8, "cod_mercadologico5"),
	MERCADOLOGICO5(9, "mercadologico5");

	private int cod;
	private String descricao;

	private EnumColunasMercadologicos() {
	}

	private EnumColunasMercadologicos(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}

	public static EnumColunasMercadologicos toEnum(Integer cod) {

		if (cod == null) {
			return null;
		}
		for (EnumColunasMercadologicos x : EnumColunasMercadologicos.values()) {
			if (cod == (x.getCod())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Id inv�lido: " + cod);
	}
	public static int getTamanho() {
		int valor = 0;
		EnumColunasMercadologicos[] values = EnumColunasMercadologicos.values();
		for (int i = 0; i < values.length; i++) {
			valor = valor + 1;
		}
		return valor;
	}


}
