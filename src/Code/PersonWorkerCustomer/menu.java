package Code.PersonWorkerCustomer;

import java.awt.*;
import java.awt.Color;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.UIManager;

public class menu {
    menu() {
        // Frame f = new Frame("Menu and MenuItem Example");
        // MenuBar mb = new MenuBar();
        // // mb.setBounds();
        // Menu menu = new Menu("Menu");
        // Menu submenu = new Menu("Sub Menu");
        // MenuItem i1 = new MenuItem("Item 1");
        // MenuItem i2 = new MenuItem("Item 2");
        // MenuItem i3 = new MenuItem("Item 3");
        // MenuItem i4 = new MenuItem("Item 4");
        // MenuItem i5 = new MenuItem("Item 5");
        // menu.add(i1);
        // menu.add(i2);
        // menu.add(i3);
        // submenu.add(i4);
        // submenu.add(i5);
        // menu.add(submenu);
        // mb.add(menu);
        // f.setMenuBar(mb);
        // f.setSize(400, 400);
        // f.setLayout(null);
        // f.setVisible(true);

        JFrame frame = new JFrame("MenuBar Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JMenuBar menuBar = new JMenuBar();
        UIManager.put("MenuBar.background", Color.green);
        JMenu fileMenu = new JMenu("File");
        // fileMenu.setMnemonic(KeyEvent.VK_F);
        menuBar.add(fileMenu);
        JMenuItem menuItem1 = new JMenuItem("New");
        fileMenu.add(menuItem1);
        JMenuItem menuItem2 = new JMenuItem("Open File", KeyEvent.VK_O);
        fileMenu.add(menuItem2);
        JMenu editMenu = new JMenu("Edit");
        // editMenu.setMnemonic(KeyEvent.VK_E);
        menuBar.add(editMenu);
        JMenuItem menuItem3 = new JMenuItem("Cut", KeyEvent.VK_C);
        editMenu.add(menuItem3);
        JMenu searchMenu = new JMenu("Search");
        // searchMenu.setMnemonic(KeyEvent.VK_S);
        menuBar.add(searchMenu);
        JMenu projectMenu = new JMenu("Project");
        // projectMenu.setMnemonic(KeyEvent.VK_P);
        menuBar.add(projectMenu);
        JMenu runMenu = new JMenu("Run");
        // runMenu.setMnemonic(KeyEvent.VK_R);
        menuBar.add(runMenu);
        menuBar.revalidate();
        frame.setJMenuBar(menuBar);
        frame.setSize(550, 350);
        frame.setVisible(true);
    }

    public static void main(String args[]) {
        new menu();
    }
}