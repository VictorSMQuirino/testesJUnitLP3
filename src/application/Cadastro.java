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
//
		try {
			Date data1 = sdf.parse("25/12/1997");
//			String stringDate = sdf.format(data1);
//			System.out.println(stringDate);
//			Date data2 = sdf.parse("18/02/2004");
//			System.out.println(data1.before(data2));
//			System.out.println(c.validaDataNascimento(data1));
			//System.out.println(c.validaIdade(data1, 23));
			//System.out.println(c.getIdade(data1));
			
			//System.out.println(c.validaIdade(data1, 23));
			
			System.out.println(c.validaTextoEndereço("Rua Capitao Silvino Araujo"));
			System.out.println(c.validaNumeroRua("39"));
			System.out.println(c.validaEndereco("Rua capitao silvino araujo", "Joaquim Romao", "Proximo a pax regional", "39"));
			
			//System.out.println(c.validaNome(" Victor"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	public boolean validaNome(String nome) {

		if (nome == "") {
			return false;
		} else {
			char primeiroChar = nome.charAt(0);

			if (primeiroChar == ' ') {
				return false;
			} else {
				try {
					return true;
				} catch (InputMismatchException e) {
					return false;
				}
			}
		}
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
		String mask1 = "(\\d\\d) 9\\d\\d\\d\\d-\\d\\d\\d\\d";
		String mask2 = "(\\d\\d) \\d\\d\\d\\d-\\d\\d\\d\\d";

		if(telefone.matches(mask1) || telefone.matches(mask2)) return true;
		
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

	public boolean validaSexo(char sexo) {
		if (sexo == 'm' || sexo == 'M' || sexo == 'f' || sexo == 'F') {
			return true;
		} else
			return false;
	}

	public boolean validaDataNascimento(Date data) {
		String mask = "\\d\\d/\\d\\d/\\d\\d\\d\\d";

		String stringDate = sdf.format(data);//Converte date para string
		if (stringDate.matches(mask) == false)
			return false;

		Date atual = new Date();// Data do momento da execução

		if (atual.before(data)) {
			return false;
		}

		return true;
	}

	public int getIdade(Date data) {
		Calendar cData = Calendar.getInstance();
		Calendar cHoje= Calendar.getInstance();
		cData.setTime(data);
		cData.set(Calendar.YEAR, cHoje.get(Calendar.YEAR));//Seta o ano da data atual na data de nascimento
		int idade = cData.after(cHoje) ? -1 : 0;//Verifica se o dia e o mês da data de nascimento já passaram na data atual. Se não passou diminui 1 da idade
		cData.setTime(data);//seta novamente o ano da data de nascimento
		idade += cHoje.get(Calendar.YEAR) - cData.get(Calendar.YEAR);
		return idade;
	}
	
	public boolean validaIdade(Date data, int idade) {
		Cadastro d = new Cadastro();

		if (d.validaDataNascimento(data) == false) return false;

		if(d.getIdade(data) != idade) return false;
		
		return true;
	}
	
	public boolean validaTextoEndereço(String texto) {
		String mask1 = "\\w";
		String mask2 = "\\s";
		String caractereVerificado;
		
		for(int i = 0; i < texto.length(); i++) {
			caractereVerificado = texto.substring(i, i + 1);
			
			if(!caractereVerificado.matches(mask1) &&
					!caractereVerificado.matches(mask2)) {
				return false;
			}
		}
		
		return true;
	}
	
	public boolean validaNumeroRua(String numero) {
		String mask = "\\W";
		String caractereVerificado;
		for(int i = 0; i < numero.length(); i++) {
			caractereVerificado = numero.substring(i, i + 1);
			if(caractereVerificado.matches(mask)) return false;
		}
		
		return true;
	}
	
	public boolean validaEndereco(String rua, String bairro, String complemento, String numero) {
		if(validaTextoEndereço(rua) && 
				validaTextoEndereço(bairro) && 
				validaTextoEndereço(complemento) 
				&& validaNumeroRua(numero)) {
			return true;
		}
		
		return false;
	}
	
	public boolean validaReservista(String numero) {
		String mask = "\\d\\d\\d\\d\\d\\d";
		
		if(numero.matches(mask)) return true;
		
		return false;
	}
	

}
