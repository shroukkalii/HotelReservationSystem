package finalhotelsystem;

import java.io.*;
import java.util.Scanner;
import java.util.Date;

public class Test {
    
    //Creating Data Object
    static Data DataObject = new Data(); 
    //handling errors
    //ay haga htcall fl main lazem tbaa static ashan main static
    //private ashan kda kda accessed f same class
    //room not dynamic array ashan msh httghyr 3ddha,22fl oda msln no
    //employee yegy w ymshe therefore dynamic bytghyr 3ddo
    
   
     private static void InitializeRooms(){
        //invoke rooms' constructor
        DataObject.AllRooms[0] = new Room(1, Room.Roomtype.Royal, null);
        
        for(int i = 1; i < 3; i++)
            DataObject.AllRooms[i] = new Room(i+1, Room.Roomtype.Presidential, null);
        
        for(int i = 3; i < 6; i++)
            DataObject.AllRooms[i] = new Room(i+1, Room.Roomtype.Suite, null);
        
        for(int i = 6; i < 10; i++)
            DataObject.AllRooms[i] = new Room(i+1, Room.Roomtype.BB, null);
    }
    
     private static void InitializeEmployees(){
        //initliaze 1 admin and 1 receptionist 
        //accesor incremented by 1 to starts with 1 not 0
        //not allowed to ++ in functions it should be +1
        
        //bdl count+1 amalt size +1
        Manager admin = new Manager(DataObject.AllEmployees.size() +1,"Ali","managerpass", Employee.EmployeeType.Manager);
        DataObject.AllEmployees.add(admin); //arraylist's library functions
        Receptionist receptionist = new Receptionist(DataObject.AllEmployees.size() +1,"Shrouk","receptionistpass", Employee.EmployeeType.Receptionist);
        DataObject.AllEmployees.add(receptionist);
    }
         
     private static boolean SignIn(int id, String password){
        //we need to check fe employees or not
        if (DataObject.AllEmployees.isEmpty())
            return false;
        
        for(int i = 0; i < DataObject.AllEmployees.size(); i++)
        {
            if (DataObject.AllEmployees.get(i).getId() == id)
                return DataObject.AllEmployees.get(i).ValidatePassword(password);
            
        }
        
        return false; //this id doesn't exist kda kda
    }
    
     private static void ViewAllRooms(){ 
       
        for(int i = 0; i < 10; i++){
            String Reserved; // to print whether it's reserved or not
            if(DataObject.AllRooms[i].isReserved())
                Reserved = "Reserved";
            else
                Reserved = "Empty";
            System.out.println("Room Number: "+DataObject.AllRooms[i].getNumber() + " - Room Type: "+ DataObject.AllRooms[i].getType() +", Reservation State: "+Reserved);
            
        }
    }
    
     private static void AddNewReceptionist(){
       
        System.out.println("Please enter the receptionist's name");
        Scanner scan= new Scanner(System.in);
        String name= scan.next();
        System.out.println("Please enter the password");
        String password= scan.next();
        
        Receptionist newrecep = new Receptionist( DataObject.AllEmployees.size() +1,name,password, Employee.EmployeeType.Receptionist);
        DataObject.AllEmployees.add(newrecep);
        newrecep.print();
    
    }
  
     private static void ViewAllReceptionists(){
        for (int i=0; i<DataObject.AllEmployees.size(); i++)
        {
            if(DataObject.AllEmployees.get(i).getType() == Employee.EmployeeType.Receptionist)
                DataObject.AllEmployees.get(i).print();
        }
       }
   
     private static void DeleteReceptionistById(){
     System.out.println("Please enter the ID you want to delete");
     Scanner scanid = new Scanner(System.in);
     int id= scanid.nextInt();
     for (int i=0; i<DataObject.AllEmployees.size(); i++)
        {
            if(DataObject.AllEmployees.get(i).getId() == id)
            {
                if(DataObject.AllEmployees.get(i).getType() == Employee.EmployeeType.Receptionist)
                    DataObject.AllEmployees.remove(i);
                else
                   System.out.println("This ID is not for a receptionist!"); 
                    
                return; //return function kolaha
            }
        }
     System.out.println("This ID doesn't exist");
     //error ghleban
    }
     
