package ru.job4j.prof;

public class Doctor extends Profession {
    public Doctor(String name, String profession) {
        super(name, profession);
    }

    public Diagnose heal(Pacient pacient) {
        Diagnose diagnose = null;
        return diagnose;
    }
}
