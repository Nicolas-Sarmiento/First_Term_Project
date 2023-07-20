package co.edu.uptc.model;

/**
 * Person Class is for manage and simulate a person
 * @Author Edwin Martinez
 * @Author Samuel Gonzalez Zambrano
 */
public class Person {
    private String name;
    private String lastname;
    private Account account;

    public Person(String name, String lastname) {
        this.name = name;
        this.lastname = lastname;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }


}

