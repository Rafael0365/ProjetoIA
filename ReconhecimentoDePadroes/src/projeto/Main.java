package projeto;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;

public class Main {
	
	
	
	
	public static void main(String[] args) {
		//declaração dos arrays list de cada tipo
		ArrayList<Vidro> tacas = new ArrayList<Vidro>();
		ArrayList<Vidro> copos = new ArrayList<Vidro>();
		ArrayList<Vidro> pratos = new ArrayList<Vidro>();
		ArrayList<Vidro> jarras = new ArrayList<Vidro>();

		//preenchimento dos arrays com dados aleatorios
		preencherTacas(tacas);
		preencherCopos(copos);
		preencherPratos(pratos);
		preencherJarras(jarras);
		
		//Constroi prototipos baseados nas bases de treinamentos (primeira metade dos arrays)
		Vidro prototipoTaca = fazerPrototipo(tacas);
		//System.out.println(prototipoTaca.getEspessura() + ", " + prototipoTaca.getForma());
		Vidro prototipoCopo = fazerPrototipo(copos);
		Vidro prototipoPrato = fazerPrototipo(pratos);
		Vidro prototipoJarra = fazerPrototipo(jarras);
		
		Vidro prototipos[] = {prototipoTaca,prototipoCopo,prototipoPrato,prototipoJarra };
		
		//a partir dos dados construir bases de teste (todas as segundas metades dos dados)
		Vidro[] testeTacas = new Vidro[50];
		Vidro[] testeCopos = new Vidro[50];
		Vidro[] testePratos = new Vidro[50];
		Vidro[] testeJarras = new Vidro[50];
		for(int i = 50;100>i;i++) {
			
			testeTacas[i-50] = (tacas.get(i));
			testeCopos[i-50] = (copos.get(i));
			testePratos[i-50] = (pratos.get(i));
			testeJarras[i-50] = (jarras.get(i));
		}
		
		//armazena as bases de testes dentro de uma matriz
		Vidro[][] testes = {testeTacas, testeCopos, testePratos, testeJarras };
		
		boolean mostrarInteracoes = false;
		
		//o contador a vai ser responsavel por mudar o prototipo
		
		for(int a=0;prototipos.length>a;a++) {
			
			
			//imprime a o prototipo que esta sendo usado
			System.out.println("=====================================================================================");
			System.out.println("Testes: "+prototipos[a].getTipo());
				
			//declarando a somatoria de acertos que é zerada a cada novo prototipo
			
			int acertos = 0;
			
			//o contador b é usado por mudar o teste atual
			for(int b=0; 50>b;b++) {
				
				
				//utilizando o calculo de city block para descobrir a dimensao da difererença entre o prototipo e o teste atual 
				if(a == 0) {
					//utilizando o calculo de city block para descobrir a dimensao da difererença entre o prototipo atual e as quatro bases de testes
					
					//o primeiro elemento "aa" é a distancia do teste que esta sendo testado com seu prototipo respectivo (acerto)
					Double resultado_aa = Math.abs(testes[a][b].getEspessura() - prototipos[a].getEspessura())+ Math.abs(testes[a][b].getForma() - prototipos[a].getForma());
					BigDecimal aa = new BigDecimal(resultado_aa).setScale(1, RoundingMode.HALF_EVEN);
					
					//os demais elementos sao as distancias do prototipo atual com as demais bases (erro)
					Double resultado_ba = Math.abs(testes[a+1][b].getEspessura() - prototipos[a].getEspessura())+ Math.abs(testes[a+1][b].getForma() - prototipos[a].getForma());
					BigDecimal ba = new BigDecimal(resultado_ba).setScale(1, RoundingMode.HALF_EVEN);
					Double resultado_ca = Math.abs(testes[a+2][b].getEspessura() - prototipos[a].getEspessura())+ Math.abs(testes[a+2][b].getForma() - prototipos[a].getForma());
					BigDecimal ca = new BigDecimal(resultado_ca).setScale(1, RoundingMode.HALF_EVEN);
					Double resultado_da = Math.abs(testes[a+3][b].getEspessura() - prototipos[a].getEspessura())+ Math.abs(testes[a+3][b].getForma() - prototipos[a].getForma());
					BigDecimal da = new BigDecimal(resultado_da).setScale(1, RoundingMode.HALF_EVEN);
					
					if(mostrarInteracoes)
						System.out.println("interação "+(b+1)+" distancia tt "+ aa.doubleValue() +" distancia tc "+ ba.doubleValue() +" distancia tp "+ ca.doubleValue() +" distancia tj "+ da.doubleValue());
					
	
					//baseado nos valores de distancia verifica se o elemento atual foi reconhecido como tal
					if(aa.doubleValue()<=ba.doubleValue()&aa.doubleValue()<=ca.doubleValue()&aa.doubleValue()<=da.doubleValue()) {
						if(mostrarInteracoes)
						System.out.println("acerto");
						acertos++;
					}
				}
				if(a == 1) {
					Double resultado_aa = Math.abs(testes[a][b].getEspessura() - prototipos[a].getEspessura())+ Math.abs(testes[a][b].getForma() - prototipos[a].getForma());
					BigDecimal aa = new BigDecimal(resultado_aa).setScale(1, RoundingMode.HALF_EVEN);
					Double resultado_ba = Math.abs(testes[a-1][b].getEspessura() - prototipos[a].getEspessura())+ Math.abs(testes[a-1][b].getForma() - prototipos[a].getForma());
					BigDecimal ba = new BigDecimal(resultado_ba).setScale(1, RoundingMode.HALF_EVEN);
					Double resultado_ca = Math.abs(testes[a+1][b].getEspessura() - prototipos[a].getEspessura())+ Math.abs(testes[a+1][b].getForma() - prototipos[a].getForma());
					BigDecimal ca = new BigDecimal(resultado_ca).setScale(1, RoundingMode.HALF_EVEN);
					Double resultado_da = Math.abs(testes[a+2][b].getEspessura() - prototipos[a].getEspessura())+ Math.abs(testes[a+2][b].getForma() - prototipos[a].getForma());
					BigDecimal da = new BigDecimal(resultado_da).setScale(1, RoundingMode.HALF_EVEN);
					
					if(mostrarInteracoes)
						System.out.println("interação "+(b+1)+" distancia cc "+ aa.doubleValue() +" distancia ct "+ ba.doubleValue() +" distancia cp "+ ca.doubleValue() +" distancia cj "+ da.doubleValue());
						
					
					if(aa.doubleValue()<=ba.doubleValue()&aa.doubleValue()<=ca.doubleValue()&aa.doubleValue()<=da.doubleValue()) {
						if(mostrarInteracoes)
							System.out.println("acerto");
						acertos++;
					}
				}
				if(a == 2) {
					Double resultado_aa = Math.abs(testes[a][b].getEspessura() - prototipos[a].getEspessura())+ Math.abs(testes[a][b].getForma() - prototipos[a].getForma());
					BigDecimal aa = new BigDecimal(resultado_aa).setScale(1, RoundingMode.HALF_EVEN);
					Double resultado_ba = Math.abs(testes[a-1][b].getEspessura() - prototipos[a].getEspessura())+ Math.abs(testes[a-1][b].getForma() - prototipos[a].getForma());
					BigDecimal ba = new BigDecimal(resultado_ba).setScale(1, RoundingMode.HALF_EVEN);
					Double resultado_ca = Math.abs(testes[a-2][b].getEspessura() - prototipos[a].getEspessura())+ Math.abs(testes[a-2][b].getForma() - prototipos[a].getForma());
					BigDecimal ca = new BigDecimal(resultado_ca).setScale(1, RoundingMode.HALF_EVEN);
					Double resultado_da = Math.abs(testes[a+1][b].getEspessura() - prototipos[a].getEspessura())+ Math.abs(testes[a+1][b].getForma() - prototipos[a].getForma());
					BigDecimal da = new BigDecimal(resultado_da).setScale(1, RoundingMode.HALF_EVEN);
					
					if(mostrarInteracoes)
						System.out.println("interação "+(b+1)+" distancia pp "+ aa.doubleValue() +" distancia pc "+ ba.doubleValue() +" distancia pt "+ ca.doubleValue() +" distancia pj "+ da.doubleValue());
					
					if(aa.doubleValue()<=ba.doubleValue()&aa.doubleValue()<=ca.doubleValue()&aa.doubleValue()<=da.doubleValue()) {
						if(mostrarInteracoes)
							System.out.println("acerto");
						acertos++;
					}
				}
				if(a == 3) {
					Double resultado_aa = Math.abs(testes[a][b].getEspessura() - prototipos[a].getEspessura())+ Math.abs(testes[a][b].getForma() - prototipos[a].getForma());
					BigDecimal aa = new BigDecimal(resultado_aa).setScale(1, RoundingMode.HALF_EVEN);
					Double resultado_ba = Math.abs(testes[a-1][b].getEspessura() - prototipos[a].getEspessura())+ Math.abs(testes[a-1][b].getForma() - prototipos[a].getForma());
					BigDecimal ba = new BigDecimal(resultado_ba).setScale(1, RoundingMode.HALF_EVEN);
					Double resultado_ca = Math.abs(testes[a-2][b].getEspessura() - prototipos[a].getEspessura())+ Math.abs(testes[a-2][b].getForma() - prototipos[a].getForma());
					BigDecimal ca = new BigDecimal(resultado_ca).setScale(1, RoundingMode.HALF_EVEN);
					Double resultado_da = Math.abs(testes[a-3][b].getEspessura() - prototipos[a].getEspessura())+ Math.abs(testes[a-3][b].getForma() - prototipos[a].getForma());
					BigDecimal da = new BigDecimal(resultado_da).setScale(1, RoundingMode.HALF_EVEN);
					
					if(mostrarInteracoes)
						System.out.println("interação "+(b+1)+" distancia jj "+ aa.doubleValue() +" distancia jp "+ ba.doubleValue() +" distancia jc "+ ca.doubleValue() +" distancia jt "+ da.doubleValue());
					
					if(aa.doubleValue()<=ba.doubleValue()&aa.doubleValue()<=ca.doubleValue()&aa.doubleValue()<=da.doubleValue()) {
						if(mostrarInteracoes)
							System.out.println("acerto");
						acertos++;
					}
				}
				
			}
			//imprime a somatoria de acertos e erros juntamente com o prototipo utilizado
			System.out.println(" ---------------------------------------------------------> Acertos: " + acertos);
			System.out.println(" ---------------------------------------------------------> Erros: "+(50-acertos));
			
		}
		
		
		
	}
	
	
	public static void preencherTacas(ArrayList<Vidro> t){
		//declaro o random
		Random gerador = new Random();
		//declaro o array de entrada
		ArrayList<Vidro> tacas = t;
		//preenchendo com os valores aleatorios
		for(int i = 0; 100 > i; i++) {
			Double espessura = gerador.nextDouble() * (1.3 - 0.8) + 0.8;
			Double forma = gerador.nextDouble() * (6.7 - 4.2) + 4.2;
			BigDecimal bd = new BigDecimal(espessura).setScale(1, RoundingMode.HALF_EVEN);
			BigDecimal bd1 = new BigDecimal(forma).setScale(1, RoundingMode.HALF_EVEN);
			//System.out.println("elemento: "  +  i+"espessura: " + bd.doubleValue() + " forma: " + bd1.doubleValue());
			Vidro aleatoria = new Vidro("Taças",bd.doubleValue(), bd1.doubleValue());
			tacas.add(aleatoria);
		}
		
	}
	
