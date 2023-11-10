public class Manager {
    private String Username;
    private String Password;
    private boolean isAuthenticated;

    public Manager(String Username) { //Manager Class to do a simple password Check as per requirement
        this.Username = Username;
        this.Password = "JAVA";
        isAuthenticated = false;

    }

    public Manager() {
        this.Username = "";
        this.Password = "JAVA";
    }

    public String getUsername() {return Username;}
    public String Authenticate(String Password) {
        if (this.Password.equals(Password)) {
            isAuthenticated = true;
            return "Login Successful";
        } else {
            isAuthenticated = false;
            return "Login Failed";
        }
    }

    public boolean isAuthenticated() {return isAuthenticated;}
}
