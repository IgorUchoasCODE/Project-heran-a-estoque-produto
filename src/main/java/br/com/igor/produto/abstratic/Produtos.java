package br.com.igor.produto.abstratic;

import br.com.igor.produto.Log;
import br.com.igor.produto.concreta.Produto;

public abstract class Produtos {
	
	protected static double globalEstoque;
	
	protected String nome; 
	protected double minhaProporcao;
	protected double proporcaoHeraca;
	protected Produto produtoPai;
	
	protected double meuEtoque;
	protected double herancaEstoque;

	

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
	
	
	
	
	
	
	
	public double adicionarEstoque(double quantidade){
					Log.registrar("Verificando entrada valida "+ this.nome);
		
		if (quantidade <= 0) {System.out.println("valor deve ser maior que 0: "+ quantidade); return this.herancaEstoque;}
		
		MyFuncoes mf = new MyFuncoes();
		double resultado = 0;
		
		if (this.produtoPai == null) {
			
			double[] dist = mf.distribuicao(String.valueOf(quantidade), String.valueOf(this.minhaProporcao));
			
					Log.registrar("||Distribuição Inteiro[0]= "+dist[0]+" Resto resto[1]= "+ dist[1] );
			
			this.meuEtoque += dist[0];
			this.herancaEstoque = (this.meuEtoque * this.proporcaoHeraca)+dist[1];
			
					Log.registrar("||Meu Estoque "+ this.meuEtoque+" estoque filho "+this.herancaEstoque);
			
			resultado = this.herancaEstoque;
			
		}else {
			
					Log.registrar("||Esse produto herda de do produto "+ this.getNomePai());
			
			double[] dist = new double[2];
			dist = mf.distribuicao(String.valueOf(quantidade), String.valueOf(this.produtoPai.proporcaoHeraca));
					
					Log.registrar("||Convertendo para proporção do pai "+dist[0]+" X "+dist[1]);
			
			double [] Mydist = mf.distribuicao(String.valueOf(this.produtoPai.adicionarEstoque(dist[0])+dist[1]), 
					String.valueOf(this.minhaProporcao));
			
					Log.registrar("||Esse produto "+nome+" distribuirá com sua proporção "+Mydist[0]+" X "+Mydist[1]);
			
			this.meuEtoque = Mydist[0];
			this.herancaEstoque = (this.meuEtoque * this.proporcaoHeraca) + Mydist[1];
			
					Log.registrar("||Estoque herdado "+this.meuEtoque+" Estoque filho "+this.herancaEstoque);
			
			resultado = this.herancaEstoque;
		}
		
		
			
		return resultado;
	}//======================fim do metodo
	
	

	private void normalizar() {
		
		if (this.produtoPai == null) { 
							Log.registrar("||Esse produto é raiz " + this.getNome());
			return;}
							Log.registrar("Esse produto Vai herda de "+this.getNomePai() + " seus valores");
		
		MyFuncoes mf = new MyFuncoes();
		
		double[] Mydist = mf.distribuicao(String.valueOf(this.produtoPai.herancaEstoque),String.valueOf(this.minhaProporcao));
		
		this.meuEtoque = Mydist[0];
		this.herancaEstoque = (this.meuEtoque * this.proporcaoHeraca) + Mydist[1];
		
							Log.registrar("Valores ajusatdos com sucesso " + this.meuEtoque);
	}
	
	
}
