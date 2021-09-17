
public class Papel implements Comparable<Papel>{
	
	private String tipo;
	private Integer quantidade;
	private Integer preco;
	
	public Papel() {}

	public Papel(String tipo, Integer quantidade, Integer preco) {
		this.tipo = tipo;
		this.quantidade = quantidade;
		this.preco = preco;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Integer getPreco() {
		return preco;
	}

	public void setPreco(Integer preco) {
		this.preco = preco;
	}

	@Override
	public String toString() {
		return "Papel [tipo=" + tipo + ", quantidade=" + quantidade + ", preco=" + preco + "]";
	}

	@Override
	public int compareTo(Papel outroPapel) {
		if(this.preco > outroPapel.getPreco()) {
			return -1;
		}
		if(this.preco < outroPapel.getPreco()) {
			return 1;
		}
		return 0;
	}
}
