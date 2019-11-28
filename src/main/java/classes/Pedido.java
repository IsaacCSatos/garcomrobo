package classes;

public class Pedido {
	private int idPedido;
	private double valorTotal;
	private String status;
	private Mesa idMesa;
	
	public int getIdPedido() {
		return idPedido;
	}
	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}
	public double getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Mesa getIdMesa() {
		return idMesa;
	}
	public void setIdMesa(Mesa idMesa) {
		this.idMesa = idMesa;
	}
	
	
}
