import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
    
        //Fazer conexão HTTP e buscando os filmes do IMDB
        String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
        URI endereco = URI.create(url);
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();
        System.out.println(body);

        //EXTRAIR OS DADOS QUE INTERESSAM (TITULO, POSTER, CLASSIFICAÇÃO)
        var parser = new JsonParser();
        List<Map<String, String>> listaDeFilmes = parser.parse(body);

        //EXIBIR E MANIPULAR OS DADOS
        for (Map<String,String> filme : listaDeFilmes) {
            System.out.println("\u001b[37;1m \u001b[41;1m\u001b[5mTitulo\u001b[m - " + filme.get("title"));
            System.out.println("\u001b[1mPoster\u001b[m - "+ filme.get("image"));
            System.out.println(filme.get("imDbRating"));
            System.out.println();
            
        }
    }
}