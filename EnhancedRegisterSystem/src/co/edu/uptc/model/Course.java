package co.edu.uptc.model;

import java.sql.Array;
import java.util.ArrayList;

public class Course {
    private String nombre;
    private Person teacher;
    ArrayList<Forum> forumCourse;

    public Course(String nombre, Person teacher) {
        this.nombre = nombre;
        this.teacher = teacher;
        this.forumCourse = new ArrayList<>();
    }
    



}
