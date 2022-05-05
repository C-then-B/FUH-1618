class Schmetterling extends Tier {
    @Override
    int legCnt() {
        return 6;
    }

    @Override
    DangerLvl isDangerous() {
        return DangerLvl.LOW;
    }
}