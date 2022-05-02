import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/*
Deze class wordt in de endGame aangeroepen in Game. Het slaat de score en de ingevoerde naam van de speler
op. In deze class wordt ook de Encrypt class aangeroepen die de tekst met de score en naam encrypted en
decrypted kan opslaan.
 */
public class ScoreFileManager {
    public void save(Player currentPlayer) {
        int score = currentPlayer.getScore();
        String name = currentPlayer.getName();
        System.out.print("Speler met de naam " + name + " heeft een score van " + score);


        /*
        Hier wordt de Encrypt class aangeroepen. Het zit een een try/catch statement
        want het kan altijd gebeuren dat er iets fout gaan met het opslaan. Dan
        wordt dat ook aangegeven.
        */
        try {
            // bestand aanmaken
            File scoresFile = new File("score.txt");
            FileWriter fileWriter = new FileWriter(scoresFile);


            // content naar bestand wegschrijven
            String plainText = "Naam: " + name + " score: " + score;
            String encryptedText = Encrypt.encrypt(plainText);
            String decryptedText = Encrypt.decrypt(encryptedText);


            fileWriter.write(decryptedText + "\n" +  encryptedText);

            fileWriter.close();
        }
        catch(IOException ioe) {
            System.out.println("Opslaan van data is niet gelukt");
        }
    }

}

