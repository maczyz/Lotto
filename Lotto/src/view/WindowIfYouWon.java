package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

import model.LottoWindowIfYouWonHelper;

public class WindowIfYouWon
{

	private JFrame frame;
	private JTextField textFieldLiczba1;
	private JTextField textFieldLiczba2;
	private JTextField textFieldLiczba3;
	private JTextField textFieldLiczba4;
	private JTextField textFieldLiczba5;
	private JTextField textFieldLiczba6;
	private JLabel lblLiczba;
	private JLabel lblLiczba_1;
	private JLabel lblLiczba_2;
	private JLabel lblLiczba_3;
	private JLabel lblLiczba_4;
	private JLabel lblWynik1;
	private JLabel lblWynik2;
	private JLabel lblWynik3;
	private JLabel lblWynik4;
	private JLabel lblWynik5;
	private JLabel lblWynik6;
	
	private Map<Integer, Integer> wygrane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			@Override
			public void run()
			{
				try
				{
					WindowIfYouWon window = new WindowIfYouWon();
					window.frame.setVisible(true);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public WindowIfYouWon()
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		frame = new JFrame();
		frame.setBounds(100, 100, 578, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblWprowadzLiczby = new JLabel(
				"Wprowadz 6 liczb by sprawdzic czy trafiles na podstawie dotychczasowych losowan:");
		lblWprowadzLiczby.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblWprowadzLiczby.setBounds(12, 27, 674, 30);
		frame.getContentPane().add(lblWprowadzLiczby);

		textFieldLiczba1 = new JTextField();
		textFieldLiczba1.setBounds(91, 82, 42, 22);
		frame.getContentPane().add(textFieldLiczba1);
		textFieldLiczba1.setColumns(10);

		textFieldLiczba2 = new JTextField();
		textFieldLiczba2.setColumns(10);
		textFieldLiczba2.setBounds(157, 82, 42, 22);
		frame.getContentPane().add(textFieldLiczba2);

		textFieldLiczba3 = new JTextField();
		textFieldLiczba3.setColumns(10);
		textFieldLiczba3.setBounds(221, 82, 42, 22);
		frame.getContentPane().add(textFieldLiczba3);

		textFieldLiczba4 = new JTextField();
		textFieldLiczba4.setColumns(10);
		textFieldLiczba4.setBounds(285, 82, 42, 22);
		frame.getContentPane().add(textFieldLiczba4);

		textFieldLiczba5 = new JTextField();
		textFieldLiczba5.setColumns(10);
		textFieldLiczba5.setBounds(350, 82, 42, 22);
		frame.getContentPane().add(textFieldLiczba5);

		textFieldLiczba6 = new JTextField();
		textFieldLiczba6.setColumns(10);
		textFieldLiczba6.setBounds(412, 82, 42, 22);
		frame.getContentPane().add(textFieldLiczba6);

		JPanel panelWynikowy = new JPanel();
		panelWynikowy.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelWynikowy.setBounds(91, 184, 363, 208);
		frame.getContentPane().add(panelWynikowy);
		panelWynikowy.setLayout(null);

		JLabel lblTwojRezultat = new JLabel("Liczba 1:");
		lblTwojRezultat.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTwojRezultat.setBounds(12, 13, 82, 24);
		panelWynikowy.add(lblTwojRezultat);
		
		lblLiczba = new JLabel("Liczba 2:");
		lblLiczba.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblLiczba.setBounds(12, 43, 82, 24);
		panelWynikowy.add(lblLiczba);
		
		lblLiczba_1 = new JLabel("Liczba 3:");
		lblLiczba_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblLiczba_1.setBounds(12, 76, 82, 24);
		panelWynikowy.add(lblLiczba_1);
		
		lblLiczba_2 = new JLabel("Liczba 4:");
		lblLiczba_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblLiczba_2.setBounds(12, 110, 82, 24);
		panelWynikowy.add(lblLiczba_2);
		
		lblLiczba_3 = new JLabel("Liczba 5:");
		lblLiczba_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblLiczba_3.setBounds(12, 140, 82, 24);
		panelWynikowy.add(lblLiczba_3);
		
		lblLiczba_4 = new JLabel("Liczba 6:");
		lblLiczba_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblLiczba_4.setBounds(12, 171, 82, 24);
		panelWynikowy.add(lblLiczba_4);
		
		lblWynik1 = new JLabel("");
		lblWynik1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblWynik1.setBounds(127, 10, 62, 24);
		panelWynikowy.add(lblWynik1);
		
		lblWynik2 = new JLabel("");
		lblWynik2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblWynik2.setBounds(127, 42, 62, 24);
		panelWynikowy.add(lblWynik2);
		
		lblWynik3 = new JLabel("");
		lblWynik3.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblWynik3.setBounds(127, 75, 62, 24);
		panelWynikowy.add(lblWynik3);
		
		lblWynik4 = new JLabel("");
		lblWynik4.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblWynik4.setBounds(127, 110, 62, 24);
		panelWynikowy.add(lblWynik4);
		
		lblWynik5 = new JLabel("");
		lblWynik5.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblWynik5.setBounds(127, 140, 62, 24);
		panelWynikowy.add(lblWynik5);
		
		lblWynik6 = new JLabel("");
		lblWynik6.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblWynik6.setBounds(127, 170, 62, 24);
		panelWynikowy.add(lblWynik6);

		JButton btnSprawdz = new JButton("Sprawdz");
		btnSprawdz.setBounds(230, 130, 97, 25);

		btnSprawdz.addActionListener((e) -> {
			List<Integer> yourNumbers = new ArrayList<>();
			yourNumbers.add(Integer.parseInt(textFieldLiczba1.getText()));
			yourNumbers.add(Integer.parseInt(textFieldLiczba2.getText()));
			yourNumbers.add(Integer.parseInt(textFieldLiczba3.getText()));
			yourNumbers.add(Integer.parseInt(textFieldLiczba4.getText()));
			yourNumbers.add(Integer.parseInt(textFieldLiczba5.getText()));
			yourNumbers.add(Integer.parseInt(textFieldLiczba6.getText()));
			
			wygrane = LottoWindowIfYouWonHelper.checkIfYouWon(yourNumbers);
			
			wypiszWygrane();
			
		});

		frame.getContentPane().add(btnSprawdz);
		this.frame.setVisible(true);
	}
	
	private void wypiszWygrane()
	{
		lblWynik1.setText(wygrane.get(1).toString());
		lblWynik2.setText(wygrane.get(2).toString());
		lblWynik3.setText(wygrane.get(3).toString());
		lblWynik4.setText(wygrane.get(4).toString());
		lblWynik5.setText(wygrane.get(5).toString());
		lblWynik6.setText(wygrane.get(6).toString());
	}
}
