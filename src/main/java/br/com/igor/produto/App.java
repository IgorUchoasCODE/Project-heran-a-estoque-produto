package br.com.igor.produto;

import br.com.igor.produto.concreta.Produto;

public class App {

	public static void main(String[] args) {
		
		IniciarEstoque();
		Log.imprimirTudo();

	}
	
	public static void IniciarEstoque() {
		Produto produto = new Produto("Caixa Ovos Branco B", null, 1, 360);
		produto.adicionarEstoque(1);
		System.out.println(produto.getNome());
		System.out.println("Produto estou herdando de "+produto.getNomePai());
		System.out.println("proporçao: "+ produto.getMinhaProporcao()+" X "+produto.getProporcaoHeranca());
		System.out.println("Estoque Atual: "+produto.getEstoqueAtual()+" Estoque herança: "+produto.getEstoqueHerranca());
	
		System.out.println();
		Produto produto1 = new Produto("Cartela Ovos Branco B", produto, 30,30 );
		System.out.println(produto1.getNome());
		System.out.println("Produto estou herdando de "+produto1.getNomePai());
		System.out.println("proporçao: "+ produto1.getMinhaProporcao()+" X "+produto1.getProporcaoHeranca());
		System.out.println("Estoque Atual: "+produto1.getEstoqueAtual()+" Estoque herança: "+produto1.getEstoqueHerranca());
		
		System.out.println();
		produto1.adicionarEstoque(16);
		
		System.out.println();
		System.out.println(produto.getNome());
		System.out.println("Produto estou herdando de "+produto.getNomePai());
		System.out.println("proporçao: "+ produto.getMinhaProporcao()+" X "+produto.getProporcaoHeranca());
		System.out.println("Estoque Atual: "+produto.getEstoqueAtual()+" Estoque herança: "+produto.getEstoqueHerranca());

		System.out.println();
		System.out.println(produto1.getNome());
		System.out.println("Produto estou herdando de "+produto1.getNomePai());
		System.out.println("proporçao: "+ produto1.getMinhaProporcao()+" X "+produto1.getProporcaoHeranca());
		System.out.println("Estoque Atual: "+produto1.getEstoqueAtual()+" Estoque herança: "+produto1.getEstoqueHerranca());
		
	}

}
