import java.util.Scanner;
import java.nio.file.Paths;

public class Main {


    /*
    De methodes van Game worden aangeroepen zodat het spel kan starten. Ik heb nog een while loop
    gebruikt voor het einde van het spel. Deze heb ik gezien in Edhub bij het spel Tic Tac Toe.
    Uiteindelijk kan de speler kiezen of hij nog een keer speelt of stopt waarbij zijn score
    wordt opgeslagen.
     */
    public static void main(String[] args) throws Exception {
        System.out.println("Welkom bij galgje succes!");

        Scanner userinput = new Scanner(System.in);

        boolean continuePlaying = true;
        while (continuePlaying) {

            Game gameApp = new Game();
            gameApp.prepareGame();
            gameApp.startGame();
            gameApp.endGame();


        /*
        Dit is een while in een while loop. Deze heb ik gemaakt zodat als er geen ja of nee wordt ingevuld
        er nog een keer gevraagd wordt of de speler nog een keer wilt spelen of stoppen.
        */
            boolean invalidChoice = true;
            while (invalidChoice) {
                System.out.println("\n" + "Wilt u het spel nog een keer spelen? Toets ja of nee");


                String continuePlayingUserChoice = userinput.next();


                switch (continuePlayingUserChoice) {
                    case "ja": {
                        System.out.println("Het spel begint opnieuw" + "\n");
                        continuePlaying = true;
                        invalidChoice = false;
                    }
                    break;
                    case "nee": {
                        System.out.println("U heeft de game beëindigd");
                        continuePlaying = false;
                        invalidChoice = false;

                        try (Scanner scanner = new Scanner(Paths.get("score.txt"))) {

                            while (scanner.hasNextLine()) {

                                String row = scanner.nextLine();

                                System.out.println(row);
                            }
                        } catch (Exception e) {
                            System.out.println("foutmelding");
                        }
                    }
                    break;
                    default: {
                        System.out.println("Geen ja of nee ingevuld");
                        invalidChoice = true;
                    }
                    break;
                }
            }
        }
    }
}


