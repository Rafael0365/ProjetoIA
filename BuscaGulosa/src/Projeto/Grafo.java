package Projeto;

import java.util.ArrayList;
import java.util.Arrays;

public class Grafo {
    private ArrayList<Vertice> vertices;
    private ArrayList<Aresta> arestas;
    
    public Grafo(){
        this.vertices = new ArrayList<Vertice>();
        this.arestas = new ArrayList<Aresta>();
    }
    //metodo que adiciona vertices ao grafo, e poe em um array de vertices
    public void adicionarVertice(String dado, Double heuristica){
        Vertice novoVertice = new Vertice(dado, heuristica);
        this.vertices.add(novoVertice);
    }
    //metodo que adiciona arestas ao grafo, e poe em um array de arestas
    public void adicionarAresta(Double peso, String dadoInicio, String dadoFim) {
    	Vertice inicio = this.getVertice(dadoInicio);
    	Vertice fim = this.getVertice(dadoFim);
    	Aresta aresta = new Aresta(peso, inicio, fim);
    	inicio.adicionarArestaSaida(aresta);
    	fim.adicionarArestaEntrada(aresta);
    	this.arestas.add(aresta);
    }
    //pegar algum vertice pertencente ao grafo pelo dado
    public Vertice getVertice(String dado){
        Vertice vertice = null;
        for(int i=0; i < this.vertices.size(); i++){
            if (this.vertices.get(i).getDado().equals(dado)){
                vertice = this.vertices.get(i);
                break;
            }
        }
        return vertice;
    }
    
    
    public void buscaGulosa(String dadoOrigem, String dadoObjetivo) {
    	//vertices que vao guiar a busca
    	Vertice origem = this.getVertice(dadoOrigem);
    	Vertice objetivo = this.getVertice(dadoObjetivo);
    	//custo real das coisas
    	Double custoReal = 0.0;
 
        //a origem vira o primeiro a ser visitado
        Vertice visitado = origem;
        //enquanto  o vertice visitado nao for o objetivo a repetiçao vai rodar
        while(!visitado.equals(objetivo)){
        	
        	
        	//imprime o visitado
        	System.out.println("Visitado: "+visitado.getDado());
        	
           //preenche as variaveis lado 1 e 2 com as duas possiveis saidas para o proximo vertice 
        	//baseado nas arestas de saida do vertice visitado
            Vertice lado1 = visitado.getArestasSaida().get(0).getFim();
            Vertice lado2 = visitado.getArestasSaida().get(1).getFim();
            //imprime as possiveis saidas e suas respectivas heuristicas
            System.out.println("Lado 1 "+ lado1.getDado()+" heuristica: " + lado1.getHeuristica());
            System.out.println("Lado 2 "+lado2.getDado()+" heuristica: " + lado2.getHeuristica());
            
          //se os lados forem iguais escolhe o mais a esquerda (ordem alfabetica)
            if(lado1.getHeuristica() == lado2.getHeuristica()){
        		
        		//criando um array para contemplar os dados (string) dos lados
        		String[] ord = {lado1.getDado(),lado2.getDado()};
        		//ordenando o array em ordem alfabetica
        		Arrays.sort(ord);
        		//adiciona o peso da aresta certa (que tem o vertice final igual "equals" ao vertice mais a esquerda)
        		for(int i = 0;visitado.getArestasSaida().size()>i;i++) {
        			if(visitado.getArestasSaida().get(i).getFim().equals(this.getVertice(ord[0]))){
        				custoReal = custoReal +  visitado.getArestasSaida().get(1).getPeso();
        			}
        		}
        		//adiciona o menor ao visitado
        		visitado = this.getVertice(ord[0]);
        		
        	}else {
	            //baseado na menor heuristica escolhe o proximo vertice
	        	if(lado1.getHeuristica() < lado2.getHeuristica()) {
	        		//adiciona ao custo o peso da aresta percorrida para alcancar o vertice
	        		custoReal = custoReal +  visitado.getArestasSaida().get(0).getPeso();
	        		//escolhe o vertice
	        		visitado = lado1;
	        	}else {
	        		//adiciona o custo
	        		custoReal = custoReal +  visitado.getArestasSaida().get(1).getPeso();
	        		//escolhe o vertice
	        		visitado = lado2;
	        		
	        		
	        	}
        	}
        	//se for o objetivo imprime uma mensagem antes de imprimir o custo
        	if(visitado.equals(objetivo)) {
        		System.out.println("Parabens vc chegou!! Visitado: " + visitado.getDado());
        	}
            
        }
 
        //imprime o custo
    	System.out.println("Custo real: " + custoReal);
    }
    
}