package application;

import java.util.Date;
import java.util.InputMismatchException;

public class Cadastro {
	String nome, cpf, rg, endereco;
	Date dataDeNascimento;
	int idade;
	String telefone, matricula, sexo, reservista = null;

	public static void main(String[] args) {
		Cadastro c = new Cadastro();
		System.out.println(c.validaNome(""));

		c.cpf = "111.111.111-11";
		c.rg = "11.111.111-11";

		System.out.println(c.validaCpf(c.cpf));
		System.out.println(c.validaRG(c.rg));
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
		String mask = "(\\d\\d) 9\\d\\d\\d\\d-\\d\\d\\d\\d";

		boolean retorno = telefone.matches(mask);

		return retorno;
	}

	public boolean validaMatricula(String matricula) {
		String mask = "\\d\\d\\d\\d\\d\\d\\d\\d\\d";

		boolean retorno = matricula.matches(mask);

		return retorno;
	}

	public boolean validaSexo(char sexo) {
		if (sexo == 'm' || sexo == 'M' || sexo == 'f' || sexo == 'F') {
			return true;
		} else
			return false;
	}

}
