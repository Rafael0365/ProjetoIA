package Projeto;

public class Aresta {
	//declara o peso o vertice de inicio e o vertice de fim da aresta
	private Double peso;
	private Vertice inicio;
	private Vertice fim;
	
	//metodo construtor
	public Aresta(Double peso, Vertice inicio, Vertice fim) {
		this.peso = peso;
		this.inicio = inicio;
		this.fim = fim;
	}
	//getters e setters das variaveis
	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public Vertice getInicio() {
		return inicio;
	}

	public void setInicio(Vertice inicio) {
		this.inicio = inicio;
	}

	public Vertice getFim() {
		return fim;
	}

	public void setFim(Vertice fim) {
		this.fim = fim;
	}

	
}
