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
		//biblioteca responsavel por deixar o numero com apenas uma casa decimal apos a virgula
		DecimalFormat formatador = new DecimalFormat("0.0");
		//preenchimento dos arrays com dados aleatorios
		preencherTacas(tacas);
		preencherCopos(copos);
		preencherPratos(pratos);
		preencherJarras(jarras);
		
		//Constroi prototipos baseados nas bases de treinamentos (primeira metade dos arrays)
		Vidro prototipoTaca = fazerPrototipo(tacas);
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
		
		//o contador j vai ser responsavel por mudar a base de testes
		for(int j=0;testes.length>j;j++) {
			
			
			//imprime a base de testes que esta sendo usada
			System.out.println("Base de teste: "+testes[j][0].getTipo());
			//o contador k é responsavel por mudar o prototipo
			for(int k=0;prototipos.length>k;k++) {
				//declarando a somatoria de acertos que é zerada a cada novas bases de testes
				int acertos = 0;
				//o contador i é usado por mudar o teste atual
				for(int i=0; 50>i;i++) {
					//utilizando o calculo de camberra descobrir a dimensao da difererença entre o prototipo e o teste atual
					Double resultado = ((testes[j][i].getEspessura() - prototipos[k].getEspessura())/(testes[j][i].getEspessura() + prototipos[k].getEspessura()))+((testes[j][i].getEspessura() - prototipos[k].getEspessura())/(testes[j][i].getEspessura() + prototipos[k].getEspessura()));
					//deixa o resultado em modulo
					resultado = Math.abs(resultado);
					//diminui as casas decimais do double para apenas uma
					BigDecimal bd = new BigDecimal(resultado).setScale(1, RoundingMode.HALF_EVEN);
					//verifica se foi acerto
					if(bd.doubleValue() == 0.0) {
						acertos++;
					}
				}
				//imprime a somatoria de acertos e erros juntamente com o prototipo utilizado
				System.out.println("Testando com prototipo dos(as) "+prototipos[k].getTipo()+ " -> acertos: " + acertos+" erros:"+(50-acertos));
			}
		}
	}
	

	//abaixo temos os metodos que preenchem os arrays com valores aleatorios
	
	public static void preencherTacas(ArrayList<Vidro> t){
		//declaro o random
		Random gerador = new Random();
		//declaro o array de entrada
		ArrayList<Vidro> tacas = t;
		//preenchendo com os valores aleatorios
		for(int i = 0; 100 > i; i++) {
			Double espessura = gerador.nextDouble() * (1.3 - 0.8) + 0.8;
			Double forma = gerador.nextDouble() * (6.7 - 4.2) + 4.2;
			Vidro aleatoria = new Vidro("Taças",espessura, forma);
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
			Vidro aleatoria = new Vidro("Copos",espessura, forma);
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
			Vidro aleatoria = new Vidro("Pratos",espessura, forma);
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
			Vidro aleatoria = new Vidro("Jarras",espessura, forma);
			jarras.add(aleatoria);
		}
	
	}
	
	//metodos que constroem um prototipo com base em um array de objetos do tipo
	public static Vidro fazerPrototipo(ArrayList<Vidro> vidros) {
		//declara o array de entrada
		ArrayList<Vidro> dados = vidros;
		//somas necessarias para tirar a media
		Double somaEspessura = 0.0;
		Double somaForma = 0.0;
		//repetiçao que realiza a somatoria da primeira metade dos dados
		for(int i=0;i<49;i++) {
			somaEspessura = dados.get(i).getEspessura() + somaEspessura;
			somaForma = dados.get(i).getForma() + somaEspessura;
		}
		//criação e entrega de um objeto que contem os valores da media (prototipo)
		Vidro media = new Vidro(dados.get(0).getTipo(),somaEspessura/50,somaForma/50);
		return media;
	}
}

