package CinemaTicket;

public class Employee {
    int id;
    String username;
    String password;
    String email;
    String role;

    public Employee(int id, String username, String password, String email, String role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
    }

    public void changePassword(String newPassword) {
        this.password = newPassword;
    }
}

