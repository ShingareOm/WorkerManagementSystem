// /**
//  * @Author om shingare
//  * @Date Date-Month-Year
//  * @Time Hr:Min AMPM
//  * @javax.swing
//  *
// */
// package Code.LoginClass;

// import javax.swing.*;
// import java.awt.*;
// import java.awt.image.ImageConsumer;
// import java.awt.image.ImagingOpException;
// import java.util.Scanner;

// public class LoginGUI {
//     public static void main(String[] args) {
//         Scanner s = new Scanner(System.in);
//         JFrame frame1 = new JFrame();
//         frame1.setDefaultCloseOperation(3);
//         frame1.setBounds(480, 30, 1000, 1000);
//         Container c = frame1.getContentPane();
//         c.setLayout(null);
//         // frame1.setResizable(false);
//         // JLabel image = new JLabel("",imageIcon,JLabel.CENTER);
//         // // frame1.add(frame1);
//         // // frame1.dispose();
//         // ImageIcon imageIcon = new ImageIcon("om.png");
//         // // image.setBounds(0,0,1000,1000);
//         // // fradd(image);
//         // frame1.add(image);
//         // // frame1.back

//         // JLabel lable = new JLabel(imageIcon);
//         // lable.setBounds(100,20,300,400);
//         // // image.setBounds(0,0,1000,1000);
//         // c.add(lable);

//         // javax.swing.ImageIcon imageIcon = new ImageIcon("om.png");

//         // JLabel label = new JLabel(imageIcon)
//         // label.setBounds(0, 500, 300, 300);

//         ImageIcon img2 = new ImageIcon("om.png");
//         JLabel l = new JLabel();
//         l.setIcon(img2);
//         Dimension size = l.getPreferredSize();
//         l.setVisible(true);
//         l.setBounds(50, 30, size.width, size.height);
//         // l.setBounds(0, 0, img2.getIconWidth(), img2.getIconHeight());
//         c.add(l);

//         // c.add(label);

//         // s.close();
//         frame1.setVisible(true);
//     }
// }

package Code.PersonWorkerCustomer;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.Container;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Random;
import java.util.StringTokenizer;

public class LoginGUI {

    static void homePageCusto() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(480, 100, 978, 658);
        // frame.setResizable(false);
        Container c = frame.getContentPane();
        c.setLayout(null);

        // System.out.println("Hey hey heyyyeye");

        JMenuBar menuBar = new JMenuBar();
        menuBar.setVisible(true);
        menuBar.setBounds(0, 0, 400, 100);

        frame.setVisible(true);

    }

    static void homePageMarchant() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(480, 100, 978, 658);
        // frame.setResizable(false);
        Container c = frame.getContentPane();
        c.setLayout(null);

        // public class PickAFile {
        // public static void main(String[] args){
        // JFileChooser chooser = new JFileChooser();
        // FileNameExtensionFilter filter = new FileNameExtensionFilter(
        // "JPG & GIF Images", "jpg", "gif", "png");
        // chooser.setFileFilter(filter);
        // int returnVal = chooser.showOpenDialog(null);
        // if (returnVal == JFileChooser.APPROVE_OPTION) {
        // System.out.println("You chose to open this file: " +
        // chooser.getSelectedFile().getPath());
        // }
        // }
        // }

        // file manager open karnya sathi.

        FileDialog dialog = new FileDialog((Frame) null, "Select File to Open");
        dialog.setResizable(true);
        dialog.setMode(FileDialog.LOAD);
        dialog.setVisible(true);
        String file = dialog.getDirectory() + dialog.getFile();
        dialog.dispose();

        // char arr[file.length()] = {};
        // char arr[1000];
        file = file.replace("\\", "\\\\");
        System.out.println(file + " chosen.");
        ImageIcon icon = new ImageIcon(file);
        JLabel label = new JLabel(icon);
        label.setBounds(790, 5, 170, 220);
        c.add(label);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        // JFrame frame = new JFrame();
        // frame.setBounds(480, 100, 1080, 608);
        // // frame.setBounds();
        // Container c = new JPanel();
        // JLabel label = new JLabel("SUBJECT ");
        // label.setIcon(new
        // ImageIcon("D:\\OMA\\JAVA\\WorkerManagementSystem\\src\\Code\\LoginClass\\back.png"));
        // label.setBounds(100,200,200,300);

        // c.setLayout(null);
        // c.add(label);
        // // panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        // frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // frame.add(c);

        // JLabel label2 = new JLabel("S4UBJECT ");
        // label2.setIcon(new
        // ImageIcon("D:\\OMA\\JAVA\\WorkerManagementSystem\\src\\Code\\LoginClass\\login.png"));
        // label2.setBounds(100,200,200,300);
        // c.setLayout(new GridBagLayout());
        // c.add(label2);

        // // frame.setSize(500, 300);

        // frame.setVisible(true);

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(480, 100, 978, 658);
        frame.setResizable(false);
        Container c = frame.getContentPane();
        c.setLayout(null);

        ImageIcon icon = new ImageIcon("D:\\OMA\\JAVA\\MicroProject\\src\\Code\\imageData\\login.png");
        JLabel label = new JLabel(icon);
        label.setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight());
        c.add(label);

        JTextField t1 = new JTextField("Mobile number");
        t1.select(0, "Mobile number".length());
        // t1.addActionListener(new ActionListener() {
        // public void actionPerformed(ActionEvent e) {
        // t1.select(0, "Mobile number".length());
        // // System.out.println("HEy hey hey.. yyeeyey");
        // }
        // });

        // t1.select(0, 13);
        // t1.sele

        // t1.
        t1.setBounds(600, 270, 190, 30);
        c.add(t1);
        // t1.
        t1.setVisible(true);

        JPasswordField t2 = new JPasswordField();
        // t2.selectAll();
        t2.setBounds(600, 330, 190, 30);
        // t2.setBorder(false);

        c.add(t2);
        t2.setVisible(true);
        // public void setOpacity(float opacity) {
        // this.opacity = opacity;
        // repaint();
        // }

        // MyJButton myJbtn = new MyJButton();
        // myJbtn.setOpacity(0.5);
        // myJbtn.repaint();

        // button.setOpaque(false);
        // button.setContentAreaFilled(false);
        // button.setBorderPainted(false);

        JButton b = new JButton("Login");
        b.setBounds(540, 448, 290, 50);
        b.setBackground(Color.LIGHT_GRAY);
        c.add(b);
        // b.setOpaque(true);
        b.setContentAreaFilled(false);
        // b.setBorderPainted(false);
        JCheckBox j1bBox = new JCheckBox();
        j1bBox.setBounds(580, 397, 20, 20);
        j1bBox.setBackground(Color.white);
        c.add(j1bBox);

        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                frame.dispose();
                if (j1bBox.isSelected())
                    homePageCusto();
                homePageMarchant();
                // System.out.println("HEy hey hey.. yyeeyey");
            }
        });

        frame.setVisible(true);
    }
}
