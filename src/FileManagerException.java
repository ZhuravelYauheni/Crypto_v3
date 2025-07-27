public class FileManagerException extends RuntimeException {
    // исключение на случай недопустимых/неверных файлов и папок
    String message;
    public FileManagerException(String message) {
        this.message = message;
    }

    public FileManagerException(String message, Throwable cause) {
        super(message, cause);
    }

    public String getMessage() {
        return message;
    }
}
