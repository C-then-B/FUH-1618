class Loewe extends Tier {
    @Override
    int legCnt() {
        return 4;
    }

    @Override
    DangerLvl isDangerous() {
        return DangerLvl.HIGH;
    }
}