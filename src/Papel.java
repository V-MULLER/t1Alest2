
public class Papel {
	
	private Character tipo;
	private Integer quantidade;
	private Integer preco;
	
	public Papel() {}

	public Papel(Character tipo, Integer quantidade, Integer preco) {
		this.tipo = tipo;
		this.quantidade = quantidade;
		this.preco = preco;
	}

	public Character getTipo() {
		return tipo;
	}

	public void setTipo(Character tipo) {
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
}
