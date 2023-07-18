package co.edu.uptc.controller;
import co.edu.uptc.model.Account;
import co.edu.uptc.controller.AccountController;
  /**
     * La clase loginController se encargar de verificar
     * los datos ingresados, valida y guarda el usuario
     * en el atributo loggedAcount
     * 
     * @author Samuel Gonzalez Zambrano
     * @version  1.0.0
     * 
 */
public class LoginController {
    Account loggedAcount;
    AccountController acc;
  
    public LoginController(){
        this.loggedAcount = new Account();
        this.acc = new AccountController();
        this.acc.loadAccounts();
    }
    /**
     * Metodo principal, verifica el nombre y contra
      * si coincide con algun usuario lo trae y lo guarda
     * en loggedAcount
     * @param nameUser,password ambos ingresados por usuario
     * @return Si las credeciales ingresadas son validas 
     * guarda el usuario y retorona true.
    * 
 */
    public  boolean login(String nameUser, String password){
        

        if(acc.findAccount(nameUser, password) != null){
            loggedAcount = acc.findAccount(nameUser, password);
            return true;

        }

        return false;
    }
    /**
     * Permite al usuario que ingreso cambiar su contraseña,
     * solo lo permite si ya inicio sesion.
     * Se debe ingresar la primera contraseña y luego ahi si procede al cambio
     * si  introduce mal la contraseña original, el cambio se cancela
     * @param oldpassword,newpassword ambos ingresados por usuario
     * @return Si las credeciales ingresadas son validas 
     * cambia la contraseña.
    * 
 */

    public boolean changePassword(String oldpassword, String newPassword){
        try {
            if(oldpassword.equals(newPassword)){
                return false;
            } else if(loggedAcount != null && loggedAcount.getPassword().equals(oldpassword)){
                boolean methodAnswer = acc.setNewPassword(loggedAcount.getUserName(),oldpassword, newPassword );
                loggedAcount = acc.findAccount(loggedAcount.getUserName(), newPassword);
                return methodAnswer;
            }
        } catch (Exception e) {}
       

        return false;
    }

    /**
     * Cierra sesion, por ende el atributro loggedAcount se hace null
     * @return booleano.
    * 
 */

    public boolean logout(){
        if(loggedAcount != null){
            loggedAcount = null;
            return true;
        }

        return false;
    }

    /**
     * Registro de usuario, requiere de todos los elementos base
     * luego son validados
     * @param name,lastname nombre compelto del usuario
     * @param id docuemnto del usuario
     * @param password contraseña ingresada por el usuario
     * @param role Especificacion del rol del usuario a crear
     * @return boolean de control, si algo falla se cancela el proceso .
    * 
 */

    public boolean signin(String name, String lastName, String id, String password, String role){
        return acc.addAccount(id, name, lastName, password, role);
    }
      /**
       * getUserName devuelve el usuario generado
       * @return String con el usuario generado
       */
    public String getUserName(){
        return acc.getUsername();
    }
    
    /**
     *Metodo para ver la informacion de la cuenta que inicio sesion
     * @return String con toda la informacion de la cuenta.
    * 
 */

    public String showInfoLoggedAcount(){
        if(loggedAcount != null){
            return loggedAcount.toString();
        }
        return "No ha inciado sesion";
    }
    
    /**
     *Metodo para ver Rol de la persona que inicie sesion
     * @return String el rol de la cuenta.
    * 
    */

    public String showRol(){
        if(loggedAcount != null){
            return loggedAcount.getRole();
        }
        return "No ha inciado sesion";
    }

      /**
       * Este método muestra todas las cuentas existentes hasta el momento
       * @return un String con todas la cuentas
       */

    public String showAccounts(){
        return acc.showAccounts();
    }

     /**
     *Metodo para  precargar estudaintes, funciona para testear
    */
    public void loadAccounts(){
        acc.loadAccounts();
    }


}
