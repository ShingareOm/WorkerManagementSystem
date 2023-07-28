package Code.PersonWorkerCustomer;

import java.awt.Color;
import java.awt.Container;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.function.BiPredicate;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.html.parser.Element;
import javax.xml.transform.Source;

import org.ietf.jgss.MessageProp;

import Code.LoginClass.Person;
import Code.LoginClass.Worker;

class Person {
    public boolean isLogin;
    public String name, address, surname, mobile, pass, email;
    public String age;
    // Date d;
    public static int i = 0;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void createAccount() {
        Scanner sc = new Scanner(System.in);
        String temp;
        String againPass1;
        String againPass2;

        System.out.println("Enter the first name");
        setName(sc.nextLine());
        System.out.println("Enter the last name");
        setSurname(sc.nextLine());
        System.out.println("Enter the mail ID");
        setEmail(sc.nextLine());

        System.out.println("Enter the address ");
        setAddress(sc.nextLine());

        System.out.println("Enter the mobile number ");
        setMobile(sc.nextLine());

        System.out.println("Enter the password ");
        againPass1 = sc.nextLine();
        System.out.println("Enter the password again ");
        againPass2 = sc.nextLine();
        if (againPass1.equals(againPass2)) {
            setPass(againPass1);
            System.out.println("Done !");
            i++;
        } else {
            System.out.println("Enter the pass again ");
            return;
        }
    }
}

class Worker extends Person {
    public String workType;
    public Integer experience;
    public String discription;
    public LinkedList nowLinkedListCustomer;
    public LinkedList oldLinkedListCustomer;
    public Double rating;
    public String timeFree;
    public static int i = 0;

    public Worker() {
        nowLinkedListCustomer = new LinkedList<>();
        oldLinkedListCustomer = new LinkedList<>();
    }

    public String getWorkType() {
        return workType;
    }

    public void setWorkType(String workType) {
        this.workType = workType;
    }

    public Integer getExperience() {
        return experience;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public LinkedList getNowLinkedListCustomer() {
        return nowLinkedListCustomer;
    }

    public void setNowLinkedListCustomer(LinkedList nowLinkedListCustomer) {
        this.nowLinkedListCustomer = nowLinkedListCustomer;
    }

    public LinkedList getOldLinkedListCustomer() {
        return oldLinkedListCustomer;
    }

    public void setOldLinkedListCustomer(LinkedList oldLinkedListCustomer) {
        this.oldLinkedListCustomer = oldLinkedListCustomer;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String getTimeFree() {
        return timeFree;
    }

    public void setTimeFree(String timeFree) {
        this.timeFree = timeFree;
    }

    @Override
    public void createAccount() {
        Scanner sc = new Scanner(System.in);
        super.createAccount();
        System.out.println("Enter the type of work");
        setWorkType(sc.nextLine());

        System.out.println("Enter the exprience");
        setExperience(sc.nextInt());

        System.out.println("Enter discription ");
        setDiscription(sc.nextLine());

        System.out.println("Enter the free time. ");
        setTimeFree(sc.next(timeFree));
        i++;
    }

}

class Customer extends Person {
    LinkedList<Worker> NewAllocatedTask;
    LinkedList<Worker> oldALocatedLTask;

    public Customer() {
        NewAllocatedTask = new LinkedList<>();
        this.oldALocatedLTask = new LinkedList<>();
    }

    @Override
    public void createAccount() {
        super.createAccount();
        isLogin = true;
    }

    public void showHistory() {
        for (int i = 0; i < oldALocatedLTask.size(); i++) {
            System.out.println(oldALocatedLTask.get(i).name + " and work is " + oldALocatedLTask.get(i).workType);
        }
    }

    public void showNewTasks() {
        for (int i = 0; i < oldALocatedLTask.size(); i++) {
            System.out.println(NewAllocatedTask.get(i).name + " and work is " + NewAllocatedTask.get(i).workType);
        }
    }

    public void deleteAccount() {

    }

    // for searching worker !
    public void searchWorker(LinkedList<Worker> linkedListWorker) {

        Scanner s = new Scanner(System.in);

        // DISPLAY THIS !
        LinkedList<Worker> TemplinkedListWorker = new LinkedList<>();

        String workType;
        double rating = 0.0d;
        boolean checkRatingBox = false;
        int i = 0;
        boolean isHere = false;
        System.out.println("Enter the workType you want");
        if (checkRatingBox) {
            System.out.println("Enter the rating ");
            rating = s.nextDouble();
        }
        workType = s.nextLine();
        for (i = 0; i < linkedListWorker.size(); i++) {
            if (checkRatingBox) {
                if ((linkedListWorker.get(i).workType.equalsIgnoreCase(workType)
                        || linkedListWorker.get(i).discription.contains(workType))
                        && linkedListWorker.get(i).rating > rating) {
                    isHere = true;
                    TemplinkedListWorker.add(linkedListWorker.get(i));
                }
            } else if (linkedListWorker.get(i).workType.equalsIgnoreCase(workType)
                    || linkedListWorker.get(i).discription.contains(workType)) {
                isHere = true;
                TemplinkedListWorker.add(linkedListWorker.get(i));

                break;
            }
        }
        if (!isHere) {
            System.out.println("Not present work !");
        } else {
            System.out.println("showing result ");

            // here display the list .. in this method !
        }
    }
}

public class CleanLogin {
    public static boolean isNumber(String str) {

        boolean isNumber = true;
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                isNumber = false;
                break;
            }
        }
        return isNumber;
    }

