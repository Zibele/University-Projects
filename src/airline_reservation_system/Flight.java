
package airline_reservation_system;

import java.text.ParseException;
import java.text.SimpleDateFormat;
/**
 *
 * 
 */
import java.util.*;

public class Flight 
{
    private int flightNumber;
    private Date flightDate;
    private String departCity;
    private String arriveCity;
    private int seatsAvailable;
    private int seatsSold;
    private double seatPrice;
    private boolean isCancelled=false;
    private String typeOfFlight;
    
    
public Flight()
{    
}
public Flight(Date date, String depart, String arrive)
{
    flightDate = date;
    departCity = depart;
    arriveCity = arrive;
}
public Flight(Date date, String depart, String arrive, int seatsAvail,int flightNum,String type)
{
    flightDate = date;
    departCity = depart;
    arriveCity = arrive;
    seatsAvailable = seatsAvail;
    flightNumber=flightNum;
    typeOfFlight=type;
}
public void setFlightDate(Date date)
{
    flightDate = date;
}
public void setDepartCity(String depart)
{
    departCity = depart;
}
public void setArriveCity(String arrive)
{
    arriveCity = arrive;
}
public void setSeatsAvailable(int seatsAvail)
{
    seatsAvailable = seatsAvail;
}
public void setSeatsSold(int soldSeats)
{
    soldSeats = seatsSold;
}
public void setSeatPrice(double price)
{
    seatPrice = price;
}
public void setCancelled(boolean cancel)
{
    isCancelled = cancel;
}
public int getFlightNumber()
{
    return flightNumber;
}
public Date getFlightDate()
{

    return flightDate;
}
public String getDepartCity()
{
    return departCity;
}
public String getArriveCity()
{
    return arriveCity;
}
public int getSeatsAvailable()
{
    return seatsAvailable;
}
public int getSeatsSold()
{
    return seatsSold;
}
public double getSeatPrice()
{
    return seatPrice;
}
//I'm not sure about this one of cancelled 
public boolean isCancelled()
{
    return isCancelled;
}

public void setFlightNumber(int num){
	flightNumber=num;
}

public void setTypeOfFlight(String type){
	typeOfFlight=type;
	
}

public String getTypeOfFlight(){
	return typeOfFlight;
}
    @Override
    public String toString()
{
    	SimpleDateFormat sdf=new SimpleDateFormat("MM/dd/yyyy");
    	
    return "----Details for the flight----\n"+"Flight Number:" +flightNumber+ "\n"+"Flight Date:" +sdf.format(flightDate)+ "\n" +"Depart City:" +departCity+ "\n" +"Arrive City:" +arriveCity+ "\n"+"Seats Available:" +seatsAvailable+ "\n"+"Seats Sold:" +seatsSold+ "\n"+"Seat Price:" +seatPrice+"\n";
}

}