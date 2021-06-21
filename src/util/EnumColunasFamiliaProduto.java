package util;

public enum EnumColunasFamiliaProduto {
	ID_FAMILIAPRODUTO(0, "id_familiaproduto"), 
	FAMILIAPRODUTO(1, "familiaproduto"),
	FAMILIAATIVO(2, "familiaativo");
	
	private int cod;
	private String descricao;

	private EnumColunasFamiliaProduto() {
	}

	private EnumColunasFamiliaProduto(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}

	public static EnumColunasFamiliaProduto toEnum(Integer cod) {

		if (cod == null) {
			return null;
		}
		for (EnumColunasFamiliaProduto x : EnumColunasFamiliaProduto.values()) {
			if (cod == (x.getCod())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Id inv�lido: " + cod);
	}
	public static int getTamanho() {
		int valor = 0;
		EnumColunasFamiliaProduto[] values = EnumColunasFamiliaProduto.values();
		for (int i = 0; i < values.length; i++) {
			valor = valor + 1;
		}
		return valor;
	}
}
