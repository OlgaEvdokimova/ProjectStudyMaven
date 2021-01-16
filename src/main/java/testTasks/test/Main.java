package testTasks.test;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println(isPerfectN(6));
        int[] a = {33,6,0,10,11};
        System.out.println(smallestDistanceInArray(a));
        List<String> str = List.of("aaff sdf","aadd ff", "aadd, asfaf");
        System.out.println(longestLines(str));
    }

    public static boolean isPerfectN(int n) {
        if (n < 1) {
            return false;
        }
        int temp = 0;
        for (int i = 1; i <= n / 2; i++) {
            if (n % i == 0) {
                temp += i;
            }
        }
        return temp == n;
    }

    public static Integer smallestDistanceInArray(int[] a) {
        Integer index = null;
        if (!((a == null) || a.length < 2)) {
            index = 0;
            long minDistance = Math.abs((long) a[index + 1] - (long) a[index]);
            for (int i = 0; i < a.length - 1; i++) {
                if (Math.abs((long) a[i + 1] - (long) a[i]) < minDistance) {
                    minDistance = Math.abs(a[index + 1] - a[index]);
                    index = i;
                }
            }
        }
        return index;
    }

    public  static List<String> longestLines(List<String> inputLines){
        if (inputLines == null){
            throw new IllegalArgumentException("Invalid parameter.");
        }
        int currentMacCount = 0;
        List<String> lines = new ArrayList<>();
        for (String line: inputLines){
            int count = (line.trim().split("\\s+")).length;
            if (count > currentMacCount){
                lines.clear();
                currentMacCount = count;
            }
            if (count == currentMacCount){
                lines.add(line);
            }
        }
        return lines;
    }
}