    public static void homePageCusto() {
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

    public static void homePageMarchant() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(480, 100, 978, 658);
        Container c = frame.getContentPane();
        c.setLayout(null);

        // file manager open karnya sathi.

        // FileDialog dialog = new FileDialog((Frame) null, "Select File to Open");
        // dialog.setResizable(true);
        // dialog.setMode(FileDialog.LOAD);
        // dialog.setVisible(true);
        // String file = dialog.getDirectory() + dialog.getFile();
        // dialog.dispose();

        // file = file.replace("\\", "\\\\");
        // System.out.println(file + " chosen.");
        // ImageIcon icon = new ImageIcon(file);
        // JLabel label = new JLabel(icon);
        // label.setBounds(780, 0, 170, 220);
        // c.add(label);

        MenuBar mb = new MenuBar();
        // mb.setBounds();
        Menu menu = new Menu("Menu");
        Menu submenu = new Menu("Sub Menu");
        MenuItem i1 = new MenuItem("Item 1");
        MenuItem i2 = new MenuItem("Item 2");
        MenuItem i3 = new MenuItem("Item 3");
        MenuItem i4 = new MenuItem("Item 4");
        MenuItem i5 = new MenuItem("Item 5");
        menu.add(i1);
        menu.add(i2);
        menu.add(i3);
        submenu.add(i4);
        submenu.add(i5);
        menu.add(submenu);

        Menu menu2 = new Menu("login");
        mb.add(menu2);

        mb.add(menu);
        frame.setMenuBar(mb);
        frame.setLayout(null);

        frame.setVisible(true);

        // String args[] = {};

        // main(args);
    }

    public static void signup04(LinkedList<Worker> linkedListWorker) {

        JFrame frame = new JFrame();
        sizee(linkedListWorker);
        // start();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(480, 100, 978, 658);
        frame.setResizable(false);
        Container c = frame.getContentPane();
        c.setLayout(null);

        ImageIcon icon2 = new ImageIcon("D:\\OMA\\JAVA\\MicroProject\\src\\imageData\\signup04.png");
        JLabel label1 = new JLabel(icon2);
        label1.setBounds(290, 50, icon2.getIconWidth(), icon2.getIconHeight());
        c.add(label1);

        // ImageIcon icon = new
        // ImageIcon("D:\\OMA\\JAVA\\MicroProject\\src\\imageData\\signupback.png");
        ImageIcon icon = new ImageIcon("D:\\OMA\\JAVA\\MicroProject\\src\\imageData\\signupback.png");
        JLabel label = new JLabel(icon);
        label.setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight());
        c.add(label);

