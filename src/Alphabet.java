import java.util.*;

public class Alphabet {
    private static final Character[] ALPHABET = {
            'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж', 'з', 'и', 'й',
            'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф',
            'х', 'ц', 'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'ю', 'я'
    };

    private static final Character[] SYMBOLS = {
        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
        '.', ',', '"', ':', ';', '-', '!', '?', '#',
        ' ', '$', '%', '&', '\'', '(', ')', '*', '+',
    };

    private final List<Character> alphabet;
    private final Map<Character, Integer> charMap;

    public Alphabet() {
        List<Character> temp = new ArrayList<Character>();
        temp.addAll(Arrays.asList(ALPHABET));
        temp.addAll(Arrays.asList(SYMBOLS));
        alphabet = List.copyOf(temp);
        charMap = new HashMap<Character, Integer>();
        for (int i = 0; i < alphabet.size(); i++) {
            charMap.put(alphabet.get(i), i);
        }
    }

    public Character getSymbol(int i) {
        if (i < 0 || i >= alphabet.size()) {
            return '?';
        }
        return alphabet.get(i);
    }

    public int getIndex(Character ch) {
        if (!charMap.containsKey(ch)) {
            return -1;
        }
        return charMap.get(ch);
    }

    public int size() {
        return alphabet.size();
    }
}
