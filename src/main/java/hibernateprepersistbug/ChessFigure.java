package hibernateprepersistbug;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@IdClass(ChessFigureKey.class)
public class ChessFigure implements Serializable {

    @Id
    private String columnLetter;
    @Id
    private int rowNumber;

    private String piece;

    private int counter;

    @PrePersist
    void prePersist() {
        System.out.println("PrePersist");
        counter++;
    }
    @PostPersist
    void postPersist() {
        System.out.println("PostPersist");
        counter++;
    }


    public ChessFigure() {
    }

    public ChessFigure(String columnLetter, int rowNumber, String piece) {
        this.columnLetter = columnLetter;
        this.rowNumber = rowNumber;
        this.piece = piece;
    }

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

    public String getPiece() {
        return piece;
    }

    public void setPiece(String piece) {
        this.piece = piece;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChessFigure that = (ChessFigure) o;
        return rowNumber == that.rowNumber && Objects.equals(columnLetter, that.columnLetter) && Objects.equals(piece, that.piece);
    }

    @Override
    public int hashCode() {
        return Objects.hash(columnLetter, rowNumber, piece);
    }

}
