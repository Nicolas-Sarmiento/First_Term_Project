package co.edu.uptc.test;

import co.edu.uptc.controller.LoginController;
import co.edu.uptc.controller.PersonController;
import co.edu.uptc.model.Account;
import co.edu.uptc.model.persontypes.Student;
import co.edu.uptc.model.Person;
import co.edu.uptc.model.persontypes.Administrator;
import co.edu.uptc.model.persontypes.Professor;
import co.edu.uptc.model.persontypes.Secretary;
import co.edu.uptc.model.persontypes.Student;

public class testPerson {
    public static void main(String[] args) {
        PersonController pctr = new PersonController();
        LoginView lgview = new LoginView();
        LoginController lgc = new LoginController();
        //creo una nueva persona
        //System.out.println( pctr.addPerson("01", "Samuel", "Gonzalez", "ADMINISTRATOR"));
        

    //creo una cuenta, se al asigno cambio contraseña y mirar si la pierde
        Account acount = new Account("123", "samuel.gonzalez" , "ASsd123" , "STUDENT" , "email");

        System.out.println("SE CREO " + lgc.signin("Kamilo", "Torres", "02", "STUDENT"));

        lgc.login("kamilo.torres", lgc.getPassword());
        //contraseña qeu genera
        System.out.println("Contraseña " + lgc.getPassword());
        
        System.out.println("Prmeroasdasras " + lgc.controlPassword("02").toString());

        //ahora la de cambiar
        System.out.println("camvbio " +  lgc.changePassword(lgc.getPassword(), "COntra124"));

        System.out.println(lgc.controlPassword("02").toString());




        


    }


}
