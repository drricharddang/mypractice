package working;

import javax.swing.*;

public class SwingTools extends JFrame {
    SwingTools() {
        super("My First Swing App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);
        setVisible(true);
    }
}

//public class Main{
//    public static void main(String[] args) throws Exception {
//        Runnable initFrame = new Runnable() {
//            @Override
//            public void run() {
//                new SwingTools();
//            }
//        };
//
//        SwingUtilities.invokeAndWait(initFrame);
//    }
//}