        JButton b = new JButton("next");
        b.setBounds(467, 420, 108, 47);
        b.setBackground(Color.LIGHT_GRAY);
        c.add(b);
        b.setContentAreaFilled(false);

        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                String a[] = {};
                main(a);

            }
        });

        JTextArea t1 = new JTextArea("Email ID");
        t1.setBorder(BorderFactory.createLineBorder(Color.white));
        t1.selectAll();
        t1.setBounds(370, 228, 190, 100);
        // t1.setVisible(true);
        c.add(t1);

        frame.setVisible(true);

    }

    public static void signup03(LinkedList<Worker> linkedListWorker, LinkedList<Person> linkedListPerson,
            Boolean isWorker, String email, String mobile, String pass) {
        // linkedListPerson.get(0) = new Person();

        // System.out.println("heyyyy !");
        Worker worker = new Worker();
        Person person = new Person();
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(480, 100, 978, 658);
        frame.setResizable(false);
        Container c = frame.getContentPane();
        c.setLayout(null);

        ImageIcon icon2 = new ImageIcon("D:\\OMA\\JAVA\\MicroProject\\src\\imageData\\signup03.png");
        JLabel label1 = new JLabel(icon2);
        label1.setBounds(290, 50, icon2.getIconWidth(), icon2.getIconHeight());
        c.add(label1);

        ImageIcon icon = new ImageIcon("D:\\OMA\\JAVA\\MicroProject\\src\\imageData\\signupback.png");
        JLabel label = new JLabel(icon);
        label.setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight());
        c.add(label);

        JButton b = new JButton("next");
        b.setBounds(534, 553, 91, 47);
        b.setBackground(Color.LIGHT_GRAY);
        c.add(b);
        b.setContentAreaFilled(false);

        JButton b2 = new JButton("prev");
        b2.setBounds(390, 553, 130, 47);
        b2.setBackground(Color.LIGHT_GRAY);
        c.add(b2);
        b2.setContentAreaFilled(false);

        JTextField t1 = new JTextField("First Name");
        t1.setBorder(BorderFactory.createLineBorder(Color.white));
        t1.selectAll();
        t1.setBounds(370, 250, 190, 30);
        c.add(t1);

        JTextField t2 = new JTextField("Last Name");
        t2.setBorder(BorderFactory.createLineBorder(Color.white));
        t2.selectAll();
        t2.setBounds(370, 320, 190, 30);
        c.add(t2);

        // System.out.println(isWorker);
        JTextField t3;
        if (isWorker) {
            t3 = new JTextField("WorkType");
        } else {
            // t3.setName("Age");
            t3 = new JTextField("Age");

        }
        t3.setBorder(BorderFactory.createLineBorder(Color.white));
        t3.selectAll();
        t3.setBounds(370, 390, 190, 30);
        c.add(t3);

        JTextArea a = new JTextArea("Address");
        a.selectAll();
        a.setBounds(370, 460, 190, 30);
        c.add(a);

        if (isWorker) {
            
            worker.email = email;
            worker.address = a.getText();
            worker.mobile = mobile;
            worker.pass = pass;
            worker.name = t1.getText();
            worker.workType = t3.getText();

            linkedListWorker.add(worker);
            b.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    frame.dispose();
                    signup04(linkedListWorker);
                }
            });

        }

        else {

            person.email = email;
            person.address = a.getText();
            person.mobile = mobile;
            person.pass = pass;
            person.name = t1.getText();
            person.age = t3.getText();

            linkedListPerson.add(person);
            b.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e) {
                    frame.dispose();
                    String s[] = { "13", "23" };
                    main(s);
                }
            });
        }

        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                signup02(pass, mobile, linkedListWorker,
                        linkedListPerson);
            }
        });

        frame.setVisible(true);

        // return icon;
    }

    public static void signup02(String pass, String mobileNum, LinkedList<Worker> linkedListWorker,
            LinkedList<Person> linkedListPerson) {

        JFrame frame = new JFrame();
        // Worker worker = new Worker();
        Boolean isWorker = false;

        // GUI
        // start();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(480, 100, 978, 658);
        frame.setResizable(false);
        Container c = frame.getContentPane();
        c.setLayout(null);

        ImageIcon icon2 = new ImageIcon("D:\\OMA\\JAVA\\MicroProject\\src\\imageData\\signup02.png");
        JLabel label1 = new JLabel(icon2);
        label1.setBounds(290, 50, icon2.getIconWidth(), icon2.getIconHeight());
        c.add(label1);

        JCheckBox j1bBox = new JCheckBox();
        j1bBox.setBounds(380, 333, 20, 20);
        j1bBox.setBackground(Color.white);
        c.add(j1bBox);

        // ImageIcon icon = new
        // ImageIcon("D:\\OMA\\JAVA\\MicroProject\\src\\imageData\\signupback.png");
        ImageIcon icon = new ImageIcon("D:\\OMA\\JAVA\\MicroProject\\src\\imageData\\signupback.png");
        JLabel label = new JLabel(icon);
        label.setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight());
        c.add(label);

        JButton b = new JButton("next");
        b.setBounds(514, 458, 128, 47);
        b.setBackground(Color.LIGHT_GRAY);
        c.add(b);
        b.setContentAreaFilled(false);

        JButton b2 = new JButton("prev");
        b2.setBounds(374, 458, 128, 47);
        b2.setBackground(Color.LIGHT_GRAY);
        c.add(b2);
        b2.setContentAreaFilled(false);

        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                signup01(linkedListWorker, linkedListPerson);

            }
        });

        JTextField t1 = new JTextField("Email ID");
        t1.setBorder(BorderFactory.createLineBorder(Color.white));
        t1.selectAll();
        t1.setBounds(370, 248, 190, 30);
        // t1.setVisible(true);
        c.add(t1);
        // t1.setText(pass + " " + mobileNum);

        // worker.mobile = mobileNum;
        // worker.

        // if
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Boolean isWorker = false;
                if (j1bBox.isSelected()) {
                    isWorker = true;
                } else {
                    isWorker = false;
                }
                // System.out.println(j1bBox);
                frame.dispose();

                String email = "";
                email = t1.getText();
                signup03(linkedListWorker, linkedListPerson, isWorker, email, mobileNum, pass);

            }
        });

        frame.setVisible(true);

    }

    public static void signup01(LinkedList<Worker> linkedListWorker, LinkedList<Person> linkedListPerson) {

        // NO GUI

        String mobileNumber = "null";
        String passWord = "pass";

        // GUI
        // MessageProp me = new MessageProp();
        System.out.println(linkedListPerson.size());
        JFrame frame = new JFrame();
        // start();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(480, 100, 978, 658);
        frame.setResizable(false);
        Container c = frame.getContentPane();
        c.setLayout(null);

        ImageIcon icon2 = new ImageIcon("D:\\OMA\\JAVA\\MicroProject\\src\\imageData\\SignUp01.png");
        JLabel label1 = new JLabel(icon2);
        label1.setBounds(290, 50, icon2.getIconWidth(), icon2.getIconHeight());
        c.add(label1);

        ImageIcon icon = new ImageIcon("D:\\OMA\\JAVA\\MicroProject\\src\\imageData\\signupback.png");
        JLabel label = new JLabel(icon);
        label.setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight());
        c.add(label);

        JButton b = new JButton("next");
        b.setBounds(447, 458, 125, 50);
        b.setBackground(Color.LIGHT_GRAY);
        c.add(b);
        // b.setOpaque(true);

        b.setContentAreaFilled(false);

        JTextField t1 = new JTextField("Mobile number");
        t1.setBorder(BorderFactory.createLineBorder(Color.white));
        t1.selectAll();
        t1.setBounds(370, 250, 190, 30);
        // t1.setVisible(true);
        c.add(t1);

        JPasswordField t2 = new JPasswordField("password");
        t2.setBorder(BorderFactory.createLineBorder(Color.white));
        t2.selectAll();
        t2.setBounds(370, 320, 190, 30);
        // t1.setVisible(true);
        c.add(t2);

        JTextField t3 = new JTextField("Password again");
        t3.setBorder(BorderFactory.createLineBorder(Color.white));
        t3.selectAll();
        t3.setBounds(370, 390, 190, 30);
        // t1.setVisible(true);
        c.add(t3);

        // t3.getActionForKeyStroke

        mobileNumber = t1.getText();

        passWord = t3.getText();

        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Boolean isnumber = isNumber(t1.getText());
                next: if (!isnumber) {
                    t1.setText("Wrong, number");
                    t1.selectAll();
                    break next;
                } else {

                    // System.out.println(t1.getText());
                    if (t2.getText().equals("") || t3.getText().equals("")) {
                        t2.setText("password not empty!");
                        t2.selectAll();

                    }

                    if (!t2.getText().equals(t3.getText())) {
                        t3.setText("wrong password !");
                        t3.selectAll();
                    } else {

                        frame.dispose();
                        signup02(t2.getText(), t1.getText(), linkedListWorker, linkedListPerson);
                        // System.out.println(t1.getText());

                    }
                }
            }
        });

        frame.setVisible(true);

    }

    public static void login(LinkedList<Worker> linkedListWorker, LinkedList<Person> linkedListPerson) {
        JFrame frame = new JFrame();

        // start();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(480, 100, 978, 658);
        frame.setResizable(false);
        Container c = frame.getContentPane();
        c.setLayout(null);

        ImageIcon icon = new ImageIcon("D:\\OMA\\JAVA\\MicroProject\\src\\imageData\\login.png");
        JLabel label = new JLabel(icon);
        label.setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight());
        c.add(label);
        float arr[] = { 1, 2, 3 };
        JTextField t1 = new JTextField("Mobile number");
        t1.setBorder(BorderFactory.createLineBorder(Color.getHSBColor(0.0f, 0.0f, 0.9019608f)));
        arr = Color.RGBtoHSB(230, 230, 230, null);
        // System.out.println(arr[0] + " " + arr[1] + " " + arr[2]);
        t1.setBackground(Color.getHSBColor(0.0f, 0.0f, 0.9019608f));
        t1.selectAll();
        t1.setBounds(600, 275, 100, 20);
        // t1.setVisible(true);
        c.add(t1);

        JPasswordField t3 = new JPasswordField("password");
        t3.setBackground(Color.getHSBColor(0.0f, 0.0f, 0.9019608f));

        // t3.setBorder(BorderFactory.createLineBorder(Color.white));
        t3.setBorder(BorderFactory.createLineBorder(Color.getHSBColor(0.0f, 0.0f, 0.9019608f)));

        t3.selectAll();
        t3.setBounds(600, 335, 100, 20);
        t3.setVisible(true);
        c.add(t3);

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

        JButton b2 = new JButton("SignUP");
        b2.setBounds(750, 515, 80, 20);
        b2.setBackground(Color.LIGHT_GRAY);
        c.add(b2);
        // b.setOpaque(true);
        b2.setContentAreaFilled(false);
        // b.setBorderPainted(false);
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                signup01(linkedListWorker, linkedListPerson);
            }
        });

        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                frame.dispose();
                if (j1bBox.isSelected())
                    homePageCusto();
                homePageMarchant();
            }
        });

        frame.setVisible(true);
    }

    public static void sizee(LinkedList l) {
        if (l.size() > 2) {
            for (int i = 0; i < l.size(); i++) {
                System.out.println(l.size() + " is the size for " + i);
            }
        }
        if (l.size() == 0) {
            System.out.println("Empty ahe ..");
        }
    }

    public static void main(String[] args) {

        LinkedList linkedListWorker = new LinkedList<>();
        Integer i = 0;
        LinkedList linkedListPerson = new LinkedList<>();
        login(linkedListWorker, linkedListPerson);
        // Thread.currentThread().stop();
        for (int j = 0; j < args.length; j++) {
            System.out.println("HEy ! ");
        }
        // linkedListWorker.size());

    }
}