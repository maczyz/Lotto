package view;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import model.LottoHelper;

/**
 * Klasa tworzaca glowne okno programu
 * 
 * @author GrzegorzK
 *
 */

public class LottoMainWindow
{
	private JFrame frame;

	public LottoMainWindow()
	{
		initialize();
	}

	/**
	 * inicjalizacja glownego okna programu
	 */
	private void initialize()
	{
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 262);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 434, 21);
		panel.add(menuBar);

		JMenu menuFile = new JMenu("File");
		menuBar.add(menuFile);

		final JMenuItem menuItemOpenRead = new JMenuItem("Open / Read file");

		menuFile.add(menuItemOpenRead);

		JMenu menuOperation = new JMenu("Operation");
		menuBar.add(menuOperation);

		JMenuItem menuItemOperationCzyTrafiles = new JMenuItem("Sprawdz czy trafiles");
		menuOperation.add(menuItemOperationCzyTrafiles);

		menuItemOpenRead.addActionListener((e) -> {
			Object source = e.getSource();
			if (source == menuItemOpenRead)
			{
				LottoHelper.saveIntoCollection();
			}
		});

		menuItemOperationCzyTrafiles.addActionListener((e) -> {
			new WindowIfYouWon();
		});

		this.frame.setVisible(true);
	}

}
