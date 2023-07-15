package co.edu.uptc.controller;

import co.edu.uptc.model.Account;

import java.util.HashSet;
import java.util.List;



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
    public Account findAccount(String username, String password){
        for (Account acc : this.accounts){
            if (acc.getUserName().equals(username) && acc.getPassword().equals(password)) return acc;
        }
        return null;
    }
    public boolean removeAccount(String username, String password){
        Account accountToRemove = this.findAccount(username, password);

        if (accountToRemove == null) return false;

        return this.accounts.remove(accountToRemove);
    }
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

    public Account cloneAccount(Account account){
        return new Account(account.getId(), account.getName(), account.getLastname(), account.getUserName(), account.getPassword(), account.getRole(), account.getEmail());
    }
}
