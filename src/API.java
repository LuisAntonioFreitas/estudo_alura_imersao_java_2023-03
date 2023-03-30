public enum API {

    IMDB_TOP_MOVIES("https://imdb-api.com/en/API/Top250Movies/k_x3pev8lm", //alterar <k_0ojt0yvm> por sua key (imdb)
            new ExtratorDeConteudoDoIMDB()),
    IMDB_TOP_SERIES("https://imdb-api.com/en/API/Top250TVs/k_x3pev8lm", //alterar <k_0ojt0yvm> por sua key (imdb)
            new ExtratorDeConteudoDoIMDB()),
    NASA("https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY&start_date=2022-06-12&end_date=2022-06-14", //alterar <DEMO_KEY> por sua key (nasa)
            new ExtratorDeConteudoDaNasa()),
    ALURA_IMDB("https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json",
            new ExtratorDeConteudoDoIMDB()),
    ALURA_LIMGUAGENS("http://localhost:8080/linguagens",
            new ExtratorDeConteudoDoALURA());

    private String url;
    private IExtratorDeConteudo extrator;

    API(String url, IExtratorDeConteudo extrator) {
        this.url = url;
        this.extrator = extrator;
    }

    public String getUrl() {
        return url;
    }

    public IExtratorDeConteudo getExtrator() {
        return extrator;
    }
}
