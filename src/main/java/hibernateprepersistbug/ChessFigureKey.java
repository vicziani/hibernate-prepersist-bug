package hibernateprepersistbug;

import java.io.Serializable;
import java.util.Objects;

public class ChessFigureKey implements Serializable {
    private String columnLetter;
    private int rowNumber;

    public String getColumnLetter() {
        return columnLetter;
    }

    public void setColumnLetter(String columnLetter) {
        this.columnLetter = columnLetter;
    }

    public int getRowNumber() {
        return rowNumber;
    }

    public void setRowNumber(int rowNumber) {
        this.rowNumber = rowNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChessFigureKey that = (ChessFigureKey) o;
        return rowNumber == that.rowNumber && Objects.equals(columnLetter, that.columnLetter);
    }

    @Override
    public int hashCode() {
        return Objects.hash(columnLetter, rowNumber);
    }
}
