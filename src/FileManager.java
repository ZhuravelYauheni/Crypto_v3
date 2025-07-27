import java.io.IOException;
import java.nio.file.*;
import java.util.List;

// Класс, экземпляры которого отвечают за чтение и запись текстовых файлов ("работа с БД")

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
            Files.writeString(filepath, content, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            Files.writeString(filepath, "\n", StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new FileManagerException(e.getMessage(), e);
        }
    }
}
