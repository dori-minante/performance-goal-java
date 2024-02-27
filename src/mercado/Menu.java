package mercado;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import mercado.util.Cores;
import mercado.model.Produto;
import mercado.controller.ProdutoController;
import mercado.model.Frutas;
import mercado.model.Laticinios;

public class Menu {

	public static void main(String[] args) {

		ProdutoController produtoController = new ProdutoController();

		Scanner sc = new Scanner(System.in);

		int opcao, id = 0, tipo = 0;
		String nome = "";
		double preco = 0, gordura = 0, fibra = 0;

		while (true) {

			System.out.println(Cores.TEXT_BLUE + Cores.ANSI_BLACK_BACKGROUND
					+"-----------------------------------------------------");
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
			System.out.println("                                                     " + Cores.TEXT_RESET);

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
				System.out.println("Criar novo Produto\n");
				System.out.println("Digite o id do produto: ");
				id = sc.nextInt();
				sc.nextLine();

				System.out.println("Digite o nome do produto: ");
				nome = sc.nextLine();

				do {
					System.out.println("Digite o tipo do produto (1 - Fruta ou 2 - Laticínio): ");
					tipo = sc.nextInt();
				} while (tipo < 1 && tipo > 2);

				System.out.println("Digite o valor do Produto");
				preco = sc.nextDouble();

				if (tipo == 1) {
					System.out.println("Qual o percentual de fibra?");
					fibra = sc.nextDouble();
					produtoController.criarProduto(new Frutas(id, tipo, nome, preco, fibra));
				} else if (tipo == 2) {
					System.out.println("Qual o percentual de gordura?");
					gordura = sc.nextDouble();
					produtoController.criarProduto(new Laticinios(id, tipo, nome, preco, gordura));
				} else {
					System.out.println("Tipo de produto inválido! Tente novamente.");
				}

				keyPress();
				break;
			case 2:
				System.out.println("Listar todos os Produtos\n\n");
				produtoController.listarTodos();

				keyPress();
				break;
			case 3:
				System.out.println("Consultar Produto por Id\n\n");
				int idConsultar = sc.nextInt();
				produtoController.consultarId(idConsultar);

				keyPress();
				break;

			case 4:
				System.out.println("Atualizar dados do Produto\n\n");

				System.out.println("Digite o número do Id: ");
				int idAtualizar = sc.nextInt();

				var buscaProduto = produtoController.buscarNaCollection(idAtualizar);

				if (buscaProduto != null) {

					System.out.println("Digite o novo nome do Produto: ");
					sc.skip("\\R?");
					String novoNome = sc.nextLine();

					int tipoAtualizar = buscaProduto.getTipo();
					System.out.println("Digite o novo preço do Produto: ");
					sc.skip("\\R?");
					double novoPreco = sc.nextDouble();
					sc.nextLine();

					if (tipoAtualizar == 1) {
						System.out.println("Digite o novo percentual de fibra da fruta");
						double novaFibra = sc.nextDouble();
						produtoController.atualizar(new Frutas(id, tipo, novoNome, novoPreco, novaFibra));
					} else if (tipoAtualizar == 2) {
						System.out.println("Digite o novo percentual de gordura do laticínio");
						double novaGordura = sc.nextDouble();
						produtoController.atualizar(new Laticinios(id, tipo, novoNome, novoPreco, novaGordura));
					} else
						System.out.println("\nProduto não encontrado!");
				}

				keyPress();
				break;
			case 5:
				System.out.println("Apagar Produto\n\n");
				System.out.println("Digite o Id do produto: ");
				int idDeletar = sc.nextInt();

				Produto produtoDeletar = produtoController.buscarNaCollection(idDeletar);

				if (produtoDeletar != null) {
					produtoController.deletar(produtoDeletar);
					System.out.println("O produto com o ID " + idDeletar + " foi deletado com sucesso!");
				} else {
					System.out.println("Produto não encontrado!");
				}

				keyPress();
				break;

			default:
				System.out.println("\nOpção Inválida!\n");
				break;
			}
		}
	}

	private static void sobre() {
		System.out.println("\n-----------------------------------------------------");
		System.out.println("Projeto Desenvolvido por: Dorivania Minante");
		System.out.println("Generation Brasil - generation@generation.org");
		System.out.println("https://github.com/dori-minante/performance-goal-java");
		System.out.println("-----------------------------------------------------");

	}

	public static void keyPress() {
		try {

			System.out.println("\nPressione Enter para continuar!");
			System.in.read();

		} catch (IOException e) {

			System.out.println("Você pressionou uma tecla diferente de enter! Tente novamente.");

		}
	}

}
