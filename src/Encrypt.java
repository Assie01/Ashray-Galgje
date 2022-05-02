/*
Deze encrypt methode is van Caesar Cipher. Ik heb de encrypt methode overgenomen en de decrypt methode
zelf gereversed. Dit ging een paar keer fout maar ik heb het kunnen oplossen. Helemaal onderaan heb ik
de oplossing er nog bij gezet met de code die eerst fout stond.
*/

public class Encrypt {

    public static String encrypt(String plainText) {

        char[] chars = plainText.toCharArray();

        String s = "";
        int len = plainText.length();
        for (int x = 0; x < len; x++) {
            char c = (char) (plainText.charAt(x) + 6);
            if (c > 'z')
                s += (char) (plainText.charAt(x) - (26 - 6));
            else
                s += (char) (plainText.charAt(x) + 6);
        }
        return s;
    }
    public static String decrypt(String plainTextEncrypted){

        char[] chars = plainTextEncrypted.toCharArray();

        String s = "";
        int len = plainTextEncrypted.length();
        for(int x = 0; x < len; x++){
            char c = (char)(plainTextEncrypted.charAt(x) - 6);
            if (c > 'z')
                s += (char)(plainTextEncrypted.charAt(x) + (26+6));
            else
                s += (char)(plainTextEncrypted.charAt(x) - 6);
        }
        return s;
    }

}


/*
(Dit bericht schreef ik op 15-02-2021)
Hieronder is een decrypt methode te zien waarbij de decryptie niet werkt. Ik heb het bewaard
zodat ik hier later nog een keer op terug kan komen.

 (decrypt)
         String s = "";
    int len = encryptedText.length();
        for(int x = 0; x < len; x++){
            char c = (char)(encryptedText.charAt(x) - 6);
            if (c > 'z')
                s += (char)(encryptedText.charAt(x) - (26+6));
            else
                s += (char)(encryptedText.charAt(x) - 6);
        }
    return s;
 */

/*
(17-02-2021)
De code is gefixt. Ik heb de juiste code alvast in de public class gezet.
Decrypten werkte niet omdat de volgende lijn ontbrak.
(char[] chars = encryptedText.toCharArray();).
Door deze lijn toe te voegen heb ik de encrypt methode kunnen reversen.
 */