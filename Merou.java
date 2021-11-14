package Javaquarium;

public class Merou extends CarnivorFish implements HermaphroditeAge {
    public Merou(String name, Sexe s) {
        super(name, s);
    }

    public Merou(String name, Sexe s, int age) {
        super(name, s, age);
    }

    @Override
    public void update() {
        super.update();
        checkAge();
    }


    @Override
    public Fish giveBirth() {
        return new Merou(this.getName() + " Jr", Sexe.MALE);
    }

    @Override
    public void checkAge() {
        if (this.age <= 10) {
            this.sexe = Sexe.MALE;
        } else {
            this.sexe = Sexe.FEMELLE;
        }
    }
}
