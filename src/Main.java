import static java.nio.file.StandardWatchEventKinds.ENTRY_CREATE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_DELETE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_MODIFY;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.List;
import java.net.URL;

import classLoader.JarClassLoader;

public class Main {

	public static void main(String[] args) {
		PluggableFrame f = new PluggableFrame();
		f.add(new BubbleComponent());
		f.setVisible(true);
		
		try {
			URL fileUrl = new File("plugins/test.jar").toURI().toURL();
			
			JarClassLoader jarLoader = new JarClassLoader(fileUrl);
	        Class<?> c = jarLoader.loadClass("JurassicTSwiftPanelPlugin");
	        Object o = c.newInstance();
	        System.out.println("NAME: " + ((IPanelPlugin) o).getName());
		}
		catch (Exception e) {
			System.out.println("Error: " + e.toString());
		}

		Path myDir = Paths.get("plugins");

		try {
			WatchService watcher = myDir.getFileSystem().newWatchService();
			myDir.register(watcher, ENTRY_CREATE, ENTRY_DELETE, ENTRY_MODIFY);

			WatchKey watckKey = watcher.take();
			while (true) {
				List<WatchEvent<?>> events = watckKey.pollEvents();
				for (WatchEvent event : events) {
					if (event.kind() == ENTRY_CREATE) {
						System.out.println("Created: " + event.context().toString());
					}
					if (event.kind() == ENTRY_DELETE) {
						System.out.println("Delete: "
								+ event.context().toString());
					}
					if (event.kind() == ENTRY_MODIFY) {
						System.out.println("Modify: "
								+ event.context().toString());
					}
				}
			}

		} catch (Exception e) {
			System.out.println("Error: " + e.toString());
		}
	}

}
