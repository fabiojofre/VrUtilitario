package util;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

public class RetornaDatas {
	private Date date = new Date();
	private Calendar c = Calendar.getInstance();
	private DateFormat df = DateFormat.getDateInstance();


	public boolean retornaVencido(String dataIni) {
		try {
			Date vence = df.parse(dataIni);
			if (vence.before(date)) {
				System.out.println("Vencido!!!");
				return true;
			} else
				System.out.println("Normal");
			return false;
		} catch (ParseException erro) {

		}
		return false;
	}

	public boolean retornaAniversarianteSemana(String dataIni, int semana) {
		try {
			Date niver = df.parse(dataIni);
			Calendar cal = Calendar.getInstance();
			cal.setTime(niver);
			if (c.get(Calendar.WEEK_OF_YEAR) == (cal.get(Calendar.WEEK_OF_YEAR)+semana)) {
				System.out.println("Aniversariante da Semana");
				return true;
			} else
				System.out.println("N�o aniversaria");
			return false;
		} catch (ParseException erro) {

		}
		return false;
	}

	public boolean retornaAniversarianteDia(String dataIni,int dia) {
		try {
			Date niver = df.parse(dataIni);
			Calendar cal = Calendar.getInstance();
			cal.setTime(niver);
			if (c.get(Calendar.DAY_OF_YEAR) == (cal.get(Calendar.DAY_OF_YEAR)+dia)) {
				System.out.println("Aniversariante do Dia");
				return true;
			} else
				System.out.println("N�o aniversaria");
			return false;
		} catch (ParseException erro) {

		}
		return false;
	}

	public boolean retornaAniversarianteMes(String dataIni, int mes) {
		try {
			Date niver = df.parse(dataIni);
			Calendar cal = Calendar.getInstance();
			cal.setTime(niver);
			if (c.get(Calendar.MONTH) == (cal.get(Calendar.MONTH)+mes)) {
				System.out.println("Aniversariante do m�s");
				return true;
			} else
				System.out.println("N�o aniversaria");
			return false;
		} catch (ParseException erro) {

		}
		return false;
	}
}
