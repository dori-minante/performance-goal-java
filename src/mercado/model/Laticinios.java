package mercado.model;

public class Laticinios extends Produto {

	int percentualGordura;

	public Laticinios(int id, int tipo, String nome, double preco, int percentualGordura) {
		super(id, tipo, nome, preco);
		this.percentualGordura = percentualGordura;
	}

	public int getPercentualGordura() {
		return percentualGordura;
	}

	public void setPercentualGordura(int percentualGordura) {
		this.percentualGordura = percentualGordura;
	}

	@Override
	public void visualizar() {
		super.visualizar();
		System.out.println("O percentual de gordura é: " + this.percentualGordura);
	}
}
