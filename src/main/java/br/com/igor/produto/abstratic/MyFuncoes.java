package br.com.igor.produto.abstratic;

import java.math.BigDecimal;
import java.math.RoundingMode;

import br.com.igor.produto.Log;

public class MyFuncoes {
	
	 private static final BigDecimal umQuarto = new BigDecimal("0.25");
	 private static final BigDecimal doisQuarto = new BigDecimal("0.50");
	 private static final BigDecimal tresQuarto = new BigDecimal("0.75");
	
	public  double[] distribuicao(String distribui, String conversa) {
		
	   if (distribui == null || conversa == null || distribui.trim().isEmpty() || conversa.trim().isEmpty()) {
	        Log.registrar("Erro: Entrada vazia ou nula.");
	        return new double[] { 0.0, 0.0 };
	    }
	   
	
		BigDecimal distribuir = new BigDecimal(distribui);
		BigDecimal conversao = new BigDecimal(conversa);
		
		if (conversao.signum() == 0) {
            return new double[] { 0.0, 0.0 };
        }
		
	    BigDecimal[] resultado = new BigDecimal[2];

	    // divisao = distribuir / conversao
	    BigDecimal divisao = distribuir.divide(conversao, 20, RoundingMode.HALF_UP);
	    BigDecimal inteiro = divisao.setScale(0, RoundingMode.FLOOR);
	    BigDecimal resto = divisao.subtract(inteiro);
	    
	    //Log.registrar("\n  Divisão "+divisao+"\n  inteiro "+inteiro+"\n  resto "+resto);

	   

	    if (resto.compareTo(umQuarto) < 0) {
	        resultado[0] = inteiro;
	        resultado[1] = resto.multiply(conversao);

	    } else if (resto.compareTo(umQuarto) >= 0 && resto.compareTo(doisQuarto) < 0) {
	        resultado[0] = inteiro.add(umQuarto);
	        resultado[1] = resto.subtract(umQuarto).multiply(conversao);

	    } else if (resto.compareTo(doisQuarto) >= 0 && resto.compareTo(tresQuarto) < 0) {
	        resultado[0] = inteiro.add(doisQuarto);
	        resultado[1] = resto.subtract(doisQuarto).multiply(conversao);

	    } else {
	        resultado[0] = inteiro.add(tresQuarto);
	        resultado[1] = resto.subtract(tresQuarto).multiply(conversao);
	    }
	    
	    //Log.registrar("\n  ajusto fino [1]"+resultado[1]);
	    resultado[1] = resultado[1].setScale(0, RoundingMode.HALF_UP);
	    //Log.registrar("\n  ajusto fino [1]"+resultado[1]);
	    
	    double[] fim = new  double[2];
	    fim[0]= resultado[0].doubleValue();
	    fim[1]= resultado[1].doubleValue();
	    return fim;
	}
}
