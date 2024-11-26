package za.ac.tut.model;

public class User {

    private int userId;
    private String username;
    private String password;
    private String fullName;
    private String email;
    private int roleId;
    
    public User(String fullName, int userID){
        this.fullName = fullName;
        this.userId = userID;
    }
    
    // Constructor
    public User(String username, String password, String fullName, String email, int roleId) {
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.email = email;
        this.roleId = roleId;
    }
    
    public User(int userID, String username, String password, String fullName, String email, int roleId) {
        this.setUserId(userID);
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.email = email;
        this.roleId = roleId;
    }
    
    // Getters and Setters
    public int getUserId() {
        return userId;
    }

    final public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        System.out.println("Getting full name: " + this.fullName);
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }
}
