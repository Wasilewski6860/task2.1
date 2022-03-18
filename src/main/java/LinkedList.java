import com.sun.scenario.effect.impl.sw.java.JSWBlend_SRC_OUTPeer;

import static java.lang.System.out;
import static java.lang.System.setOut;

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


    public int getSize(){
        int size = 0;
        Cell thisCell = this.head;

        while( thisCell != null){
            size++;
            thisCell = thisCell.getNextCell();
        }
        System.out.println(size);
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

    public void addAllFromTail(LinkedList x1){
        Cell thisCell = x1.head;


        while( thisCell != null){
            this.addFromTail(thisCell.getValue());
            thisCell = thisCell.getNextCell();
        }
    }


    public static LinkedList arrayToList(double[] array){
        out.println("Проверка входного массива в arrayToList");
        for (int i=0;i<array.length;i++){
            out.print(array[i]+" ");
        }
        out.println();
        LinkedList list = new LinkedList();
        for (int i=0; i< array.length;i++){
            list.addFromTail(array[i]);
        }
        return list;
    }


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
        answer += " " + thisCell.getValue();
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

        while  (thisCell.getNextCell() != null ){

            if ((thisCell.getValue()>thisCell.getNextCell().getValue()) && (thisCell.getValue()>thisCell.getPreviousCell().getValue())){
                answer++;
                System.out.println("Нашли Лок.Максимум " + thisCell.getPreviousCell().getValue()+" , "+thisCell.getNextCell().getValue()+" < "+thisCell.getValue());
            }
            thisCell = thisCell.getNextCell();
        }
        return answer;

    }

    public double searchForNumOfLocalMin(){
        double answer =0;
        Cell thisCell = this.head.getNextCell();

        while  (thisCell.getNextCell() != null){

            if ((thisCell.getValue()<thisCell.getNextCell().getValue()) && (thisCell.getValue()<thisCell.getPreviousCell().getValue())){
                answer++;
                System.out.println("Нашли Лок.Мин " + thisCell.getPreviousCell().getValue()+" , "+thisCell.getNextCell().getValue()+" > "+thisCell.getValue());
            }
            thisCell = thisCell.getNextCell();
        }

        return answer;
    }

}