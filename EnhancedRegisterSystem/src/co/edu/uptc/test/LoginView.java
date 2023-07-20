
package co.edu.uptc.test;

import co.edu.uptc.controller.LoginController;
import co.edu.uptc.utilities.InputLibrary;

/**
 * Esta clase es para mostrar el menu con sus funciones
 * para que se pueda intancias sin tener que hacer cambios en la logica
 * @author Edwin Martinez
 * @author Samuel Gonzalez
 */
public class LoginView {

    private final InputLibrary util;
    private  final LoginController loginController;
    private final String[] roles;
    private final String errorMessage;

    public LoginView(){
        this.util = new InputLibrary();
        this.loginController = new LoginController();
        this.roles = new String[]{"Student", "Professor", "Secretary", "Administrator"};
        this.errorMessage = "Invalid input. Try again";
    }
    /**
     *Este el metodo principal que muestra el menu
     */
    public static void main(String[] args) {
        LoginView portal = new LoginView();
        int decision;
        String message = """
                =============================
                |\t\tUPTC\t\t|
                |\t\t1.Login\t\t\t\t|
                |\t\t2.Exit\t\t\t\t|
                =============================""";
        String password = "",userName = "";
        do {
            System.out.println(message);
            decision = portal.util.inputInt("Selection -------->", "Invalid input. Try again");
            switch (decision) {
                case 1 :
                    userName = portal.util.inputString("\tUsername", "Invalid Input. Try again");
                    password = portal.util.inputString("\tPassword", "Invalid input. Try again");
                    if (portal.loginController.login(userName, password)) {
                        portal.login();
                    } else {
                        System.out.println("User name or password incorrect");
                    }
                break;
                case 2 :
                    System.out.println("Coming out....");
                break;
                default:
                    System.out.println("Invalid option. Try again");
            }
        }while (decision!=2);
    }

    /**
     * Este método muesta las opciones despues del login
     */
    public void login(){
        System.out.println(this.loginController.showInfoLoggedAcount());
        String role = loginController.showRol();

        if (role.equals("ADMINISTRATOR")) {
            this.optionsGeneralsLogin();
            return;
        }

        this.optionsBasic();
    }

    /**
     * Este método muesta la opcion para Administrador, Director, Secretaria de mostrar todas las cuentas
     */
    public  void optionsGeneralsLogin(){
        String loginMessage = """
                ========================
                |\t1.Sing in accounts\t|
                |\t2.see accounts\t\t|
                |\t3.change password\t|
                |\t4.logout\t\t\t|
                ========================""";
        int decision,role;
        do{
            System.out.println(loginMessage);
            decision = this.util.inputInt("Selection ----->", this.errorMessage);
            switch (decision){
                case 1 :
                    System.out.println(this.singInAccounts() ?  "you successfully registered\n" +
                            "your user name is: "+loginController.getUserName(): "Error with your data");
                break;
                case 2:
                    System.out.println(loginController.showAccounts());
                break;
                case 3:
                    System.out.println(this.changePassword() ? "password change was successful":"Error");
                break;
                case 4:
                    System.out.println(this.logOut() ? "Logging out" : "Error. Try again");
                break;
                default:
                    System.out.println("Invalid option, try again.");
                break;
            }
        }while(decision!=4);
    }

    public boolean singInAccounts(){
        String names = "", lastNames = "", id = "";
        int roleIndex = 0;

        roleIndex = this.util.inputInt("\tType your role in the university\n\t1.Student\n\t2.Professor\n\t3.Secretary", errorMessage, 1,3);
        names = this.util.inputString("\tType their names", this.errorMessage);
        lastNames = this.util.inputString("\tType your last name", errorMessage);
        id = this.util.inputString("\tType your identification", errorMessage);

        return loginController.signin(names,lastNames,id,this.roles[roleIndex-1]);
    }

    public boolean changePassword(){
        String oldPassword = "", newPassword = "";
        oldPassword = this.util.inputString("\tType old password", errorMessage);
        newPassword = this.util.inputString("\tType new password. Your password will include 2 Uppercase characters, 2 Lowercase characters, 2 numbers. At least 6 characters.", errorMessage);
        return this.loginController.changePassword(oldPassword, newPassword);
    }

    public boolean logOut(){
        return this.loginController.logout();
    }


    /**
     * Este método muestra las opciones basicas para personas que no tienen permisos especiales
     */
    public  void optionsBasic(){
        String message = """
                ========================
                |\t1.change password\t|
                |\t2.logout\t\t\t|
                ========================""";

        int decision = 0;
        do{
            System.out.println(message);
            decision = this.util.inputInt("Selection ----->", this.errorMessage);
            switch (decision){
                case 1:
                    System.out.println(this.changePassword() ? "password change was successful": "Error");
                break;
                case 2:
                    System.out.println(this.logOut() ? "Logging out" : "Error. Try again");
                    break;
                default:
                    System.out.println("Invalid option, try again.");
                break;
            }

        }while(decision!=2);
    }
}
