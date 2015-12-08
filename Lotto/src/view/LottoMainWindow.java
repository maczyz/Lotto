package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

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
	frame.setLayout(null);

	JPanel panel = new JPanel();
	panel.setBounds(0, 0, 434, 262);
	frame.add(panel);
	panel.setLayout(null);

	JMenuBar menuBar = new JMenuBar();
	menuBar.setBounds(0, 0, 434, 21);
	panel.add(menuBar);

	JMenu menuFile = new JMenu("File");
	menuBar.add(menuFile);

	JMenuItem menuItemOpenRead = new JMenuItem("Open / Read file");

	menuFile.add(menuItemOpenRead);

	JMenu menuOperation = new JMenu("Operation");
	menuBar.add(menuOperation);

	JMenuItem menuItemOperation1 = new JMenuItem("Operation 1");
	menuOperation.add(menuItemOperation1);

	menuItemOpenRead.addActionListener(new ActionListener()
	{
	    public void actionPerformed(ActionEvent e)
	    {
		int i;
		Object source = e.getSource();
		if (source == menuItemOpenRead)
		{
		    FileInputStream fileInputStream = getFileInputStream();
		    try {
			do {
			    i = fileInputStream.read();
			    if (i != -1) System.out.print((char)i);
			} while (i != -1);
		    }
		    catch (IOException e1){
			System.out.print("Blad odczytu pliku");
		    }
		}
	    }
	});

	this.frame.setVisible(true);
    }

    private FileInputStream getFileInputStream()
    {
	FileInputStream inputStream = null;
	JFileChooser fileChooser = new JFileChooser();
	if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
	{
	    File file = fileChooser.getSelectedFile();
	    try
	    {
		inputStream = new FileInputStream(file);
	    } catch (FileNotFoundException e1)
	    {
		e1.printStackTrace(); // wyświetla przyczyne bledu w
				      // konsoli
		JOptionPane.showMessageDialog(null, "Nie można odnaleźć określonego pliku");
		this.getFileInputStream(); // dzięki THIS odwołujemy się do
					   // każdego elementów obecnej klasy.
	    }
	}
	return inputStream;
    }

}
