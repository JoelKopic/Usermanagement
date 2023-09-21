package CinemaTicket;

import java.util.HashMap;
import java.util.Map;



class User {
    private String username;
    private String password;
    private String paymentMethod;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.paymentMethod = null;
    }


    public void setPassword(String password) {
        this.password = password;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getPassword() {
        return password;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setUsername(String username){
        this.username= username;
    }
    public String getUsername(){
        return username;
    }
}




public class CinemaTicketSystem {
    private Map<String, User> userDB = new HashMap<>();


    HashMap<Integer, Employee> employees = new HashMap<>();

    // Methode zum Registrieren eines Benutzers
    public void createUser(String username, String password) {
        User user = new User(username, password);
        userDB.put(username, user);
    }
    //Angestellten ins System miteinbringen
    public void addEmployee(Employee employee) {
        employees.put(employee.id, employee);
    }

    public Employee getEmployeeById(int id) {
        return employees.get(id);
    }

    // Methode zum Anmelden eines Benutzers
    public boolean login(String username, String password) {
        if (userDB.containsKey(username)) {
            User user = userDB.get(username);
            return user.getPassword().equals(password);
        }
        return false;
    }

    // Methode zum Ändern des Passworts eines Benutzers
    public void changePassword(String username, String newPassword) {
        if (userDB.containsKey(username)) {
            User user = userDB.get(username);
            user.setPassword(newPassword);
        }
    }

    // Methode zum Löschen eines Benutzers
    public void deleteUser(String username) {
        if (userDB.containsKey(username)) {
            userDB.remove(username);
        }
    }


    public void addPaymentMethod(String username, String paymentMethod) {
        if (userDB.containsKey(username)) {
            User user = userDB.get(username);
            user.setPaymentMethod(paymentMethod);
        }
    }

    public static void main(String[] args) {
        CinemaTicketSystem ticketSystem = new CinemaTicketSystem();


        ticketSystem.createUser("benutzer1", "passwort123");


        boolean loggedIn = ticketSystem.login("benutzer1", "passwort123");
        if (loggedIn) {
            System.out.println("Anmeldung erfolgreich");
        } else {
            System.out.println("Anmeldung fehlgeschlagen");
        }


        ticketSystem.changePassword("benutzer1", "neuespasswort");


        ticketSystem.deleteUser("benutzer1");


        ticketSystem.addPaymentMethod("benutzer2", "Kreditkarte");



    }
    }






