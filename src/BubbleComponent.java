import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JComponent;

public class BubbleComponent extends JComponent {

	private static final long serialVersionUID = -1153376522007633784L;
	private ArrayList<Bubble> bubbles;

	public BubbleComponent(ArrayList<Bubble> bubbles) {
		Dimension size = new Dimension(1150, 850);
		this.setPreferredSize(size);
		this.bubbles = bubbles;

		this.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// does nothing.
			}

			@Override
			public void mousePressed(MouseEvent e) {
				bubbles.add(new Bubble(e.getX(), e.getY()));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// does nothing.
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// does nothing.
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// does nothing.
			}
		});

	}

	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		Rectangle r = this.getBounds();

		g2.setColor(new Color(81, 0, 142));
		g2.fillRect(r.x, r.y, r.width, r.height);

		for (Bubble b : this.bubbles) {
			g2.setColor(b.getColor());
			g2.fill(b.getShape());
		}
	}
}
