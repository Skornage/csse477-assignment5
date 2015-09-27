import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

public class PluggableFrame extends javax.swing.JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8245314602864068840L;

	public PluggableFrame() {
		
		Dimension size = new Dimension(1400, 1000);
		Dimension buttonPanelSize = new Dimension(250, 1);
		Dimension pluggablePanelSize = new Dimension(600, 1);
		
		this.setSize(size);
		this.setResizable(false);
		
		JPanel p1 = new JPanel();
		p1.setLayout(new BorderLayout());
		p1.setSize(size);
		p1.setBackground(Color.ORANGE);

		JPanel p2 = new JPanel();
		p2.setPreferredSize(buttonPanelSize);
		p2.setBackground(Color.black);

		JPanel p3 = new JPanel();
		p3.setPreferredSize(pluggablePanelSize);
		p3.setBackground(Color.GREEN);
		
		

		p3.add(new BubbleComponent());
		
		p1.add(p2, BorderLayout.WEST);
		p1.add(p3,BorderLayout.CENTER);
		
		this.add(p1);
		
	}
}
