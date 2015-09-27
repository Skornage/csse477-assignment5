
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class PluginListComponent extends JPanel implements ListSelectionListener {
	
	private JLabel label = new JLabel("");

	public PluginListComponent() {
		String[] words = { "quick", "brown", "hungry", "wild", "silent", "huge", "test", "test", "test", "test", "test", "test", "test" };

		JList wordList = new JList(words);
		JScrollPane scrollPane = new JScrollPane(wordList);
		scrollPane.setPreferredSize(new Dimension(250, 1000));

		this.add(scrollPane);
		this.setPreferredSize(new Dimension(250, 1000));
		wordList.addListSelectionListener(this);
		this.add(label, "Center");
	}

	public void valueChanged(ListSelectionEvent evt) {
		JList source = (JList) evt.getSource();
		Object[] values = source.getSelectedValues();

		String text = "";
		for (int i = 0; i < values.length; i++) {
			String word = (String) values[i];
			text += word + " ";
		}
		label.setText(text);
	}
}
