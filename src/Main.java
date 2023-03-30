import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        //System.out.println("Hello world!");

        API api = API.ALURA_IMDB;

        String url = api.getUrl();
        IExtratorDeConteudo extrator = api.getExtrator();

        ClienteHttp http = new ClienteHttp();
        String json = http.buscaDados(url);

        // exibir e manipular os dados
        List<Conteudo> conteudos = extrator.extraiConteudos(json);

        // exibir e manipular os dados
        GeradoraDeFigurinhas geradora = new GeradoraDeFigurinhas();

        try {
            for (int i = 0; i < 10; i++) {

                Conteudo conteudo = conteudos.get(i);

                InputStream inputStream = new URL(conteudo.urlImagem()).openStream();
                String nomeArquivo = "saida/" +
                        conteudo.titulo().replaceAll("[^a-zA-Z0-9]","") +
                        ".png";

                geradora.cria(inputStream, nomeArquivo);

                System.out.println(conteudo.titulo());
                System.out.println();
            }
        } catch (Exception ignored) {}


//        // exibir e manipular os dados
//        for (Map<String,String> filme : listaDeFilmes) {
//            System.out.println(filme.get("title"));
//            System.out.println(filme.get("image"));
//            System.out.println(filme.get("imDbRating"));
//            System.out.println();
//        }

//        // exibir e manipular os dados
//        GeradoraDeFigurinhas geradora = new GeradoraDeFigurinhas();
//        for (Map<String,String> filme : listaDeFilmes) {
//
//            String urlImagem = filme.get("image");
//            String titulo = filme.get("title");
//            String rating = filme.get("imDbRating");
//            String image = filme.get("image");
//
//            InputStream inputStream = new URL(urlImagem).openStream();
//            String nomeArquivo = titulo
//                    .trim()
//                    .replace(" ", "")
//                    .replaceAll("[^a-zA-Z0-9]","")
//                    + ".png";
//
//            geradora.cria(inputStream, nomeArquivo);
//
//            System.out.println(titulo);
//            System.out.println(rating);
//            System.out.println(image);
//            System.out.println(nomeArquivo);
//            System.out.println();
//        }

    }
}