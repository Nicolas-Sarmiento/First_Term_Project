package co.edu.uptc.controller;

import java.util.Scanner;

public class probar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LoginController lgc = new LoginController();
        AccountController cc = new AccountController();

        //cc.loadAccounts();
        lgc.loadAccounts();
        boolean respos = lgc.login("maria.rodriguez","AJsv92");
        //System.out.println(respos);

        //System.out.println(lgc.showInfoLoggedAcount());
        boolean respuesta2 = lgc.changePassword("AJsv92", "Bmn123");
        //System.out.println("HOLA SADSAFAS " + respuesta2);


        System.out.println(lgc.showInfoLoggedAcount());
        String nombre="", contra="", id="";

         
        if(lgc.logout()){
            System.out.println("Salio");
        }else{System.out.println("no salio, o  no ha inciado sesion");}
        
        System.out.println(lgc.showInfoLoggedAcount());

        //nombre 




    }
}
