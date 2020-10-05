package segerfast.philip;

import java.util.Scanner;

public final class Utils {

    // ANSI escape code COLORS
    // https://en.wikipedia.org/wiki/ANSI_escape_code#Colors

    // Olika symboler
    // https://www.w3schools.com/charsets/ref_utf_block.asp

    private static final Scanner scanner = new Scanner(System.in);

    private Utils() {}

    public static void printColoredLine(String text, GameColor color) {
        printColoredString(text + System.lineSeparator(), color);
    }

    public static void printColoredString(String text, GameColor color) {
        System.out.printf("%s%s%s", color, text, GameColor.RESET);
    }

    private static void printInputCursor() {
        printLineSeparator();
        System.out.print(GameColor.CURSOR + "> ");
    }

    public static void printLineSeparator() {
        System.out.println(GameColor.SEPARATOR + "==============================" + GameColor.RESET);
    }

    public static String getStringInput() {
        printInputCursor();
        String input = scanner.nextLine();
        printLineSeparator();
        return input;
    }

    public static int getIntInput() {
        printInputCursor();
        System.out.print(GameColor.YELLOW);
        int input = scanner.nextInt();
        System.out.print(GameColor.RESET);
        printLineSeparator();
        return input;
    }

}