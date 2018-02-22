package airline_reservation_system;

import java.util.ArrayList;

public class FlightHandler {
	
	private ArrayList<Flight> Flights;
	private ArrayList<Ticket> Ticket;
	
	
	FlightHandler(){
		Flights=new ArrayList<Flight>();
		Ticket=new ArrayList<Ticket>();
		
	}

	
	
 public ArrayList<Flight> getFlights(){
	 return Flights;
 }
	
 public ArrayList<Ticket> getTickets(){
	return Ticket;
 }

 
	
}
