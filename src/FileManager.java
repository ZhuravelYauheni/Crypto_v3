import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileManager {
    public List<String> readFile(String fileName) {
        try {
            Path filepath = Path.of(fileName);
            return Files.readAllLines(filepath);
        } catch (IOException | InvalidPathException e) {
            throw new FileManagerException(e.getMessage(), e);
        }
    }

    public void writeFile(String fileName, String content) {
        try {
            Path filepath = Path.of(fileName);
            Files.writeString(filepath, content);
        } catch (IOException e) {
            throw new FileManagerException(e.getMessage(), e);
        }
    }
}
