package app;

import java.util.Scanner;

import entidade.Funcionario;
import implement.FuncionarioDAOImp;

public class Aplicacao {

	public static void main(String[] args) {

		Funcionario fun = new Funcionario();


		try (Scanner scan = new Scanner(System.in)) {
			System.out.print("Digite o Nome do funcion�rio: ");
			fun.setNome(scan.nextLine());
			System.out.print("Digite o  CPF do funcion�rio: ");
			fun.setCpf(scan.nextLine());
			System.out.print("Digite o  Telefone do funcion�rio: ");
			fun.setTelefone(scan.nextLine());
			System.out.print("Digite o  Endere�o do funcion�rio: ");
			fun.setEndereco(scan.nextLine());
			System.out.print("Digite o  Cargo do funcion�rio: ");
			fun.setCargo(scan.nextLine());
			System.out.print("Digite o email para cadastro: ");
			fun.setEmail(scan.nextLine());
			System.out.print("Digite o Login para cadastro: ");
			fun.setLogin(scan.nextLine());
			System.out.print("Digite a senha para cadastro: ");
			fun.setSenha(scan.nextLine());
			
			if (new FuncionarioDAOImp().salvar(fun))
				
				System.out.println("Dados gravados com sucesso");
			else
				System.out.println("Falha na grava��o");
		}
	}
}