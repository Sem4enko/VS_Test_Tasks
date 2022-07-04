package Task1;

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Input your message:");
        String message = input.nextLine();

        System.out.println("Input the key:");
        Integer key = input.nextInt();

        if(message.isBlank()) {
            System.out.println("Sorry , but your message is empty , please try again");
        } else if( key<= 2) {
            System.out.println("Sorry , but your key is less or equal 2 , please try again");
        }else{

            System.out.println("Your string is represented in a three-rail system:" + "\n");

            String encodedString = encode(message, key);

            System.out.println("Encoded string: " + encodedString);

            System.out.println("Decoded string: " + decode(encodedString, key));

        }

    }

    static String encode(String string, Integer key) {
        String encodedMessage = "";

        boolean check = false;
        int j = 0;
        int row = key;
        int col = string.length();
        char[][] a = new char[row][col];

        for (int i = 0; i < col; i++) {
            if (j == 0 || j == key - 1) {
                check = !check;
            }

            a[j][i] = string.charAt(i);

            if (check) {
                j++;
            } else {
                j--;
            }
        }

        for (int i = 0; i < row; i++) {
            for (int k = 0; k < col; k++) {
                if (a[i][k] != 0) {
                    encodedMessage += a[i][k];
                }
            }
        }

        for (int i = 0; i < row; i++) {
            for (int k = 0; k < col; k++) {
                System.out.print(a[i][k] + " ");
            }
            System.out.println();
        }

        System.out.println();

        return encodedMessage;

    }

    static String decode(String string, Integer key) {
        String decodedMessage = "";

        boolean check = false;

        int j = 0;
        int row = key;
        int col = string.length();
        char[][] a = new char[row][col];



        for (int i = 0; i < col; i++) {
            if (j == 0 || j == key - 1) {
                check = !check;
            }

            a[j][i] = '*';

            if (check) {
                j++;
            } else {
                j--;
            }
        }


        int index = 0;
        check = false;
        for (int i = 0; i < row; i++) {
            for (int k = 0; k < col; k++) {
                if (a[i][k] == '*' && index < col) {
                    a[i][k] = string.charAt(index++);
                }
            }
        }

        j = 0;
        for (int i = 0; i < col; i++) {
            if (j == 0 || j == key - 1) {
                check = !check;
            }

            decodedMessage += a[j][i];


            if (check) {
                j++;
            } else {
                j--;
            }
        }

        System.out.println();
        return decodedMessage;
    }
}
