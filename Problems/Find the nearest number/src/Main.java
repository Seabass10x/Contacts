import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Integer> numberList = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayList::new));
        int n = scanner.nextInt();
        int minDistance = Integer.MAX_VALUE;
        ArrayList<Integer> minDistanceList = new ArrayList<>();

        for (Integer number : numberList) {
            if (Math.abs(n - number) < minDistance) {
                minDistance = Math.abs(n - number);
            }
        }
        for (Integer number : numberList) {
            if (Math.abs(n - number) == minDistance) {
                minDistanceList.add(number) ;
            }
        }
        Collections.sort(minDistanceList);

        for (Integer number: minDistanceList) {
            System.out.print(number + " ");
        }

    }
}