public class Main {

    public static void main(String [] args) throws IllegalAccessException {

        System.out.println("Проверочка" );
        LinkedList  list = new LinkedList();

        list.addFromTail(10);
        list.addFromTail(11);
        list.addFromTail(9);
        list.addFromTail(12);
        list.addFromTail(11);
        list.addFromTail(32);
        list.addFromTail(12);
        list.addFromTail(13);
        list.addFromTail(14);
        list.addFromTail(10);
        System.out.println(list.toString());
       list.removeCell(list.findCell(11));
        System.out.println(list.toString());
        System.out.println(list.searchForNumOfLocalMax());
        System.out.println(list.toString());

    }
}
