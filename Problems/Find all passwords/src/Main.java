import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        Pattern passwordPattern = Pattern.compile("password[\\s:]*([a-z0-9]+)", Pattern.CASE_INSENSITIVE);
        Matcher matcher = passwordPattern.matcher(text);

        if (!matcher.find()) {
            System.out.println("No passwords found.");
        } else {
            do {
                System.out.println(matcher.group(1));
            } while (matcher.find());
        }
    }
}