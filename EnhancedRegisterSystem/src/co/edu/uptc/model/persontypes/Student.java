package co.edu.uptc.model.persontypes;

import java.lang.reflect.Array;
import java.util.ArrayList;

import co.edu.uptc.model.Forum;
import co.edu.uptc.model.Person;

public class Student extends Person {
    private ArrayList<Forum> forums;

    public Student(String id, String name, String lastname) {
        super(id, name, lastname);
        this.forums = new ArrayList<>();
    }

    
		public ArrayList<Forum> getForums() {
			return forums;
		}

		public void setForums(ArrayList<Forum> forums) {
			this.forums = forums;
		}

	    

}
