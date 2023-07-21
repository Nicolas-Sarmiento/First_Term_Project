package co.edu.uptc.controller;

import co.edu.uptc.model.Account;
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
       Person newPerson = this.createPersonByRole(id, name, lastName, role);
       if (newPerson == null) return false;
       return this.personCollection.add(newPerson);
    }

    public boolean assingAccount(String id, Account acc){
        Person personToAssing = this.findPersonById(id);
        if (personToAssing == null) return false;
        for (Person p : this.personCollection){
            if (p.equals(personToAssing)){
                Person tempPerson = this.clonePerson(p);
                tempPerson.setAccount(acc);
                this.personCollection.remove(p);
                this.personCollection.add(tempPerson);
                return true;
            }
        }
        return false;
    }

    public Roles getRole(String role){
        for (Roles r: Roles.values()){
            if (r.name().equalsIgnoreCase(role)) return r;
        }
        return null;
    }

    public Person findPersonById(String id){
        for (Person person : this.personCollection){
            if (person.getId().equals(id)) return person;
        }
        return null;
    }

    public Person clonePerson(Person p) {
        String role = p.getClass().getSimpleName();
        return this.createPersonByRole(p.getId(), p.getName(), p.getLastname(), role);
    }

    public Person createPersonByRole(String id, String name, String lastName,String role){
        Roles typePerson = this.getRole(role);
        if (typePerson == null) return null;
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

        return newPerson;
    }
}
