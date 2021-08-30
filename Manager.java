package finalhotelsystem;

public class Manager extends Employee{
    
    
    Manager()
    {} //for main
    //constructor to initiliaze the inherited attributes
    Manager(int id,String name,String password, EmployeeType type){
        super(id, name, password, type);
    }
    
    
    
    public void menu(){
        System.out.println("1- View all rooms");
        System.out.println("2- Add new receptionists");
        System.out.println("3- View all receptionists");
        System.out.println("4- Delete receptionist by id");
        System.out.println("5- Make new reservation");
        System.out.println("6- View all reservations");
        System.out.println("7- Delete a reservation");
        System.out.println("8- Add new customer");
        System.out.println("9- View all customers");
        System.out.println("10- Delete customer by id");
        System.out.println("11- Sign Out");
        System.out.println("12- Exit and Save");
    }
}