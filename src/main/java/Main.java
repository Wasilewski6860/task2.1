import java.util.Locale;

import static java.lang.System.out;

public class Main {

    public static void main(String [] args) throws IllegalAccessException {
        Locale.setDefault(Locale.ENGLISH);

int[] array = new int[3];
        out.println(array.length);
for (int i=0;i<array.length;i++){
    array[i]=0;
    out.print(array[i]+" ");
}

LinkedList list = new LinkedList();
list.addFromTail(10);
        list.addFromTail(11);
        list.addFromTail(12);
        out.println(list.getSize());


        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new MainForm().setVisible(true);
            }
        });

    }
}
