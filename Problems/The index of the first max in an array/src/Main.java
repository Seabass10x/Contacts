import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] array = new int[n];
        int maxValue = 0;
        int maxIndex = 0;

        if (n == 1) {
            System.out.println(0);
        } else {
            for (int i = 0; i < n; i++) {
                array[i] = scanner.nextInt();
                if (i == 0) {
                    maxValue = array[i];
                } else {
                    if (array[i] > maxValue) {
                        maxValue = array[i];
                        maxIndex = i;
                    }
                }
            }
            System.out.println(maxIndex);
        }
    }
}