package projeto;

import java.util.ArrayList;

public class Main {
	private static int t= 1;
	
	public static void main(String[] args) {
		//cria�ao de uma lista de amostras
		ArrayList<Amostra> amostras = new ArrayList<Amostra>();
		//declara�ao das amostras (x1,x2,saida desejada) e adi�ao a lista de amostras
		Amostra amostra1 = new Amostra(0,0,0);
		amostras.add(amostra1);
		Amostra amostra2 = new Amostra(0,1,1);
		amostras.add(amostra2);
		Amostra amostra3 = new Amostra(1,0,1);
		amostras.add(amostra3);
		Amostra amostra4 = new Amostra(1,1,1);
		amostras.add(amostra4);
		
		// contador responsavel por manter a repeti�ao
		int i =0;
		
		//declara�ao dos pesos
		int w1 = 0;
		int w2 = 0;
		int w3 = 0;
		
		//it � o instante de tempo, que ser� alterado durante a repeti�ao
		int it = 0;
		
		//saida real � a variavel que ir� armazenar 1 ou 0 responsavel por dizer se haver� altera�ao nos pesos
		int saidaReal;
		
		// repeti�ao que so vai parar quando o treinamento finalizar
		while(amostras.size()>i) {
			//incremento do instante de tempo
			it++;
			//faz o calculo da saida
			int soma = (amostras.get(i).getX1()*w1)+(amostras.get(i).getX2()*w2)+(t*w3);
			//Fun�ao de ativa��o que da a saida real
			if(soma>0) saidaReal = 1;
			else saidaReal = 0;
			
			//print que informa o andamento do trinamento
			System.out.println("Instante de tempo: "+it+ " Amostra: "+ (i+1)+" Entradas: (" + amostras.get(i).getX1()+", "+amostras.get(i).getX2()+", " + t+") Pesos: ("
					+ w1 + ", "+w2+", "+w3+") Soma: "+ soma +" saida real: "+saidaReal+" saida desejada: "+ amostras.get(i).getSaidaDesejada());
			
			//se a saida real nao for a desejada ele entra no recalcular peso
			if(saidaReal != amostras.get(i).getSaidaDesejada()){
				
				//recalcula peso baseado na regra passada
				if(saidaReal==0 & amostras.get(i).getSaidaDesejada()==1) {
					it++;
					System.out.println("Instante de Tempo: "+it+" Soma ao peso: ("+ amostras.get(i).getX1()+", "+amostras.get(i).getX2()+", " + t+")");
					w1 = w1 + amostras.get(i).getX1();
					w2 = w2 + amostras.get(i).getX2();
					w3 = w3 + t;
					//teste que vai verificar antes de zerar o contador
					int verifica = (amostras.get(i).getX1()*w1)+(amostras.get(i).getX2()*w2)+(t*w3);
					if(verifica>0) verifica = 1;
					else verifica = 0;
					if(verifica == amostras.get(i).getSaidaDesejada()) {
						i = 0;
					}
					
					
				}
				if(saidaReal==1 & amostras.get(i).getSaidaDesejada() == 0) {
					it++;
					System.out.println("Instante de Tempo: "+it+" Subtrai ao peso: ("+ amostras.get(i).getX1()+", "+amostras.get(i).getX2()+", " + t+")");
					w1 = w1 - amostras.get(i).getX1();
					w2 = w2 - amostras.get(i).getX2();
					w3 = w3 - t;
					//teste que vai verificar antes de zerar o contador
					int verifica = (amostras.get(i).getX1()*w1)+(amostras.get(i).getX2()*w2)+(t*w3);
					if(verifica>0) verifica = 1;
					else verifica = 0;
					if(verifica == amostras.get(i).getSaidaDesejada()) {
						i = 0;
					}
					
				}
			}else {
				//se a saida real for igual a desejada o contador avan�a chamando mais uma amostra
				i++;
			}
			//14~16 instantes de tempos
			
		}

	}

}
