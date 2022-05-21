package Projeto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Grafo {
    private ArrayList<Vertice> vertices;
    private ArrayList<Aresta> arestas;
    
    public Grafo(){
        this.vertices = new ArrayList<Vertice>();
        this.arestas = new ArrayList<Aresta>();
    }
    
    public void adicionarVertice(String dado, Double heuristica){
        Vertice novoVertice = new Vertice(dado, heuristica);
        this.vertices.add(novoVertice);
    }
    
    public void adicionarAresta(Double peso, String dadoInicio, String dadoFim) {
    	Vertice inicio = this.getVertice(dadoInicio);
    	Vertice fim = this.getVertice(dadoFim);
    	Aresta aresta = new Aresta(peso, inicio, fim);
    	inicio.adicionarArestaSaida(aresta);
    	fim.adicionarArestaEntrada(aresta);
    	this.arestas.add(aresta);
    }
    
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
    
    public ArrayList<String> darOsDados(ArrayList<Vertice> n) {
    	ArrayList<Vertice> lista = n;
    	ArrayList<String> z = new ArrayList();
    	for(int i = 0; i < lista.size(); i++ ) {
    		z.add(n.get(i).getDado());
    	}
    	return z;
    }
    
    public ArrayList<Vertice> receberOsDados(ArrayList<String> z){
    	ArrayList<String> lista = z;
    	ArrayList<Vertice> n = new ArrayList();
    	for(int i = 0; i < lista.size(); i++) {
    		n.add(this.getVertice(lista.get(i)));
    	}
    	return n;
    }
    
    public void buscaAEstrela(String dadoOrigem, String dadoObjetivo) {
    	//vertices que vao guiar a busca
    	Vertice origem = this.getVertice(dadoOrigem);
    	Vertice objetivo = this.getVertice(dadoObjetivo);
    	//custo real das coisas
    	Double custoReal = 0.0;
    	ArrayList<Vertice> marcados = new ArrayList<Vertice>();
        ArrayList<Vertice> filhos = new ArrayList<Vertice>();
        marcados.add(origem);
        System.out.println(origem.getDado());
        for(int i = 0; i < marcados.get(0).getArestasSaida().size(); i++) {
        	filhos.add(origem.getArestasSaida().get(i).getFim());
        }
        Vertice visitado = origem;
        while(filhos.size() > 0){
        	// deixa em ordem alfabetica o vetor de filhos
        	ArrayList<String> h = this.darOsDados(filhos);
        	Collections.sort(h);
        	filhos = this.receberOsDados(h);
        	//seta o visitado e o menor
        	
        	visitado = filhos.get(0);
        	
        	
        	System.out.println(visitado.getDado());
        	
           
            	Vertice lado1 = visitado.getArestasSaida().get(0).getFim();
            	Vertice lado2 = visitado.getArestasSaida().get(1).getFim();
            	if((lado1.getHeuristica() + custoReal) < (lado2.getHeuristica() + custoReal)) {
            		
            		Vertice proximo = lado1;
            		
            		custoReal = custoReal + visitado.getArestasSaida().get(0).getPeso();
            		
            		 if (!marcados.contains(proximo)){ //se o vértice ainda não foi marcado
                     //marca ele como visitado para ele nao ser mais visitado
              		 marcados.add(visitado);
                     //imprime o escolhido
                     
                      //adiciona o escolhido na lista de filhos
                      filhos.add(proximo);
                    
                       
                   }
            		
            	
            	
            	
            	
            	
            	
            	
            	
            	
            	//descobrir qual é o vetor com menor custo + heuristica
//            	if((visitado.getArestasSaida().get(i).getFim().getHeuristica() + custoReal) < menor){
//            		//o menor vira o que foi escolhido
//            		menor = visitado.getArestasSaida().get(i).getFim().getHeuristica() + custoReal;
//            		//o que tiver menor custo + heuristica é escolhido como proximo
//            		Vertice proximo = visitado.getArestasSaida().get(i).getFim();
//            	
//            		
//            		//adicionar o peso da aresta ao custo real
//                	custoReal = custoReal + visitado.getArestasSaida().get(i).getPeso();
//                	
//                	
//                	 if (!marcados.contains(proximo)){ //se o vértice ainda não foi marcado
//                         //marca ele como visitado para ele nao ser mais visitado
//                		 marcados.add(visitado);
//                         //imprime o escolhido
//                         
//                         //adiciona o escolhido na lista de filhos
//                         filhos.add(proximo);
//                         for(int j = 0; j < marcados.get(0).getArestasSaida().size(); j++) {
//                         	filhos.add(visitado.getArestasSaida().get(j).getFim());
//                         }
//                         
//                     }
            	}else {
            		Vertice proximo = lado2;
            		
            		custoReal = custoReal + visitado.getArestasSaida().get(1).getPeso();
            		
            		 if (!marcados.contains(proximo)){ //se o vértice ainda não foi marcado
                     //marca ele como visitado para ele nao ser mais visitado
              		 marcados.add(visitado);
                     //imprime o escolhido
                     
                      //adiciona o escolhido na lista de filhos
                      filhos.add(proximo);
                    
                       
                   }
            		
            		
            	}
            	
            
            filhos.remove(0);
        }
        //
    	System.out.println("Custo real: " + custoReal);
    }
    
}