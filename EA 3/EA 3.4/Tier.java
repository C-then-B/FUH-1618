abstract class Tier {
    enum DangerLvl {
        LOW("nein"),
        MEDIUM("manchmal"),
        HIGH("JA!");

        final String name;

        DangerLvl(String s) {
            name = s;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    abstract int legCnt();

    abstract DangerLvl dangerLvl();

    public void druckeEigenschaften() {
        System.out.println(legCnt() + " Beine");
        System.out.println("Gefährlich für Menschen: " + dangerLvl());
    }
}