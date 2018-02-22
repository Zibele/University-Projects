package airline_reservation_system;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class ManageResGUI extends JFrame {

	private JPanel contentPane;
	private JTextField nameField;
	private JTextField surnameField;
	public JComboBox sltFlightComb;
	public JComboBox sltPassComb;
	public JComboBox cSltFlightComb;
	public JComboBox amnSeatsComb;
	private Vector seatVector;
	private int focusFlight;
	private JTable resTable;
	public JComboBox vSltFlightCombo;
	private int counter=0;
	private Vector comboItems;
	private Double inter_Sales=0.0;
	private Double loc_Sales=0.0;
	private GuiInvoker ctx;
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageResGUI frame = new ManageResGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ManageResGUI(GuiInvoker script) {
		this.ctx=script;
		setTitle("Manage Reservations");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 858, 529);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				script.resGUI.setVisible(false);
				script.mainGUI.setVisible(true);
			}
		});
		
		seatVector = new Vector();
		comboItems = new Vector();
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		
		JScrollPane scrollPane = new JScrollPane();
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(panel, GroupLayout.PREFERRED_SIZE, 287, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 257, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE))
								.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 812, Short.MAX_VALUE))
							.addContainerGap())
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE)
							.addGap(268))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(panel_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(panel, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 258, GroupLayout.PREFERRED_SIZE))
							.addGap(18)))
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnBack)
					.addGap(6))
		);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("View  Passengers");
		lblNewLabel_2.setBounds(79, 11, 108, 14);
		panel_2.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Select a flight number:");
		lblNewLabel_3.setBounds(10, 33, 141, 14);
		panel_2.add(lblNewLabel_3);
		
		vSltFlightCombo = new JComboBox();
		vSltFlightCombo.setModel(new DefaultComboBoxModel(new String[]{"None"
		}));
		vSltFlightCombo.setBounds(161, 30, 69, 20);
		panel_2.add(vSltFlightCombo);
		
		JButton vPassOnFBtn = new JButton("Passengers on flight");
		vPassOnFBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			      JOptionPane display=new JOptionPane();
				  JTextArea values=new JTextArea();
				  values.append("-------Passengers for flight:"+vSltFlightCombo.getSelectedItem().toString()+"-------\n");
				  
				for(int x=0;x<script.flightHandler.getTickets().size();x++){
					//vsltflightcombo
					
					if(Integer.parseInt(vSltFlightCombo.getSelectedItem().toString())==script.flightHandler.getTickets().get(x).getFlightNumber()){
						
						values.append(script.flightHandler.getTickets().get(x).getPassengerName()+" "+script.flightHandler.getTickets().get(x).getPassengerSurname()+"\n");
						
						
						
					}
					
					
				}
				
				
				display.showMessageDialog(null,values,"View Passengers on flight",JOptionPane.INFORMATION_MESSAGE);
				
			}
		});
		vPassOnFBtn.setBounds(10, 96, 230, 23);
		panel_2.add(vPassOnFBtn);
		
		JButton vPassOnCFlight = new JButton("Passengers on cancelled flight");
		vPassOnCFlight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			      JOptionPane display=new JOptionPane();
							  JTextArea values=new JTextArea();
							  values.append("-------Passengers for cancelled flights-------\n");
							  
							for(int x=0;x<script.flightHandler.getTickets().size();x++){
								//vsltflightcombo
								
								if(script.flightHandler.getFlights().get(searchForCancelled(script.flightHandler.getFlights())).getFlightNumber()==script.flightHandler.getTickets().get(x).getFlightNumber()){
									
									values.append(script.flightHandler.getTickets().get(x).getPassengerName()+" "+script.flightHandler.getTickets().get(x).getPassengerSurname()+"\n");
									
									
									
								}
								
								
							}
							
							
							display.showMessageDialog(null,values,"View Passengers on flight",JOptionPane.INFORMATION_MESSAGE);
				
				
				
				
				
				
			}
		});
		vPassOnCFlight.setBounds(10, 149, 232, 23);
		panel_2.add(vPassOnCFlight);
		
		resTable = new JTable();
		resTable.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"Date", "Flight No.", "Depart City", "Arrival City", "Pass. Surname", "Pass.Name", "Ticket No.", "Amount Paid", "Seats Booked"
			}
		));
		resTable.getColumnModel().getColumn(1).setPreferredWidth(94);
		resTable.getColumnModel().getColumn(2).setPreferredWidth(82);
		resTable.getColumnModel().getColumn(4).setPreferredWidth(94);
		resTable.getColumnModel().getColumn(5).setPreferredWidth(85);
		resTable.getColumnModel().getColumn(6).setPreferredWidth(67);
		resTable.getColumnModel().getColumn(7).setPreferredWidth(91);
		resTable.getColumnModel().getColumn(8).setPreferredWidth(87);
		scrollPane.setViewportView(resTable);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Select a flight number:");
		lblNewLabel_1.setBounds(10, 33, 155, 14);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblCancelABooking = new JLabel("Cancel a booking");
		lblCancelABooking.setBounds(73, 8, 105, 14);
		panel_1.add(lblCancelABooking);
		
		cSltFlightComb = new JComboBox();
		cSltFlightComb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(int x=0;x<script.flightHandler.getTickets().size();x++)
				if(Integer.parseInt(cSltFlightComb.getSelectedItem().toString())==script.flightHandler.getTickets().get(x).getFlightNumber()){
					
					addToBox(script.flightHandler.getTickets().get(x).getPassengerName()+" "+script.flightHandler.getTickets().get(x).getPassengerSurname(),comboItems);
                    
				}
				sltPassComb.setModel(getModel(comboItems));
			}
			
			
		});
		cSltFlightComb.setModel(new DefaultComboBoxModel(new String[] {"None"}));
		cSltFlightComb.setBounds(147, 30, 100, 20);
		panel_1.add(cSltFlightComb);
		
		JLabel lblSelectAPassenger = new JLabel("Select a passenger:");
		lblSelectAPassenger.setBounds(10, 68, 155, 14);
		panel_1.add(lblSelectAPassenger);
		
		sltPassComb = new JComboBox();
		sltPassComb.setModel(new DefaultComboBoxModel(new String[] {"None"}));
		sltPassComb.setBounds(147, 61, 100, 20);
		panel_1.add(sltPassComb);
		
		JButton cnlBookingBtn = new JButton("Cancel booking");
		cnlBookingBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SimpleDateFormat sf= new SimpleDateFormat("MM/dd/yyyy");
				removeFromBox(sltPassComb.getSelectedItem().toString(),comboItems);	
				removeTicket(sltPassComb.getSelectedItem().toString(),script.flightHandler.getTickets(),script.flightHandler.getFlights());
				clearTable(resTable);

				for(int y=0;y<script.flightHandler.getTickets().size();y++){
					
			      //   if(Integer.parseInt(sltFlightComb.getSelectedItem().toString())==script.flightHandler.getTickets().get(y).getFlightNumber()){
			        	 
			        	 resTable.setValueAt(script.flightHandler.getTickets().get(y).getDepartCity(), y, 2);
			        	 resTable.setValueAt(script.flightHandler.getTickets().get(y).getArriveCity(), y, 3);
			        	 resTable.setValueAt(sf.format(script.flightHandler.getTickets().get(y).getFlightDate()), y, 0);
			        	 resTable.setValueAt(script.flightHandler.getTickets().get(y).getPassengerName(), y, 4);
			             resTable.setValueAt(script.flightHandler.getTickets().get(y).getPassengerSurname(), y, 5);
			             resTable.setValueAt(script.flightHandler.getTickets().get(y).getTicketNumber(), y, 6);
			             resTable.setValueAt(script.flightHandler.getTickets().get(y).getAmountPaid(), y, 7);
			             resTable.setValueAt(script.flightHandler.getTickets().get(y).getSeatsBooked(), y, 8);
			             resTable.setValueAt(script.flightHandler.getTickets().get(y).getFlightNumber(), y, 1);
			             sltPassComb.setModel(getModel(comboItems));
			       System.out.println("Current Tickets:"+script.flightHandler.getTickets());
			}
				
				script.reportGUI.table.setValueAt("R"+script.resGUI.getIntSales(), 0, 0);
				script.reportGUI.table.setValueAt("R"+script.resGUI.getLocSales(), 0, 1);
			}
			}
					
				
				
);
		cnlBookingBtn.setBounds(62, 114, 142, 23);
		panel_1.add(cnlBookingBtn);
		panel.setLayout(null);
		
		JButton addBookBtn = new JButton("Add booking");
		addBookBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SimpleDateFormat sf= new SimpleDateFormat("MM/dd/yyyy");
				counter++;
				for(int x=0;x<script.flightHandler.getFlights().size();x++){
				if(Integer.parseInt(sltFlightComb.getSelectedItem().toString())==script.flightHandler.getFlights().get(x).getFlightNumber()){
				setPrices(script.flightHandler.getFlights());
				script.flightHandler.getTickets().add(new Ticket(Integer.parseInt(sltFlightComb.getSelectedItem().toString()),nameField.getText(),surnameField.getText(),Integer.parseInt(amnSeatsComb.getSelectedItem().toString()),(calculateSales((double)script.flightHandler.getFlights().get(x).getSeatPrice(),Integer.parseInt(amnSeatsComb.getSelectedItem().toString()),script.flightHandler.getFlights().get(x).getTypeOfFlight())),counter,script.flightHandler.getFlights().get(x).getFlightDate(),script.flightHandler.getFlights().get(x).getDepartCity(),script.flightHandler.getFlights().get(x).getArriveCity(),script.flightHandler.getFlights().get(x).getTypeOfFlight()));
                script.flightHandler.getFlights().get(x).setSeatsAvailable(script.flightHandler.getFlights().get(x).getSeatsAvailable()-Integer.parseInt(amnSeatsComb.getSelectedItem().toString()));
			//	script.flightHandler.getTickets().get(x).setFlightNumber(script.flightHandler.getFlights().get(x).getFlightNumber());
  
    			amnSeatsComb.setModel(getModel(setNumbering(script.flightHandler.getFlights().get(x).getSeatsAvailable(),seatVector)));
    		
    				
				
				System.out.println(script.flightHandler.getTickets());
				}
				}
				
				for(int y=0;y<script.flightHandler.getTickets().size();y++){
					
			         if(Integer.parseInt(sltFlightComb.getSelectedItem().toString())==script.flightHandler.getTickets().get(y).getFlightNumber()){
			        	 
			        	 resTable.setValueAt(script.flightHandler.getTickets().get(y).getDepartCity(), y, 2);
			        	 resTable.setValueAt(script.flightHandler.getTickets().get(y).getArriveCity(), y, 3);
			        	 resTable.setValueAt(sf.format(script.flightHandler.getTickets().get(y).getFlightDate()), y, 0);}
			        	 resTable.setValueAt(script.flightHandler.getTickets().get(y).getPassengerName(), y, 4);
			             resTable.setValueAt(script.flightHandler.getTickets().get(y).getPassengerSurname(), y, 5);
			             resTable.setValueAt(script.flightHandler.getTickets().get(y).getTicketNumber(), y, 6);
			             resTable.setValueAt(script.flightHandler.getTickets().get(y).getAmountPaid(), y, 7);
			             resTable.setValueAt(script.flightHandler.getTickets().get(y).getSeatsBooked(), y, 8);
			             resTable.setValueAt(script.flightHandler.getTickets().get(y).getFlightNumber(), y, 1);
			             System.out.println("Seat price R"+script.flightHandler.getFlights().get(checkIndex(y,script.flightHandler.getFlights())).getSeatPrice());
		            
			           
				
				}
					
					script.reportGUI.table.setValueAt("R"+script.resGUI.getIntSales(), 0, 0);
					script.reportGUI.table.setValueAt("R"+script.resGUI.getLocSales(), 0, 1);
					
					System.out.println("International sales:"+script.resGUI.getIntSales());
				}
				
				}
		);
		addBookBtn.setBounds(86, 212, 121, 23);
		panel.add(addBookBtn);
		
		JLabel lblAddABooking = new JLabel("Add a booking");
		lblAddABooking.setBounds(105, 11, 88, 14);
		panel.add(lblAddABooking);
		
		JLabel lblSelectAFlight = new JLabel("Select a flight number:");
		lblSelectAFlight.setBounds(10, 36, 151, 14);
		panel.add(lblSelectAFlight);
		
		sltFlightComb = new JComboBox();
		sltFlightComb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(int x=0;x<script.flightHandler.getFlights().size();x++){
				if(Integer.parseInt(sltFlightComb.getSelectedItem().toString())==script.flightHandler.getFlights().get(x).getFlightNumber()){
				amnSeatsComb.setModel(getModel(setNumbering(script.flightHandler.getFlights().get(x).getSeatsAvailable(),seatVector)));
				
				}
				
				
			}
		}});
		sltFlightComb.setModel(new DefaultComboBoxModel(new String[] {"None"}));
		sltFlightComb.setBounds(219, 33, 58, 20);
		panel.add(sltFlightComb);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(10, 117, 74, 14);
		panel.add(lblName);
		
		JLabel lblNewLabel = new JLabel("Surname:");
		lblNewLabel.setBounds(10, 162, 116, 14);
		panel.add(lblNewLabel);
		
		nameField = new JTextField();
		nameField.setBounds(191, 114, 86, 20);
		panel.add(nameField);
		nameField.setColumns(10);
		
		JLabel lblAmountOfSeats = new JLabel("Amount of seats to reserve:");
		lblAmountOfSeats.setBounds(10, 76, 183, 14);
		panel.add(lblAmountOfSeats);
		
		amnSeatsComb = new JComboBox();
		amnSeatsComb.setModel(new DefaultComboBoxModel(new Integer[] {0}));
		amnSeatsComb.setBounds(219, 73, 58, 20);
		panel.add(amnSeatsComb);
		
		surnameField = new JTextField();
		surnameField.setBounds(191, 159, 86, 20);
		panel.add(surnameField);
		surnameField.setColumns(10);
		contentPane.setLayout(gl_contentPane);
	}

	public DefaultComboBoxModel getModel(Vector items){
		DefaultComboBoxModel tempModel = new DefaultComboBoxModel(items);
		return tempModel;	
}
	
	public void addToBox(int num,Vector itms){
		if(!itms.contains(num)){
		itms.addElement(num);
		}
	}
	
	public void removeFromBox(int num,Vector itms){
		if(itms.contains(num)){
			itms.removeElement(num);
		}
	}
	
	public void removeFromBox(String num,Vector itms){
		if(itms.contains(num)){
			itms.removeElement(num);
		}
	}
	
	public Vector setNumbering(int num,Vector itms){
		itms.clear();
		for(int x=1;x<=num;x++){
			
			if(!itms.contains(num)){
				itms.add(x);
			}
			
			
		}
		return itms;
	
	}
	
	
	
	public void setPrices(ArrayList<Flight>fObj){
		
		for(int x=0;x<fObj.size();x++){
			if(fObj.get(x).getTypeOfFlight().equals("Local")){
				fObj.get(x).setSeatPrice(500);
			}
			else if(fObj.get(x).getTypeOfFlight().equals("International")){
				fObj.get(x).setSeatPrice(1000);
			}
			
				
		}
		
	}
		
     public void setFocusFlight(int num){
    	 focusFlight=num;
     }
	
     public int getFocusFlight(){
    	 return focusFlight;
     }
	
	public double getPaid(ArrayList<Flight> flight){
		
		return flight.get(getFocusFlight()).getSeatPrice() * Double.parseDouble(amnSeatsComb.getSelectedItem().toString());
	}
	
	public int checkIndex(int num,ArrayList<Flight> flight){
		System.out.println("Number:"+num);
		if(num<flight.size()){
			return num;
		}
		else{
			return 0;
		}
		
	}
	
	public void addToBox(String str,Vector itms){
		if(!itms.contains(str)){
		itms.addElement(str);
		}
	}
	

	public void removeTicket(String i,ArrayList<Ticket> a,ArrayList<Flight> b){
		if(!a.isEmpty()){
			
		if(a.size()>1){	
		for(int x=0;x<a.size();++x){
		if((a.get(x).getPassengerName()+" "+a.get(x).getPassengerSurname()).equals(i)){
			reduceSales((double)a.get(x).getAmountPaid(),a.get(x).getTypeOfBooking());
			for(int y=0;y<b.size();++y){
			if(a.get(x).getFlightNumber()==b.get(y).getFlightNumber()){
				System.out.println("Same number");
				b.get(y).setSeatsAvailable(b.get(y).getSeatsAvailable()+a.get(x).getSeatsBooked());
			}
			}
			a.remove(x);
		}
		}
		}
		else if(a.size()==1){
			a.remove(0);
			
		}
		}
		System.out.println(a.size());
		
		
	}
	public static void clearTable(final JTable table) {
		   for (int i = 0; i < table.getRowCount(); i++)
		      for(int j = 0; j < table.getColumnCount(); j++) {
		          table.setValueAt("", i, j);
		      }
		   }
	
	public double calculateSales(Double price,int seats,String type){
		
		if(type.equals("Local")){
			double income=price * seats;
			loc_Sales=loc_Sales+income;
			return income;
		}
		else{
			double income= price * seats;
			inter_Sales=inter_Sales+income;
			return income;
		}
		
 
		
	}
	
	public void reduceSales(Double price,String type){
		if(type.equals("Local")){
			
			loc_Sales=loc_Sales-price;
			
		}
		else{
			
			inter_Sales=inter_Sales-price;
			
		}
		
	}
	
	 public double getIntSales(){
		  return inter_Sales;
	  }
	public double getLocSales(){
		return loc_Sales;
	}
	
	public int searchForCancelled(ArrayList<Flight> a){
		int temp=0;
		for(int x=0;x<a.size();x++){
			
			if(a.get(x).isCancelled()){
				
				return temp=x;
			}
			
			
			
			
		}
		
		return temp;
	}
}
