package Task2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        int num;
        Scanner input = new Scanner(System.in);
        System.out.print("Input number:");
        num = input.nextInt();

        List<Integer> numbers = new ArrayList<>();

        while (num / 10 != 0) {
            int a = num % 10;
            numbers.add(a + 1);
            num = num / 10;
            if (num / 10 == 0) {
                int b = num % 10;
                numbers.add(b + 1);
            }
        }

        for (int i = numbers.size()-1; i >=0 ; i--) {
            System.out.print(numbers.get(i));
        }
    }
}
