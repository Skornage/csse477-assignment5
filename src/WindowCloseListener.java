import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class WindowCloseListener implements WindowListener {

	@Override
	public void windowActivated(WindowEvent e) {
		// does nothing.
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// does nothing.
	}

	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// does nothing.
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// does nothing.
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// does nothing.
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// does nothing.
	}

}
