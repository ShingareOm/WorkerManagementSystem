package Code.PersonWorkerCustomer;
import java.awt.*;

public class Test {

    Test() {
        Frame frame = new Frame();

        TextArea t1 = new TextArea("This is text area 1.\n It has scrollbars\n on both sides.");
        TextArea t2 = new TextArea("This is text area 2.\n It has horizontal scrollbar only.", 2, 10,
                TextArea.SCROLLBARS_HORIZONTAL_ONLY);
        TextArea t3 = new TextArea();

        t3.setText("Adding new Text...");

        t1.setBounds(50, 50, 100, 60);
        t2.setBounds(50, 150, 100, 60);
        t3.setBounds(50, 250, 100, 50);

        frame.setLayout(null);
        frame.setVisible(true);
        frame.setSize(300, 300);

        t3.append("\nRows in t1 " + t1.getRows() + "\nColumns in t1 " + t1.getColumns());

        frame.add(t1);
        frame.add(t2);
        frame.add(t3);

    }

    public static void main(String[] args) {
        Test ob = new Test();

    }
}