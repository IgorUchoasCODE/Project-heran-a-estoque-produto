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
		this.normalizar();
	}
	
	
	public String getNome() {return this.nome;}
	public String getNomePai() {if( this.produtoPai == null) { return null;} else {return this.produtoPai.getNome();} }
	public double getMinhaProporcao() {return this.minhaProporcao;}
	public double getProporcaoHeranca() {return this.proporcaoHeraca;}
	public double getGlobalEstoqueProduto() {return Produtos.globalEstoque;}
	public double getEstoqueAtual() {return this.meuEtoque;}
	public double getEstoqueHerranca() {return this.herancaEstoque;}
	public Produto getObjetoProdutoPai() {if(this.getNomePai() != null) {return this.produtoPai;} return null;}
	
	
	public void adicionarEstoque(double quantidade){
		Log.registrar("Adicionado quantidade: "+ quantidade + " Produto: " + this.nome);
		
		if (this.produtoPai == null) {
			this.meuEtoque += quantidade / this.minhaProporcao;
			this.herancaEstoque = this.meuEtoque * this.proporcaoHeraca;
			Produtos.globalEstoque = this.meuEtoque;
			return;
		}
		
		
	}
	
	public void normalizar() {
		if (this.getNomePai() == null ) {
			Log.registrar(getNome() + " esse produto é uma raiz");
			
			this.herancaEstoque = this.meuEtoque * this.proporcaoHeraca;
			
			Log.registrar(nome + " normalização concluída");
			return;
		}
		Log.registrar("| Esse produto " + nome + " é herdeiro de " + this.getNomePai());
		
		this.produtoPai.normalizar();
		this.meuEtoque = this.produtoPai.herancaEstoque/ this.minhaProporcao;
		this.herancaEstoque = this.meuEtoque * this.proporcaoHeraca;
		Produtos.globalEstoque += this.meuEtoque;
		
		Log.registrar("| "+nome + " normalização concluída");
	}
	
	
}
