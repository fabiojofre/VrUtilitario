package util;

public enum EnumColunasCreditoRotativo {
	ID(0, "id"), CNPJ(1, "cnpj"), EMISSAO(2, "emissao"), VENCIMENTO(3, "vencimento"), ECF(4, "ecf"),
	IDCLIENTE(5, "idcliente"), JUROS(6, "juros"), MULTA(7, "multa"), CUPOM(8, "cupom"), OBSERVACAO(9, "observacao"),
	PARCELA(10, "parcela"), VALOR(11, "valor"), SITUACAOROTATIVO(12, "situacaorotativo"), TOTALPAGO(13, "totalpago");

	private int cod;
	private String descricao;

	private EnumColunasCreditoRotativo() {
	}

	private EnumColunasCreditoRotativo(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}

	public static EnumColunasCreditoRotativo toEnum(Integer cod) {

		if (cod == null) {
			return null;
		}
		for (EnumColunasCreditoRotativo x : EnumColunasCreditoRotativo.values()) {
			if (cod == (x.getCod())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Id inv�lido: " + cod);
	}

	public static int getTamanho() {
		int valor = 0;
		EnumColunasCreditoRotativo[] values = EnumColunasCreditoRotativo.values();
		for (int i = 0; i < values.length; i++) {
			valor = valor + 1;
		}
		return valor;
	}
}
