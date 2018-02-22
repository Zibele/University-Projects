package airline_reservation_system;

import javax.swing.JFrame;

public class GuiInvoker {

	int scene=0;
	GUI mainGUI;
	ReportGui reportGUI;
	ManageResGUI resGUI;
	FlightHandler flightHandler;
	ManageFlight manageFlight;
	GroupMembersGUI groupMembers;
	
	GuiInvoker(){
		mainGUI=new GUI(this);
		manageFlight=new ManageFlight(this);
		reportGUI=new ReportGui(this);
		resGUI=new ManageResGUI(this);
		flightHandler=new FlightHandler();
		groupMembers=new GroupMembersGUI(this);
	}
	
	
	
	public void setScene(int scn){
		scene=scn;
	}
	
	public int getScene(){
		return scene;
	}
	
	public void displayScene(){
		
		switch(getScene()){
		case 0:
			System.out.println("About to display scene one");
			mainGUI.setVisible(true);
			break;
		}
		
	}
	
	public void hideScene(JFrame a){
		a.setVisible(false);
	}
	
	
}
