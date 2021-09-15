import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		LeituraDeArquivo arquivo = new LeituraDeArquivo();

		
		
		double lucroTotal = 0;
		int comprasRestantes = 0;
		int vendasRestantes = 0;
		
		List<Papel> compras = retornaListaDeCompras(arquivo.getPapeis());
		List<Papel> vendas = retornaListaDeVendas(arquivo.getPapeis());
		
		test(arquivo);
	
		
	}

	public static Integer calculaQuantidade(Papel p1, Papel p2) {
		int qtd = p1.getQuantidade() - p2.getQuantidade();
		if (qtd < 0) {
			return 0;
		}
		return qtd;
	}
	
	public static List<Papel> retornaListaDeCompras(List<Papel> listaGeral){
		List<Papel> listaDeCompras = new ArrayList<>();
		for(Papel obj : listaGeral) {
			if (obj.getTipo() == 'c') {
				listaDeCompras.add(obj);
			}
		}
		Collections.sort(listaDeCompras);
		return listaDeCompras;
	}
	
	public static List<Papel> retornaListaDeVendas(List<Papel> listaGeral){
		List<Papel> listaDeVendas = new ArrayList<>();
		for(Papel obj : listaGeral) {
			if (obj.getTipo() == 'v') {
				listaDeVendas.add(obj);
			}
		}
		Collections.sort(listaDeVendas);
		return listaDeVendas;
	}
	
	/*public static String calculaCompraEVenda(List<Papel> listaDeCompra, List<Papel> listaDeVenda) {
		for(int i = 0; i < listaDeCompra.size(); i++) {
			for(int j = listaDeVenda.size(); j >= listaDeVenda.size(); j--) {
				int precoCompra = listaDeCompra.get(i).getPreco();
				int qtdCompra = listaDeCompra.get(i).getQuantidade();
				int precoVenda = listaDeVenda.get(j).getPreco();
				int qtdVenda = listaDeVenda.get(j).getQuantidade();
				if()
			}
		}
		
		return null; 
	}*/
	
	public static void test(LeituraDeArquivo arquivo) {
		arquivo.leArquivo(Paths.get("trinta_enunciado.txt"));
		
		double lucroTotal = 0;
		int comprasRestantes = 0;
		int vendasRestantes = 0;

		for (int i = 0; i < arquivo.getPapeis().size(); i++) {
			if (arquivo.getPapeis().get(i).getTipo() == 'c') {
				for (int j = arquivo.getPapeis().size(); j > arquivo.getPapeis().size() - i; j--) {
					
					int precoCompra = arquivo.getPapeis().get(i).getPreco();
					int qtdCompra = arquivo.getPapeis().get(i).getQuantidade();
					int precoVenda = arquivo.getPapeis().get(j).getPreco();
					int qtdVenda = arquivo.getPapeis().get(j).getQuantidade();
					
					if ((arquivo.getPapeis().get(j).getTipo() == 'v' && (precoCompra <= arquivo.getPapeis().get(j).getPreco() && arquivo.getPapeis().get(j).getQuantidade() > 0)) 
							|| qtdCompra > 0) {
						
						lucroTotal += (precoCompra - precoVenda) * qtdCompra;
						arquivo.getPapeis().get(i).setQuantidade(
								calculaQuantidade(arquivo.getPapeis().get(i), arquivo.getPapeis().get(j)));
						arquivo.getPapeis().get(j).setQuantidade(
								calculaQuantidade(arquivo.getPapeis().get(j), arquivo.getPapeis().get(i)));
					}
					else {
						//if(qtdVenda == 0) {
							//arquivo.getPapeis().remove(j);
						//}
						
						continue;
					}
				}
			}
			//se for venda
			else {
				for (int j = 0; j < i; j++) {
					int precoCompra = arquivo.getPapeis().get(j).getPreco();
					int qtdCompra = arquivo.getPapeis().get(j).getQuantidade();
					int precoVenda = arquivo.getPapeis().get(i).getPreco();
					int qtdVenda = arquivo.getPapeis().get(i).getQuantidade();
					
					if ((arquivo.getPapeis().get(j).getTipo() == 'c' && (precoVenda >= precoCompra && qtdCompra > 0)) || qtdVenda > 0) {
						
						lucroTotal += (precoVenda - precoCompra) * qtdVenda;
						arquivo.getPapeis().get(i).setQuantidade(
								calculaQuantidade(arquivo.getPapeis().get(i), arquivo.getPapeis().get(j)));
						arquivo.getPapeis().get(j).setQuantidade(
								calculaQuantidade(arquivo.getPapeis().get(i), arquivo.getPapeis().get(j)));
					}
					else {
						//if(qtdCompra == 0) {
							//arquivo.getPapeis().remove(j);
						//}
						
						continue;
					}
				}
			}
		}
		
		System.out.println(lucroTotal);
	 }
	 
}
