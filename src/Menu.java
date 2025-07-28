import java.util.Scanner;

    /*
    Класс отображает меню, позволяет юзеру через консоль взаимодействовать с прогой, генерирует задачи для "бекенда"
     */

public class Menu {

    private static final String TITLE = "Это крипто-анализатор";
    private static final String NAVIGATE = "Для навигации по меню используйте цифровые клавиши (NumPad) от 0 до 5";
    private static final String CASE_0 = "0 - дополнительная информация";
    private static final String CASE_1 = "1 - зашифровать текст с помощью ключа-значения";
    private static final String CASE_2 = "2 - расшифровать текст с помощью ключа-значения";
    private static final String CASE_3 = "3 - расшифровать текст методом brute force";
    private static final String CASE_4 = "4 - расшифровать текст методом статистического анализа";
    private static final String CASE_5 = "5 - завершить программу";
    private static final String BYE = "Дай вам бог здоровьечка!";
    private static final String WRONGCHOICE = "Выберите один из предлагаемых вариантов";
    private static final String ENTER_INPUT_FILE = "Укажите исходный файл *.txt";
    private static final String ENTER_OUTPUT_FILE = "Укажите итоговый файл *.txt";
    private static final String ENTER_KEY = "Введите ключ шифрования";
    private static final String DONE = "Готово!";
    private static int menuShownCounter = 0;

    private static void showMainMenu() {
        if (menuShownCounter == 0) {
            System.out.println();
            System.out.println(TITLE);
            System.out.println(NAVIGATE);
        }
        System.out.println();
        System.out.println(CASE_0);
        System.out.println(CASE_1);
        System.out.println(CASE_2);
        System.out.println(CASE_3);
        System.out.println(CASE_4);
        System.out.println(CASE_5);
        System.out.println();
        menuShownCounter++;
    }

    public static void menuNavigation() {
        Scanner scanner = new Scanner(System.in);
        // Выносим Scanner на уровень класса

        while (true) {
                showMainMenu();
            String input = scanner.nextLine();

            switch (input) {
                case "0":
                    Info.showInfo();
                    break;
                case "1":
                    Coder coderEn = new Coder();
                    System.out.println(ENTER_INPUT_FILE);
                    String inputEnFile = scanner.nextLine();
                    System.out.println(ENTER_OUTPUT_FILE);
                    String outputEnFile = scanner.nextLine();
                    System.out.println(ENTER_KEY);
                    Integer keyEn = Integer.parseInt(scanner.nextLine());
                    coderEn.encode(inputEnFile, outputEnFile, keyEn);
                    System.out.println(DONE);
                    break;
                case "2":
                    Coder coderDe = new Coder();
                    System.out.println(ENTER_INPUT_FILE);
                    String inputDeFile = scanner.nextLine();
                    System.out.println(ENTER_OUTPUT_FILE);
                    String outputDeFile = scanner.nextLine();
                    System.out.println(ENTER_KEY);
                    Integer keyDe = Integer.parseInt(scanner.nextLine());
                    coderDe.decode(inputDeFile, outputDeFile, keyDe);
                    System.out.println(DONE);
                    break;
                case "3":
                    System.out.println(ENTER_INPUT_FILE);
                    String inputBruteFile = scanner.nextLine();
                    System.out.println(ENTER_OUTPUT_FILE);
                    String outputBruteFile = scanner.nextLine();
                    BruteForceDecoder bruteForceDecoder = new BruteForceDecoder(new Alphabet());
                    int foundKey = bruteForceDecoder.bruteForce(inputBruteFile, outputBruteFile);
                    System.out.println("Найден наиболее вероятный ключ: " + foundKey);
                    System.out.println(DONE);
                    break;
                case "4":
                    System.out.println("тут вообще ничего не понятно");
                    break;
                case "5":
                    System.out.println(BYE);
                    scanner.close();
                    return;
                default:
                    System.out.println(WRONGCHOICE);
            }
        }
    }
}
