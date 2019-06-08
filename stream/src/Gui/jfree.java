package Gui;

import java.awt.EventQueue;

import javax.swing.JFrame;

import javafx.scene.chart.XYChart;
import javax.swing.JTextField;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import javax.swing.JTable;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.table.DefaultTableModel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.ScrollPane;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;

public class jfree {

	private JFrame frame;
	private JLabel  [] labels  = new JLabel [31];
	public static JTextField  [] totalTrips  = new JTextField [31];
	public static JTextField  [] Vehicles  = new JTextField [31];
	public static JTextField  [][] MadBroc  = new JTextField [31][3];

	int init =10;
	int totalIndex=56;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField txtMinutesPerTrip;
	private JTextField txtNoDropoffTrips;
	private JTextField MinGreen;
	private JTextField MinYellow;
	private JTextField MinFhv;
	private JTextField NDFhv;
	private JTextField NDYellow;
	private JTextField NDGreen;
	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					jfree window = new jfree();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public jfree() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1246, 1000);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel.setBackground(Color.GREEN);
		panel.setBounds(12, 13, 264, 835);
	
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("               Trips Per Day");
		lblNewLabel.setFont(new Font("Jokerman", Font.BOLD, 15));
		lblNewLabel.setBounds(0, 0, 264, 29);
		panel.add(lblNewLabel);
	
		
		JSeparator separator = new JSeparator();
		separator.setBounds(62, 42, 1, 2);
		panel.add(separator);
		

		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel_1.setBackground(Color.GREEN);
		panel_1.setBounds(288, 13, 200, 835);
		frame.getContentPane().add(panel_1);
		
		JLabel lblTripsPerDay = new JLabel("      Vehicles Per Day");
		lblTripsPerDay.setFont(new Font("Jokerman", Font.BOLD, 15));
		lblTripsPerDay.setBounds(0, 0, 200, 29);
		panel_1.add(lblTripsPerDay);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(62, 42, 1, 2);
		panel_1.add(separator_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel_2.setBackground(Color.GREEN);
		panel_2.setBounds(500, 13, 287, 835);
		frame.getContentPane().add(panel_2);
		
		JLabel lblMadisonbrooklenPerDay = new JLabel("      Madison/Brooklen Per Day  ");
		lblMadisonbrooklenPerDay.setBackground(Color.WHITE);
		lblMadisonbrooklenPerDay.setFont(new Font("Jokerman", Font.BOLD, 15));
		lblMadisonbrooklenPerDay.setBounds(0, 0, 281, 29);
		panel_2.add(lblMadisonbrooklenPerDay);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(62, 42, 1, 2);
		panel_2.add(separator_2);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.BLUE);
		panel_4.setBounds(799, 450, 417, 398);
		frame.getContentPane().add(panel_4);
		panel_4.setLayout(null);
		
		txtNoDropoffTrips = new JTextField();
		txtNoDropoffTrips.setEditable(false);
		txtNoDropoffTrips.setText("                         No Drop-off Trips");
		txtNoDropoffTrips.setFont(new Font("Jokerman", Font.BOLD, 17));
		txtNoDropoffTrips.setColumns(10);
		txtNoDropoffTrips.setBounds(12, 13, 393, 47);
		panel_4.add(txtNoDropoffTrips);
		
		NDFhv = new JTextField();
		NDFhv.setEditable(false);
		NDFhv.setColumns(10);
		NDFhv.setBackground(Color.ORANGE);
		NDFhv.setBounds(12, 308, 393, 47);
		panel_4.add(NDFhv);
		
		NDYellow = new JTextField();
		NDYellow.setEditable(false);
		NDYellow.setColumns(10);
		NDYellow.setBackground(Color.YELLOW);
		NDYellow.setBounds(12, 228, 393, 47);
		panel_4.add(NDYellow);
		
		NDGreen = new JTextField();
		NDGreen.setEditable(false);
		NDGreen.setColumns(10);
		NDGreen.setBackground(Color.GREEN);
		NDGreen.setBounds(12, 152, 393, 47);
		panel_4.add(NDGreen);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.BLUE);
		panel_3.setBounds(799, 13, 417, 398);
		frame.getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		txtMinutesPerTrip = new JTextField();
		txtMinutesPerTrip.setEditable(false);
		txtMinutesPerTrip.setFont(new Font("Jokerman", Font.BOLD, 17));
		txtMinutesPerTrip.setText("                         Minutes Per Trip");
		txtMinutesPerTrip.setBounds(12, 13, 393, 47);
		panel_3.add(txtMinutesPerTrip);
		txtMinutesPerTrip.setColumns(10);
		
		MinGreen = new JTextField();
		MinGreen.setBackground(Color.GREEN);
		MinGreen.setEditable(false);
		MinGreen.setBounds(12, 152, 393, 47);
		panel_3.add(MinGreen);
		MinGreen.setColumns(10);
		
		MinYellow = new JTextField();
		MinYellow.setEditable(false);
		MinYellow.setBackground(Color.YELLOW);
		MinYellow.setColumns(10);
		MinYellow.setBounds(12, 228, 393, 47);
		panel_3.add(MinYellow);
		
		MinFhv = new JTextField();
		MinFhv.setEditable(false);
		MinFhv.setBackground(Color.ORANGE);
		MinFhv.setColumns(10);
		MinFhv.setBounds(12, 308, 393, 47);
		panel_3.add(MinFhv);
		
		

		
		
		for(int i=0;i<31;i++){
			labels[i]= new JLabel(String.valueOf(i+1));
			labels[i].setBounds(10, totalIndex, 65, 20);
			panel.add(labels[i]);
			totalTrips[i] = new JTextField("0");
			totalTrips[i].setColumns(10);
			totalTrips[i].setBounds(76, totalIndex, 150, 20);
			totalTrips[i].setEditable(false);
			panel.add(totalTrips[i]);
			
			Vehicles[i] = new JTextField("0");
			Vehicles[i].setColumns(10);
			Vehicles[i].setEditable(false);
			Vehicles[i].setBounds(25, totalIndex, 150, 20);
			panel_1.add(Vehicles[i]);
			MadBroc[i][0] = new JTextField("0");
			MadBroc[i][0].setEditable(false);
			MadBroc[i][0].setBackground(Color.YELLOW);
			MadBroc[i][0].setBounds(10, totalIndex, 81, 22);
			panel_2.add(MadBroc[i][0]);
			MadBroc[i][0].setColumns(10);
			
			MadBroc[i][1] = new JTextField("0");
			MadBroc[i][1].setEditable(false);
			MadBroc[i][1].setBackground(Color.GREEN);
			MadBroc[i][1].setColumns(10);
			MadBroc[i][1].setBounds(103, totalIndex, 81, 22);
			panel_2.add(MadBroc[i][1]);
			
			MadBroc[i][2] = new JTextField("0");
			MadBroc[i][2].setEditable(false);	
			MadBroc[i][2].setBackground(Color.ORANGE);
			MadBroc[i][2].setColumns(10);
			MadBroc[i][2].setBounds(196, totalIndex, 81, 22);
			panel_2.add(MadBroc[i][2]);
			
			totalIndex+=25;

		}

	}
}
