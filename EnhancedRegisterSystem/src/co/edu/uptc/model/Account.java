package co.edu.uptc.model;

public class Account {

    private String id;
    private String name;
    private String lastname;
    private String userName;
    private String password;
    private String role;
    private String email;

    public Account(String id, String name, String lastname, String userName, String password, String role, String email) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.userName = userName;
        this.password = password;
        this.role = role;
        this.email = email;
    }

    public Account(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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
}