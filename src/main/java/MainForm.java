import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;

import static java.lang.System.out;

public class MainForm extends JFrame {
    private JPanel panel1;
    private JTable table;
    private JButton readFromFileButton;
    private JButton answerButton;
    private JTextField answerField;
    private JButton popTailButton;
    private JButton popFromHeadButton;
    private JButton addFromTailButton;
    private JButton addFromHeadButton;
    private LinkedList list = new LinkedList();

    public MainForm(){
        this.setTitle("ТАбличка");
        this.setContentPane(panel1);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();

        readFromFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileopen = new JFileChooser();
                int ret = fileopen.showDialog(null, "Открыть файл");

                if (ret == JFileChooser.APPROVE_OPTION) {

                    File file = fileopen.getSelectedFile();
                    String path = file.toString();
                    double []array = ru.vsu.baryshev.util.ArrayUtils.readDoubleArrayFromFile(path);
                    ru.vsu.baryshev.util.JTableUtils.writeArrayToJTable(table,array);
                    list=LinkedList.arrayToList(array);

                }

            }
        });

        answerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    out.println(ru.vsu.baryshev.util.JTableUtils.readDoubleArrayFromJTable(table).toString());
                    list=LinkedList.arrayToList(ru.vsu.baryshev.util.JTableUtils.readDoubleArrayFromJTable(table));
                } catch (ParseException ex) {
                    ex.printStackTrace();
                }
                answerField.setText("Максимумы "+list.searchForNumOfLocalMax() +" Минимумы "+list.searchForNumOfLocalMin());
            }
        });

        addFromTailButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    list = LinkedList.arrayToList(ru.vsu.baryshev.util.JTableUtils.readDoubleArrayFromJTable(table));

                } catch (ParseException ex) {
                    ex.printStackTrace();
                }
                list.addFromTail(0);
                double[] arr = LinkedList.listToArray(list);
                ru.vsu.baryshev.util.JTableUtils.writeArrayToJTable(table,arr);
            }
        });

        popTailButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    list = LinkedList.arrayToList(ru.vsu.baryshev.util.JTableUtils.readDoubleArrayFromJTable(table));

                } catch (ParseException ex) {
                    ex.printStackTrace();
                }
                list.popTail();
                double[] arr = LinkedList.listToArray(list);
                for (int i=0;i<arr.length;i++){
                    out.print(arr[i]+" ");
                }
                ru.vsu.baryshev.util.JTableUtils.writeArrayToJTable(table,arr);
            }
        });

        addFromHeadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    list = LinkedList.arrayToList(ru.vsu.baryshev.util.JTableUtils.readDoubleArrayFromJTable(table));
                    double[] array = ru.vsu.baryshev.util.JTableUtils.readDoubleArrayFromJTable(table);
                    for (int i=0;i<array.length;i++){
                        out.print(" "+array[i]);
                    }
                    out.println("Check of list "+list.toString());
                } catch (ParseException ex) {
                    ex.printStackTrace();
                }
                list.addFromHead(0);
                double[] arr = LinkedList.listToArray(list);

                for (int i=0;i<arr.length;i++){
                    out.print(arr[i]+" ");
                }
                ru.vsu.baryshev.util.JTableUtils.writeArrayToJTable(table,arr);
            }
        });

        popFromHeadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    list = LinkedList.arrayToList(ru.vsu.baryshev.util.JTableUtils.readDoubleArrayFromJTable(table));
                    double[] array = ru.vsu.baryshev.util.JTableUtils.readDoubleArrayFromJTable(table);
                    for (int i=0;i<array.length;i++){
                        out.print(" "+array[i]);
                    }
                    out.println("Check of list "+list.toString());

                } catch (ParseException ex) {
                    ex.printStackTrace();
                }

                try {
                    list.popHead();
                } catch (IllegalAccessException ex) {
                    ex.printStackTrace();
                }
                double[] arr = LinkedList.listToArray(list);

                ru.vsu.baryshev.util.JTableUtils.writeArrayToJTable(table,arr);
            }
        });

    }
}
