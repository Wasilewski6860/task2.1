import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {

    LinkedListTest() throws Exception{

    }

    @Test
    void test1() {
        LinkedList list = new LinkedList();
        list.addFromHead(16);
        list.addFromHead(15);
        list.addFromHead(14);
        list.addFromTail(17);
        String string = list.toString();
        assertEquals(list, string);
    }

}