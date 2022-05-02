public class Player {


        private String name;
        private int score;

        /*
        Deze methode heb ik van de game Tic Tac Toe in Edhub. Hier is er alleen geen token nodig zoals X of
        0 wat nodig is om drie op een rij te spelen. Hier is alleen de naam nodig met de score. Het belangrijkste hier
        is dat er telkens als er woord wordt geraden dat er een punt wordt bijgeschreven.
         */
        //constructor
        public Player(String name) {
            this.name = name;
            score = 0;
        }

        //methoden
        public String getName() {
            return name;
        }

        public int getScore() {
            return score;
        }

        public void addScore() {
            score++;
        }
    }


