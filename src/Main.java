import java.nio.file.Paths;

public class Main {
	public static void main(String[] args) {
		LeituraDeArquivo arquivo = new LeituraDeArquivo();
		
		arquivo.leArquivo(Paths.get("trinta_enunciado.txt"));
		
		for(Papel obj : arquivo.getPapeis()) {
			System.out.println(obj);
		}
	}
}
