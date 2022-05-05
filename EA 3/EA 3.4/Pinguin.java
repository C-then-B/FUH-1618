class Pinguin extends Tier {
    @Override
    int legCnt() {
        return 2;
    }

    @Override
    DangerLvl isDangerous() {
        return DangerLvl.MEDIUM;
    }
}