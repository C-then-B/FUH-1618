class HagenGames {
    public K1618Restricted buyGame() {
        return new K1618();
    }

    public void updateK1618(K1618Restricted game) {
        ((K1618) game).update();
    }
}