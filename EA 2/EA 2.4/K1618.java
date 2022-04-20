class K1618 implements K1618Restricted {
    private double version = 1.0;

    public void playGame() {
        System.out.println("Running Kurs1618, Version " + version);
    }

    public void update() {
        version = version + 0.1;
    }
}