package co.edu.uptc.utilities;

import co.edu.uptc.controller.Roles;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

/**
 * @author:EdwinMartinez
 * {@code @version:14/07/2023}
 */
public class AccountUtilities{
    public AccountUtilities() {
    }
    /**
     *Método que devuelve si la contraseña cumple con los requisitos minimos para ser segura
     * @param password es el parametro a comparar
     * @return si el valida o no para ser una contraseña segura
     */
    public boolean validatePassword(String password){
        boolean flagUpper=false;
        boolean flagLower=false;
        int count=0;
        //Cantidad de números en la contaseña
        for(int i=0;i<password.length();i++){
            Character character=password.charAt(i);
            if(character.isDigit(character)){
                count++;
            }
        }
        //Mayusculas y minusculas en la contraseña
        for (int i = 0; i < password.length(); i++) {
            char character = password.charAt(i);
            if (Character.isLetter(character)) {
                if (Character.isUpperCase(character)) {
                    flagUpper = true;
                } else if (Character.isLowerCase(character)) {
                    flagLower = true;
                }
            }
        }
        //verificacion que contenga los tres parametros para ser segura
        if(flagUpper && flagLower && count>=2 && password.length()>=6 && password.length()<=15){
            return true;
        }
        return false;
    }//Cierre método

    /**
     * Método para validar que el nombre que ingreso no este vacio
     * @param name nombre a verificar
     * @return retorna si esta o no vacio
     */
    public boolean validateName(String name){
        if(name!=null&&name!=" "){
            return true;
        }
        return false;
    }//Cierre Método

    /**
     * Método para verificar que el metodo ingresado exista en los definidos en el login
     * @param roles rol a comparar
     * @return retorna si el rol el valido
     */
    public boolean validateRole(String roles){
        for (Roles s:Roles.values()) {
            if(s.name().equalsIgnoreCase(roles)){
                return true;
            }
        }
        return false;
    }//cierre método

    /**
     * Método que verifica que la identificación ingresada no este vacia
     * @param id identificación a comparar
     * @return retorna si esta o no vacio
     */
    public boolean validateId(String id){
        if(id!=null&&id!=" "){
            return true;
        }
        return false;
    }//cierre método

    /**
     * Método para generar el correo de la persona que se registra
     * @param user es el nombre de usuario
     * @return retorna el correo con la extension de la universidad
     */
    public String generateEmail(String user){
        return user+"@uptc.edu.co";
    }//cierre método

    /**
     * Método para generar el usuario de la persona añadiendo un numero si esta repetido
     * @param names son los nombres del usuario
     * @param lastNames apellidos del usuario
     * @param userNames la lista de usuarios registrados para comparar
     * @return retorna el usuario con un numero si ya existe un usuario parecido
     */
    public String generateUser(String names,String lastNames,String[] userNames){
        try {
            String[] newUserNames = new String[userNames.length];
            String[] newName = names.split(" ");
            String[] newLastNames = lastNames.split(" ");
            String aux = newName[0] + newLastNames[0];
            int count = 0;
            for (int i = 0; i < userNames.length; i++) {
                newUserNames[i] = removeDigits(userNames[i]);
            }
            for (String s : newUserNames) {
                if (s.equals(aux)) {
                    count++;
                }
            }
            if (count != 0 && count < 10) {
                return newName[0] + "." + newLastNames[0] + "0" + count;
            } else if (count != 0) {
                return newName[0] + "." + newLastNames[0] + count;
            }
            return newName[0] + "." + newLastNames[0];
        }catch (ArrayIndexOutOfBoundsException e){
            return " ";
        }
    }//cierre método

    /**
     * Método para eliminar los número y caracteres especiales de los usuarios
     * @param userName es el nombre de usuario a eliminar números y caracteres especiales
     * @return retorna un nombre de usuario sin números y caracteres especiales
     */
    public String removeDigits(String userName){
        return userName.replaceAll("[^a-z]","");
    }//cierre método

    /**
     * Método para ponerlo en minuscula y eliminar espacios innecesarios
     * @param name
     * @return nombre sin espacios y en minuscula
     */
    public String cleanNames(String name){
        String cleanName =  name.toLowerCase();
        if (cleanName.startsWith(" ")) return cleanName.replaceFirst(" ", "");
        return cleanName;
    }

    /**
     * Genera contraseñas aleatorias que no se repiten
     * Debido a que compara un arreglo de contraseñas existentes
     * @param passwords contraseñas existentes
     * @return String, una contraseña única
     */
    public String genNewPassword(String[] passwords){
        String password = "";
        HashSet<String> listPasswords = new HashSet<>(Arrays.asList(passwords));
        do {
            password = this.randomPassword();
            if (!listPasswords.contains(password)) break;
        }while (true);
        return password;
    }

    /**
     * Genera contraseñas aleatorias de 6 caracteres
     * 2 numeros, 2 Mayúsculas y 2 minúsculas
     * @return Contraseña aleatoria de 6 caracteres
     */
    private String randomPassword(){
        Random rand = new Random();
        String password = "";
        password += rand.nextInt(10) + "" + rand.nextInt(10) +
                (char)(rand.nextInt(25) + 65) +
                (char)(rand.nextInt(25) + 65) +
                (char)(rand.nextInt(25) + 65) +
                (char)(rand.nextInt(25) + 97) +
                (char)(rand.nextInt(25) + 97);
        return password;
    }


}//cierre clase
