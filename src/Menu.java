import java.util.Scanner;

public class Menu {
    /*
    В этом классе я попробую изобразить что-то похожее на юзабельное меню программы
     */
    private Menu() {
    }

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
    private static int menuShownCounter = 0;
    private static int option;

    public static String getWrongchoice(){
        return WRONGCHOICE;
    }

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
        Scanner scanner = new Scanner(System.in); // Выносим Scanner на уровень класса

        while (true) {
            showMainMenu();
            String input = scanner.nextLine();

            switch (input) {
                case "0":
                    Info.showInfo();
                    break;
                case "1":

                    break;
                case "2":

                    break;
                case "3":
                    System.out.println("тут завал");
                    break;
                case "4":
                    System.out.println("тут вообще ничего не понятно");
                    break;
                case "5":
                    System.out.println(BYE);
                    scanner.close();
                    return; // Выход из метода
                default:
                    System.out.println(WRONGCHOICE);
            }
        }
    }
}
