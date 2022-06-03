package projeto;

public class Vidro {
	private String tipo;
	private double espessura;
	private double forma;
	public Vidro(String tipo, double espessura, double forma) {
		super();
		this.tipo = tipo;
		this.espessura = espessura;
		this.forma = forma;
	}
	
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public double getEspessura() {
		return espessura;
	}
	public void setEspessura(double espessura) {
		this.espessura = espessura;
	}
	public double getForma() {
		return forma;
	}
	public void setForma(double forma) {
		this.forma = forma;
	}
	

}
