
class LinkedList{

    private class Cell {

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

    private Cell head;
    private Cell tail;

    public void addFromHead(double value){
        Cell tempCell = new Cell(value);

        if (this.head !=null){
            head.setPreviousCell(tempCell);
            tempCell.setNextCell(head);
            head=tempCell;
        }else {
            head=tail=tempCell;
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

    public double popHead() throws NullPointerException {

        if (head == null) {
            throw new NullPointerException();
        }

        double value = head.getValue();

        if (head.getNextCell() != null) {
            head = head.getNextCell();
            head.setPreviousCell(null);
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

        Cell tempCell = head;
        Cell answerCell = null;

        while (tempCell != null) {
            if (Math.abs(tempCell.getValue() - searchingValue) <= 1E-5) {
                answerCell=tempCell;
                tempCell = tempCell.getNextCell();
            }
            else {
                tempCell = tempCell.getNextCell();
            }
        }

        return answerCell;
    }

    public String toString(){
        Cell tempCell = this.head;
        String answer = new String();

        while(tempCell.getNextCell() !=null ){
            answer = answer + " " + tempCell.getValue();

            tempCell = tempCell.getNextCell();
        }
        answer += " " + tempCell.getValue();
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

    public int searchForNumOfLocalMax(){

        int answer =0;
        if (this.getSize() !=1) {
            Cell tempCell = this.head.getNextCell();

            while (tempCell.getNextCell() != null) {

                if ((tempCell.getValue() > tempCell.getNextCell().getValue()) && (tempCell.getValue() > tempCell.getPreviousCell().getValue())) {
                    answer++;
                }
                tempCell = tempCell.getNextCell();
            }
        }
        return answer;

    }

    public int searchForNumOfLocalMin(){
        int answer =0;

        if (this.getSize()!=1) {
            Cell thisCell = this.head.getNextCell();

            while (thisCell.getNextCell() != null ) {

                if ((thisCell.getValue() < thisCell.getNextCell().getValue()) && (thisCell.getValue() < thisCell.getPreviousCell().getValue())) {
                    answer++;

                }
                thisCell = thisCell.getNextCell();
            }
        }
        return answer;
    }

    public int getSize(){
        int size = 0;
        Cell thisCell = this.head;

        while( thisCell != null){
            size++;
            thisCell = thisCell.getNextCell();
        }
        return size;
    }






    public static double[] listToArray(LinkedList list){
        double[] array = new double[list.getSize()];
        Cell thisCell = list.head;

        int i=0;
        while( thisCell != null){
            array[i]= thisCell.getValue();
            i++;
            thisCell = thisCell.getNextCell();
        }
        return array;
    }

    public static LinkedList arrayToList(double[] array){

        LinkedList list = new LinkedList();
        for (int i=0; i< array.length;i++){
            list.addFromTail(array[i]);
        }
        return list;
    }

}