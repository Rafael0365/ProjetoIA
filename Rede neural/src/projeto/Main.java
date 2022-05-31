package projeto;

import java.util.ArrayList;

public class Main {
	private static int t= 1;
	
	public static void main(String[] args) {
		//criaçao de uma lista de amostras
		ArrayList<Amostra> amostras = new ArrayList<Amostra>();
		//declaraçao das amostras (x1,x2,saida desejada) e adiçao a lista de amostras
		Amostra amostra1 = new Amostra(0,0,0);
		amostras.add(amostra1);
		Amostra amostra2 = new Amostra(0,1,1);
		amostras.add(amostra2);
		Amostra amostra3 = new Amostra(1,0,1);
		amostras.add(amostra3);
		Amostra amostra4 = new Amostra(1,1,1);
		amostras.add(amostra4);
		
		int i =0;
		
		int w1 = 0;
		int w2 = 0;
		int w3 = 0;
		int it = 0;
		int saidaReal;
		while(amostras.size()>i) {
			it++;
			int soma = (amostras.get(i).getX1()*w1)+(amostras.get(i).getX2()*w2)+(t*w3);
			if(soma>0) {
				saidaReal = 1;
			}else{
				saidaReal = 0;
			}
			
			System.out.println("Instante de tempo: "+it+ " Amostra: "+ (i+1)+" Entradas: (" + amostras.get(i).getX1()+", "+amostras.get(i).getX2()+", " + t+") Pesos: ("
					+ w1 + ", "+w2+", "+w3+") Soma: "+ soma +" saida real: "+saidaReal+" saida desejada: "+ amostras.get(i).getSaidaDesejada());
			
			
			
			if(saidaReal==0 & amostras.get(i).getSaidaDesejada()==1) {
				it++;
				System.out.println("Instante de Tempo: "+it+" Soma ao peso: ("+ amostras.get(i).getX1()+", "+amostras.get(i).getX2()+", " + t+")");
				w1 = w1 + amostras.get(i).getX1();
				w2 = w2 + amostras.get(i).getX2();
				w3 = w3 + t;
				//colocar um novo if que vai verificar antes de zerar
				i = 0;
			}
			if(saidaReal==1 & amostras.get(i).getSaidaDesejada() == 0) {
				it++;
				System.out.println("Instante de Tempo: "+it+" Subtrai ao peso: ("+ amostras.get(i).getX1()+", "+amostras.get(i).getX2()+", " + t+")");
				w1 = w1 - amostras.get(i).getX1();
				w2 = w2 - amostras.get(i).getX2();
				w3 = w3 - t;
				//colocar um novo if que vai verificar antes de zerar
				i = 0;
			}else if(saidaReal == amostras.get(i).getSaidaDesejada()){
				i++;
			}
			//14~16 instantes de tempos
			
		}

	}

}
