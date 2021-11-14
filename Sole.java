package Javaquarium;

public class Sole extends HerbivorFish implements HermaphroditeOpportunist {
    public Sole(String name, Sexe sexe) {
        super(name, sexe);
    }

    public Sole(String name, Sexe sexe, int age) {
        super(name, sexe, age);
    }

    @Override
    public Fish giveBirth() {
        return new Sole(this.getName() + " Jr", Sexe.getRandom());
    }

    @Override
    public boolean wantHaveChild(Fish f) {
        if (f == null) {
            return false;
        }
        setSexe(f);
        return super.wantHaveChild(f);
    }

    @Override
    public void setSexe(Fish f) {
        this.sexe = (f.getSexe() == Sexe.FEMELLE) ? Sexe.MALE : Sexe.FEMELLE;
    }


}
