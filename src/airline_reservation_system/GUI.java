package airline_reservation_system;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JLabel;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.LineBorder;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class GUI extends JFrame implements MouseListener {

	private JPanel contentPane;
    private JButton editFlightButton;
    private JButton deleteFlightButton;
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
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
	public GUI(GuiInvoker script) {
		//Listeners
		addMouseListener(this);
		//
		setTitle("Airline Reservation System");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setBounds(100, 100, 419, 247);
	    //
	    
	    
		contentPane = new JPanel();
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		
		JButton addBtn = new JButton("Manage Flights");
		addBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				script.mainGUI.setVisible(false);
				script.manageFlight.setVisible(true);
			}
		});
		
		JLabel welcome = new JLabel("Chase a Cheque Airways");
		
		JButton manageBtn = new JButton("Manage Reservations");
		manageBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				script.mainGUI.setVisible(false);
				script.resGUI.setVisible(true);
			}
		});
		
		JButton btnViewFinancialReport = new JButton("View Report");
		btnViewFinancialReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				script.mainGUI.setVisible(false);
				script.reportGUI.setVisible(true);
			}
		});
		
		JButton btnViewGroupMembers = new JButton("View Group Members");
		btnViewGroupMembers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				script.mainGUI.setVisible(false);
				script.groupMembers.setVisible(true);
			}
		});
		
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(138)
					.addComponent(welcome)
					.addContainerGap(135, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addGap(130)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnViewGroupMembers, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
						.addComponent(addBtn, GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
						.addComponent(btnViewFinancialReport, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
						.addComponent(manageBtn, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(126))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(welcome)
					.addGap(18)
					.addComponent(addBtn)
					.addGap(11)
					.addComponent(manageBtn)
					.addGap(18)
					.addComponent(btnViewFinancialReport)
					.addGap(18)
					.addComponent(btnViewGroupMembers)
					.addContainerGap(27, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		//
		
	
	}

	

	@Override
	public void mouseClicked(MouseEvent e) {
		Point p= e.getPoint();
		int x = (int)p.getX();
		int y= (int)p.getY();
		
		System.out.println("Clicked coordinate -("+x+","+y+")");
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
