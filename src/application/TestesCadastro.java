package application;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestesCadastro {
	
	static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void test() throws ParseException {
		Cadastro c = new Cadastro();
		
		/*Testes nome*/
		
//		assertTrue(c.validaNome("Victor"));
//		assertTrue(c.validaNome(""));
//		assertTrue(c.validaNome("123"));
//		assertTrue(c.validaNome(" Victor"));
//		assertTrue(c.validaNome("Victor*"));
//		assertTrue(c.validaNome("Vic6tor"));
		
		/*Testes cpf*/
		
//		assertTrue(c.validaCpf("111.111.111-11"));
//		assertTrue(c.validaCpf(""));
//		assertTrue(c.validaCpf("jaca"));
//		assertTrue(c.validaCpf("111.111.111-"));
//		assertTrue(c.validaCpf("111.111-111-11"));
//		assertTrue(c.validaCpf(".111.111-11"));
//		assertTrue(c.validaCpf("/**/*++"));
		
		/*Teste rg*/
		
//		assertTrue(c.validaRG("11.111.111-11"));
//		assertTrue(c.validaRG("11-111.111-11"));
//		assertTrue(c.validaRG(""));
//		assertTrue(c.validaRG("jaca"));
//		assertTrue(c.validaRG("11.111.111-"));
//		assertTrue(c.validaRG("11.111-111-11"));
//		assertTrue(c.validaRG(".111.111-11"));
//		assertTrue(c.validaRG("/**/*++"));
		
		/*Testes Endereço*/
		
//		assertTrue(c.validaEndereco("", "Bairro", "", "45"));
//		assertTrue(c.validaEndereco("Rua da Avenida", "Bairro da Avenida", "", "89"));
//		assertTrue(c.validaEndereco("Rua da Avenida", "Bairro da Avenida", "", ""));
//		assertTrue(c.validaEndereco("Rua da Avenida", "", "", "89"));
//		assertTrue(c.validaEndereco("", "Bairro da Avenida", "", "89"));
//		assertTrue(c.validaEndereco("Rua da Avenida", "@/*", "", "89"));
//		assertTrue(c.validaEndereco(" ", "Bairro da Avenida", "", "89"));
//		assertTrue(c.validaEndereco("Rua da Avenida ", " ", "", "89"));
//		assertTrue(c.validaEndereco("Rua da Avenida ", "Bairro da Avenida", "", " "));
//		assertTrue(c.validaEndereco("Rua da Avenida ", "Bairro da Avenida", "", "jaca"));
//		assertTrue(c.validaEndereco("Rua da Avenida ", "Bairro da Avenida", "", "39a"));
//		assertTrue(c.validaEndereco("Rua da Avenida ", "Bairro da Avenida", "", "5"));
		
		/*Testes data de nascimento*/
		
//		assertTrue(c.validaDataNascimento(sdf.parse("05/12/1995")));
//		assertTrue(c.validaDataNascimento(sdf.parse("28/12/2020")));
//		assertTrue(c.validaDataNascimento(sdf.parse("05/121995")));
//		assertTrue(c.validaDataNascimento(sdf.parse("05/121995")));
//		assertTrue(c.validaDataNascimento(sdf.parse("")));
//		assertTrue(c.validaDataNascimento(sdf.parse("jaca")));
//		assertTrue(c.validaDataNascimento(sdf.parse("05/13/1995")));
//		assertTrue(c.validaDataNascimento(sdf.parse("14/14/1996")));
		
		/*Testes Idade*/
		
//		assertTrue(c.validaIdade(sdf.parse("25/11/1995"), 24));
//		assertTrue(c.validaIdade(sdf.parse("25/11/1995"), "/*-"));
//		assertTrue(c.validaIdade(sdf.parse("25/11/1995"), ""));
		
		/*Testes Telefone*/
		
//		assertTrue(c.validaTelefone("(73) 99122-4478"));
//		assertTrue(c.validaTelefone("Jaca"));
//		assertTrue(c.validaTelefone(""));
//		assertTrue(c.validaTelefone("/*-"));
//		assertTrue(c.validaTelefone("(73) 99122-4"));
//		assertTrue(c.validaTelefone("73 99122-4478"));
		
		/*Testes Matricula*/
		
//		assertTrue(c.validaMatricula("201710636"));
//		assertTrue(c.validaMatricula(""));
//		assertTrue(c.validaMatricula("jaca"));
//		assertTrue(c.validaMatricula("asdfga"));
//		assertTrue(c.validaMatricula("aaaaaaaaa"));
		
		/*Testes Sexo*/
		
//		assertTrue(c.validaSexo("M"));
//		assertTrue(c.validaSexo("F"));
//		assertTrue(c.validaSexo("f"));
//		assertTrue(c.validaSexo("m"));
//		assertTrue(c.validaSexo(""));
//		assertTrue(c.validaSexo("1564"));
//		assertTrue(c.validaSexo("Jaca"));
		
		/*Testes Reservista*/
		
//		assertTrue(c.validaReservista("123456"));
//		assertTrue(c.validaReservista(""));
//		assertTrue(c.validaReservista("Jaca"));
//		assertTrue(c.validaReservista("/*-@#"));
//		assertTrue(c.validaReservista("1234 56"));
//		assertTrue(c.validaReservista("123456 "));
		
	}

}
