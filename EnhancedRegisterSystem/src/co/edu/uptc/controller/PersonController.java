package co.edu.uptc.controller;

import co.edu.uptc.model.Person;
import co.edu.uptc.model.persontypes.Administrator;
import co.edu.uptc.model.persontypes.Professor;
import co.edu.uptc.model.persontypes.Secretay;
import co.edu.uptc.model.persontypes.Student;

import java.util.HashSet;

public class PersonController {
    private HashSet<Person> personCollection;

    public PersonController(){
        this.personCollection = new HashSet<>();
    }

    public boolean addPerson(String id, String name, String lastName, String role){
        Roles typePerson = this.getRole(role);
        if (typePerson == null) return false;
        Person newPerson = null;
        switch (typePerson){
            case STUDENT :
                newPerson = new Student(id, name, lastName);
                break;
            case PROFESSOR, DIRECTOR:
                newPerson = new Professor(id, name, lastName);
                break;
            case ADMINISTRATOR:
                newPerson = new Administrator(id, name, lastName);
                break;
            case SECRETARY:
                newPerson = new Secretay(id, name, lastName);
                break;
        }

        return this.personCollection.add(newPerson);
    }

    public Roles getRole(String role){
        for (Roles r: Roles.values()){
            if (r.name().equalsIgnoreCase(role)) return r;
        }
        return null;
    }
}
