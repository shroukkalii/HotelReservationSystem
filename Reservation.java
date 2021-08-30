package finalhotelsystem;

import java.io.Serializable;
import java.util.Date;

public class Reservation implements Serializable{
    
    //the employee creates a reservation to a room for the customer
    public static int count;
    private int id;
    private Date dateCreated; //date datatype
    private int duration;
    private int roomID;
    private int customerID;
    private int creatorID;
    
    
    Reservation(int id, Date dateCreated, int duration, int customerID, int roomID, int creatorID )
    {
        this.id = id;
        this.dateCreated = dateCreated;
        this.duration = duration;
        this.roomID = roomID;
        this.customerID = customerID;
        this.creatorID = creatorID;
        this.count++;
        
        //make the room reserved
        for (int i=0; i<Test.DataObject.AllRooms.length; i++)
        {
            if(Test.DataObject.AllRooms[i].getNumber() == roomID)
            {
                Test.DataObject.AllRooms[i].reservation = this; //created f room kda kda b null fa hena baamelha reserve
                break;
            }
        }
        
        //add reservation to the customer reservations
        for (int i=0; i<Test.DataObject.AllCustomers.size(); i++)
        {
            if(Test.DataObject.AllCustomers.get(i).getId() == customerID)
            {
                for (int j=0; j<Test.DataObject.AllCustomers.get(i).CustomerReservation.length; j++)
                {
                    if(Test.DataObject.AllCustomers.get(j).CustomerReservation[j] == null)
                    {
                        Test.DataObject.AllCustomers.get(j).CustomerReservation[j] = this;
                        break;
                    }
                }
                break; 
            }
        }
        
    }
    public int getId() {
        return id;
    }
    public int getcustomerID() {
        return customerID;
    }
    public Date getDate() {
        return dateCreated;
    }
    public int getDuration() {
        return duration;
    }
    
   public void print(){
        System.out.println("Reservation details: "+"Id: "+id+ " Customer ID: "+ customerID + " Room Number: " + roomID +" Date created: "+dateCreated+" Duration: "+duration);
      
        //amalt zyada customerid w room number ashan method view all reservation ause this print
    }
}
