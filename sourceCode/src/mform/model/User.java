package mform.model;

/**
 *
 * @author Kelompok1
 */
public class User {

    private int id;
    private String name;
    private String email;
    private String username;
    private String password;
    private int jumlahEntri;
    private int statusLogin;

    public User() {
    }

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public int getJumlahEntri() {
        return jumlahEntri;
    }

    public void setJumlahEntri(int jumlahEntri) {
        this.jumlahEntri = jumlahEntri;
    }

    public int getStatusLogin() {
        return statusLogin;
    }

    public void setStatusLogin(int statusLogin) {
        this.statusLogin = statusLogin;
    }
   
    
}
