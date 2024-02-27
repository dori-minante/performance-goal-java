package mercado.controller;

import java.util.ArrayList;

import mercado.model.Produto;
import mercado.repository.ProdutoRepository;

public class ProdutoController implements ProdutoRepository {
	
	private ArrayList<Produto> listaProdutos = new ArrayList<Produto>();
	
	@Override
	public void consultarId(int id) {
		var produto = buscarNaCollection(id);

		if (produto != null)
			produto.visualizar();
		else
			System.out.println("\nO produto: " + id + " não foi encontrado!");

	}

	public Produto buscarNaCollection(int id) {
		for (Produto produto : listaProdutos) {
			if (produto.getId() == id) {
				return produto;

			}
		}
		return null;
	}

	@Override
	public void criarProduto(Produto produto) {
		listaProdutos.add(produto);
		System.out.println("\nParabéns! O produto: " + produto.getId() + " foi cadastrado com sucesso!");
	}

	@Override
	public void listarTodos() {
		for (var produto : listaProdutos) {
			produto.visualizar();
		}
	}

	@Override
	public void atualizar(Produto produto) {
	    var buscaProduto = buscarNaCollection(produto.getId());

	    if (buscaProduto != null) {
	        int indice = listaProdutos.indexOf(buscaProduto);
	        listaProdutos.set(indice, produto);
	        System.out.println("\nO produto: " + produto.getId() + " foi atualizado com sucesso!");
	    } else {
	        System.out.println("\nO produto: " + produto.getId() + " não foi encontrado!");
	    }
	}

	@Override
	public void deletar(Produto produto) {
		var p = buscarNaCollection(produto.getId());

		if (p != null) {
			if (listaProdutos.remove(p) == true)
				System.out.println("\nO produto: " + produto.getId() + " foi deletada com sucesso!");
		} else
			System.out.println("\nO produto: " + produto.getId() + " não foi encontrado!");
	}

}

