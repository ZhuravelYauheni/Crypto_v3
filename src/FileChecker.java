import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileChecker {

    private static final List<String> PROHIBITED_DIRS = List.of("C:\\Windows", "C:\\Program Files");

    public void checkForWriting(String fileName) {
        Path path = checkPath(fileName);
        if (Files.exists(path)) {
            if (Files.isDirectory(path)) {
                throw new FileManagerException(path + " не файл, а папка!");
            }
            if (!Files.isWritable(path)) {
                throw new FileManagerException(path + " недоступен для записи!");
            }

        }
    }

    public void checkForReading(String fileName) {
        Path path = checkPath(fileName);
        if (Files.notExists(path)) {
            throw new FileManagerException("Файл " +path + " не существует!");
        }
        if (Files.isDirectory(path)) {
            throw new FileManagerException(path + " не файл, а папка!");
        }
        if (!Files.isReadable(path)) {
            throw new FileManagerException("Файл " + path + " недоступен для чтения!");
        }
    }


    private Path checkPath(String fileName) {
        Path path = Paths.get(fileName).normalize();
        String absolutePath = path.toAbsolutePath().toString();

        for (String pathPath : PROHIBITED_DIRS) {
            if (absolutePath.startsWith(pathPath)) {
                throw new FileManagerException("Путь " + fileName + " запрещён в целях безопасности. Не используйте папки Windows и Program Files!");
            }
        }
        try {
            Path path2 = Path.of(fileName);
            return path2;
        } catch (InvalidPathException e) {
            throw new FileManagerException("Неверный путь.  " + e.getMessage());
        }
    }
}
