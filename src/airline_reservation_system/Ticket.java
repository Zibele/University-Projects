
package airline_reservation_system;

import java.util.Date;

public class Ticket 
{
    private int ticketNumber;
    private int flightNumber;
    private String passengerName;
    private String passengerSurname;
    private int seatsBooked;
    private double amountPaid;
    private Date dateBooked;
    private String bookDepart;
    private String bookArrival;
    private String typeOfBooking;
    
public Ticket()
{
    ticketNumber=0;
    flightNumber=0;
    passengerSurname="";
    seatsBooked=0;
    amountPaid=0;
    dateBooked=null;
    bookDepart="";
    bookArrival="";
    typeOfBooking="";
}
public Ticket(int flight, String name, String surname, int numSeats, double amtPaid,int tickNum,Date bookDate,String depart,String arrival,String type)
{
    flightNumber = flight;
    passengerName = name;
    passengerSurname = surname;
    seatsBooked = numSeats;
    amountPaid = amtPaid;
    ticketNumber=tickNum;
    dateBooked=bookDate;
    bookDepart=depart;
    bookArrival=arrival;
    typeOfBooking=type;
}
public void setFlightNumber(int flightNum)
{
    flightNumber = flightNum;
}
public void setPassengerName(String nm)
{
    passengerName = nm;
}
public void setPassengerSurname(String snm)
{
    passengerSurname = snm;
}
public void setSeatsBooked(int numSeats)
{
    seatsBooked = numSeats;
}
public void setAmountPaid(double amtPaid)
{
    amountPaid = amtPaid;
}
public int getFlightNumber()
{
    return flightNumber;
}
public String getPassengerName()
{
    return passengerName;
}
public String getPassengerSurname()
{
    return passengerSurname;
}
public int getSeatsBooked()
{
    return seatsBooked;
}
public double getAmountPaid()
{
    return amountPaid;
}
    @Override
    public String toString()
{
    return "---Ticket details---\n" +"Flight Number:"+flightNumber+ "\n"+"Passenger Name:" +passengerName+ "\n" +"Passenger Surname:"+passengerSurname+ "\n"+"Seats booked:" +seatsBooked+ "\n"+"Amount Paid:" +amountPaid+"\n";
}
   
    public void setTicketNumber(int num){
    	ticketNumber=num;
    }
    
    public int getTicketNumber(){
    	return ticketNumber;
    }
    
    public String getDepartCity(){
    	return bookDepart;
    }
    
    public String getArriveCity(){
    	return bookArrival;
    }
    
    public Date getFlightDate(){
    	return dateBooked;
    }
    
    public void setTypeOfBooking(String type){
    	typeOfBooking=type;
    }
    
    public String getTypeOfBooking(){
    	return typeOfBooking;
    }
}
