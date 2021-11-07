package Javaquarium;

public class Poisson {
    protected boolean isCarnivore = false;
    protected boolean isHerbivore = false;
    protected String nom = "";
    protected Sexe sexe = Sexe.MALE;
    protected int pv = 10;
    protected int age = 1;
    protected int energie = 10;
    public boolean estMort = false;
    public Poisson(String nom) {
        this.nom = nom;
    }
    public Poisson(String nom, Sexe sexe) {
        this.nom = nom;
        this.sexe = sexe;
    }



    public Poisson(String nom, int energie) {
        this.nom = nom;
        this.energie = energie;
    }

    public Poisson(String nom, Sexe sexe,  int age) {
        this.nom = nom;
        this.sexe = sexe;
        this.age = age;
    }

    public int getAge() {
        return this.age;
    }

    public int getPV() {
        return this.pv;
    }

    public String getNom() {
        return this.nom;
    }

    public Sexe getSexe() {
        return this.sexe;
    }

    public void enlevePV(int n) {
        if (this.pv - n < 0) {
            this.pv = 0;
            this.estMort = true;
        } else {
            this.pv = this.pv - n;
        }
    }

    public void old(int year) {
        this.age += year;
    }

    public void reposer() {
        this.energie += 10;
    }
    public boolean manger() {};



}


public class PoissonCarnivor extends Poisson {

    public PoissonCarnivor(String nom) {
        super(nom);
        this.isCarnivore = true;
    }

    public PoissonCarnivor(String nom, Sexe sexe) {
        super(nom, sexe);
        this.isCarnivore = true;

    }

    public PoissonCarnivor(String nom, int energie) {
        super(nom, energie);
        this.isCarnivore = true;

    }

    public PoissonCarnivor(String nom, Sexe sexe, int age) {
        super(nom, sexe, age);
        this.isCarnivore = true;

    }

    public int attaquer(Poisson e) {
        if (this.estMort) {
            return 4;
        }

        if (!(this.energie <= 0)) {
            
            e.enlevePV((int) this.energie / 5);
            this.energie -= 10;
            this.pv -= 4;
            if (e.estMort) {
                this.energie += 20;
                this.pv += 15;
                return 1;
            }
            return 2;
        } 
        return 3;
    }

    public boolean manger(Poisson e) {
        attaquer(e);
        return true;
    }
}

public class PoissonHerbivore extends Poisson {

    public PoissonHerbivore(String nom) {
        super(nom);
        this.isHerbivore = true;
    }

    public PoissonHerbivore(String nom, Sexe sexe) {
        super(nom, sexe);
        this.isHerbivore = true;
    }

    public PoissonHerbivore(String nom, Sexe sexe, int pv) {
        super(nom, sexe, pv);
        this.isHerbivore = true;
    }

    public PoissonHerbivore(String nom, int energie, int pv) {
        super(nom, energie, pv);
        this.isHerbivore = true;
    }

    public PoissonHerbivore(String nom, Sexe sexe, int pv, int age) {
        super(nom, sexe, pv, age);
        this.isHerbivore = true;
    }

    public boolean manger(Algue a) {
        if (a.estMort) {
            return false;
        }
        a.subir(2);
        this.pv += 3;
    }
}


