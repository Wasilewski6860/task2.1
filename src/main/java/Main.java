import java.util.Locale;

import static java.lang.System.out;

public class Main {

    public static void main(String [] args) throws IllegalAccessException {
        Locale.setDefault(Locale.ENGLISH);

        double[] array = new double[3];

        out.println("Длина массива"+array.length);
        out.println("Массив");
        for (int i=0;i<array.length;i++){
             array[i]=0;
             out.print(array[i]+" ");
         }

    LinkedList list = new LinkedList();
    list.addFromTail(10);
        list.addFromTail(11);
        list.addFromTail(12);
        list.addFromTail(111);

        array=LinkedList.listToArray(list);
        out.println();

        out.println("РАзмер списка"+list.getSize());
        out.println("Обновленный массив");
        for (int i=0;i<array.length;i++){
            out.print(array[i]+" ");
        }

        list = LinkedList.arrayToList(array);
        out.println("Обновленный список");
        out.println(list.toString());

        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new MainForm().setVisible(true);
            }
        });

    }
}
