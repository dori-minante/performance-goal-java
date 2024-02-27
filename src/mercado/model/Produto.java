package mercado.model;

public abstract class Produto {
	private int id, tipo;
	private String nome;
	private double preco;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public Produto(int id, int tipo, String nome, double preco) {
		this.id = id;
		this.tipo = tipo;
		this.nome = nome;
		this.preco = preco;

	}

	public void visualizar() {

		String tipoProduto = "";

		switch (this.tipo) {
		case 1:
			tipoProduto = "Frutas";
			break;
		case 2:
			tipoProduto = "Laticínios";
			break;
		}

		System.out.println("-----------------------------------------------------");
		System.out.println("\nDados do Produto\n");
		System.out.println("-----------------------------------------------------");
		System.out.println("ID do produto: " + this.id);
		System.out.println("Tipo do produto (Digite 1 para Frutas ou 2 para Laticínios): " + this.tipo);
		System.out.println("Nome do produto: " + this.nome);
		System.out.printf("Preço do produto R$ %.2f\n ", this.preco);

	}

}
