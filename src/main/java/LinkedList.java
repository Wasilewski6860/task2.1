class LinkedList{
    private Cell head;
    private Cell tail;


    public void addFromHead(double value){
        Cell helpCell = new Cell(value);

        if (this.head !=null){
            head.setPreviousCell(helpCell);
            helpCell.setNextCell(head);
            head=helpCell;
        }else {
            head=tail=helpCell;
        }

    }

    public void addFromTail(double value){
        Cell helpCell = new Cell(value);

        if (this.tail != null){
            tail.setNextCell(helpCell);
            helpCell.setPreviousCell(tail);
            tail = helpCell;
        }else {
            head=tail=helpCell;
        }
    }

    public double popHead() throws IllegalAccessException {

        if (head == null) {
            throw new IllegalArgumentException();
        }

        double value = head.getValue();

        if (head.getNextCell() != null) {
            head.setPreviousCell(null);
            head = head.getNextCell();
        }
        else {
            head = tail = null;
        }

        return value;
    }

    public double popTail(){

        if (tail == null) {
            throw new IllegalArgumentException();
        }

        double value = tail.getValue();

        if (tail.getPreviousCell() != null){
            tail=tail.getPreviousCell();
            tail.setNextCell(null);
        }
        else {
            head=tail=null;
        }

        return value;

    }

    public Cell findCell(double searchingValue){

        Cell thisCell = head;
        Cell helpCell = null;

        while (thisCell != null) {
            if (Math.abs(thisCell.getValue() - searchingValue) <= 1E-5) {
                helpCell=thisCell;
                thisCell = thisCell.getNextCell();
            }
            else {
                thisCell = thisCell.getNextCell();
            }
        }

        return helpCell;
    }

    public String toString(){
        Cell thisCell = this.head;
        String answer = new String();

        while(thisCell.getNextCell() !=null && thisCell != null){
            answer = answer + " " + thisCell.getValue();

            thisCell = thisCell.getNextCell();
        }
        return answer;
    }

    public void removeCell(Cell removingCell) throws IllegalAccessException {
        if (removingCell.equals(this.head)){
            popHead();
        }else if (removingCell.equals(this.tail)){
            popTail();
        }
        else {
            Cell previousCell = removingCell.getPreviousCell();
            Cell nextCell = removingCell.getNextCell();

            nextCell.setPreviousCell(previousCell);
            previousCell.setNextCell(nextCell);
        }
    }

    public double searchForNumOfLocalMax(){
        double answer =0;
        Cell thisCell = this.head;

        while  (thisCell.getNextCell()!=null ){

            if ((thisCell.getValue()>thisCell.getNextCell().getValue()) && (thisCell.getValue()>thisCell.getPreviousCell().getValue())){
                answer++;
                System.out.println("Нашли Лок.Максимум " + thisCell.getPreviousCell().getValue()+" , "+thisCell.getNextCell().getValue()+" < "+thisCell.getValue());
            }
            thisCell = thisCell.getNextCell();
        }
        return answer;
    }

}