public class Board {

    private String topRow;
    private String middleRow;
    private String bottomRow;

    // Default constructor — initializes with coordinates
    public Board() {
        topRow = "(0,0)|(0,1)|(0,2)";
        middleRow = "(1,0)|(1,1)|(1,2)";
        bottomRow = "(2,0)|(2,1)|(2,2)";
    }

    // Getter and Setter for topRow
    public String getTopRow() {
        return topRow;
    }

    public void setTopRow(String topRow) {
        this.topRow = topRow;
    }

    // Getter and Setter for middleRow
    public String getMiddleRow() {
        return middleRow;
    }

    public void setMiddleRow(String middleRow) {
        this.middleRow = middleRow;
    }

    // Getter and Setter for bottomRow
    public String getBottomRow() {
        return bottomRow;
    }

    public void setBottomRow(String bottomRow) {
        this.bottomRow = bottomRow;
    }

    // Optional: method to check if a specific cell is taken
    public boolean isCellTaken(int row, int col) {
        String[] rows = { topRow, middleRow, bottomRow };
        String current = rows[row];
        // Cells are assumed to be in the format: (r,c) or contain a single number in that place
        char value = current.charAt(2 + (col * 6)); // approximate index for the number slot
        return Character.isDigit(value);
    }
}
