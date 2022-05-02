public class WordsGenerator {
    private String[] allWords;
    private String currentWord;

    public WordsGenerator() {
        fillAllWords();
    }


    public String[] getAllWords() {
        return allWords;
    }

    /*
    Deze woordenlijst bestaat uit random woorden die ik zelf heb toegevoegd. Er zijn ook manier om bestanden
    van internet te kopiëren en te plakken zodat uit dat bestand een woord wordt gekozen.
    Voor nu houd ik het nog bij deze woordenlijst omdat ik hier goed de array heb kunnen toepassen.
     */
    public  void fillAllWords() {
         allWords = new String[]{"moeder", "pannekoek", "druivensap", "mammoet", "zool", "bril", "pakjesdoos",
                "kabel", "duitsland", "geld", "jodenkoek", "controller", "biefstuk", "appel", "fles", "boom", "speler",
                "mobiel", "beugel" , "computer", "beer", "beker", "pen", "bal", "bed", "water", "oplader", "dakraam",
                "geld", "deur", "kast", "auto", "snelweg", "sneeuw", "koptelefoon", "banaan", "regen", "galgje", "munt",
                 "water", "vuur", "wind", "aarde", "toetsenbord", "app", "kaart", "mondkapje", "lenzen", "raam", "code"
        };
    }

    public String getRandomWord() {
        return allWords[(int) (Math.random() * allWords.length)];
    }

    public void generateRandomWord() {
        this.currentWord = getRandomWord();
    }

    public String getCurrentWord() {
        return this.currentWord;
    }



}
