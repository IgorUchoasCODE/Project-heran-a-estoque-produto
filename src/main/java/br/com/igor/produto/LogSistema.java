package br.com.igor.produto;

import java.util.ArrayList;



public class LogSistema {

	private static final ArrayList<String> logs = new ArrayList<String>();
	private static int contador= 0;


    public static void registrar(String mensagem) {
    	contador ++;
        logs.add(contador + " => " +mensagem);
    }

    public static void imprimirTudo() {
        System.out.println("\n===== LOG DO SISTEMA ===========================");
        for (String log : logs) {
            System.out.println(log);
        }
        System.out.println("===== FIM DO LOG =================================\n");
    }
}
