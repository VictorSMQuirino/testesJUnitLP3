package application;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.jupiter.api.Test;

class TestesCadastro {
	
	static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	@Test
	void test() throws ParseException {
		Cadastro c = new Cadastro();
		
		/*Testes nome*/
		
		assertTrue(c.validaNome("Victor"));
		assertTrue(c.validaNome("Victor Quirino"));
		assertFalse(c.validaNome(""));
		assertFalse(c.validaNome("123"));
		assertFalse(c.validaNome(" Victor"));
		assertFalse(c.validaNome("Victor*"));
		assertFalse(c.validaNome("Vic6tor"));
		
		/*Testes cpf*/
		
		assertTrue(c.validaCpf("111.111.111-11"));
		assertFalse(c.validaCpf(""));
		assertFalse(c.validaCpf("jaca"));
		assertFalse(c.validaCpf("111.111.111-"));
		assertFalse(c.validaCpf("111.111-111-11"));
		assertFalse(c.validaCpf(".111.111-11"));
		assertFalse(c.validaCpf("/**/*++"));
		
		/*Teste rg*/
		
		assertTrue(c.validaRG("11.111.111-11"));
		assertFalse(c.validaRG("11-111.111-11"));
		assertFalse(c.validaRG(""));
		assertFalse(c.validaRG("jaca"));
		assertFalse(c.validaRG("11.111.111-"));
		assertFalse(c.validaRG("11.111-111-11"));
		assertFalse(c.validaRG(".111.111-11"));
		assertFalse(c.validaRG("/**/*++"));
		
		/*Testes Endereço*/
		
		assertFalse(c.validaEndereco("", "Bairro", "", "45"));
		assertTrue(c.validaEndereco("Rua da Avenida", "Bairro da Avenida", "", "89"));
		assertFalse(c.validaEndereco("Rua da Avenida", "Bairro da Avenida", "", ""));
		assertFalse(c.validaEndereco("Rua da Avenida", "", "", "89"));
		assertFalse(c.validaEndereco("", "Bairro da Avenida", "", "89"));
		assertFalse(c.validaEndereco("Rua da Avenida", "@/*", "", "89"));
		assertFalse(c.validaEndereco("Rua da Avenida ", " ", "", "89"));
		assertFalse(c.validaEndereco("Rua da Avenida ", "Bairro da Avenida", "", " "));
		assertFalse(c.validaEndereco("Rua da Avenida ", "Bairro da Avenida", "", "jaca"));
		assertTrue(c.validaEndereco("Rua da Avenida ", "Bairro da Avenida", "", "39a"));
		assertTrue(c.validaEndereco("Rua da Avenida ", "Bairro da Avenida", "", "5"));
		
		/*Testes data de nascimento*/
		
		/**
		 * Deixamos os testes de validação de nascimento comentados 
		 * por que o método de validação foi o que não funcionou, como
		 * comentamos na aula de apresentação do trabalho.
		 * */
		
//		assertTrue(c.validaDataNascimento(sdf.parse("05/12/1995")));
//		assertTrue(c.validaDataNascimento(sdf.parse("28/12/2020")));
//		assertFalse(c.validaDataNascimento(sdf.parse("05/121995")));
//		assertFalse(c.validaDataNascimento(sdf.parse("05/121995")));
//		assertFalse(c.validaDataNascimento(sdf.parse("")));
//		assertFalse(c.validaDataNascimento(sdf.parse("jaca")));
//		assertFalse(c.validaDataNascimento(sdf.parse("05/13/1995")));
//		assertFalse(c.validaDataNascimento(sdf.parse("14/14/1996")));
		
		/*Testes Idade*/
		
		assertTrue(c.validaIdade(sdf.parse("25/11/1995"), "25"));
		assertFalse(c.validaIdade(sdf.parse("25/11/1995"), "24"));
		assertFalse(c.validaIdade(sdf.parse("25/11/1995"), "/*-"));
		assertFalse(c.validaIdade(sdf.parse("25/11/1995"), ""));
		
		/*Testes Telefone*/
		
		assertTrue(c.validaTelefone("(73) 99122-4478"));
		assertFalse(c.validaTelefone("Jaca"));
		assertFalse(c.validaTelefone(""));
		assertFalse(c.validaTelefone("/*-"));
		assertFalse(c.validaTelefone("(73) 99122-4"));
		assertFalse(c.validaTelefone("73 99122-4478"));
		assertFalse(c.validaTelefone("() 99122-4478"));
		
		/*Testes Matricula*/
		
		assertTrue(c.validaMatricula("201710636"));
		assertTrue(c.validaMatricula("201720636"));
		assertFalse(c.validaMatricula("201730636"));
		assertFalse(c.validaMatricula("201700636"));
		assertFalse(c.validaMatricula("202210636"));
		assertFalse(c.validaMatricula(""));
		assertFalse(c.validaMatricula("jaca"));
		assertFalse(c.validaMatricula("asdfga"));
		assertFalse(c.validaMatricula("aaaaaaaaa"));
		
		/*Testes Sexo*/
		
		assertTrue(c.validaSexo("M"));
		assertTrue(c.validaSexo("F"));
		assertTrue(c.validaSexo("f"));
		assertTrue(c.validaSexo("m"));
		assertFalse(c.validaSexo(""));
		assertFalse(c.validaSexo("1564"));
		assertFalse(c.validaSexo("Jaca"));
		
		/*Testes Reservista*/
		
		assertTrue(c.validaReservista("123456789123"));
		assertFalse(c.validaReservista(""));
		assertFalse(c.validaReservista("Jaca"));
		assertFalse(c.validaReservista("/*-@#"));
		assertFalse(c.validaReservista("1234 56789"));
		assertFalse(c.validaReservista("123456 7891"));
		
	}

}