	public static void preencherCopos(ArrayList<Vidro> c){
		//declaro o random
		Random gerador = new Random();
		//declaro o array de entrada
		ArrayList<Vidro> copos = c;
		//preenchendo com os valores aleatorios
		for(int i = 0; 100 > i; i++) {
			Double espessura = gerador.nextDouble() * (1.5 - 1.1) + 1.1;
			Double forma = gerador.nextDouble() * (6.5 - 3.9) + 3.9;
			BigDecimal bd = new BigDecimal(espessura).setScale(1, RoundingMode.HALF_EVEN);
			BigDecimal bd1 = new BigDecimal(forma).setScale(1, RoundingMode.HALF_EVEN);
			Vidro aleatoria = new Vidro("Copos",bd.doubleValue(), bd1.doubleValue());
			copos.add(aleatoria);
		}
	
	}
	
	public static void preencherPratos(ArrayList<Vidro> p){
		//declaro o random
		Random gerador = new Random();
		//declaro o array de entrada
		ArrayList<Vidro> pratos = p;
		//preenchendo com os valores aleatorios
		for(int i = 0; 100 > i; i++) {
			Double espessura = gerador.nextDouble() * (1.8 - 1.4) + 1.4;
			Double forma = gerador.nextDouble() * (5.9 - 3.7) + 3.7;
			BigDecimal bd = new BigDecimal(espessura).setScale(1, RoundingMode.HALF_EVEN);
			BigDecimal bd1 = new BigDecimal(forma).setScale(1, RoundingMode.HALF_EVEN);
			Vidro aleatoria = new Vidro("Pratos",bd.doubleValue(), bd1.doubleValue());
			pratos.add(aleatoria);
		}
	
	}
	
