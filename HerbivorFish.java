package Javaquarium;


public abstract class HerbivorFish extends Fish {

    public HerbivorFish(String name, Sexe sexe) {
        super(name, sexe);
    }

    public HerbivorFish(String name, Sexe sexe, int age) {
        super(name, sexe, age);
    }

    @Override
    public boolean eat(Algue algue){
        if (algue.isDead) {
            return false;
        }
        algue.hurt(2);
        this.pv += 3;
        return true;
    }
    public abstract Fish giveBirth();
}
/*
if (algue.isDead) {
            return false;
        }
        algue.hurt(2);
        this.pv += 3;
        return true;
 */

/*
return new HerbivorFish(this.getName() + " Jr", (HerbivorSpecie) this.getSpecie(),this.getSexuality(), Sexe.getRandom());
 */