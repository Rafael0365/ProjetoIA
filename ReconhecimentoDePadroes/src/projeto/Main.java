package projeto;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;

public class Main {
	
	
	
	
	public static void main(String[] args) {
		//declaração dos arrays list de cada tipo
		ArrayList<Taca> tacas = new ArrayList<Taca>();
		ArrayList<Copo> copos = new ArrayList<Copo>();
		ArrayList<Prato> pratos = new ArrayList<Prato>();
		ArrayList<Jarra> jarras = new ArrayList<Jarra>();
		//biblioteca responsavel por deixar o numero com apenas uma casa decimal apos a virgula
		DecimalFormat formatador = new DecimalFormat("0.0");
		//preenchimento dos arrays com dados aleatorios
		preencherTacas(tacas);
		preencherCopos(copos);
		preencherPratos(pratos);
		preencherJarras(jarras);
		
		//Constroi prototipos baseados nas bases de treinamentos (primeira metade dos arrays)
		Taca prototipoTaca = fazerPrototipoTaca(tacas);
		System.out.println("prototipo  " + formatador.format(prototipoTaca.getEspessura()));
		
		
		
		for(int i = 0; tacas.size() > i;i++) {
			System.out.println("espessura:" + formatador.format(tacas.get(i).getEspessura()) +"     forma:" + formatador.format(tacas.get(i).getForma()));
		}
		
	}
	
	//abaixo temo os metodos que preenchem os arrays com valores aleatorios
	
	public static void preencherTacas(ArrayList<Taca> t){
		//declaro o random
		Random gerador = new Random();
		//declaro o array de entrada
		ArrayList<Taca> tacas = t;
		//preenchendo com os valores aleatorios
		for(int i = 0; 100 > i; i++) {
			Double espessura = gerador.nextDouble() * (1.3 - 0.8) + 0.8;
			Double forma = gerador.nextDouble() * (6.7 - 4.2) + 4.2;
			Taca aleatoria = new Taca(espessura, forma);
			tacas.add(aleatoria);
		}
		
	}
	
	public static void preencherCopos(ArrayList<Copo> c){
		//declaro o random
		Random gerador = new Random();
		//declaro o array de entrada
		ArrayList<Copo> copos = c;
		//preenchendo com os valores aleatorios
		for(int i = 0; 100 > i; i++) {
			Double espessura = gerador.nextDouble() * (1.5 - 1.1) + 1.1;
			Double forma = gerador.nextDouble() * (6.5 - 3.9) + 3.9;
			Copo aleatoria = new Copo(espessura, forma);
			copos.add(aleatoria);
		}
	
	}
	
	public static void preencherPratos(ArrayList<Prato> p){
		//declaro o random
		Random gerador = new Random();
		//declaro o array de entrada
		ArrayList<Prato> pratos = p;
		//preenchendo com os valores aleatorios
		for(int i = 0; 100 > i; i++) {
			Double espessura = gerador.nextDouble() * (1.8 - 1.4) + 1.4;
			Double forma = gerador.nextDouble() * (5.9 - 3.7) + 3.7;
			Prato aleatoria = new Prato(espessura, forma);
			pratos.add(aleatoria);
		}
	
	}
	
	public static void preencherJarras(ArrayList<Jarra> j){
		//declaro o random
		Random gerador = new Random();
		//declaro o array de entrada
		ArrayList<Jarra> jarras = j;
		//preenchendo com os valores aleatorios
		for(int i = 0; 100 > i; i++) {
			Double espessura = gerador.nextDouble() * (1.7 - 1.0) + 1.0;
			Double forma = gerador.nextDouble() * (6.3 - 4.1) + 4.1;
			Jarra aleatoria = new Jarra(espessura, forma);
			jarras.add(aleatoria);
		}
	
	}
	
	//metodo que constroi um prototipo com base em um array de objetos do tipo
	public static Taca fazerPrototipoTaca(ArrayList<Taca> tacas) {
		ArrayList<Taca> dados = tacas;
		Double somaEspessura = 0.0;
		Double somaForma = 0.0;
		for(int i=0;i<49;i++) {
			somaEspessura = dados.get(i).getEspessura() + somaEspessura;
			somaForma = dados.get(i).getForma() + somaEspessura;
		}
		Taca media = new Taca(somaEspessura/50,somaForma/50);
		return media;
	}
}

