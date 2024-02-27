package mercado;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int opcao = 0;

		while (true) {

			System.out.println("-----------------------------------------------------");
			System.out.println("                                                     ");
			System.out.println("               Mercadinho da Skina                   ");
			System.out.println("                                                     ");
			System.out.println("-----------------------------------------------------");
			System.out.println("                                                     ");
			System.out.println("            1 - Criar Produto                        ");
			System.out.println("            2 - Listar todos os Produtos             ");
			System.out.println("            3 - Consultar Produto por Id             ");
			System.out.println("            4 - Atualizar Produto                    ");
			System.out.println("            5 - Apagar Produto                       ");
			System.out.println("            9 - Sair                                 ");
			System.out.println("                                                     ");
			System.out.println("-----------------------------------------------------");
			System.out.println("Entre com a opção desejada:                          ");
			System.out.println("                                                     ");

			try {
				opcao = sc.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Você precisa digitar valores inteiros!");
				opcao = 0;
			}

			if (opcao == 9) {
				System.out.println("\nMercadinho da Skina: Frescor que encanta, qualidade que alimenta!\n");
				sobre();
				sc.close();
				System.exit(0);
			}

			switch (opcao) {
			case 1:
				System.out.println("Criar Produto\n\n");

				break;
			case 2:
				System.out.println("Listar todos os Produtos\n\n");

				break;
			case 3:
				System.out.println("Consultar Produto por Id\n\n");

				break;
			case 4:
				System.out.println("Atualizar dados do Produto\n\n");

				break;
			case 5:
				System.out.println("Apagar Produto\n\n");

				break;

			default:
				System.out.println("\nOpção Inválida!\n");
				break;
			}
		}
	}

	private static void sobre() {
		System.out.println("\n*********************************************************");
		System.out.println("Projeto Desenvolvido por: Dorivania Minante");
		System.out.println("Generation Brasil - generation@generation.org");
		System.out.println("https://github.com/dori-minante/performance-goal-java");
		System.out.println("*********************************************************");

	}

}
