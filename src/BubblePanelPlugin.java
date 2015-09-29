import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.JComponent;

public class BubblePanelPlugin implements IPanelPlugin {
	protected static final long REPAINT_INTERVAL_MS = 40;
	protected BubbleComponent comp;
	protected Thread workThread;
	protected ArrayList<Bubble> bubbles = new ArrayList<Bubble>();

	public BubblePanelPlugin() {
		this.comp = new BubbleComponent(this.bubbles);

		Runnable repainter = new Runnable() {
			@Override
			public void run() {
				// Periodically asks Java to repaint this component
				try {
					while (true) {
						Thread.sleep(REPAINT_INTERVAL_MS);
						moveBubbles();
						BubblePanelPlugin.this.comp.repaint();
					}
				} catch (InterruptedException exception) {
					// Stop when interrupted
				}
			}
		};
		this.workThread = new Thread(repainter);
		this.workThread.start();
	}

	protected void moveBubbles() {
		Rectangle r = this.comp.getBounds();
		for (Bubble b : this.bubbles) {

			if (b.getMinX() < 0 || b.getMaxX() > r.width) {
				b.bounceOffSideWall();
			} else if (b.getMinY() < 0 || b.getMaxY() > r.height) {
				b.bounceOffTopBottomWall();
			}
			b.updatePosition();
		}
	}

	@Override
	public String getName() {
		return "Bubbles";
	}

	@Override
	public JComponent getComponent() {
		return this.comp;
	}

	@Override
	public void onPause() {
		// does nothing.
	}

	@Override
	public void onResume() {
		// does nothing.

	}

	@Override
	public void onCreate() {
		// does nothing.
	}

	@Override
	public void onDestroy() {
		// does nothing.
	}

	@Override
	public void onStart() {
		// does nothing.
	}

	@Override
	public void onRestart() {
		// does nothing.
	}

	@Override
	public void onStop() {
		// does nothing.
	}

}
