import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        greedy1();
    }

    static void greedy1() {
        Scanner reader;
        ArrayList<Integer> arrayList = new ArrayList<>();
        int max = 0;
        try {
            BufferedReader br = new BufferedReader(new FileReader("input1.txt"));
            reader = new Scanner(br);
            while (reader.hasNextInt()) {
                int temp = reader.nextInt();
                arrayList.add(temp);
                if (temp > arrayList.get(max)) {
                    max = arrayList.size() - 1;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Integer[] array = new Integer[arrayList.size()]; //too much typing to use arraylist. no, thank you
        array = arrayList.toArray(array);
        while (array[max] != 0) {
            int[] keepTrack = new int[array.length];
            keepTrack[max] = 1;
            while (array[max] != 0) {
                int target = 0;
                for (int i = 1; i < array.length; i++) {
                    if (keepTrack[i] == 0 && array[i] > array[target]) {
                        target = i;
                    }
                }
                if (array[target] == 0) {
                    System.out.println("no");
                    System.exit(0);
                }
                array[max] -= 1;
                array[target] -= 1;
                keepTrack[target] = 1;
            }
            for (int i = 0; i < array.length; i++) {
                if (array[i] > array[max]) {
                    max = i;
                }
            }
        }
        System.out.println("yes");
    }
}