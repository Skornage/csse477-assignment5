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
	private String IMAGEHTML = "<!DOCTYPE html><html><body><div style='float:left; clear:both;'><img src=\"http://celebmafia.com/wp-content/uploads/2014/11/taylor-swift-photoshoot-for-time-magazine-november-2014_3.jpg\" height=\"445\" width=\"397\"/><img src=\"http://www.sportsalcohol.com/wp-content/uploads/2015/06/Jurassic.jpg\" height=\"445\" width=\"792\"/></div></body></html>";
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
		editText.setSize(new Dimension(150, 50));
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
		String messgeToSend = editText.getText().trim();
		if (!messgeToSend.equals("")) {
			System.out.println(messgeToSend);
			editText.setText("");
		}
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
