import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class LeituraDeArquivo {

	private List<Papel> papeis = new ArrayList<>();
	
	public LeituraDeArquivo() {}
	
	public void leArquivo(Path path) {
		try (BufferedReader br = Files.newBufferedReader(path, Charset.defaultCharset())) {
			String line = br.readLine();

			line = br.readLine();
			while (line != null) {
				String[] fields = line.split(" ");
				//List<String> fields = Arrays.asList(vect);
				Character tipo = fields[0].charAt(0);
				Integer quantidade = Integer.parseInt(fields[1]);
				Integer preco = Integer.parseInt(fields[2]);

				papeis.add(new Papel(tipo, quantidade, preco));

				line = br.readLine();
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
			
		}
	}

	public List<Papel> getPapeis() {
		return papeis;
	}
}
