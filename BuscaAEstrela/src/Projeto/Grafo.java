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
    
    public void buscaGulosa(String dadoOrigem, String dadoObjetivo) {
    	//vertices que vao guiar a busca
    	Vertice origem = this.getVertice(dadoOrigem);
    	Vertice objetivo = this.getVertice(dadoObjetivo);
    	//custo real das coisas
    	Double custoReal = 0.0;
    	//ArrayList<Vertice> marcados = new ArrayList<Vertice>();
        //ArrayList<Vertice> filhos = new ArrayList<Vertice>();
        //a origem vira o primeiro a ser visitado
        Vertice visitado = origem;
        //Vertice proximo;
        //filhos.add(origem);
        while(!visitado.equals(objetivo)){
        	// deixa em ordem alfabetica o vetor de filhos
        	//ArrayList<String> h = this.darOsDados(filhos);
        	//Collections.sort(h);
        	//filhos = this.receberOsDados(h);
        	//seta o visitado e o menor
        	
        	//visitado = filhos.get(0);
        	
        	
        	System.out.println("Visitado: "+visitado.getDado());
        	
           
            Vertice lado1 = visitado.getArestasSaida().get(0).getFim();
            Vertice lado2 = visitado.getArestasSaida().get(1).getFim();
            System.out.println("Lado 1 "+ lado1.getDado()+" heuristica: " + lado1.getHeuristica());
            System.out.println("Lado 2 "+lado2.getDado()+" heuristica: " + lado2.getHeuristica());
            	if(lado1.getHeuristica() < lado2.getHeuristica()) {
            		custoReal = custoReal +  visitado.getArestasSaida().get(0).getPeso();
            		visitado = lado1;
            	}else {
            		custoReal = custoReal +  visitado.getArestasSaida().get(1).getPeso();
            		visitado = lado2;
            		
            		
            	}
            	
            	if(visitado.equals(objetivo)) {
            		System.out.println("Parabens vc chegou!! Visitado: " + visitado.getDado());
            	}
            	
            	
                
            //filhos.add(visitado);
            //System.out.println(filhos.get(0).getDado());
            //System.out.println(filhos.get(1).getDado());
//				if (!marcados.contains(proximo)){ //se o v�rtice ainda n�o foi marcado
//                     //marca ele como visitado para ele nao ser mais visitado
//              		 marcados.add(visitado);
//                     //imprime o escolhido
//                     
//                      //adiciona o escolhido na lista de filhos
//                      filhos.add(proximo);
//                    
//                       
//                   }
            	
            
            //filhos.remove(0);
           // System.out.println(filhos.get(0).getDado());
            
        }
 
        //
    	System.out.println("Custo real: " + custoReal);
    }
    
}