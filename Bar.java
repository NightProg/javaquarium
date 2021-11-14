package Javaquarium;


public class Bar extends HerbivorFish implements HermaphroditeAge {

    public Bar(String name, Sexe sexe) {
        super(name, sexe);
    }

    public Bar(String name, Sexe sexe, int age) {
        super(name, sexe, age);
    }

    @Override
    public Fish giveBirth() {
        return new Bar(this.getName() + " Jr", Sexe.MALE);
    }



    @Override
    public void update() {
        super.update();
        checkAge();
    }

    @Override
    public void checkAge() {
        if(this.age <= 10) {
            this.sexe = Sexe.MALE;
        } else {
            this.sexe = Sexe.FEMELLE;
        }
    }
}
