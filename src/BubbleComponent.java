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
	protected static final long REPAINT_INTERVAL_MS = 40;
	private ArrayList<Bubble> bubbles = new ArrayList<Bubble>();
	private Thread workThread;

	public BubbleComponent() {
		Dimension size = new Dimension(1150, 850);
		this.setPreferredSize(size);
		this.setMinimumSize(size);

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

		Runnable repainter = new Runnable() {
			@Override
			public void run() {
				// Periodically asks Java to repaint this component
				try {
					while (true) {
						Thread.sleep(REPAINT_INTERVAL_MS);
						repaint();
					}
				} catch (InterruptedException exception) {
					// Stop when interrupted
				}
			}
		};
		this.workThread = new Thread(repainter);
		this.workThread.start();
		this.workThread.suspend();
	}

	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		Rectangle r = this.getBounds();

		g2.setColor(new Color(81, 0, 142));
		g2.fillRect(r.x, r.y, r.width, r.height);

		for (Bubble b : this.bubbles) {

			b.updatePosition();

			g2.setColor(b.getColor());
			g2.fill(b.getShape());

			if (b.getMinX() < 0 || b.getMaxX() > r.width) {
				b.bounceOffSideWall();
			} else if (b.getMinY() < 0 || b.getMaxY() > r.height) {
				b.bounceOffTopBottomWall();
			}
		}
	}

	protected void pause() {
		this.workThread.suspend();
	}

	protected void resume() {
		this.workThread.resume();
	}
}
