package airline_reservation_system;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.CardLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import net.miginfocom.swing.MigLayout;

public class ManageFlight extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JTextField dateField;
	private JComboBox typeFlightComb;
	private JComboBox arvCityComb;
	private Vector comboItems;
	JComboBox depCityComb;
	JComboBox delSltFlightComb;
	private JTable currTable;
	JComboBox cnlFlightBookComb;
	int counter=1;
	public ManageFlight(GuiInvoker script) {
		
		setTitle("Manage Flights");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 768, 536);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		
		comboItems=new Vector();
		
		JButton backBtn = new JButton("BACK");
		backBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				script.manageFlight.setVisible(false);
				script.mainGUI.setVisible(true);
			}
		});
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		
		JButton btnSortByDate = new JButton("Sort by date");
		btnSortByDate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Collections.sort(script.flightHandler.getFlights(), new Comparator<Flight>() {
					  public int compare(Flight f1, Flight f2) {
					      if (f1.getFlightDate() == null || f2.getFlightDate() == null)
					        return 0;
					      return f1.getFlightDate().compareTo(f2.getFlightDate());
					  }
					});
				
				
				
				SimpleDateFormat sf= new SimpleDateFormat("MM/dd/yyyy");
				
          for(int x=0;x<script.flightHandler.getFlights().size();x++){
     
					
					currTable.setValueAt(script.flightHandler.getFlights().get(x).getFlightNumber(),x, 0);
					currTable.setValueAt(sf.format(script.flightHandler.getFlights().get(x).getFlightDate()), x, 1);
					currTable.setValueAt(script.flightHandler.getFlights().get(x).getDepartCity(), x, 2);
				    currTable.setValueAt(script.flightHandler.getFlights().get(x).getArriveCity(), x, 3);
				    currTable.setValueAt(script.flightHandler.getFlights().get(x).getSeatsAvailable(), x, 4);
				    currTable.setValueAt(getCancel(script.flightHandler.getFlights().get(x).isCancelled()),x, 5);
				   	
			}
          
          JOptionPane.showMessageDialog(null,"Flights sorted in ascending order.");
		}});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 341, GroupLayout.PREFERRED_SIZE)
					.addGap(71)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel_3, GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
						.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE))
					.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(54)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 630, Short.MAX_VALUE)
					.addGap(58))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(251, Short.MAX_VALUE)
					.addComponent(backBtn, GroupLayout.PREFERRED_SIZE, 272, GroupLayout.PREFERRED_SIZE)
					.addGap(219))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(331, Short.MAX_VALUE)
					.addComponent(btnSortByDate)
					.addGap(318))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(4)
							.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
							.addGap(7)
							.addComponent(panel_3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 241, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnSortByDate)
					.addGap(1)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(backBtn)
					.addGap(21))
		);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel lblCurrentFlights_2 = new JLabel("Current Flights:");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 626, Short.MAX_VALUE)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(279, Short.MAX_VALUE)
					.addComponent(lblCurrentFlights_2, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
					.addGap(245))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(lblCurrentFlights_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE))
		);
		
		currTable = new JTable();
		currTable.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"Flight Number", "Flight Date", "Departure City", "Arrival City", "Available Seats", "Availability"
			}
		));
		currTable.getColumnModel().getColumn(0).setPreferredWidth(92);
		currTable.getColumnModel().getColumn(2).setPreferredWidth(95);
		currTable.getColumnModel().getColumn(3).setPreferredWidth(82);
		currTable.getColumnModel().getColumn(4).setPreferredWidth(87);
		scrollPane.setViewportView(currTable);
		panel.setLayout(gl_panel);
		panel_3.setLayout(null);
		
		JLabel lblCancellingAFlight = new JLabel("Cancelling a Flight");
		lblCancellingAFlight.setBounds(100, 14, 141, 14);
		panel_3.add(lblCancellingAFlight);
		
		cnlFlightBookComb = new JComboBox();
		cnlFlightBookComb.setModel(new DefaultComboBoxModel(new String[] {"None"}));
		cnlFlightBookComb.setBounds(212, 39, 60, 20);
		panel_3.add(cnlFlightBookComb);
		
		JLabel lblCurrentFlights_1 = new JLabel("Select a flight number:");
		lblCurrentFlights_1.setBounds(24, 42, 164, 14);
		panel_3.add(lblCurrentFlights_1);
		
		JButton cancelFlightBtn = new JButton("Cancel Flight");
		cancelFlightBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"Successfully cancelled flight:"+cnlFlightBookComb.getSelectedItem().toString());
				cancelFlight(Integer.parseInt(cnlFlightBookComb.getSelectedItem().toString()),script.flightHandler.getFlights());
				SimpleDateFormat sf= new SimpleDateFormat("MM/dd/yyyy");
				
				
				for(int x=0;x<script.flightHandler.getFlights().size();x++){
					
					currTable.setValueAt(script.flightHandler.getFlights().get(x).getFlightNumber(),x, 0);
					currTable.setValueAt(sf.format(script.flightHandler.getFlights().get(x).getFlightDate()), x, 1);
					currTable.setValueAt(script.flightHandler.getFlights().get(x).getDepartCity(), x, 2);
				    currTable.setValueAt(script.flightHandler.getFlights().get(x).getArriveCity(), x, 3);
				    currTable.setValueAt(script.flightHandler.getFlights().get(x).getSeatsAvailable(), x, 4);
				    currTable.setValueAt(getCancel(script.flightHandler.getFlights().get(x).isCancelled()),x, 5);
				    addToBox(script.flightHandler.getFlights().get(x).getFlightNumber());
				    delSltFlightComb.setModel(getModel(comboItems));
				    cnlFlightBookComb.setModel(getModel(comboItems));
				    script.resGUI.sltFlightComb.setModel(getModel(comboItems));
				    script.resGUI.cSltFlightComb.setModel(getModel(comboItems));
				}
				
			}
		});
		cancelFlightBtn.setBounds(89, 80, 128, 23);
		panel_3.add(cancelFlightBtn);
		panel_2.setLayout(null);
		
		JLabel lblDeletingAFlight = new JLabel("Deleting a flight");
		lblDeletingAFlight.setBounds(101, 11, 145, 14);
		panel_2.add(lblDeletingAFlight);
		
		delSltFlightComb = new JComboBox();
		delSltFlightComb.setModel(new DefaultComboBoxModel(new String[] {"None"}));
		delSltFlightComb.setBounds(209, 39, 63, 20);
		panel_2.add(delSltFlightComb);
		
		JLabel lblCurrentFlights = new JLabel("Select a flight number:");
		lblCurrentFlights.setBounds(28, 42, 150, 14);
		panel_2.add(lblCurrentFlights);
		
		JButton deleteFlightBtn = new JButton("Delete Flight");
		deleteFlightBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SimpleDateFormat sf= new SimpleDateFormat("MM/dd/yyyy");
				removeFlight(Integer.parseInt(delSltFlightComb.getSelectedItem().toString()),script.flightHandler.getFlights());
				removeFromBox(Integer.parseInt(delSltFlightComb.getSelectedItem().toString()));	
				
				clearTable(currTable);
				
				
				
				 for(int x=0;x<script.flightHandler.getFlights().size();x++){
					 
					 currTable.setValueAt(script.flightHandler.getFlights().get(x).getFlightNumber(),x, 0);
						currTable.setValueAt(sf.format(script.flightHandler.getFlights().get(x).getFlightDate()), x, 1);
						currTable.setValueAt(script.flightHandler.getFlights().get(x).getDepartCity(), x, 2);
					    currTable.setValueAt(script.flightHandler.getFlights().get(x).getArriveCity(), x, 3);
					    currTable.setValueAt(script.flightHandler.getFlights().get(x).getSeatsAvailable(), x, 4);
					    currTable.setValueAt(getCancel(script.flightHandler.getFlights().get(x).isCancelled()),x, 5);
					    addToBox(script.flightHandler.getFlights().get(x).getFlightNumber());
					    delSltFlightComb.setModel(getModel(comboItems));
					    cnlFlightBookComb.setModel(getModel(comboItems));
					    script.resGUI.sltFlightComb.setModel(getModel(comboItems));
					    script.resGUI.cSltFlightComb.setModel(getModel(comboItems));
				 }
				
				if(script.flightHandler.getFlights().isEmpty()){
					addToBox("None");
					delSltFlightComb.setModel(getModel(comboItems));
					cnlFlightBookComb.setModel(getModel(comboItems));
					script.resGUI.sltFlightComb.setModel(getModel(comboItems));
					script.resGUI.cSltFlightComb.setModel(getModel(comboItems));
				}
				   
				
			}
		});
		deleteFlightBtn.setBounds(104, 82, 114, 23);
		panel_2.add(deleteFlightBtn);
		panel_1.setLayout(null);
		
		JLabel addFlight = new JLabel("Adding a Flight");
		addFlight.setBounds(127, 11, 109, 14);
		panel_1.add(addFlight);
		
		JButton addFlightBtn = new JButton("Add Flight");
		addFlightBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Date date=null;
				
				 SimpleDateFormat sdf= new SimpleDateFormat("MM/dd/yyyy");
				 
				 try {
					if(!dateField.getText().equals("")){
					date=sdf.parse(dateField.getText());
						
					}
					else{
						JOptionPane.showMessageDialog(null,"Invalid Date entered,remember to enter the date in a mm/dd/yyyy format...");
					}
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if(dateField.getText().length()!=10||dateField.getText().contains(".")||!dateField.getText().contains("/")){
					JOptionPane.showMessageDialog(null,"Invalid Date,remember to enter mm/dd/yyyy format...");
				}
				else if(script.flightHandler.getFlights().add(new Flight(date,depCityComb.getSelectedItem().toString(),arvCityComb.getSelectedItem().toString(),100,counter++,typeFlightComb.getSelectedItem().toString()))){
					SimpleDateFormat sf= new SimpleDateFormat("MM/dd/yyyy");
					JOptionPane.showMessageDialog(null, "Successfully created flight.");
					
					for(int x=0;x<script.flightHandler.getFlights().size();x++){
						
						currTable.setValueAt(script.flightHandler.getFlights().get(x).getFlightNumber(),x, 0);
						currTable.setValueAt(sf.format(script.flightHandler.getFlights().get(x).getFlightDate()), x, 1);
						currTable.setValueAt(script.flightHandler.getFlights().get(x).getDepartCity(), x, 2);
					    currTable.setValueAt(script.flightHandler.getFlights().get(x).getArriveCity(), x, 3);
					    currTable.setValueAt(script.flightHandler.getFlights().get(x).getSeatsAvailable(), x, 4);
					    currTable.setValueAt(getCancel(script.flightHandler.getFlights().get(x).isCancelled()),x, 5);
					    addToBox(script.flightHandler.getFlights().get(x).getFlightNumber());
					    delSltFlightComb.setModel(getModel(comboItems));
					    cnlFlightBookComb.setModel(getModel(comboItems));
					    script.resGUI.sltFlightComb.setModel(getModel(comboItems));
					    script.resGUI.cSltFlightComb.setModel(getModel(comboItems));
					    script.resGUI.vSltFlightCombo.setModel(getModel(comboItems));
					}
				}
				else{
					JOptionPane.showMessageDialog(null,"Invalid details,unable to create flight");
				}
				
				System.out.println(script.flightHandler.getFlights().get(0).toString());
				
			}
		});
		addFlightBtn.setBounds(126, 214, 89, 23);
		panel_1.add(addFlightBtn);
		
		JLabel lblDateddmmyyy = new JLabel("Date  (dd/mm/yyyy) :");
		lblDateddmmyyy.setBounds(30, 54, 159, 14);
		panel_1.add(lblDateddmmyyy);
		
		dateField = new JTextField();
		dateField.setBounds(222, 51, 112, 20);
		panel_1.add(dateField);
		dateField.setColumns(10);
		
		JLabel lblDepartCity = new JLabel("Depart City:");
		lblDepartCity.setBounds(30, 138, 89, 14);
		panel_1.add(lblDepartCity);
		
		depCityComb = new JComboBox();
		depCityComb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(typeFlightComb.getSelectedItem().equals("International")){
					arvCityComb.setModel(new DefaultComboBoxModel(new String[]{"Sydney","London","New York","Paris","Amsterdam"}));
				}
				else{
					
					if(depCityComb.getSelectedItem().equals("Cape Town")){
						arvCityComb.setModel(new DefaultComboBoxModel(new String[]{"Johannesburg","Durban","Port Elizabeth","George"}));
					}
					else if(depCityComb.getSelectedItem().equals("Johannesburg")){
						arvCityComb.setModel(new DefaultComboBoxModel(new String[]{"Cape Town","Durban","Port Elizabeth","George"}));
					}
					else if(depCityComb.getSelectedItem().equals("Durban")){
						arvCityComb.setModel(new DefaultComboBoxModel(new String[]{"Cape Town","Johannesburg","Port Elizabeth","George"}));
					}
					else if(depCityComb.getSelectedItem().equals("Port Elizabeth")){
						arvCityComb.setModel(new DefaultComboBoxModel(new String[]{"Cape Town","Johannesburg","Durban","George"}));
					}
					else{
						arvCityComb.setModel(new DefaultComboBoxModel(new String[]{"Cape Town","Johannesburg","Durban","Port Elizabeth"}));
					}
				}
				
					
				}
				
			}
		);
		depCityComb.setModel(new DefaultComboBoxModel(new String[]{"Cape Town","Johannesburg"}));
		depCityComb.setBounds(222, 135, 108, 20);
		panel_1.add(depCityComb);
		
		JLabel lblTypeOfFlight = new JLabel("Type of Flight:");
		lblTypeOfFlight.setBounds(30, 97, 89, 14);
		panel_1.add(lblTypeOfFlight);
		
		typeFlightComb = new JComboBox();
		final DefaultComboBoxModel int_Depart = new DefaultComboBoxModel(new String[]{"a", "b", "c"});
		String[] loc_Depart={"Cape Town","Johannesburg","Durban","Port-Elizabeth","George"};
		
		typeFlightComb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(typeFlightComb.getSelectedItem().equals("International")){
					depCityComb.setModel(new DefaultComboBoxModel(new String[]{"Cape Town","Johannesburg"}));
					arvCityComb.setModel(new DefaultComboBoxModel(new String[]{"Sydney","London","New York","Paris","Amsterdam"}));
				}
				else{
					depCityComb.setModel(new DefaultComboBoxModel(new String[]{"Cape Town","Johannesburg","Durban","Port-Elizabeth","George"}));
					arvCityComb.setModel(new DefaultComboBoxModel(new String[]{"Johannesburg","Durban","Port Elizabeth","George"}));
				}
			}
		});
		typeFlightComb.setModel(new DefaultComboBoxModel(new String[] {"International", "Local"}));
		typeFlightComb.setBounds(221, 94, 109, 20);
		panel_1.add(typeFlightComb);
		
		JLabel lblArrivalCity = new JLabel("Arrival City:");
		lblArrivalCity.setBounds(30, 185, 76, 14);
		panel_1.add(lblArrivalCity);
		
		arvCityComb = new JComboBox();
		arvCityComb.setModel(new DefaultComboBoxModel(new String[]{"Sydney","London","New York","Paris","Amsterdam"}));
		arvCityComb.setBounds(222, 182, 108, 20);
		panel_1.add(arvCityComb);
		contentPane.setLayout(gl_contentPane);
		
		
		
		
