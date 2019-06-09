package Gui;

import java.awt.EventQueue;

import javax.swing.JFrame;

import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

/**
 * @author Ahmednasser
 *
 */
public class DashBoard {

	private JFrame frame;
	private JLabel[] labels = new JLabel[31];
	public static JTextField[] totalTrips = new JTextField[31];
	public static JTextField[] Vehicles = new JTextField[31];
	public static JTextField[][] MadBroc = new JTextField[31][3];

	int init = 10;
	int totalIndex = 56;
	public static JTextField txtMinutesPerTrip;
	public static JTextField txtNoDropoffTrips;
	public static JTextField MinGreen;
	public static JTextField MinYellow;
	public static JTextField MinFhv;
	public static JTextField NDFhv;
	public static JTextField NDYellow;
	public static JTextField NDGreen;
	private JTextField txtNycTaxiDashboard;
	private JTextField txtTripsPerDay;
	private JTextField txtVehiclesPerDay;
	private JTextField txtMadisonbrooklenPerDay;

	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DashBoard window = new DashBoard();
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
	public DashBoard() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 1246, 1000);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		panel.setBackground(Color.WHITE);
		panel.setBounds(12, 105, 264, 835);

		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JSeparator separator = new JSeparator();
		separator.setBounds(62, 42, 1, 2);
		panel.add(separator);

		txtTripsPerDay = new JTextField();
		txtTripsPerDay.setFont(new Font("Arial Narrow", Font.BOLD, 18));
		txtTripsPerDay.setEditable(false);
		txtTripsPerDay.setHorizontalAlignment(SwingConstants.CENTER);
		txtTripsPerDay.setText("Trips Per Day");
		txtTripsPerDay.setBounds(12, 13, 240, 29);
		panel.add(txtTripsPerDay);
		txtTripsPerDay.setColumns(10);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(288, 105, 200, 835);
		frame.getContentPane().add(panel_1);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(62, 42, 1, 2);
		panel_1.add(separator_1);

		txtVehiclesPerDay = new JTextField();
		txtVehiclesPerDay.setFont(new Font("Arial Narrow", Font.BOLD, 18));
		txtVehiclesPerDay.setEditable(false);
		txtVehiclesPerDay.setHorizontalAlignment(SwingConstants.CENTER);
		txtVehiclesPerDay.setText("Vehicles Per Day");
		txtVehiclesPerDay.setBounds(12, 15, 176, 29);
		panel_1.add(txtVehiclesPerDay);
		txtVehiclesPerDay.setColumns(10);

		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(500, 105, 287, 835);
		frame.getContentPane().add(panel_2);

		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(62, 42, 1, 2);
		panel_2.add(separator_2);

		txtMadisonbrooklenPerDay = new JTextField();
		txtMadisonbrooklenPerDay.setFont(new Font("Arial Narrow", Font.BOLD, 18));
		txtMadisonbrooklenPerDay.setEditable(false);
		txtMadisonbrooklenPerDay.setHorizontalAlignment(SwingConstants.CENTER);
		txtMadisonbrooklenPerDay.setText("Madison/Brooklen Per Day");
		txtMadisonbrooklenPerDay.setBounds(12, 15, 263, 29);
		panel_2.add(txtMadisonbrooklenPerDay);
		txtMadisonbrooklenPerDay.setColumns(10);

		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		panel_4.setBackground(Color.WHITE);
		panel_4.setBounds(799, 542, 417, 398);
		frame.getContentPane().add(panel_4);
		panel_4.setLayout(null);

		txtNoDropoffTrips = new JTextField();
		txtNoDropoffTrips.setHorizontalAlignment(SwingConstants.CENTER);
		txtNoDropoffTrips.setEditable(false);
		txtNoDropoffTrips.setText("No Drop-off Trips");
		txtNoDropoffTrips.setFont(new Font("Arial Narrow", Font.BOLD, 24));
		txtNoDropoffTrips.setColumns(10);
		txtNoDropoffTrips.setBounds(12, 13, 393, 47);
		panel_4.add(txtNoDropoffTrips);

		NDFhv = new JTextField("0");
		NDFhv.setFont(new Font("Arial Black", Font.BOLD, 20));
		NDFhv.setHorizontalAlignment(SwingConstants.CENTER);
		NDFhv.setEditable(false);
		NDFhv.setColumns(10);
		NDFhv.setBackground(Color.ORANGE);
		NDFhv.setBounds(12, 308, 393, 47);
		panel_4.add(NDFhv);

		NDYellow = new JTextField("0");
		NDYellow.setFont(new Font("Arial Black", Font.BOLD, 20));
		NDYellow.setHorizontalAlignment(SwingConstants.CENTER);
		NDYellow.setEditable(false);
		NDYellow.setColumns(10);
		NDYellow.setBackground(Color.YELLOW);
		NDYellow.setBounds(12, 228, 393, 47);
		panel_4.add(NDYellow);

		NDGreen = new JTextField("0");
		NDGreen.setFont(new Font("Arial Black", Font.BOLD, 20));
		NDGreen.setHorizontalAlignment(SwingConstants.CENTER);
		NDGreen.setEditable(false);
		NDGreen.setColumns(10);
		NDGreen.setBackground(Color.GREEN);
		NDGreen.setBounds(12, 152, 393, 47);
		panel_4.add(NDGreen);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(799, 105, 417, 398);
		frame.getContentPane().add(panel_3);
		panel_3.setLayout(null);

		txtMinutesPerTrip = new JTextField();
		txtMinutesPerTrip.setHorizontalAlignment(SwingConstants.CENTER);
		txtMinutesPerTrip.setEditable(false);
		txtMinutesPerTrip.setFont(new Font("Arial Narrow", Font.BOLD, 24));
		txtMinutesPerTrip.setText("Minutes Per Trip");
		txtMinutesPerTrip.setBounds(12, 13, 393, 47);
		panel_3.add(txtMinutesPerTrip);
		txtMinutesPerTrip.setColumns(10);

		MinGreen = new JTextField("0");
		MinGreen.setFont(new Font("Arial Black", Font.BOLD, 20));
		MinGreen.setHorizontalAlignment(SwingConstants.CENTER);
		MinGreen.setBackground(Color.GREEN);
		MinGreen.setEditable(false);
		MinGreen.setBounds(12, 152, 393, 47);
		panel_3.add(MinGreen);
		MinGreen.setColumns(10);

		MinYellow = new JTextField("0");
		MinYellow.setFont(new Font("Arial Black", Font.BOLD, 20));
		MinYellow.setHorizontalAlignment(SwingConstants.CENTER);
		MinYellow.setEditable(false);
		MinYellow.setBackground(Color.YELLOW);
		MinYellow.setColumns(10);
		MinYellow.setBounds(12, 228, 393, 47);
		panel_3.add(MinYellow);

		MinFhv = new JTextField("0");
		MinFhv.setFont(new Font("Arial Black", Font.BOLD, 20));
		MinFhv.setHorizontalAlignment(SwingConstants.CENTER);
		MinFhv.setEditable(false);
		MinFhv.setBackground(Color.ORANGE);
		MinFhv.setColumns(10);
		MinFhv.setBounds(12, 308, 393, 47);
		panel_3.add(MinFhv);

		txtNycTaxiDashboard = new JTextField();
		txtNycTaxiDashboard.setForeground(new Color(255, 255, 0));
		txtNycTaxiDashboard.setEditable(false);
		txtNycTaxiDashboard.setBackground(Color.BLACK);
		txtNycTaxiDashboard.setFont(new Font("Arial Narrow", Font.BOLD, 40));
		txtNycTaxiDashboard.setText("NYC TAXI DASHBOARD");
		txtNycTaxiDashboard.setHorizontalAlignment(SwingConstants.CENTER);
		txtNycTaxiDashboard.setBounds(12, 13, 1204, 79);
		frame.getContentPane().add(txtNycTaxiDashboard);
		txtNycTaxiDashboard.setColumns(10);

		for (int i = 0; i < 31; i++) {
			labels[i] = new JLabel(String.valueOf(i + 1));
			labels[i].setBounds(10, totalIndex, 65, 20);
			labels[i].setFont(new Font("Arial Black", Font.BOLD, 15));
			panel.add(labels[i]);
			labels[i].setHorizontalAlignment(SwingConstants.CENTER);
			totalTrips[i] = new JTextField("0");
			totalTrips[i].setColumns(10);
			totalTrips[i].setFont(new Font("Arial Black", Font.PLAIN, 12));
			totalTrips[i].setBounds(76, totalIndex, 150, 20);
			totalTrips[i].setEditable(false);
			totalTrips[i].setHorizontalAlignment(SwingConstants.CENTER);
			panel.add(totalTrips[i]);

			Vehicles[i] = new JTextField("0");
			Vehicles[i].setColumns(10);
			Vehicles[i].setFont(new Font("Arial Black", Font.PLAIN, 12));
			Vehicles[i].setEditable(false);
			Vehicles[i].setBounds(25, totalIndex, 150, 20);
			Vehicles[i].setHorizontalAlignment(SwingConstants.CENTER);
			panel_1.add(Vehicles[i]);
			MadBroc[i][0] = new JTextField("0");
			MadBroc[i][0].setEditable(false);
			MadBroc[i][0].setBackground(Color.YELLOW);
			MadBroc[i][0].setFont(new Font("Arial Black", Font.PLAIN, 12));
			MadBroc[i][0].setBounds(10, totalIndex, 81, 22);
			MadBroc[i][0].setHorizontalAlignment(SwingConstants.CENTER);
			panel_2.add(MadBroc[i][0]);
			MadBroc[i][0].setColumns(10);

			MadBroc[i][1] = new JTextField("0");
			MadBroc[i][1].setEditable(false);
			MadBroc[i][1].setFont(new Font("Arial Black", Font.PLAIN, 12));
			MadBroc[i][1].setBackground(Color.GREEN);
			MadBroc[i][1].setColumns(10);
			MadBroc[i][1].setBounds(103, totalIndex, 81, 22);
			MadBroc[i][1].setHorizontalAlignment(SwingConstants.CENTER);
			panel_2.add(MadBroc[i][1]);

			MadBroc[i][2] = new JTextField("0");
			MadBroc[i][2].setEditable(false);
			MadBroc[i][2].setBackground(Color.ORANGE);
			MadBroc[i][2].setFont(new Font("Arial Black", Font.PLAIN, 12));
			MadBroc[i][2].setColumns(10);
			MadBroc[i][2].setBounds(196, totalIndex, 81, 22);
			MadBroc[i][2].setHorizontalAlignment(SwingConstants.CENTER);
			panel_2.add(MadBroc[i][2]);

			totalIndex += 25;

		}

	}
}
