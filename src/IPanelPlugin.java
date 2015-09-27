import javax.swing.JComponent;

public interface IPanelPlugin {

	public JComponent getComponent();
	
	public String getName();

	public void onPause();

	public void onResume();

	public void onCreate();

	public void onDestroy();

	public void onStart();

	public void onRestart();

	public void onStop();

}
