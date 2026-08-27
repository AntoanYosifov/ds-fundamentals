import tree.matrix.TheMatrix;

public class Main {
    public static void main(String[] args) {

        char[][] matrix = {
                {'a', 'a', 'a'},
                {'a', 'a', 'a'},
                {'a', 'b', 'a'},
                {'a', 'b', 'a'},
                {'a', 'b', 'a'}
        };
        char fillChar = 'x';
        int startRow = 0;
        int startCol = 0;

        TheMatrix theMatrix = new TheMatrix(matrix, fillChar, startRow, startCol);

        theMatrix.solve();

        System.out.println("Solved: ");

        System.out.println(theMatrix.toOutputString());

        String expectedStr =
                "xxx\r\n" +
                        "xxx\r\n" +
                        "xbx\r\n" +
                        "xbx\r\n" +
                        "xbx";

        System.out.println("Expected: ");
        System.out.println(expectedStr);

        System.out.println(theMatrix.toOutputString().equals(expectedStr));

    }
}
