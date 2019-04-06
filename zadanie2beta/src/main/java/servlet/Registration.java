package servlet;

public class Registration {
    private String username;
    private String password;
    private String confirmPasword;
    private String email;

    public String getUsername(){
        return username;
    }
    public void setUsername(String username){
        this.username=username;
    }
    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password=password;
    }
    public String getConfirmPasword(){
        return confirmPasword;
    }
    public void setConfirmPasword(String confirmPasword){
        this.confirmPasword=confirmPasword;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email=email;
    }
}
