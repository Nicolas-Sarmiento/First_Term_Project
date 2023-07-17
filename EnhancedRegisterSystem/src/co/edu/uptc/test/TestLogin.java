package co.edu.uptc.test;

import java.util.Scanner;
import co.edu.uptc.controller.AccountController;
import co.edu.uptc.controller.LoginController;

/**
     * La clase TestLogin comprueba que todo
     * funcione con total normalidad.
     * 
     * @author Samuel Gonzalez Zambrano
     * @version  1.0.0
     * 
 */

public class TestLogin {
    LoginController lgc = new LoginController();
    AccountController cc = new AccountController();
    
       
        

    
    public TestLogin(){
        //precargar cuentas para trabajar.
        lgc.loadAccounts();
    }
    
    /**
     *Metodo para testear el login 
     de la clase LoginController, primero valida
     la respuesta del metodo login y luego
     devuelve el string de la informacion
     @param nameUser No confundir con con nombre de la persona.
     @param password
     * @return String para saber si funciono.
    * 
    */

    public String TestLoginin(String nameUser, String password){
       
        boolean respuestaLogin =  lgc.login(nameUser, password);
        if(respuestaLogin){
            //debe retorna lo mismo de la cuenta que se le envio
            return lgc.showInfoLoggedAcount();
        }
        return "Fallo el login, revise el username o password";
    }

    /**
     *Metodo para probar cerrar sesion.
     @param oldpassword contraseña anterior
     @param newpassword nueva contraseña a cambiar
     @return String para saber si funciono el cambio de contraseña.
    * 
    */

    public String Testchangepassword(String oldpassword, String newpassword){
    
        boolean respuestaChangePassword =  lgc.changePassword(oldpassword, newpassword);
        if(respuestaChangePassword){
            //debe retorna en la parte de contraseña el cambio
            //sabiendo que en el parametro se le envio la contraseña anterior
            System.out.println("ESTPOY ASDASCAS");
            return lgc.showInfoLoggedAcount();
        }
        return "FALLO el cambio, revise si ya incio sesion o si envio las contraseñas mal (tiene que ser segura)";
    }

    public static void main(String[] args) {
      TestLogin tst = new TestLogin();
      Scanner sc = new Scanner(System.in);
      boolean salir = false;
      do{
        String menuProbarLoginController = "1) Login\n2) cambiar contraseña\n3) Logout\n4) Registro\n5) Salir";
        System.out.println("Que desea probar.\n" + menuProbarLoginController);
        char seleccion = sc.next().charAt(0);
        switch (seleccion) {
            case '1':
                System.out.println("Ingrese el nombre de usuaro");
                String nameUser = sc.next();
                System.out.println("Ingrese la contraseña");
                String password = sc.next();
                //debe retornar los datos del usuario enviado por consola
                System.out.println(tst.TestLoginin(nameUser, password));
            break;
            // se comprobo que la funcion login funciona con total normalidad

            case '2':
                System.out.println("Recomendado iniciar sesion primero (opcion 1)");
                System.out.println("Ingrese la contraseña anterior");
                String oldpassword = sc.next();
                System.out.println("Ingrese la nueva contraseña a cambiar");
                String nepassword = sc.next();

                System.out.println(tst.Testchangepassword(oldpassword, nepassword));

             break;
             //La funcion cambiar contraseña funciona perfectamente 
            case '3':

            break;
            case '4':
                
            break;
        
            default:
                salir = true;
                break;
        }


    }while(salir == false);
    }

}
