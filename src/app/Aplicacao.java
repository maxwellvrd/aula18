package app;

import java.util.Scanner;

import entidade.Funcionario;
import implement.FuncionarioDAOImp;

public class Aplicacao {

	public static void main(String[] args) {

		Funcionario fun = new Funcionario();


		try (Scanner scan = new Scanner(System.in)) {
			System.out.print("Digite o Nome do funcionário: ");
			fun.setNome(scan.nextLine());
			System.out.print("Digite o  CPF do funcionário: ");
			fun.setCpf(scan.nextLine());
			System.out.print("Digite o  Telefone do funcionário: ");
			fun.setTelefone(scan.nextLine());
			System.out.print("Digite o  Endereço do funcionário: ");
			fun.setEndereco(scan.nextLine());
			System.out.print("Digite o  Cargo do funcionário: ");
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
				System.out.println("Falha na gravação");
		}
	}
}