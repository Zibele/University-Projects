package airline_reservation_system;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GroupMembersGUI extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public GroupMembersGUI(GuiInvoker script) {
		setTitle("Group Members");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				script.groupMembers.setVisible(false);
				script.mainGUI.setVisible((true));
			}
		});
		btnNewButton.setBounds(52, 209, 331, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblGroupMembers = new JLabel("Group Members:");
		lblGroupMembers.setBounds(168, 11, 117, 14);
		contentPane.add(lblGroupMembers);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.setBounds(10, 36, 414, 162);
		contentPane.add(panel);
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(26)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(27, Short.MAX_VALUE))
		);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"216133432", "Zibele", "Nqunqa", "2B"},
				{"216194350", "Thando", "Mzwakali", "2A"},
			},
			new String[] {
				"Student Number", "Name", "Surname", "Group"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(135);
		table.getColumnModel().getColumn(1).setPreferredWidth(126);
		table.getColumnModel().getColumn(2).setPreferredWidth(125);
		table.getColumnModel().getColumn(3).setPreferredWidth(114);
		scrollPane.setViewportView(table);
		panel.setLayout(gl_panel);
	}
}
