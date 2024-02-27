package mercado.model;

public class Laticinios extends Produto {

	double percentualGordura;

	public Laticinios(int id, int tipo, String nome, double preco, double percentualGordura) {
		super(id, tipo, nome, preco);
		this.percentualGordura = percentualGordura;
	}

	public double getPercentualGordura() {
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
