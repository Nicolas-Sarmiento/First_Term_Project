package co.edu.uptc.model;

import java.util.ArrayList;

public class Answer {
    private String anwers;
    private Person person;
    public Answer(String anwers, Person personCometed) {
        this.anwers = anwers;
        this.person = personCometed;
    }

    public String getAnwers() {
        return anwers;
    }

    public void setAnwers(String anwers) {
        this.anwers = anwers;
    }

    @Override
    public String toString() {
        return "Answer= "  + anwers + '\'' +
                "of the Person= " + person;
    }
}
