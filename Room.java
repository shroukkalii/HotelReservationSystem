package finalhotelsystem;

import java.io.Serializable;

public class Room implements Serializable{

//enumeration to generally assign types into a datatype    
 //public to be accessed fl test
    public enum Roomtype
    {
        Royal, Suite, Presidential, BB
    }
    private static int count;
    private int number;
    private Roomtype type;
    Reservation reservation= null; //default=null as no reserved room
    
    Room(){} //empty constructor for reservation class
    Room(int number, Roomtype type,Reservation reserve){
        this.number=number;
        this.type=type;  
        this.reservation=reserve;
    }
    
    public int getNumber() {
        return number;
    }
     public Roomtype getType() {
        return type;
    }
    static public int getCount() {
        return count;
    }
    
    //return true if the room is reserved
    public boolean isReserved (){
       return reservation!=null;
    }
    
    //reserve the room
    public void reserve (Reservation reserve)
    {
        reservation = reserve;
    
    }
    
    //free the room
    public void free(){
       reservation=null;
      
    }
    
    
    
}