//JButton delFlightBtn = new JButton("Delete a Flight");
		
	//	JButton cancFlightBtn = new JButton("Cancel a Flight");
		
	//	JLabel label = new JLabel("ADD A FLIGHT");
		
	//	JPanel panel = new JPanel();
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				script.manageFlight.setVisible(false);
				script.mainGUI.setVisible(true);
			}
		});
		
	}
	
	public void addToBox(int num){
		if(!comboItems.contains(num)){
		comboItems.addElement(num);
		}
	}
	
	public void removeFromBox(int num){
		if(comboItems.contains(num)){
			comboItems.removeElement(num);
		}
	}
	
	public void addToBox(String str){
		if(!comboItems.contains(str)){
		comboItems.addElement(str);
		}
	}
	
	public DefaultComboBoxModel getModel(Vector items){
		DefaultComboBoxModel tempModel = new DefaultComboBoxModel(items);
		return tempModel;	
}
	public void removeFlight(int i,ArrayList<Flight> a){
		if(!a.isEmpty()){
			
		if(a.size()>1){	
		for(int x=0;x<a.size();++x){
		if(a.get(x).getFlightNumber()==i){
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
	
	public void cancelFlight(int flightNr,ArrayList<Flight> script){
		if(!script.isEmpty()){
			
			if(script.size()>1){	
			for(int x=0;x<script.size();++x){
			if(script.get(x).getFlightNumber()==flightNr){
				script.get(x).setCancelled(true);
			}
			}
			}
			else if(script.size()==1){
				script.get(0).setCancelled(true);;
				
			}
		
		}
		
	}
	
	public String getCancel(boolean a){
		if(a){
			return "Cancelled";
		}
		else{
			return "Available";
		}
	}
	
	public void updateTable(GuiInvoker script){
		
		SimpleDateFormat sf= new SimpleDateFormat("MM/dd/yyyy");
		JOptionPane.showMessageDialog(null, "Successfully created flight.");
		
		for(int x=0;x<script.flightHandler.getFlights().size();x++){
			
			currTable.setValueAt(script.flightHandler.getFlights().get(x).getFlightNumber(),x, 0);
			currTable.setValueAt(sf.format(script.flightHandler.getFlights().get(x).getFlightDate()), x, 1);
			currTable.setValueAt(script.flightHandler.getFlights().get(x).getDepartCity(), x, 2);
		    currTable.setValueAt(script.flightHandler.getFlights().get(x).getArriveCity(), x, 3);
		    currTable.setValueAt(script.flightHandler.getFlights().get(x).getSeatsAvailable(), x, 4);
		    currTable.setValueAt(getCancel(script.flightHandler.getFlights().get(x).isCancelled()),x, 5);
		    addToBox(script.flightHandler.getFlights().get(x).getFlightNumber());
		    delSltFlightComb.setModel(getModel(comboItems));
		    cnlFlightBookComb.setModel(getModel(comboItems));
		    script.resGUI.sltFlightComb.setModel(getModel(comboItems));
		    script.resGUI.cSltFlightComb.setModel(getModel(comboItems));
		}
		
	}
		



 







}

    
