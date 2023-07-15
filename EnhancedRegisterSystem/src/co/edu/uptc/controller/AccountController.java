package co.edu.uptc.controller;

import co.edu.uptc.model.Account;

import java.util.HashSet;
import java.util.List;

/**
 * La clase Account Controller permite gestionar una
 * colección de cuentas que estaran disponibles en la
 * ejecución del programa, así como la creación, eliminación
 * y edición de contraseñas
 * @author Nicolas Sarmiento : Nicolas-Sarmiento
 * @version  1.0.0
 */

public class AccountController {
    private HashSet<Account> accounts;
    private final Account[] defaultAccounts = {
        new Account("202210568","manuel fernando", "martinez delgado", "manuel.martinez", "Masfx83", "student", "manuel.martinez@uptc.edu.co"),
        new Account("2021456", "maria fernanda","rodriguez vargas","maria.rodriguez","AJsv92","student","maria.rodriguez@uptc.edu.co"),
        new Account("2020154", "juan david","velandia gonzalez","juan.velandia","njksAPO293","student","juan.velandia@uptc.edu.co"),
        new Account("2022159", "maria jose","rodriguez castillo","maria.rodriguez01","HJAkjsf234","student","maria.rodriguez01@uptc.edu.co"),
        new Account("46389778", "johana","torres perez","johana.torres","JKJfsdhf334","professor","johana.torres@uptc.edu.co"),
        new Account("10953483", "ivan santiago","mendoza paez","ivan.mendoza","HJ23jkil","professor","ivan.mendoza@uptc.edu.co"),
        new Account("47865421", "laura daniela","castillo perez","laura.castillo","jaklsBJ832","director","laura.castillo@uptc.edu.co")
    };

    public AccountController(){
        this.accounts = new HashSet<>();
    }
    public boolean loadAccounts(){
        this.accounts = new HashSet<>(List.of(defaultAccounts));
        return true;
    }

    /**
     * El método AddAccount permite la creación y adición de
     * una cuenta a la colección de cuentas, validando los paramétros
     * de entrada
     * @param id código miembro de la institución
     * @param name Nombres del miembro de la institución
     * @param lastName Apeellidos del miembro de la institución
     * @param password Contraseña de la cuenta
     * @param role Rol que tiene el miembro en la institución
     * @return true si la cuenta fue añadida satisfactoriamente, false si ya existe o los parámetros son inválidos
     */
    public boolean addAccount(String id, String name, String lastName, String password, String role){
        String username = "manuel.martinez";
        String email = "manuel.martinez@uptc.edu.co";



        /*
        Validate inputs
         */

        id = id.toLowerCase();
        name = name.toLowerCase();
        lastName = lastName.toLowerCase();

        Account newAccount = new Account(id, name, lastName, username, password, role, email);

        if (this.accounts.contains(newAccount)) return false;


        this.accounts.add(newAccount);

        return true;
    }

    /**
     * findAccount permite la busqueda de una cuenta a partir de
     * usuario y contraseña
     * @param username
     * @param password
     * @return Objeto de tipo Account, dicho objeto será nulo, si no es encontrado en la colección
     */
    public Account findAccount(String username, String password){
        for (Account acc : this.accounts){
            if (acc.getUserName().equals(username) && acc.getPassword().equals(password)) return acc;
        }
        return null;
    }

    /**
     * Permite remover una cuenta de la colecciona a partir de
     * usuario y contraseña
     * @param username
     * @param password
     * @return true si la cuenta se eliminó, false si no se eliminó o no fue encontrada
     */
    public boolean removeAccount(String username, String password){
        Account accountToRemove = this.findAccount(username, password);

        if (accountToRemove == null) return false;

        return this.accounts.remove(accountToRemove);
    }

    /**
     * Permite el cambio de contraseña de una cuenta a partir
     * de usuario y contraseña
     * @param username
     * @param password contraseña antigua
     * @param newPassword contraseña nueva
     * @return true si el cambio fue satisfactorio, false si no se encontró la cuenta o la nueva contraseña es inválida
     */
    public boolean setNewPassword(String username, String password, String newPassword){
        Account accountSetPassword = this.findAccount(username, password);
        if (accountSetPassword == null) return false;

        /*
        Validate New Password
         */

        for (Account acc : this.accounts){
            if (acc.equals(accountSetPassword)){
                Account tempAccount = this.cloneAccount(acc);
                tempAccount.setPassword(newPassword);
                this.accounts.remove(acc);
                this.accounts.add(tempAccount);
                return true;
            };
        }


        return false;
    }

    /**
     * Pequeña utilidad que se utiliza en el cambio de contraseña,
     * debido a que se requiere crear un nuevo objeto para que se genere
     * un nuevo código hash en la colección
     * @param account cuenta a ser clonada
     * @return Account object con los atributos de la cuenta ingresada
     */
    private Account cloneAccount(Account account){
        return new Account(account.getId(), account.getName(), account.getLastname(), account.getUserName(), account.getPassword(), account.getRole(), account.getEmail());
    }
}
