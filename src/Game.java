import java.util.Scanner;

public class Game {
    private Player currentPlayer;
    private Scanner sc;

    public Game() {
        sc = new Scanner(System.in);
    }

   /*
   De naam van de speler wordt gevraagd en opgeslagen als de currentPlayer.
   Ik heb .next gehanteerd zodat er niet een specifieke regel aangeklikt hoeft te worden.
   De speler typt zijn naam en kan beginnen.
    */
    public void prepareGame() {
        System.out.println("Voer spelersnaam in: ");
        String playerName = sc.next();

        currentPlayer = new Player(playerName);
    }


    /*
    Hier wordt het hele spel afgespeeld nadat de speler zijn of haar naam heeft ingevoerd.
     */
    public void startGame() {
        System.out.println("Welkom " + currentPlayer.getName());

        boolean playingGame = true;
        while (playingGame) {

            /*
            Hier wordt de WordsGenerator aangeroepen om te beginnen met zijn taken.
             */
            WordsGenerator wg = new WordsGenerator();
            wg.generateRandomWord();

            /*
            Het is handig om te zien welke letters er nog gebruikt kunnen worden om herhaling te voorkomen.
            Daarom heb ik een String met het alfabet gemaakt die de letters wegschrijft als ze gebruikt zijn.
             */
            String notUsed = "abcdefghijklmnopqrstuvwxyz";


            /*
            Hier wordt het woord in puntjes weergeven. Elke correcte letter vervangt het puntje
            en zo wordt het woord om te raden langzaam zichtbaar.
             */
            System.out.println("Het woord heeft " +  wg.getCurrentWord().length() + " letters");

            char[] letters = new char[wg.getCurrentWord().length()];

            for (int i = 0; i < letters.length; i++) {
                letters[i] = '.';
            }

            /*
            Eerst gebruikte ik levens omdat ik nog geen idee voor de tekening had. Deze levens heb ik later gekoppeld
            aan de tekening die in DrawHangman staat. Hier stond dus ook eerst een for loop die voor elke foute letter
            een leven af schreef.
             */
            int lives = 10;

            while (lives > 0) {

                this.drawHangman(lives);

               /*
               De letter die de speler moet invoeren moet natuurlijk wel gelezen worden.
               Hiervoor heb ik een scanner gemaakt. Met de boolean isGuestCorrect wordt
               bepaald of de letter in het woord zit. Dit zit in de while loop waardoor
               dit ook herhaald wordt.
                */
                System.out.println("Voer een letter in: ");

                String input = sc.next();

                char letter = input.charAt(0);


                boolean isGuestCorrect = false;

                for (int i = 0; i < wg.getCurrentWord().length(); i++) {
                    char x = wg.getCurrentWord().charAt(i);

                    if (x == letter) {
                        letters[i] = x;
                        isGuestCorrect = true;
                    }
                }

                if (!isGuestCorrect) {
                    lives = lives - 1;
                }

                /*
                Met een boolean geef ik hier aan of het spel door moet blijven gaan na
                elke geraden letter. Want als het woord al volledig is geraden
                dan moet dat ook aangegeven worden en moet de for loop verbroken
                worden.
                 */
                boolean isGameFinished = true;

                System.out.print("Woord ");
                for (int i = 0; i < letters.length; i++) {
                    if (letters[i] == '.') {
                        isGameFinished = false;
                    }

                    System.out.print(letters[i]);
                }
                System.out.println();

                /*
                Hieronder staan nog 2 lijnen die ervoor zorgen dat het alfabet telkens wordt
                gerefreshed. Hij wordt ook constant opnieuw getekend omdat het in de
                while loop staat. Telkesn als er een letter wordt geraden wordt het
                weggeschreven. De string hiervoor met het alfabet is bovenin al 1 keer
                genoemd. Hij staat bovenin omdat anders het alfabet telkens wordt geprint
                met maar 1 letter verdwenen. Dat komt door de while loop. De speler wilt
                natuurlijk alle letters zien verdwijnen die hij of zij gebruikt.
                 */
                notUsed = notUsed.replace(letter, ' ');
                System.out.println(notUsed);

                /*
                Ik gebruik hier de if statement omdat er maar 2 uitslagen mogelijk zijn. Je
                wint of verliest. Ik had hier ook een if else statement kunnen gebruiken.
                Daarmee kwamen er complicaties naar boven omdat ik de levens(lives) moest koppelen
                aan de laatste tekening van de volledige galg. Daarom staat de laatste tekening ook
                hierbij en niet bij DrawHangman.

                 */
                if (isGameFinished) {
                    System.out.println("\n" + "Je hebt 1 punt gewonnen!" + "\n");
                    System.out.println("____________________________________");
                    currentPlayer.addScore();
                    break;
                }
                /*
                Dit is de laatste tekening die bij 0 levens hoort.
                 */
                if (lives == 0) {
                    playingGame = false;
                    System.out.println("\n" + "-----|-");
                    System.out.println("|    O");
                    System.out.println("|   -|-");
                    System.out.println("|   /|");
                    System.out.println("____________");
                    System.out.println("Je hebt verloren het woord was " + "\n" +  wg.getCurrentWord());
                    System.out.println("____________________________________" + "\n");
                }
            }
        }
    }

    /*
    De score van de speler wordt in een file opgeslagen en wordt aan het einde van het spel weergeven.
    Dit is wat ik tot nu toe heb kunnen ontwikkelen. Het is mij nog niet gelukt om de scores onder
    elkaar te weergeven.
    */
    public void endGame() {
        //score van huidige speler opslaan
        ScoreFileManager sfm = new ScoreFileManager();
        sfm.save(currentPlayer);
    }


    /*
    Zoals eerder vermeld zijn de tekeningen elk gekoppeld aan een leven. Dus telkens als er een
    leven kwijt is zal de daar bijbehorende tekening worden uit geprint. De tekening voor hangman heb ik gebaseerd op
    de oefeningen van w3resource.com. Door telkens system out print te herhalen kan er tussen de haakjes een
    simpele tekening worden gemaakt. Bij galgje hoort natuurlijk een tekening. Zoals eerder beschreven is de
    laatste tekening bij 0 levens geschreven in de if statement. Ik had het eerst hier bij staan maar toen werd er niks
    getekend als het spel was afgelopen.
     */
    public  void drawHangman(int lives) {
        //tekening van de galg met sout
        if(lives == 9 ) {
            System.out.println();
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
        }

        else if(lives == 8) {
            System.out.println("--------");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
        }

        else if(lives == 7) {
            System.out.println("--------");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("____________");
        }

        else if(lives == 6) {
            System.out.println("-----|-");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("____________");
        }

        else if(lives == 5) {
            System.out.println("-----|-");
            System.out.println("|    O");
            System.out.println("|");
            System.out.println("|");
            System.out.println("____________");

        }
        else if(lives == 4) {
            System.out.println("-----|-");
            System.out.println("|    O");
            System.out.println("|    |");
            System.out.println("|");
            System.out.println("____________");

        }
        else if(lives == 3) {
            System.out.println("-----|-");
            System.out.println("|    O");
            System.out.println("|   -|");
            System.out.println("|");
            System.out.println("____________");

        }
        else if(lives == 2) {
            System.out.println("-----|-");
            System.out.println("|    O");
            System.out.println("|   -|-");
            System.out.println("|");
            System.out.println("____________");

        }
        else if(lives == 1) {
            System.out.println("-----|-");
            System.out.println("|    O");
            System.out.println("|   -|-");
            System.out.println("|   /");
            System.out.println("____________");

        }


        }


}


