package br.com.igor.produto.abstratic;

import br.com.igor.produto.Log;
import br.com.igor.produto.LogSistema;
import br.com.igor.produto.concreta.Produto;

public abstract class Produtos {
	
	protected static double globalEstoque;
	
	protected String nome; 
	protected double minhaProporcao;
	protected double proporcaoHeraca;
	protected Produto produtoPai;
	
	protected double meuEtoque;
	protected double herancaEstoque;
	private double restoEstoque;
	

	public Produtos(String nome, Produto produtoPai, double minhaProporcar, double proporcaoHeranca) {
		this.nome = nome;
		this.produtoPai = produtoPai;
		this.minhaProporcao = minhaProporcar;
		this.proporcaoHeraca = proporcaoHeranca;
		
		Log.registrar("Criando Produto " + nome);
		
	
	}
	
	
	public String getNome() {return this.nome;}
	public String getNomePai() {if( this.produtoPai == null) { return null;} else {return this.produtoPai.getNome();} }
	public double getMinhaProporcao() {return this.minhaProporcao;}
	public double getProporcaoHeranca() {return this.proporcaoHeraca;}
	public double getEstoqueAtual() {return this.meuEtoque;}
	public double getEstoqueHerranca() {return this.herancaEstoque;}
	public Produto getObjetoProdutoPai() {if(this.getNomePai() != null) {return this.produtoPai;} return null;}
	
	@SuppressWarnings("static-access")
	public void adicionarEstoque(double quantidade){
		Log.registrar("Adicionado quantidade: "+ quantidade + " Produto: " + this.nome);
	}
	
}
