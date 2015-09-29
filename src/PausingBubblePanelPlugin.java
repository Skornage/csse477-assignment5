public class PausingBubblePanelPlugin extends BubblePanelPlugin implements
		IPanelPlugin {

	public PausingBubblePanelPlugin() {
		super();
		this.workThread.suspend();
	}

	@Override
	public String getName() {
		return "Pausing Bubbles";
	}

	@Override
	public void onPause() {
		this.workThread.suspend();
	}

	@Override
	public void onStart() {
		this.workThread.resume();
	}

}
