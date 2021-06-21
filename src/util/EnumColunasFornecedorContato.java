package util;

public enum EnumColunasFornecedorContato {
	ID(0, "id"), 
	CONT1_NOME(1, "cont1_nome"),
	CONT1_TELEFONE(2, "cont1_telefone"),
	CONT1_EMAIL(3, "cont1_email"),
	CONT1_TIPO(4, "cont1_tipo");

	private int cod;
	private String descricao;

	private EnumColunasFornecedorContato() {
	}

	private EnumColunasFornecedorContato(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}

	public static EnumColunasFornecedorContato toEnum(Integer cod) {

		if (cod == null) {
			return null;
		}
		for (EnumColunasFornecedorContato x : EnumColunasFornecedorContato.values()) {
			if (cod == (x.getCod())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Id inv�lido: " + cod);
	}
	public static int getTamanho() {
		int valor = 0;
		EnumColunasFornecedorContato[] values = EnumColunasFornecedorContato.values();
		for (int i = 0; i < values.length; i++) {
			valor = valor + 1;
		}
		return valor;
	}

}
