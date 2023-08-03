package co.edu.uptc.model;

import java.util.ArrayList;
import java.util.Objects;

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

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "Answer= "  + anwers + '\'' +
                "of the Person= " + person;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Answer respons = (Answer) o;
        return this.anwers.equals(((Answer) o).getAnwers()) & this.person.getId() == respons.getPerson().getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(anwers, person);
    }
}
