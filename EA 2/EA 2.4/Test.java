public class Test {
    public static void main(String[] args) {
        HagenGames hg = new HagenGames();
        K1618Restricted game = hg.buyGame();

        // Nicht möglich
        //game.update();

        game.playGame();
        hg.updateK1618(game);
        game.playGame();
    }
}