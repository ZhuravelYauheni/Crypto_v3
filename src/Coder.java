import java.util.List;

public class Coder {
    private Cypher cypher;
    private FileManager fileManager;
    private FileChecker fileChecker;

    public Coder() {
        this.cypher = new Cypher(new Alphabet());
        this.fileManager = new FileManager();
        this.fileChecker = new FileChecker();
    }

    public void encode(String inputFile, String outputFile, int k) {
        fileChecker.checkForReading(inputFile);
        fileChecker.checkForWriting(outputFile);
        List<String> inputLines = fileManager.readFile(inputFile);
        for (String line : inputLines) {
            String encodedLine = cypher.encode(line, k);
            fileManager.writeFile(outputFile, encodedLine);
        }
    }

    public void decode(String inputFile, String outputFile, int k) {
        fileChecker.checkForReading(inputFile);
        fileChecker.checkForWriting(outputFile);
        List<String> inputLines = fileManager.readFile(inputFile);
        for (String line : inputLines) {
            String decodedLine = cypher.decode(line, k);
            fileManager.writeFile(outputFile, decodedLine);
        }
    }
}
