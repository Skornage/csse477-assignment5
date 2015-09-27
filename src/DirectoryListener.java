
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.nio.file.Watchable;
import java.util.List;
import static java.nio.file.StandardWatchEventKinds.*;


public class DirectoryListener {
	
	public DirectoryListener() {
		
		WatchKey key = null;
		try {
			WatchService watcher = FileSystems.getDefault().newWatchService();
			Watchable dir = (Watchable) new File("plugins").toPath();
			key = dir.register(watcher,
                    ENTRY_CREATE,
                    ENTRY_DELETE,
                    ENTRY_MODIFY);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
