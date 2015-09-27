import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

import javax.swing.JComponent;

public class BubbleComponent extends JComponent {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1153376522007633784L;

	public BubbleComponent() {
		this.setSize(400, 200);
	}

	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;

		Ellipse2D.Double cir = new Ellipse2D.Double(80, 80, 30, 30);
		g2.draw(cir);
	}

}
