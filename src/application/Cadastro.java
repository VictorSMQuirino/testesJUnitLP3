package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.InputMismatchException;

public class Cadastro {
	String nome, cpf, rg, endereco;
	Date dataDeNascimento;
	int idade;
	String telefone, matricula, sexo, reservista = null;

	static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public static void main(String[] args) {
		Cadastro c = new Cadastro();
//		System.out.println(c.validaNome(""));
		
		sdf.setLenient(false);
		try {
			Date data2 = sdf.parse("34/06/1997");
			System.out.println(data2);
		} catch (ParseException e1) {
			
			e1.printStackTrace();
		}
//
		try {
			Date data1 = sdf.parse("25/12/1997");
//			String stringDate = sdf.format(data1);
//			System.out.println(stringDate);
//			Date data2 = sdf.parse("18/02/2004");
//			System.out.println(data1.before(data2));
//			System.out.println(c.validaDataNascimento(data1));
			// System.out.println(c.validaIdade(data1, 23));
			// System.out.println(c.getIdade(data1));

			// System.out.println(c.validaIdade(data1, 23));

//			System.out.println(c.validaTextoEndereço("Rua Capitao Silvino Araujo"));
//			System.out.println(c.validaNumeroRua(""));
//			System.out.println(
//					c.validaEndereco("Rua capitao silvino araujo", "Joaquim Romao", "Proximo a pax regional", "39"));

			// System.out.println(c.validaNome(" Victor"));
			
//			String numero = "3545";
//			
//			System.out.println(numero.length());
//			
//			int index = numero.length();
//			System.out.println(numero.substring(0, 1));
			
//			Calendar cal = Calendar.getInstance();
//			cal.setTime(data1);
//			
//			System.out.println(cal.get(Calendar.DAY_OF_MONTH));
//			System.out.println(cal.get(Calendar.MONTH));
//			System.out.println(cal.get(Calendar.YEAR));
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	public boolean validaNome(String nome) {
		String validoNumero = "\\d";
		String validoLetra = "\\w";

		if (nome == "") {
			return false;
		} else {
			char primeiroChar = nome.charAt(0);

			if (primeiroChar == ' ') {
				return false;
			} else if (nome.matches(validoLetra) && !nome.matches(validoNumero)) {
				return true;
			}
		}

		return false;
	}

	public boolean validaCpf(String cpf) {
		String mask = "\\d\\d\\d\\.\\d\\d\\d\\.\\d\\d\\d-\\d\\d";

		boolean retorno = cpf.matches(mask);

		return retorno;
	}

	public boolean validaRG(String rg) {
		String mask = "\\d\\d\\.\\d\\d\\d\\.\\d\\d\\d-\\d\\d";

		boolean retorno = rg.matches(mask);

		return retorno;
	}

	public boolean validaTelefone(String telefone) {
		String mask1 = "^\\([1-9]{2}\\) (?:[2-8]|9[1-9])[0-9]{3}\\-[0-9]{4}$";
		//String mask2 = "(\\d\\d) \\d\\d\\d\\d-\\d\\d\\d\\d";

		if (telefone.matches(mask1)/* || telefone.matches(mask2)*/)
			return true;

		return false;
	}

	public boolean validaMatricula(String matricula) {
		String mask = "\\d\\d\\d\\d\\d\\d\\d\\d\\d";

		// Verifica se a matricula foi digitada corretamente
		boolean retorno = matricula.matches(mask);

		Date atual = new Date();// Data do momento da execução
		Calendar cal = Calendar.getInstance();
		cal.setTime(atual);

		// Verifica se o ano da matricula é posterior ao ano do momento da verificação
		int anoMatricula = Integer.parseInt(matricula.substring(0, 4));
		int anoVerificado = cal.get(Calendar.YEAR);

		if (anoMatricula > anoVerificado) {
			return false;
		}

		return retorno;
	}

	public boolean validaSexo(String sexo) {
		if (sexo == "m" || sexo == "M" || sexo == "f" || sexo == "F") {
			return true;
		} else
			return false;
	}

	public boolean validaDataNascimento(Date data) {
		
		sdf.setLenient(false);
		
		String mask = "\\d\\d/\\d\\d/\\d\\d\\d\\d";

		String stringDate = sdf.format(data);// Converte date para string
		if (stringDate.matches(mask) == false)
			return false;
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(data);
		
		if(cal.get(Calendar.MONTH) + 1 < 1 || cal.get(Calendar.MONTH) + 1 > 12) {
			return false;
		} else {
			
			if(cal.get(Calendar.DAY_OF_MONTH) < 1) return false;
			
			int dias;
			
			if(cal.get(Calendar.MONTH) + 1 == 2){
				if(cal.get(Calendar.YEAR) % 4 == 0) {
					dias = 29;
				} else dias = 28;
				
			} else if(cal.get(Calendar.MONTH) + 1 == 4 ||
					cal.get(Calendar.MONTH) + 1 == 6 ||
					cal.get(Calendar.MONTH) + 1 == 9 ||
					cal.get(Calendar.MONTH) + 1 == 11) {
				
				dias = 30;
				
			} else 
				dias = 31;
			
			if(cal.get(Calendar.DAY_OF_MONTH) > dias) return false;
		}
		
		Date atual = new Date();// Data do momento da execução

		if (atual.before(data)) {
			return false;
		}

		return true;
	}

	public String getIdade(Date data) {
		Calendar cData = Calendar.getInstance();
		Calendar cHoje = Calendar.getInstance();
		cData.setTime(data);
		cData.set(Calendar.YEAR, cHoje.get(Calendar.YEAR));// Seta o ano da data atual na data de nascimento
		int idade = cData.after(cHoje) ? -1 : 0;// Verifica se o dia e o mês da data de nascimento já passaram na data
												// atual. Se não passou diminui 1 da idade
		cData.setTime(data);// seta novamente o ano da data de nascimento
		idade += cHoje.get(Calendar.YEAR) - cData.get(Calendar.YEAR);
		String sIdade = Integer.toString(idade);
		return sIdade;
	}

	public boolean validaIdade(Date data, String idade) {
		Cadastro d = new Cadastro();

		if (d.getIdade(data) != idade)
			return false;

		return true;
	}

	public boolean validaTextoEndereço(String texto) {
		if (texto == "")
			return false;

		String mask1 = "\\w";
		String mask2 = "\\s";
		String caractereVerificado;
		int caracteresNEspacos = 0;

		for (int i = 0; i < texto.length(); i++) {
			caractereVerificado = texto.substring(i, i + 1);

			if (!caractereVerificado.matches(mask1) && !caractereVerificado.matches(mask2)) {
				return false;
			}

			if (caractereVerificado.matches(mask1))
				caracteresNEspacos++;
		}

		if (caracteresNEspacos == 0)
			return false;

		return true;
	}

	public boolean validaComplemento(String texto) {
		if (texto == "")
			return true;

		String mask1 = "\\w";
		String mask2 = "\\s";
		String caractereVerificado;
		int caracteresNEspacos = 0;

		for (int i = 0; i < texto.length(); i++) {
			caractereVerificado = texto.substring(i, i + 1);

			if (!caractereVerificado.matches(mask1) && !caractereVerificado.matches(mask2)) {
				return false;
			}

			if (caractereVerificado.matches(mask1))
				caracteresNEspacos++;
		}

		if (caracteresNEspacos == 0)
			return false;

		return true;
	}

	public boolean validaNumeroRua(String numero) {

		if (numero == "")
			return false;

		String mask = "\\D";
		String caractereVerificado;

		if (numero.length() > 1) {
			for (int i = 0; i < numero.length() - 1; i++) {
				caractereVerificado = numero.substring(i, i + 1);
				if (caractereVerificado.matches(mask))
					return false;
			}
			
			String index = numero.substring(numero.length() - 1, numero.length());
			String mask2 = "\\w";
			
			if(!index.matches(mask2)) return false;
			
		} else {
			if(numero.matches(mask)) return false;
		}

		return true;
	}

	public boolean validaEndereco(String rua, String bairro, String complemento, String numero) {
		if (validaTextoEndereço(rua) && validaTextoEndereço(bairro) && validaComplemento(complemento)
				&& validaNumeroRua(numero)) {
			return true;
		}

		return false;
	}

	public boolean validaReservista(String numero) {
		String mask = "\\d\\d\\d\\d\\d\\d";

		if (numero.matches(mask))
			return true;

		return false;
	}

}
