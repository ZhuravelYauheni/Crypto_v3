public class ProgressBar {
    private final int totalSteps;
    private int currentStep;
    private final int width; // Ширина прогресс-бара в символах

    public ProgressBar(int totalSteps, int width) {
        this.totalSteps = totalSteps;
        this.width = width;
        this.currentStep = 0;
    }

    public void update(int step) {
        this.currentStep = step;
        print();
    }

    public void increment() {
        this.currentStep++;
        print();
    }

    private void print() {
        float progress = (float) currentStep / totalSteps;
        int filledWidth = (int) (progress * width);

        System.out.print("\r["); // \r возвращает каретку в начало строки
        for (int i = 0; i < width; i++) {
            if (i < filledWidth) {
                System.out.print("=");
            } else if (i == filledWidth) {
                System.out.print(">");
            } else {
                System.out.print(" ");
            }
        }
        System.out.print("] ");
        System.out.printf("%.1f%%", progress * 100);
    }

    public void complete() {
        currentStep = totalSteps;
        print();
        System.out.println(); // Переход на новую строку после завершения
    }
}