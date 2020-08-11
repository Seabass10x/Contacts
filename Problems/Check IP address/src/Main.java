import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String ipAddress = scanner.nextLine();
        String isIPAddress = "NO";

        if (ipAddress.matches("(1?[0-9]{1,2}|2[0-4][0-9]|25[0-5])\\." +
                                    "(1?[0-9]{1,2}|2[0-4][0-9]|25[0-5])\\." +
                                    "(1?[0-9]{1,2}|2[0-4][0-9]|25[0-5])\\." +
                                    "(1?[0-9]{1,2}|2[0-4][0-9]|25[0-5])")) {
            isIPAddress = "YES";
        }
        System.out.println(isIPAddress);
    }
}