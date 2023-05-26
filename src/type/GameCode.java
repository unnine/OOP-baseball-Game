package type;

public enum GameCode {
    CONTINUE(1),
    EXIT(2);

    private final int code;

    GameCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static boolean isContinue(int code) {
        return GameCode.CONTINUE.getCode() == code;
    }

}