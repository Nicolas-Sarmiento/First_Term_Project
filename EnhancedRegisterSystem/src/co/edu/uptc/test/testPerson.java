package co.edu.uptc.test;

import co.edu.uptc.controller.PersonController;

public class testPerson {
    public static void main(String[] args) {
        PersonController pctr = new PersonController();
        //creo una nueva persona
        System.out.println( pctr.addPerson("01", "Samuel", "Gonzalez", "ADMINISTRATOR"));
       //verifico que si se cree bien
       System.out.println(pctr.findPersonById("01").toString());







    }


}
