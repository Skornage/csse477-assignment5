import java.awt.Dimension;

import javax.swing.JPanel;

public class PluggableFrame extends javax.swing.JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8245314602864068840L;

	public PluggableFrame() {
		Dimension size = new Dimension(800, 600);
		this.setPreferredSize(size);
		JPanel p = new JPanel();
		p.setPreferredSize(size);

		p.add(new BubbleComponent());
	}
}
