package concurrent;

import java.io.File;
import java.io.FileFilter;
import java.util.concurrent.BlockingQueue;

/**
 * Created by CS on 2017/12/6.
 */
public class FileCrawler implements Runnable {
    private final BlockingQueue<File> filerQueue;
    private final FileFilter filter;
    private final File root;

    public FileCrawler(BlockingQueue<File> filerQueue, FileFilter filter, File root) {
        this.filerQueue = filerQueue;
        this.filter = filter;
        this.root = root;
    }

    private void crawl(File root) throws InterruptedException {
        File[] files = root.listFiles(filter);
        if (files != null) {
            for (File file : files) {
                if(file.isDirectory()) crawl(file);
                else if(!alreadyIndexed(file)) filerQueue.put(file);
            }
        }
    }

    private boolean alreadyIndexed(File file) {
        return false;
    }

    @Override
    public void run() {
        try {
            crawl(root);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

    }
}
