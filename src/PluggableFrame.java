import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JComponent;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class PluggableFrame extends javax.swing.JFrame {

	private static final long serialVersionUID = 8245314602864068840L;
	private ArrayList<IPanelPlugin> plugins = new ArrayList<IPanelPlugin>();
	DefaultListModel<String> listModel = new DefaultListModel<String>();
	private JComponent centralPanel;
	private int currentPluginIndex = -1;

	public PluggableFrame() {

		loadPlugins();

		Dimension size = new Dimension(1400, 1000);
		Dimension buttonPanelSize = new Dimension(250, 1);

		this.setSize(size);
		this.setResizable(false);
		this.addWindowListener(new WindowCloseListener());

		JPanel p1 = new JPanel();
		p1.setLayout(new BorderLayout());
		p1.setSize(size);

		JPanel p2 = new JPanel();
		p2.setPreferredSize(buttonPanelSize);
		p2.setBackground(Color.black);
		
		JList<String> namesList = new JList<String>(listModel);
		namesList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		namesList.setLayoutOrientation(JList.VERTICAL);
		namesList.setVisibleRowCount(-1);

		namesList.getSelectionModel().addListSelectionListener(
				new ListSelectionListener() {

					@Override
					public void valueChanged(ListSelectionEvent e) {
						if (e.getValueIsAdjusting()) {
							ListSelectionModel lsm = (ListSelectionModel) e
									.getSource();
							int index = -1;
							// Find out which indexes are selected.
							int minIndex = lsm.getMinSelectionIndex();
							int maxIndex = lsm.getMaxSelectionIndex();
							for (int i = minIndex; i <= maxIndex; i++) {
								if (lsm.isSelectedIndex(i)) {
									index = i;
									selectPlugin(index);
									break;
								}
							}
						}
					}
				});

		JScrollPane listScrollPane = new JScrollPane(namesList);
		Dimension listPaneSize = new Dimension(150, 800);
		listScrollPane.setPreferredSize(listPaneSize);

		p2.add(listScrollPane);

		this.centralPanel = new JPanel();

		p1.add(p2, BorderLayout.WEST);
		p1.add(this.centralPanel, BorderLayout.CENTER);
		this.add(p1);
	}

	private void loadPlugins() {

		File f = new File("/plugins");
		File[] jarsToAdd = f.listFiles();

		for (File jar : jarsToAdd) {
			if (jar.isFile()) {
				String name = jar.getName();
				int i = name.lastIndexOf('.');
				if (i > 0) {
					String extension = name.substring(i + 1);
					if (extension.toLowerCase().equals("jar")) {
						// addPlugin(new JurassicTSwiftPanelPlugin());
					}
				}

			}
		}

		addPlugin(new JurassicTSwiftPanelPlugin());
		addPlugin(new BubblePanelPlugin());
	}

	private void addPlugin(IPanelPlugin plugin) {
		this.plugins.add(plugin);
		plugin.onCreate();
		listModel.addElement(plugin.getName());
	}

	protected void selectPlugin(int index) {
		this.centralPanel.removeAll();
		this.centralPanel.add(this.plugins.get(index).getComponent());
		this.plugins.get(index).onStart();
		this.plugins.get(this.currentPluginIndex).onPause();
		this.centralPanel.revalidate();
		this.centralPanel.repaint();
		this.currentPluginIndex = index;
	}
}
