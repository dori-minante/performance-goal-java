package mercado.repository;

import mercado.model.Produto;

public interface ProdutoRepository {
	
	public void criarProduto(Produto produto);

	public void listarTodos();

	public void consultarId(int id);

	public void atualizar(Produto produto);

	public void deletar(Produto produto);
}