     private static void MakeNewReservation(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter the customer ID");
        int CustomerId= scan.nextInt();
        System.out.println("Please enter the room number");
        int RoomNum= scan.nextInt();
        System.out.println("Please enter the duration");
        int Duration= scan.nextInt();

        int id = Reservation.count + 1;
        
        Date dateCreated = new Date(System.currentTimeMillis());
        System.out.println("Please enter the creator's ID");
        
        int CreatorId= scan.nextInt();
         
        //check if the customer id exists
        boolean check = false; //flag mlaatosh lsa
        for (int i=0; i<DataObject.AllCustomers.size(); i++)
        {
            if(DataObject.AllCustomers.get(i).getId() == CustomerId)
            {
                check = true;
                break;
            }
        }
        if(!check) // hykhosh lw mlaanash
            {
                System.out.println("There is no customer created with this ID, please create a customer profile first.");
                return;
            }
         
        //check if the room exists and empty
        check = false; //not dynamic array
        for (int i=0; i<DataObject.AllRooms.length; i++)
        {
            if(DataObject.AllRooms[i].getNumber() == RoomNum)
            {
                if(DataObject.AllRooms[i].isReserved())
                    check = false; //mhgoza fa arg3 false
                else
                    check = true;
                
                break;
            }
        } 
        if(!check)
            {
                System.out.println("There is no room with this ID, or the room is already reserved");
                return;
            }
        
        Reservation reservation  = new Reservation(id, dateCreated ,Duration, CustomerId, RoomNum, CreatorId);
        DataObject.AllReservations.add(reservation);
        reservation.print();
     }
   
     private static void ViewAllReservations(){
         for (int i=0; i<DataObject.AllReservations.size(); i++)
             DataObject.AllReservations.get(i).print();
     }
     
     private static void DeleteReservation(){
     System.out.println("Please enter the reservation's ID you want to delete");
     Scanner scanid = new Scanner(System.in);
     int id= scanid.nextInt();
     for (int i=0; i<DataObject.AllReservations.size(); i++)
        {
            if(DataObject.AllReservations.get(i).getId() == id)
            {
                
                //make the room empty
                for (int j=0; j<DataObject.AllRooms.length; j++)
                {
                    if(DataObject.AllRooms[j].getNumber() == id)
                    {
                        DataObject.AllRooms[j].reservation = null;
                        break;
                    }
                }
                //bshof men cust el amel reserv asln
                //delete reservation from the customer reservations
                for (int k=0; k<DataObject.AllCustomers.size(); k++)
                {
                    if(DataObject.AllCustomers.get(k).getId() == DataObject.AllReservations.get(i).getcustomerID()) //gbt el id bt3o
                    {
                        for (int R=0; R<DataObject.AllCustomers.get(k).CustomerReservation.length; R++)
                        {//ando msln kza reserv fa ashof ane al i
                            if(DataObject.AllCustomers.get(k).CustomerReservation[R] == DataObject.AllReservations.get(i)) //anhe f hogzato el amsaho
                            {
                                DataObject.AllCustomers.get(k).CustomerReservation[R] = null;
                                break;
                            }
                        }
                        break; 
                    }
                }
                
                DataObject.AllReservations.remove(i);
            }
             //reference reservation set to null
            
            return; //return function kolaha
        }
     System.out.println("This ID doesn't exist");
     }
     
     private static void AddNewCustomer(){
       
        //id already random fe customer class not from the user
        System.out.println("Please enter the customer's name");
        Scanner scanname= new Scanner(System.in);
        String name= scanname.next();
        
        Customer newcust = new Customer(name);
        DataObject.AllCustomers.add(newcust); 
        newcust.print();
    }
     
     private static void ViewAllCustomers(){
        for (int i=0; i<DataObject.AllCustomers.size(); i++)
            DataObject.AllCustomers.get(i).print();
       }
     
     private static void DeleteCustomerById(){
     System.out.println("Please enter the ID you want to delete");
     Scanner scanid = new Scanner(System.in);
     int id= scanid.nextInt();
     for (int i=0; i<DataObject.AllCustomers.size(); i++)
        {
            if(DataObject.AllCustomers.get(i).getId() == id)
            {
                DataObject.AllCustomers.remove(i);
                return;
            }
        }
     System.out.println("This ID doesn't exist");
     
    }
     
