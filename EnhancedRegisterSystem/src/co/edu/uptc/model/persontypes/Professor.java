package co.edu.uptc.model.persontypes;

import java.lang.reflect.Array;
import java.util.ArrayList;
import co.edu.uptc.model.Forum;

import co.edu.uptc.model.Person;

public class Professor extends Person {
    private ArrayList<Forum> forumCreateds;

    public Professor(String id, String name, String lastname) {
        super(id, name, lastname);
        this.forumCreateds = new ArrayList<>();
    }

    public ArrayList<Forum> getForumCreateds() {
        return forumCreateds;
    }

    public void setForumCreateds(ArrayList<Forum> forumCreateds) {
        this.forumCreateds = forumCreateds;
    }

    
}
