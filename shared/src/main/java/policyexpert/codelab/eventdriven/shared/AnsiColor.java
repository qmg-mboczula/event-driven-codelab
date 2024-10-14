package policyexpert.codelab.eventdriven.shared;

public enum AnsiColor {
    ANSI_RESET("\u001B[0m"),
    ANSI_RED("\u001B[31m"),
    ANSI_YELLOW("\u001B[33m"),
    ANSI_GREEN("\u001B[32m"),
    ANSI_PURPLE("\u001B[35m"),
    ANSI_CYAN("\u001B[36m");
    private final String color;

    AnsiColor(String color) {
        this.color = color;
    }

    public void print(final String msg) {
        System.out.println(this.color + msg);
    }
}
