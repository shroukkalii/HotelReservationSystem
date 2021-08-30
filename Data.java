package finalhotelsystem;
import java.io.Serializable;
import java.util.ArrayList;
        
public class Data implements Serializable{
    
    Room[] AllRooms = new Room[10]; //array of fixed number of rooms with specific types
    ArrayList<Employee> AllEmployees = new ArrayList<Employee>(); 
    ArrayList<Customer> AllCustomers = new ArrayList<Customer>(); //with empty customers
    ArrayList<Reservation> AllReservations = new ArrayList<Reservation>(); //with empty reservations
    
   
}
