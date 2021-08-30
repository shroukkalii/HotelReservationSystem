package finalhotelsystem;

public class Receptionist extends Employee {
    
    Receptionist()
    {}//for main
    
    //constructor to initiliaze the inherited attributes
    Receptionist(int id, String name, String password, EmployeeType type){
        super(id, name, password, type);
    }
    
    
    public void menu(){
        System.out.println("1- View all rooms");
        System.out.println("2- Make new reservation");
        System.out.println("3- View all reservations");
        System.out.println("4- Add new customer");
        System.out.println("5- View all customers");
        System.out.println("6- Delete customer by id");
        System.out.println("7- Sign Out");
        System.out.println("8- Exit and Save");
        
        
    }
}   
