package Projeto;

import java.util.ArrayList;

public class Vertice {
	//declaração de dado ("nome" do vertice) heuristica e dois arrays, 
	//um para todas as arestas que tiverem apontando para o vertice e todas que o vertice aponta para
	private String dado;
	private Double heuristica;
	private ArrayList<Aresta> arestasEntrada = new ArrayList<Aresta>();
	private ArrayList<Aresta> arestasSaida = new ArrayList<Aresta>();;
	//construtor da classe
	public Vertice(String valor, Double heuristica) {
		this.dado = valor;
		this.heuristica = heuristica;
		this.arestasEntrada = new ArrayList <Aresta>();
		this.arestasEntrada = new ArrayList <Aresta>();
	}
	//getters e setters das variaveis
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
	//metodos responsaveis por manipular os arrays de arestas (usados no metodo adicionarAresta na classe Grafo)
	public void adicionarArestaEntrada(Aresta aresta) {
		this.arestasEntrada.add(aresta);
	}
	
	public void adicionarArestaSaida(Aresta aresta) {
		this.arestasSaida.add(aresta);
	}

	public ArrayList<Aresta> getArestaEntrada() {
		return arestasEntrada;
	}

	public void setArestasEntrada(ArrayList<Aresta> arestaEntrada) {
		this.arestasEntrada = arestaEntrada;
	}

	public ArrayList<Aresta> getArestasSaida() {
		return arestasSaida;
	}

	public void setArestaSaida(ArrayList<Aresta> arestaSaida) {
		this.arestasSaida = arestaSaida;
	}
	
	
	
	
	

}
