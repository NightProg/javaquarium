package Javaquarium;

public class Carpe extends HerbivorFish {
    public Carpe(String name, Sexe sexe) {
        super(name, sexe);
    }

    public Carpe(String name, Sexe sexe, int age) {
        super(name, sexe, age);
    }


    @Override
    public Fish giveBirth() {
        return new Carpe(this.getName() + " Jr", Sexe.getRandom());
    }
}
