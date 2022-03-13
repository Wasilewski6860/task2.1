
class Cell {

    private double value;

    private Cell nextCell;
    private Cell previousCell;

    public Cell(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    public Cell getNextCell() {
        return nextCell;
    }

    public void setNextCell(Cell nextCell) {
        this.nextCell = nextCell;
    }

    public Cell getPreviousCell() {
        return previousCell;
    }

    public void setPreviousCell(Cell previousCell) {
        this.previousCell = previousCell;
    }

}

