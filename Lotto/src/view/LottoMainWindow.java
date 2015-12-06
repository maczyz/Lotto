package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class LottoMainWindow
{

    private JFrame frame;

    public LottoMainWindow()
    {
	initialize();
    }

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
	
	JMenuItem menuItemOpenRead = new JMenuItem("Open / Read file");
	
	menuItemOpenRead.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    System.out.print("Dupa Jasiu");
		}
	});
	menuFile.add(menuItemOpenRead);
	
	JMenu menuOperation = new JMenu("Operation");
	menuBar.add(menuOperation);
	
	JMenuItem menuItemOperation1 = new JMenuItem("Operation 1");
	menuOperation.add(menuItemOperation1);
	
	this.frame.setVisible(true);
    }
}
