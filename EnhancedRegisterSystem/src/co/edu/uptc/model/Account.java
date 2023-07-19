package co.edu.uptc.model;

import java.util.Objects;
/*
    La clase Account comprende los atributos que conforma una cuenta
    de la uptc, maneja los atributos de nombre, código, usuario, contraseña, rol en la universida
    y correo institucional
    @author Nicolas Sarmiento vargas : Nicolas-Sarmiento
    @version 1.0.0
*/

public class Account {

    private String id;
    private String userName;
    private String password;
    private String role;
    private String email;

    public Account(String id, String userName, String password, String role, String email) {

        this.userName = userName;
        this.password = password;
        this.role = role;
        this.email = email;
    }

    public Account(){}

   

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /*
    Los métodos equals y hashcode se sobreescribieron para poder utilizar un
    HashSet como controlador de la clase Account
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, password, role);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Account)) return false;

        Account objAccount = (Account) obj;

        return this.id.equals(objAccount.getId()) && this.password.equals(objAccount.getPassword()) &&
                this.role.equals(objAccount.getRole());
    }

    @Override
    public String toString() {
        return "Account{" +
                ", userName='" + userName + '\'' +
                ", role='" + role + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}