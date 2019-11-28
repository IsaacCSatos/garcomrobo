package classes;

public class ItensPedido {
	private int idItensPedido;
	private int idPedido;
	private int idProduto;
	private int quantidade;
	private double valorUni;
	private double valorTotal;
	private String observacao;
	
	public ItensPedido() {
	}

	public int getIdItensPedido() {
		return idItensPedido;
	}

	public void setIdItensPedido(int idItensPedido) {
		this.idItensPedido = idItensPedido;
	}

	public int getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}

	public int getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public double getValorUni() {
		return valorUni;
	}

	public void setValorUni(double valorUni) {
		this.valorUni = valorUni;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	
	
}
