package mercado.model;

public class Frutas extends Produto {
	
	double percentualFibras;
	public Frutas(int id, int tipo, String nome, double preco, double percentualFibras) {
		super(id, tipo, nome, preco);
		this.percentualFibras =  percentualFibras;
	}
	public double getPercentualFibras() {
		return percentualFibras;
	}
	public void setPercentualFibras(int percentualFibras) {
		this.percentualFibras = percentualFibras;
	}

	@Override
	public void visualizar() {
		super.visualizar();
		System.out.println("O percentual de fibras é: " + this.percentualFibras);
	}
}
