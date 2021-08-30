# HotelReservationSystem

Implemented a Hotel Reservation System using Object Oriented Programming concepts.

*(Classes, Association, Encapsulation, Inheritance, Polymorphism, Exceptions, Abstraction)

It simulates hotel rooms, employees, customers, and reservation in form of object-oriented classes.

-Class Employee has id, name and password. It has with 2 types (Manager & Receptionist) and 3 methods ( validatePassword, displayData, Menu (abstracted) )

-Class Customer has count, id, name, and array of reservations. It has 2 methods (addReservation, displayData)

-Class Room has count, number, type, reservation (reference to class Reservation). and has 4 types (Royal, Presidential, Suite and BB or Bed and Breakfast) with 3 methods (isReserved, reserve, freeTheRoom (that sets the reservation to NULL) )

-Class Reservation has count, id, dateCreated, duration, room, customer and employee or the creator. In addition to a print method.

*Encapsulation is applied to all attributes.

*Inheritance is applied for Employee types.

*Enumeration is used for Room types.

In the main function:

when the system starts it prompts the user to enter his id & password, after signing in, a menu appears
with options ( View All rooms, Add New Receptionist, View All Receptionists, Delete Receptionist by Id, Make New Reservation, View All Reservations, Delete a Reservation, Add new Customer, View all Customers, Delete Customer by ID, Sign-out, Exit & Save)

*where these options can only be accessed by the manager (Add New Receptionist, View All Receptionists, Delete Receptionist by Id, Delete a Reservation)

Using Serializable interface:

*when the system load which load the data from a saved file named save.data

*when the user exits the system, it calls the method save which saves or overwrite the current saved file.

The system throws Exception in case of:

*EmployeeExistException, EmployeeNotFoundException, RoomNotFoundException, CustomerNotFoundException, ReservationNotFoundException, RoomNotAvailableException
