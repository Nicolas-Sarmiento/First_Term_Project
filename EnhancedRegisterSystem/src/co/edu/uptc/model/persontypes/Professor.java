package co.edu.uptc.model.persontypes;

import java.lang.reflect.Array;
import java.util.ArrayList;
import co.edu.uptc.model.Forum;
import co.edu.uptc.model.Course;

import co.edu.uptc.model.Person;

public class Professor extends Person {
    private ArrayList<Course> courses;

    public Professor(String id, String name, String lastname) {
        super(id, name, lastname);
        this.courses = new ArrayList<>();
    }


    
}
