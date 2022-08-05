import java.io.File;

public class FileUtils {

    public static long calculateFolderSize(String path) {
        long sumWithFile = 0;
        File file = new File(path);
        File[] files = file.listFiles();
        for (File file1 : files) {
            if (file1.isFile()) {
                sumWithFile += file1.length();
            } else {
                sumWithFile += calculateFolderSize(file1.getPath());
            }
        }
        return sumWithFile;
    }
}
