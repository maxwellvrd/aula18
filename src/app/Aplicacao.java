package app;

import java.util.Scanner;

import entidade.Usuario;
import implement.UsuarioDAOImp;

public class Aplicacao {

	public static void main(String[] args) {

		Usuario usu = new Usuario();


		try (Scanner scan = new Scanner(System.in)) {
			System.out.print("Digite o Nome do funcionário: ");
			usu.setNome(scan.nextLine());
			System.out.print("Digite o  CPF do funcionário: ");
			usu.setCpf(scan.nextLine());
			System.out.print("Digite o  Telefone do funcionário: ");
			usu.setTelefone(scan.nextLine());
			System.out.print("Digite o  Endereço do funcionário: ");
			usu.setEndereco(scan.nextLine());
			System.out.print("Digite o  Cargo do funcionário: ");
			usu.setCargo(scan.nextLine());
			
			if (new UsuarioDAOImp().salvar(usu))
				
				System.out.println("Dados gravados com sucesso");
			else
				System.out.println("Falha na gravação");
		}
	}
}