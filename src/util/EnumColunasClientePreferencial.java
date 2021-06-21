package util;

public enum EnumColunasClientePreferencial {
	ID(0, "id"), CNPJ(1, "cnpj"), INSCRICAOESTADUAL(2, "inscricaoestadual"), ORGAOEMISSOR(3, "orgaoemissor"),
	RAZAO(4, "razao"), FANTASIA(5, "fantasia"), ATIVO(6, "ativo"), BLOQUEADO(7, "bloqueado"),
	DATABLOQUEADO(8, "databloqueado"), ENDERECO(9, "endereco"), NUMERO(10, "numero"), COMPLEMENTO(11, "complemento"),
	BAIRRO(12, "bairro"), MUNICIPIOIBGE(13, "municipioibge"), MUNICIPIO(14, "municipio"), UFIBGE(15, "ufibge"),
	UF(16, "uf"), CEP(17, "cep"), ESTADOCIVIL(18, "estadocivil"), DATANASCIMENTO(19, "datanascimento"),
	DATACADASTRO(20, "datacadastro"), SEXO(21, "sexo"), EMPRESA(22, "empresa"), EMPRESAENDERECO(23, "enpresaendereco"),
	EMPRESANUMERO(24, "empresanumero"), EMPRESACOMPLEMENTO(25, "empresacomplemento"),
	EMPRESABAIRRO(26, "empresabairro"), EMPRESAMUNICIPIOIBGE(27, "empresamunicipioibge"),
	EMPRESAMUNICIPIO(28, "empresamunicipio"), EMPRESAUFIBGE(29, "empresaufibge"), EMPRESAUF(30, "empresauf"),
	EMPRESACEP(31, "empresacep"), EMPRESATELEFONE(32, "empresatelefone"), DATAADMISSAO(33, "dataadmissao"),
	CARGO(34, "cargo"), SALARIO(35, "salario"), VALORLIMITE(36, "valorlimite"), NOMECONJUGE(37, "nomeconjuge"),
	NOMEPAI(38, "nomepai"), NOMEMAE(39, "nomemae"), OBSERVACAO(40, "observacao"), DIAVENCIMENTO(41, "diavencimento"),
	PERMITECREDITOROTATIVO(42, "permitecreditorotativo"), PERMITECHEQUE(43, "permitecheque"), TELEFONE(44, "telefone"),
	CELULAR(45, "celular"), EMAIL(46, "email"), FAX(47, "fax"), COBRANCATELEFONE(48, "cobrancatelefone"),
	PRAZOPAGAMENTO(49, "prazopagamento"), COBRANCAENDERECO(50, "cobrancaendereco"),
	COBRANCANUMERO(51, "cobrancanumero"), COBRANCACOMPLEMENTO(52, "cobrancacomplemento"),
	COBRANCABAIRRO(53, "cobrancabairro"), COBRANCAMUNICIPIOIBGE(54, "cobrancamunicipioibge"),
	COBRANCAMUNICIPIO(55, "cobrancamunicipio"), COBRANCAUFIBGE(56, "cobrancaufibge"), COBRANCAUF(57, "cobrancauf"),
	COBRANCACEP(58, "cobrancacep"), TIPOORGAOPUBLICO(59, "tipoorgaopublico"), LIMITECOMPRA(60, "limitecompra"),
	INSCRICAOMUNICIPAL(61, "inscricaomunicipal"), TIPOINDICADORIE(62, "tipoindicadorie"), ID_CLIENTE(63, "id_cliente");

	private int cod;
	private String descricao;

	private EnumColunasClientePreferencial() {
	}

	private EnumColunasClientePreferencial(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}

	public static EnumColunasClientePreferencial toEnum(Integer cod) {

		if (cod == null) {
			return null;
		}
		for (EnumColunasClientePreferencial x : EnumColunasClientePreferencial.values()) {
			if (cod == (x.getCod())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Id inv�lido: " + cod);
	}

	public static int getTamanho() {
		int valor = 0;
		EnumColunasClientePreferencial[] values = EnumColunasClientePreferencial.values();
		for (int i = 0; i < values.length; i++) {
			valor = valor + 1;
		}
		return valor;
	}

}
