package finalhotelsystem;

import java.io.Serializable;

public abstract class Employee implements Serializable{
    
    //enumeration lel type manag or recep to print all recep
    public enum EmployeeType
    {
        Manager, Receptionist, None
    } //none ashan fltest adelo default type because flmain lazem adelo default
    //static ashan aprint taht w print called fl test therefore, static
    private static int count; //increase by forming new objects
    private int id;
    private EmployeeType type;
    private String name;
    private String password;
    
    Employee()
    {}

    //constructor initiliaze the attributes
    Employee(int id,String name,String password, EmployeeType type){
        this.id=id;
        this.name=name;
        this.password=password;
        this.type = type;
        this.count++;
        
    }
    
   
    //return 1 if the password is correct 
    public boolean ValidatePassword (String pass){
        return this.password.equals(pass);
    }
    //abstracted methods defined in the subclasses
    abstract public void menu();
    
    //accessors
    public String getName() {
        return name;
    }
    public int getId() {
        return id;
    }
    public EmployeeType getType() {
        return type;
    }
    static public int getCount() {
        return count;
    }
    
    public String getPassword() {
        return password;
    }
    
    //print the employee
    public void print(){
        System.out.println("Id:"+id+" Name:"+name+" Password: "+password);
    }
}
