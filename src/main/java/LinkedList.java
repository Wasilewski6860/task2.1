class LinkedList {

    private Cell head;
    private Cell tail;


    public void addFromHead(double value) {
        Cell newHead = new Cell(value);

        addFromHead(newHead);
    }


    public void addFromHead(Cell cell) {

        if (head!=null){
            cell.setNextCell(head);
            cell.setPreviousCell(null);
            head.setPreviousCell(cell);
        }
        head=cell;
    }


    public void addFromTail(double value) {

        Cell newTail = new Cell(value);
        addFromTail(newTail);
    }


    public void addFromTail(Cell newTail) {

        if (tail != null) {
            newTail.setPreviousCell(tail);
            tail.setNextCell(newTail);
            tail = newTail;
        } else {
            head = newTail;
            tail = newTail;
        }
    }


    public int searchForNumOfLocalMax(){
        int answer =0;
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


    public double popHead() throws IllegalAccessException {
        double value = head.getValue();

        if (head != null){
            if (head.getNextCell() != null) {
                head = head.getNextCell();
                head.setPreviousCell(null);
            } else {
                head = null;
                tail = null;
            }
        }else {
            throw new IllegalAccessException();

        }

        return value;
    }



    public double popTail() throws IllegalAccessException {

        double value = tail.getValue();

        if (tail != null) {
            if (tail.getPreviousCell() != null) {
                tail = tail.getPreviousCell();
                tail.setNextCell(null);
            }

            else {
                head = null;
                tail = null;
            }
        } else {
            throw new IllegalAccessException();
        }


        return value;
    }


    public Cell findCell(double value) {

        Cell thisCell = head;

        while (thisCell != null) {

            if (thisCell.getValue() == value) {
                return thisCell;
            }

            else {
                thisCell = thisCell.getNextCell();
            }
        }

        return null;
    }


    public void insertAfter(Cell previousCell, double value) {

        if (previousCell != tail) {

            Cell helpCell = new Cell(value);
            helpCell.setPreviousCell(previousCell);
            helpCell.setNextCell(previousCell.getNextCell());

            previousCell.setNextCell(helpCell);
            helpCell.getNextCell().setPreviousCell(helpCell);
        }
        else {
            addFromTail(value);
        }
    }


    public void removeNode(Cell selectedCell) throws IllegalAccessException {

        if (selectedCell == tail) {
            popTail();
        }
        else if (selectedCell == head) {
            popHead();
        }
        else {
            Cell nextCell = selectedCell.getNextCell();
            Cell previousCell = selectedCell.getPreviousCell();

            previousCell.setNextCell(nextCell);
            nextCell.setPreviousCell(previousCell);
        }

    }

    public boolean isEmpty() {
        return head == null;
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
}




