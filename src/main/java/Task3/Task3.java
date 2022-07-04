package Task3;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Task3 {
    public static void main(String[] args) {

        var validSudoku = List.of(
                List.of(7, 8, 4, 1, 5, 9, 3, 2, 6),
                List.of(5, 3, 9, 6, 7, 2, 8, 4, 1),
                List.of(6, 1, 2, 4, 3, 8, 7, 5, 9),
                List.of(9, 2, 8, 7, 1, 5, 4, 6, 3),
                List.of(3, 5, 7, 8, 4, 6, 1, 9, 2),
                List.of(4, 6, 1, 9, 2, 3, 5, 8, 7),
                List.of(8, 7, 6, 3, 9, 4, 2, 1, 5),
                List.of(2, 4, 3, 5, 6, 1, 9, 7, 8),
                List.of(1, 9, 5, 2, 8, 7, 6, 3, 4));


        System.out.println("checkSudoku(list) = " + checkSudoku(validSudoku));

    }

    public static boolean checkSudoku(List<List<Integer>> sudoku) {
        return checkSudokuSizes(sudoku) && checkRows(sudoku) && checkColumns(sudoku);
    }

    private static boolean checkSudokuSizes(List<List<Integer>> sudoku) {
        int n = sudoku.size();
        if (!checkPerfectSquare(n) || n <= 1) {
            return false;
        }
        for (List<Integer> l : sudoku) {
            if (l.size() != n)
                return false;
        }
        return true;
    }


    private static boolean checkRows(List<List<Integer>> sudoku) {
        List<List<Integer>> rows = new ArrayList<>();
        for (int i = 0; i < sudoku.size(); i++) {
            int finalI = i;
            rows.add(sudoku.stream().map(e -> e.get(finalI)).collect(Collectors.toList()));
        }
        return rows.stream().allMatch(Task3::listContains1toN);

    }

    private static boolean checkColumns(List<List<Integer>> sudoku) {
        return sudoku.stream().allMatch(Task3::listContains1toN);
    }

    private static boolean listContains1toN(List<Integer> list) {
        return list.stream()
                .filter(el -> el >= 1 && el <= list.size())
                .distinct()
                .count() == list.size();
    }


    static boolean checkPerfectSquare(double number) {
        double sqrt = Math.sqrt(number);
        return ((sqrt - Math.floor(sqrt)) == 0);
    }

}





