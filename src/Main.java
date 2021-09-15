import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		LeituraDeArquivo arquivo = new LeituraDeArquivo();

		arquivo.leArquivo(Paths.get("trinta_enunciado.txt"));
		Collections.sort(arquivo.getPapeis());
		double lucroTotal = 0;
		int comprasRestantes = 0;
		int vendasRestantes = 0;

	
		 else {}
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
	
	public static String calculaCompraEVenda(List<Papel> listaDeCompra, List<Papel> listaDeVenda) {
		
		
		return null; 
	}
	
	//Lógica ainda em estudo kkk
	/*	for (int i = 0; i < arquivo.getPapeis().size(); i++) {
			if (arquivo.getPapeis().get(i).getTipo() == 'c') {
				for (int j = arquivo.getPapeis().size(); j > arquivo.getPapeis().size() - i; j--) {
					if (arquivo.getPapeis().get(j).getTipo() == 'v') {
						lucroTotal += arquivo.getPapeis().get(i).getPreco() - arquivo.getPapeis().get(j).getPreco();
						arquivo.getPapeis().get(i).setQuantidade(
								calculaQuantidade(arquivo.getPapeis().get(i), arquivo.getPapeis().get(j)));

					}
				}
			}
		}
	 */
	 
}
