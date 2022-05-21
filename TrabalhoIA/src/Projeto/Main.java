package Projeto;

public class Main {

	public static void main(String[] args) {
		Grafo grafo = new Grafo();
		grafo.adicionarVertice("s", 9.0);
		grafo.adicionarVertice("a", 5.0);
		grafo.adicionarVertice("b", 4.0);
		grafo.adicionarVertice("c", 4.0);
		grafo.adicionarVertice("d", 3.0);
		grafo.adicionarVertice("t", 0.0);
		grafo.adicionarVertice("g", 2.0);
		grafo.adicionarVertice("f", 4.0);
		grafo.adicionarVertice("e", 7.0);
		
		
		grafo.adicionarAresta(2.0, "s", "a");
		grafo.adicionarAresta(2.0, "a", "s");
		
		grafo.adicionarAresta(2.0, "a", "b");
		grafo.adicionarAresta(2.0, "b", "a");
		
		grafo.adicionarAresta(2.0, "c", "b");
		grafo.adicionarAresta(2.0, "b", "c");
		
		grafo.adicionarAresta(3.0, "c", "d");
		grafo.adicionarAresta(3.0, "d", "c");
		
		grafo.adicionarAresta(3.0, "d", "t");
		grafo.adicionarAresta(3.0, "t", "d");
		
		grafo.adicionarAresta(2.0, "t", "g");
		grafo.adicionarAresta(2.0, "g", "t");
		
		grafo.adicionarAresta(2.0, "g", "f");
		grafo.adicionarAresta(2.0, "f", "g");
		
		grafo.adicionarAresta(5.0, "f", "e");
		grafo.adicionarAresta(5.0, "e", "f");
		
		grafo.adicionarAresta(2.0, "e", "s");
		grafo.adicionarAresta(2.0, "s", "e");
		
		grafo.buscaAEstrela("s", "t");

	}

}
