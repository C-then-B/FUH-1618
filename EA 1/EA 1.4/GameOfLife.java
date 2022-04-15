public class GameOfLife {
    boolean[][] feld = {
            { false, false, false, false, false },
            { false, false, true, false, false },
            { false, false, true, false, false },
            { false, false, true, false, false },
            { false, false, false, false, false } };

    void print() {
        for (int i = 0; i < feld.length; i++) {
            for (int j = 0; j < feld[i].length; j++) {
                if (feld[i][j]) {
                    System.out.print("o ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
    }

    void nextGeneration() {
        boolean[][] nextGen = new boolean[feld.length][feld.length];

        for (int i = 0; i < feld.length; i++) {
            for (int j = 0; j < feld[i].length; j++) {
                // Zelle ist...
                // ...Randzelle, ignoriere
                if (i == 0 || i == feld.length - 1 || j == 0 || j == feld.length - 1)
                    continue;

                int living = 0;
                for (int k = i - 1; k < i + 2; k++) {
                    for (int l = j - 1; l < j + 2; l++) {
                        if (feld[k][l] && (k != i || l != j))
                            living++;
                    }
                }

                // ...lebendig und 2 oder 3 lebendige Nachbarn
                if (feld[i][j] && (living == 2 || living == 3)) {
                    nextGen[i][j] = true;
                }
                // ...tot und 3 lebendige Nachbarn
                else if (!feld[i][j] && living == 3) {
                    nextGen[i][j] = true;
                }
            }
        }

        feld = nextGen;
    }

    public static void main(String[] args) {
        GameOfLife myGame = new GameOfLife();
        for (int i = 0; i < 10; i++) {
            myGame.nextGeneration();
            myGame.print();
            System.out.println();
        }
    }
}