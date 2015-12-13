package hlavni;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JCheckBox;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

public class Ramec extends JFrame {
	private final ArrayList<ArrayList<Polygon3D>> budovy;
	
	public Ramec(ArrayList<ArrayList<Polygon3D>> budovy) {
		this.budovy = budovy;
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setMinimumSize(Toolkit.getDefaultToolkit().getScreenSize());
		setExtendedState(Ramec.MAXIMIZED_BOTH);
		setTitle("3DViz");
		init();
		setVisible(true);
	}
	
	public JPanel panel;

	/**
	 * nacte horni listy 
	 */
	private void init() {
		panel = new Panel3D(budovy);
		Container cont = getContentPane();
		cont.setLayout(new BorderLayout());
		cont.add(panel, BorderLayout.CENTER);
		JMenuBar mb = new JMenuBar();
		this.setJMenuBar(mb);
		JCheckBoxMenuItem cb = new JCheckBoxMenuItem("Anaglyph");
		cb.setState(false);
		cb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cb.getState()) {
					Panel3D.anaglyph = true;
					panel.repaint();
				} else {
					Panel3D.anaglyph = false;
					panel.repaint();
				}
			}
		});
		mb.add(cb);
	}
}