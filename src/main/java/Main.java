import static java.lang.System.out;

public class Main {

    public static void main(String [] args) throws IllegalAccessException {

        System.out.println("Проверочка" );
        LinkedList  list = new LinkedList();

        list.addFromHead(55);
        list.addFromTail(10);
        list.addFromTail(50);
        list.addFromTail(30);
        list.addFromTail(40);
        list.addFromTail(50);

        out.println("Start List: "+list.toString());

        list.addFromHead(10);
//       list.popTail();
        out.println("Push 10 in head: "+list.toString());
        list.popTail();
        out.println("List with popped tail: "+list.toString());
        list.removeCell(list.findCell(55));
        out.println("list with removed 55: "+list.toString());
        list.popHead();
        out.println("List with popped head: "+list.toString());

        out.println();
        out.println(list.searchForNumOfLocalMax());
        out.println();

    }
}