	public static void preencherJarras(ArrayList<Vidro> j){
		//declaro o random
		Random gerador = new Random();
		//declaro o array de entrada
		ArrayList<Vidro> jarras = j;
		//preenchendo com os valores aleatorios
		for(int i = 0; 100 > i; i++) {
			Double espessura = gerador.nextDouble() * (1.7 - 1.0) + 1.0;
			Double forma = gerador.nextDouble() * (6.3 - 4.1) + 4.1;
			BigDecimal bd = new BigDecimal(espessura).setScale(1, RoundingMode.HALF_EVEN);
			BigDecimal bd1 = new BigDecimal(forma).setScale(1, RoundingMode.HALF_EVEN);
			Vidro aleatoria = new Vidro("Jarras",bd.doubleValue(), bd1.doubleValue());
			jarras.add(aleatoria);
		}
	
	}
	
	//metodos que constroem um prototipo com base em um array de objetos do tipo
	public static Vidro fazerPrototipo(ArrayList<Vidro> vidros) {
		
		//declara o array de entrada
		ArrayList<Vidro> dados = vidros;
		//somas necessarias para tirar a media
		Double e = 0.0;
		Double f = 0.0;
		//repetiçao que realiza a somatoria da primeira metade dos dados
		for(int i=0;i<50;i++) {
			e = dados.get(i).getEspessura() + e;
			f = dados.get(i).getForma() + f;
			
		}
		Double mediaEspessura = e/50;
		Double mediaForma = f/50;
		
		BigDecimal me = new BigDecimal(mediaEspessura).setScale(1, RoundingMode.HALF_EVEN);
		BigDecimal mf = new BigDecimal(mediaForma).setScale(1, RoundingMode.HALF_EVEN);
		//criação e entrega de um objeto que contem os valores da media (prototipo)
		Vidro media = new Vidro(dados.get(0).getTipo(),me.doubleValue(),mf.doubleValue());
		
		return media;
	}
}

