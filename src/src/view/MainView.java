package src.view;

import javax.swing.JFrame;
import java.awt.Component;
import javax.swing.BoxLayout;
import javax.swing.ComboBoxModel;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import java.awt.Font;
import java.util.Vector;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;

public class MainView extends JFrame {

	Vector<Integer> stokTipiArray = new Vector<>() {
		{
			add(1);
			add(2);
			add(3);
			add(4);
			add(5);
			add(6);

		}
	};
	Vector<String> birimArray = new Vector<>() {
		{
			add("1");
			add("2");
			add("3");
			add("4");
			add("5");
			add("6");

		}
	};

	Vector<Double> kdvTipi = new Vector<>() {
		{
			add(1.2);
			add(2.3);
			add(4.5);
			add(3.15);
			add(6.7);
			
		}
	};

	public JTable stokKartTable = new JTable();
	public DefaultTableModel model = new DefaultTableModel();
	public JButton deleteButton = new JButton("Delete");
	public JButton saveButton = new JButton("Save");
	public JButton updateButton = new JButton("Update");
	public JButton copyButton = new JButton("Copy");
	public JTextField stokKoduField = new JTextField();
	public JTextField stokAdiField = new JTextField();
	public JTextField barkodField = new JTextField();
	public final JScrollPane scrollPane = new JScrollPane();
	public JComboBox stokTipiField = new JComboBox(stokTipiArray);;
	public JComboBox birimField = new JComboBox(birimArray);
	public JComboBox kdvTipiField = new JComboBox(kdvTipi);
	public JTextArea aciklamaField = new JTextArea();
	public JDateChooser olusTarihField = new JDateChooser();
	public JTextField searchBar = new JTextField();

	/**
	 * Create the application.
	 */
	public MainView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		this.setBounds(100, 100, 1920, 1080);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);

		this.getContentPane().setLayout(null);
		scrollPane.setAlignmentY(Component.TOP_ALIGNMENT);
		scrollPane.setAlignmentX(Component.LEFT_ALIGNMENT);
		scrollPane.setBounds(10, 56, 940, 568);
		stokKartTable.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Stok Kodu", "Stok Adı",
				"Stok Tipi", "Birimi", "Barkodu", "KDV Tipi", "Açıklama", "Oluşturma Tarihi" }));
		scrollPane.add(stokKartTable);
		getContentPane().add(scrollPane);
		stokKartTable.setLayout(new BoxLayout(stokKartTable, BoxLayout.X_AXIS));

		scrollPane.setViewportView(stokKartTable);

		stokKartTable.getColumnModel().getColumn(0).setPreferredWidth(71);
		stokKartTable.getColumnModel().getColumn(1).setPreferredWidth(71);
		stokKartTable.getColumnModel().getColumn(2).setPreferredWidth(71);
		stokKartTable.getColumnModel().getColumn(3).setPreferredWidth(71);
		stokKartTable.getColumnModel().getColumn(4).setPreferredWidth(71);
		stokKartTable.getColumnModel().getColumn(5).setPreferredWidth(71);
		stokKartTable.getColumnModel().getColumn(6).setPreferredWidth(71);
		stokKartTable.getColumnModel().getColumn(7).setPreferredWidth(71);

		JPanel dataPanel = new JPanel();
		dataPanel.setBounds(960, 29, 570, 289);
		getContentPane().add(dataPanel);
		dataPanel.setLayout(null);

		stokKoduField = new JTextField();
		stokKoduField.setBounds(100, 30, 120, 25);
		dataPanel.add(stokKoduField);
		stokKoduField.setColumns(10);

		stokAdiField = new JTextField();
		stokAdiField.setBounds(100, 70, 120, 25);
		dataPanel.add(stokAdiField);
		stokAdiField.setColumns(10);

		barkodField = new JTextField();
		barkodField.setBounds(100, 110, 120, 25);
		dataPanel.add(barkodField);
		barkodField.setColumns(10);

		stokTipiField.setBounds(400, 30, 120, 25);
		dataPanel.add(stokTipiField);

		birimField.setBounds(400, 90, 120, 25);
		dataPanel.add(birimField);

		kdvTipiField.setBounds(400, 150, 120, 25);
		dataPanel.add(kdvTipiField);

		aciklamaField.setBounds(73, 190, 447, 81);
		dataPanel.add(aciklamaField);

//		JFormattedTextField olusTarihField = new JFormattedTextField();
//		olusTarihField.setBounds(100, 150, 120, 25);
//		dataPanel.add(olusTarihField);

		olusTarihField.setDateFormatString("yyyy-MM-dd ");
		olusTarihField.setBounds(100, 150, 120, 25);
		dataPanel.add(olusTarihField);

		JLabel lblNewLabel = new JLabel("Stok Kodu");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(5, 30, 70, 25);
		dataPanel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Stok Adı");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(5, 70, 70, 25);
		dataPanel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Barkodu");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(5, 110, 70, 25);
		dataPanel.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Olş Tarih");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(5, 150, 70, 25);
		dataPanel.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Stok Tipi");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(305, 30, 120, 25);
		dataPanel.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Birimi");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(305, 90, 120, 25);
		dataPanel.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("KDV Tipi");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_6.setBounds(305, 150, 120, 25);
		dataPanel.add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel("Açıklama");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_7.setBounds(5, 190, 58, 81);
		dataPanel.add(lblNewLabel_7);

		deleteButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		deleteButton.setBounds(1061, 346, 100, 50);
		this.getContentPane().add(deleteButton);

		saveButton.setBounds(961, 346, 100, 50);
		this.getContentPane().add(saveButton);
		saveButton.setFont(new Font("Tahoma", Font.PLAIN, 20));

		updateButton.setBounds(1161, 346, 100, 50);
		this.getContentPane().add(updateButton);
		updateButton.setFont(new Font("Tahoma", Font.PLAIN, 20));

		copyButton.setBounds(1261, 346, 100, 50);
		this.getContentPane().add(copyButton);
		copyButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		searchBar.setBounds(10, 27, 120, 25);
		getContentPane().add(searchBar);
		searchBar.setColumns(10);
	}
}
