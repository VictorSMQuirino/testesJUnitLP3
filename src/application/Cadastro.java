package application;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Cadastro {
	String nome, cpf, rg, endereco;
	Date dataDeNascimento;
	int idade;
	String telefone, matricula, sexo, reservista = null;

	static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public static void main(String[] args) {
		Cadastro c = new Cadastro();
	
	}

	public boolean validaNome(String nome) {
		String validoNumero = "\\d";
		String validoLetra = "\\w";
		String validoEspaco = "\\s";
		int caractereNEspaco = 0;

		if (nome == "") {
			return false;
		} else {
			char primeiroChar = nome.charAt(0);

			if (primeiroChar == ' ') {
				return false;
			} else {
				
				for(int i = 0; i < nome.length(); i++) {
					if((!nome.substring(i, i + 1).matches(validoLetra) || nome.substring(i, i + 1).matches(validoNumero)) &&
							!nome.substring(i, i + 1).matches(validoEspaco)) {
						return false;
					}
					
					if(!nome.substring(i, i + 1).matches(validoEspaco)) {
						caractereNEspaco++;
					}
				}
				
			} 
//			if (nome.matches(validoLetra) && !nome.matches(validoNumero)) {
//				return true;
//			}
		}
		
		if(caractereNEspaco == 0) return false;

		return true;
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
		
		if(matricula == "") return false;
		
		String mask = "\\d\\d\\d\\d\\d\\d\\d\\d\\d";

		// Verifica se a matricula foi digitada corretamente
		
		if(!matricula.matches(mask)) return false;
		

		Date atual = new Date();// Data do momento da execução
		Calendar cal = Calendar.getInstance();
		cal.setTime(atual);

		// Verifica se o ano da matricula é posterior ao ano do momento da verificação
		int anoMatricula = Integer.parseInt(matricula.substring(0, 4));
		int anoVerificado = cal.get(Calendar.YEAR);

		if (anoMatricula > anoVerificado - 1) {
			return false;
		}
		
		int semestreMatricula = Integer.parseInt(matricula.substring(4, 5));
		
		if(semestreMatricula < 1 || semestreMatricula > 2) return false;

		return true;
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

		if (!d.getIdade(data).equals(idade))
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
		String mask = "\\d\\d\\d\\d\\d\\d\\d\\d\\d\\d\\d\\d";

		if (numero.matches(mask))
			return true;

		return false;
	}

}
