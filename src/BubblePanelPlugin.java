import javax.swing.JComponent;

public class BubblePanelPlugin implements IPanelPlugin {
	private BubbleComponent comp;

	public BubblePanelPlugin() {
		this.comp = new BubbleComponent();
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
		this.comp.pause();
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
		this.comp.resume();
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
