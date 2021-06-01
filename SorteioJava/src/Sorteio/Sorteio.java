package Sorteio;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;


public class Sorteio {
	private int n;
	private int min;
	private int max;
	private int[] numeros;
	
	public int getN() {
		return n;
	}
	
	public void setN(int n) {
		this.n = n;
	}
	
	public int getMin() {
		return min;
	}
	
	public void setMin(int min) {
		this.min = min;
	}
	
	public int getMax() {
		return max;
	}
	
	public void setMax(int max) {
		this.max = max;
	}
	
	public int[] getNumeros() {
		return numeros;
	}
	
	public void setNumeros(int[] numeros) {
		this.numeros = numeros;
	}
	
	public Sorteio(int n, int min, int max) throws Exception {
		if (n <= 0 || n > 100) {
			throw new Exception("N necessita estar entre 1 e 100.");
		}
		if (min > max) {
			throw new Exception("MIN necessita ser MENOR que MAX.");
		}
		if (min <= 0) {
			throw new Exception("MIN necessita ser maior do que zero.");
		}
		
		setN(n);
		setMin(min);
		setMax(max);
		int[] a = new int[n];
		setNumeros(a);
	}
	void gerarNumeros() throws Exception {
		try {
		while (!terminou()) {
			proximoNumero();
		}
		}catch(Exception e){
			System.out.println(e);
		}
	}
	
	boolean terminou() throws Exception {
		
		int c = 0;
	    for (int d = 0; d < getNumeros().length; d++){
	    	if (getNumeros()[d] == 0){
	    		break;
	    	}
	    	c = d;
	    }
		if(c == getN() - 1) {
			return true;
		}
		return false;
	}	
			
	void proximoNumero() throws Exception {
		try{
			if (terminou()) {
				throw new Exception("O sorteio já terminou.");
		}
		
		Random rand = new Random();
		int range = getMax() - getMin() +1;
		int num = (int) rand.nextInt(range) + getMin();
		boolean c = true;
		while (c) {
			c = false;
			for(int k : getNumeros()) {
			if (num == k) {
				num = (int) rand.nextInt(range) + getMin();
				c = true;
			}
		}
		}
		

		
	    for (int d = 0; d < getNumeros().length; d++){
	    	if (getNumeros()[d] == 0) {
	    		getNumeros()[d] = num;
	    		break;
	    	}    		
	    }
	}catch(Exception e) {
		System.out.println(e);
	}
	}
	
 	public String resultado(String padrao) throws Exception {
 		try {
 		if (padrao == null) {
			throw new Exception("O padrão do resultado não pode ser NULL."); 
		}
 		String str = Arrays.toString(getNumeros());
 		
 		return str.replace(",", padrao);
 		}catch(Exception e){
			System.out.println(e);
			return null;
		}
 	}
}




