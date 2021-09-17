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
		arquivo.leArquivo(Paths.get("trinta_enunciado.txt"));
		
		
		
		/*for(Papel obj : arquivo.getPapeis()) {
			System.out.printf("%d\n",obj.getPreco());
		}*/
		

		test2(arquivo);

	}

	
	public static double calculaVenda(Papel venda, Papel compra) {
		double lucroDaOperacao = 0.0;
		//o valor é maior ou igual o da venda
		if(venda.getPreco() <= compra.getPreco() && compra.getQuantidade() > 0) {
			//se quantidade do estoque de venda é maior que o de compra
			if(venda.getQuantidade() - compra.getQuantidade() > 0) {
				//multiplica o valor da diferença pela quantidade do estoque de compra que foi zerado
				lucroDaOperacao = (compra.getPreco() - venda.getPreco()) * compra.getQuantidade();
				//seta o estoque de venda, como é maior que o de compra vai ser >0
				venda.setQuantidade(venda.getQuantidade() - compra.getQuantidade());
				//seta em zero já que a diferença ia dar negativo
				compra.setQuantidade(0);
				return lucroDaOperacao;
			}
			//se quantidade do estoque de venda é menor que o de compra
			else {
				//multiplica o valor da diferença pela quantidade do estoque de venda que foi zerado
				lucroDaOperacao = (compra.getPreco() - venda.getPreco()) * venda.getQuantidade();
				venda.setQuantidade(0);
				compra.setQuantidade(compra.getQuantidade() - venda.getQuantidade());
				return lucroDaOperacao;
			}
		}
		return lucroDaOperacao;
	}
	
	public static double calculaCompra(Papel compra, Papel venda) {
		double lucroDaOperacao = 0.0;
		//o valor de venda ou igual o de compra
		if(compra.getPreco() >= venda.getPreco() && venda.getQuantidade() > 0) {
			//se a quantidade do estoque de compra é maior que o de venda
			if(compra.getQuantidade() - venda.getQuantidade() > 0) {
				//multiplica a diferença pelo estoque de venda que vai ser zerado
				lucroDaOperacao = (compra.getPreco() - venda.getPreco()) * venda.getQuantidade();
				//seta o estoque de compra, como o estoque de venda é maior vai ser >0
				compra.setQuantidade(compra.getQuantidade() - venda.getQuantidade());
				//seta em zero pra não ficar negativo
				venda.setQuantidade(0);
				return lucroDaOperacao;
			}
			//se a quantidade do estoque de compra é menor que o de venda
			else {
				//multiplica a diferença pelo estoque de compra que vai ser zerado
				lucroDaOperacao = (compra.getPreco() - venda.getPreco()) * compra.getQuantidade();
				//seta o estoque de venda, como o estoque de venda é maior vai ser >0
				venda.setQuantidade(venda.getQuantidade() - compra.getQuantidade());
				//seta em 0 para não ficar negativo
				compra.setQuantidade(0);
				return lucroDaOperacao;
			}
		}
		return lucroDaOperacao;
	}


	public static void test2(LeituraDeArquivo arquivo) {
		arquivo.leArquivo(Paths.get("trinta_enunciado.txt"));
		double lucroTotalVenda = 0.0;
		double lucroTotalCompra = 0.0;
		int comprasRestantes = 0;
		int vendasRestantes = 0;
		//Collections.sort(arquivo.getPapeis());
		
		for (int i = 0; i < arquivo.getPapeis().size(); i++) {
			for(int j = i + 1; j < arquivo.getPapeis().size(); j++) {
				//SE COMPRA E VENDA e tiver estoque
				if(arquivo.getPapeis().get(i).getTipo().equals("C") && arquivo.getPapeis().get(j).getTipo().equals("V")
						&&(arquivo.getPapeis().get(i).getQuantidade() != 0 || arquivo.getPapeis().get(j).getQuantidade() != 0)) {
					
					lucroTotalCompra += calculaCompra(arquivo.getPapeis().get(i), arquivo.getPapeis().get(j));
					System.out.println("compra: " + lucroTotalCompra);
				}
				//SE VENDA E COMPRA e tiver estoque
				else if(arquivo.getPapeis().get(i).getTipo().equals("V") && arquivo.getPapeis().get(j).getTipo().equals("C")
						&&(arquivo.getPapeis().get(i).getQuantidade() != 0 || arquivo.getPapeis().get(j).getQuantidade() != 0)) {
					
					lucroTotalVenda += calculaVenda(arquivo.getPapeis().get(i), arquivo.getPapeis().get(j));
					System.out.println("venda: " + lucroTotalVenda);
				}
				//se nenhuma
				else {
					continue;
				}
			}
		}
		System.out.println(lucroTotalCompra + lucroTotalVenda);
	}
	
}
