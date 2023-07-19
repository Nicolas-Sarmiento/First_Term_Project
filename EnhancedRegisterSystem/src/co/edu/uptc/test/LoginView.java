
package co.edu.uptc.test;

import co.edu.uptc.controller.LoginController;

import java.util.Scanner;

/**
 * Esta clase es para mostrar el menu con sus funciones
 * para que se pueda intancias sin tener que hacer cambios en la logica
 * @author Edwin Martinez
 * @author Samuel Gonzalez
 */
public class LoginView {

    private static LoginController loginController=new LoginController();
    private static Scanner sc =new Scanner(System.in);
    /**
     *Este el metodo principal que muestra el menu
     */
    public static void main(String[] args) {
        int decision;
        String names,lastNames,id,password,role,userName;
        do {
            System.out.println("=============================\n" +
                    "|\t\tUPTC Options\t\t|\n" +
                    "|\t\t1.Sing in\t\t\t|\n" +
                    "|\t\t2.Login\t\t\t\t|\n" +
                    "|\t\t3.Exit\t\t\t\t|\n" +
                    "=============================");
            System.out.print("Selection -------->");
            decision= sc.nextInt();
            sc.nextLine();
            switch (decision){
                case 1:{
                    System.out.println("\tType their names");
                    names=sc.nextLine();
                    System.out.println("\tType your last name");
                    lastNames=sc.nextLine();
                    System.out.println("\tType your identification");
                    id=sc.nextLine();
                    System.out.println("\tType your role in the university");
                    role=sc.nextLine();
                    System.out.println("\tType your password (with a capital letter, a lower case letter, at least 6 and 15 in length)");
                    password=sc.nextLine();
                    if(loginController.signin(names,lastNames,id,role)){
                        System.out.println("you successfully registered\n" +
                                "your user name is: "+loginController.getUserName());
                    }else {
                        System.out.println("Erros with your data");
                    }
                }break;
                case 2:{
                    System.out.println("\tType your user name");
                    userName=sc.nextLine();
                    System.out.println("\tType your password");
                    password=sc.nextLine();
                    if (loginController.login(userName, password)) {
                            login();
                    } else {
                            System.out.println("Error User name or password incorrect");
                    }
                }break;
                case 3:{
                    System.out.println("Coming out....");
                }
            }
        }while (decision!=3);
    }

    /**
     * Este método muesta las opciones despues del login
     */
    public static void login(){
        System.out.println(loginController.showInfoLoggedAcount());
        String role= loginController.showRol();
        switch (role){
            case "ADMINISTRATOR":{
                optionsGeneralsLogin();
            }break;
            case "DIRECTOR":{
                optionsGeneralsLogin();
            }break;
            case "SECRETARY":{
                optionsGeneralsLogin();
            }break;
            case "PROFESSOR":{
                optionsBasic();
            }break;
            case "STUDENT":{
                optionsBasic();
            }break;
        }
    }

    /**
     * Este método muesta la opcion para Administrador, Director, Secretaria de mostrar todas las cuentas
     */
    public static void optionsGeneralsLogin(){
        int decision;
        do{
            System.out.println("========================\n" +
                    "|\t1.see counts\t\t|\n" +
                    "|\t2.change password\t|\n" +
                    "|\t3.logout\t\t\t|\n" +
                    "========================");
            System.out.print("Selection ----->");
            decision=sc.nextInt();
            sc.nextLine();
            if(decision==1){
                System.out.println(loginController.showAccounts());
            }else if(decision==2){
                System.out.println("\tType old password");
                String oldPassword=sc.nextLine();
                System.out.println("\tType new password");
                String newPassword=sc.nextLine();
                if(loginController.changePassword(oldPassword,newPassword)){
                    System.out.println("password change was successful");
                }else {
                    System.out.println("Error");
                }
            }else if(decision==3){
                if(loginController.logout()){
                    System.out.println("logout..");
                }else {
                    System.out.println("Error");
                }
            }
        }while(decision!=3);
    }

    /**
     * Este método muestra las opciones basicas para personas que no tienen permisos especiales
     */
    public static void optionsBasic(){
        int decision;
        do{
            System.out.println("========================\n" +
                    "|\t1.change password\t|\n" +
                    "|\t2.logout\t\t\t|\n" +
                    "========================");
            System.out.print("Selection ----->");
            decision=sc.nextInt();
            sc.nextLine();
            if(decision==1){
                System.out.println("\tType old password");
                String oldPassword=sc.nextLine();
                System.out.println("\tType new password");
                String newPassword=sc.nextLine();
                if(loginController.changePassword(oldPassword,newPassword)){
                    System.out.println("password change was successful");
                }else {
                    System.out.println("Error");
                }
            }else if(decision==2){
                if(loginController.logout()){
                    System.out.println("logout..");
                }else {
                    System.out.println("Error");
                }
            }
        }while(decision!=2);
    }
}
