package models;


public class User {

    private String email;
    private boolean active;
    private String first_name;
    private String last_name;
    private String password;
    private int roleId;
    private String roleName;

    public User(String email, boolean active, String first_name, String last_name, String password, String roleName) {
        this.email = email;
        this.active = active;
        this.first_name = first_name;
        this.last_name = last_name;
        this.password = password;
        this.roleId = roleId;
        this.roleName = roleName;
    }

    public User() {
    }

    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
