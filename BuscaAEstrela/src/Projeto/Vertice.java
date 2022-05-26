package Projeto;

import java.util.ArrayList;

public class Vertice {
	private String dado;
	private Double heuristica;
	private ArrayList<Aresta> arestasEntrada;
	private ArrayList<Aresta> arestasSaida;
	
	public Vertice(String valor, Double heuristica) {
		this.dado = valor;
		this.heuristica = heuristica;
		this.arestasEntrada = new ArrayList <Aresta>();
		this.arestasEntrada = new ArrayList <Aresta>();
	}

	public String getDado() {
		return dado;
	}

	public void setDado(String dado) {
		this.dado = dado;
	}

	public Double getHeuristica() {
		return heuristica;
	}

	public void setHeuristica(Double heuristica) {
		this.heuristica = heuristica;
	}
	
	public void adicionarArestaEntrada(Aresta aresta) {
		this.arestasEntrada.add(aresta);
	}
	
	public void adicionarArestaSaida(Aresta aresta) {
		this.arestasEntrada.add(aresta);
	}

	public ArrayList<Aresta> getArestaEntrada() {
		return arestasEntrada;
	}

	public void setArestasEntrada(ArrayList<Aresta> arestaEntrada) {
		this.arestasEntrada = arestaEntrada;
	}

	public ArrayList<Aresta> getArestasSaida() {
		return arestasEntrada;
	}

	public void setArestaSaida(ArrayList<Aresta> arestaSaida) {
		this.arestasEntrada = arestaSaida;
	}
	
	
	
	
	

}
