class Schmetterling extends Tier {
    @Override
    int legCnt() {
        return 6;
    }

    @Override
    DangerLvl dangerLvl() {
        return DangerLvl.LOW;
    }
}