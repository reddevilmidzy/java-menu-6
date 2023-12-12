package menu.constant;

public enum ErrorMessage {

    INVALID_COACH_NAME("유효하지 않은 코치 이름입니다. "),
    INVALID_MENU("유효하지 않은 메뉴입니다. "),
    ;


    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
