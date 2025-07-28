public class Cypher {

    // Здесь логика шифрования и дешифрования шрифта Цезаря

    private final Alphabet alphabet;

    public Cypher(Alphabet alphabet) {
        this.alphabet = alphabet;
    }

    public String encode(String inputLine, int k) {
        return processor(inputLine, k);
    }

    public String decode(String inputLine, int k) {
        return processor(inputLine, -k);
    }

    private String processor(String inputLine, int k) {
        StringBuilder outputLine = new StringBuilder();
        for (int i = 0; i<inputLine.length(); i++) {
            Character input = Character.toLowerCase(inputLine.charAt(i));
            int inputChInd = alphabet.getIndex(input);
            int outputChInd = (alphabet.size() + (inputChInd + k)) % alphabet.size();
            outputLine.append(alphabet.getSymbol(outputChInd));
        }
        return outputLine.toString();
    }
}
