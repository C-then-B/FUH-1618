class Loewe extends Tier {
    @Override
    int legCnt() {
        return 4;
    }

    @Override
    DangerLvl dangerLvl() {
        return DangerLvl.HIGH;
    }
}