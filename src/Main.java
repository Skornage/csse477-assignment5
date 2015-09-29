import static java.nio.file.StandardWatchEventKinds.ENTRY_CREATE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_DELETE;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		PluggableFrame f = new PluggableFrame();
		f.setVisible(true);

		Path myDir = Paths.get("plugins");

		try {
			WatchService watcher = myDir.getFileSystem().newWatchService();
			myDir.register(watcher, ENTRY_CREATE, ENTRY_DELETE);

			WatchKey watckKey = watcher.take();
			while (true) {
				List<WatchEvent<?>> events = watckKey.pollEvents();
				for (WatchEvent event : events) {
					if (event.kind() == ENTRY_CREATE) {
						f.loadPlugin(new File("plugins/"
								+ event.context().toString()));
					} else if (event.kind() == ENTRY_DELETE) {
						f.removePlugin(event.context().toString());
					}
				}
			}

		} catch (Exception e) {
			System.out.println("Error: " + e.toString());
		}
	}

}
