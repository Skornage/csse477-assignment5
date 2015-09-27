import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JEditorPane;
import javax.swing.JPanel;

public class JurassicTSwiftPanelPlugin implements IPanelPlugin {

	private JPanel p;
	private String IMAGEHTML = "<!DOCTYPE html><html><body><div><img src=\"http://celebmafia.com/wp-content/uploads/2014/11/taylor-swift-photoshoot-for-time-magazine-november-2014_3.jpg\"/></div><div><img src=\"http://celebmafia.com/wp-content/uploads/2014/11/taylor-swift-photoshoot-for-time-magazine-november-2014_3.jpg\"/></div></body></html>";
	// private String SIMPLEHTML =
	// "<!DOCTYPE html><html><body><div><p>Hello World!</p></div><div><p>Hello World 2</p></div></body></html>";
	private JEditorPane editText;

	public JurassicTSwiftPanelPlugin() {
		p = new JPanel();
		p.setLayout(new BorderLayout());

		JEditorPane tSwiftPane;
		tSwiftPane = new JEditorPane();
		tSwiftPane.setContentType("text/html");
		tSwiftPane.setText(IMAGEHTML);

		JPanel messagePanel = new JPanel();
		editText = new JEditorPane();
		JButton messageButton = new JButton("Send Message");
		messageButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				sendText();

			}
		});
		messagePanel.add(editText);
		messagePanel.add(messageButton);
		messagePanel.setPreferredSize(new Dimension(1, 100));

		p.add(tSwiftPane, BorderLayout.CENTER);
		p.add(messagePanel, BorderLayout.SOUTH);

	}

	protected void sendText() {
		System.out.println(editText.getText());
	}

	@Override
	public String getName() {
		return "Jurassic T Swizzle";
	}

	@Override
	public JComponent getComponent() {
		return p;
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
