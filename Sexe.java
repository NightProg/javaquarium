package Javaquarium;

public enum Sexe {
    MALE,
    FEMELLE;
    public static Sexe getRandom() {
        return values()[(int) (Math.random() * values().length)];
    }
}