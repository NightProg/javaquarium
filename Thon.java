package Javaquarium;

public class Thon extends CarnivorFish{
    public Thon(String name, Sexe sexe) {
        super(name, sexe);
    }

    public Thon(String name, Sexe sexe, int age) {
        super(name, sexe, age);
    }

    @Override
    public Fish giveBirth() {
        return new Thon(this.getName() + " Jr", Sexe.getRandom());
    }
}