     private static void Save(){
         try{ // fout to access the file savedata
         FileOutputStream fout=new FileOutputStream("save.data");  
         ObjectOutputStream out=new ObjectOutputStream(fout);  
         out.writeObject(DataObject);  
         out.flush(); //to write the object in savedata  
         //closing the stream  
         out.close();  
         System.out.println("Saved successfully..");
         }catch(Exception e){System.out.println(e);} //to print the exception warning
     }
     
     private static void Load(){
         try{  
         //Creating stream to read the object  
         FileInputStream fin=new FileInputStream("save.data");
         ObjectInputStream in=new ObjectInputStream(fin);  
         DataObject = (Data)in.readObject(); 
         //closing the stream  //mfesh flush write
         in.close();  
         }catch(Exception e){System.out.println(e);}
         
     }
    
     public static void main(String[] args){
        
        //Rooms Initializing
        InitializeRooms();
        
        //Employees Initializing
        InitializeEmployees();
        
        //Load saved data
        Load();
        
        
        //Sign in
        System.out.println("Welcome to the Hotel System");
        
        //view all rooms
        System.out.println("Hotel Rooms:");
        ViewAllRooms();
        
        while(true)
        {
            //ViewAllReceptionists();
        System.out.println("Please enter your ID");
        Scanner scan = new Scanner(System.in);
        int id= scan.nextInt();
        System.out.println("Please enter your Password");
        String password= scan.next();
        
            /*check id wpassword w kda kda msh hykhosh fl if ela law sah
            gher kda yfdal true ashan user yenter id&password for another time*/
            
            if (SignIn(id, password))
            {
                Employee.EmployeeType UserType = Employee.EmployeeType.None; //default initialization
                for(int i=0; i<DataObject.AllEmployees.size(); i++)
                {
                    if(DataObject.AllEmployees.get(i).getId() == id)
                    {
                        UserType = DataObject.AllEmployees.get(i).getType();
                        System.out.println("Welcome " + DataObject.AllEmployees.get(i).getName());
                    }
                        
                }
                //label
                options: while(true)
                {
                    if(UserType == Employee.EmployeeType.Manager)
                    {
                        Manager manager = new Manager();
                        System.out.println("Please choose your option: ");
                        manager.menu();
                        int choice =scan.nextInt();
                        
                        switch(choice)
                        {
                            case 1:
                                ViewAllRooms();
                                break;
                            case 2:
                                AddNewReceptionist();
                                break;  
                            case 3:
                                ViewAllReceptionists();
                                break;
                            case 4:
                                DeleteReceptionistById();
                                break;  
                            case 5:
                                MakeNewReservation();
                                break;
                            case 6:
                                ViewAllReservations();
                                break;  
                            case 7:
                                DeleteReservation();
                                break;
                            case 8:
                                AddNewCustomer();
                                break;
                            case 9:
                                ViewAllCustomers();
                                break;
                            case 10:
                                DeleteCustomerById();
                                break;  
                            case 11:
                                //signout
                                break options;
                            case 12:
                                //exit and save
                                Save();
                                return; //return mlmain
                            default:
                                System.out.println("Invalid Selection!");
                                break;
                        }
                        
                    }
                    else if(UserType == Employee.EmployeeType.Receptionist)
                    {
                        Receptionist receptionist = new Receptionist();
                        receptionist.menu();
                        System.out.println("Please choose your option: ");
                        int choice =scan.nextInt();
                        
                        switch(choice)
                        {
                            case 1:
                                ViewAllRooms();
                                break;
                            case 2:
                                MakeNewReservation();
                                break;
                            case 3:
                                ViewAllReservations();
                                break;  
                            case 4:
                                AddNewCustomer();
                                break;
                            case 5:
                                ViewAllCustomers();
                                break;
                            case 6:
                                DeleteCustomerById();
                                break;  
                            case 7:
                                //signout
                                break options;
                            case 8:
                                //exit and save
                                Save();
                                return; //return mlmain
                            default:
                                System.out.println("Invalid Selection!");
                                break;
                        }
                    }
                }
            }
            else
                System.out.println("Wrong ID or Password, please try again.");
        }
    }
}