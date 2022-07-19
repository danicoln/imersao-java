import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;

public class Desafios {
    public static void main(String[] args) throws Exception {

        // Desafio 1.
        // Consumir o endpoint de filmes mais populares;
        // Melhores séries;
        // Séries mais populares.

        //String url = "https://imdb-api.com/en/API/MostPopularMovies/k_dl148dyd"; // filmes mais populares;
        //String url = "https://imdb-api.com/en/API/Top250TVs/k_dl148dyd"; // melhores séries;
        //String url = "https://imdb-api.com/en/API/MostPopularTVs/k_dl148dyd"; // séries mais populares;
        String url = "https://mocki.io/v1/9a7c1ca9-29b4-4eb3-8306-1adb9d159060"; // Substitui os endpoints anteriores;
        URI endereco = URI.create(url);
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(endereco).GET().build();
        var response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String body = response.body();
        System.out.println(body);

        // Pega apenas os dados: título, poster e notas do filme.
        var parser = new JsonParser();
        List<Map<String, String>> listaDeFilmes = parser.parse(body);

        // Exibir e manipular os dados
        for (Map<String, String> filme : listaDeFilmes) {
            System.out.println(filme.get("title"));
            System.out.println(filme.get("image"));
            System.out.println("\u001b[42;1m Classificação\u001b[0m: " + filme.get("imDbRating"));
            System.out.println("-------------------------------------------------------");

        }
    }
}
