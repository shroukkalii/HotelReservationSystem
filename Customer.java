package finalhotelsystem;

import java.io.Serializable;

public class Customer implements Serializable{
    private static int count; //increase by forming new objects
    private int id;
    private String name;
    
    //aggregation to connect the customer with reservations
    Reservation[] CustomerReservation= new Reservation[20];
    
    //constructor
    Customer(String name){
        
        this.id=this.count+1;  //the customer takes a default id starts from 1
        this.name=name;
        this.count++;
        for (int i=0;i<20;i++)
            CustomerReservation[i] = null; //empty all the reservations
    }
    
    
    public String getName() {
        return name;
    }
    public int getId() {
        return id;
    }
    static public int getCount() {
        return count;
    }
    
    //reserve the not reserved ashan mahgz haga mhgoza
    //bakhod reservation fa bakhod parameter
    public void AddReservation(Reservation reservation){
        for (int i=0;i<20;i++)
        {
            if (CustomerReservation[i] != null)
            {
                CustomerReservation[i] = reservation;
                return;
            }         
        }
    }
    
    public void print(){
        int ReservationCount = 0;
        for (int i=0;i<20;i++)
        {
            //number of reserved
            if (CustomerReservation[i] != null)
                ReservationCount++;        
        }
        //prints id,name,[id,number of reservations of this id]
        System.out.println("Id:"+id+" Name:"+name+" Reservation:"+"["+id+","+ReservationCount+"]");
    }
}
