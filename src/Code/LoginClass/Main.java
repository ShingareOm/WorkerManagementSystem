package Code.LoginClass;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

class Person {
    public String imagePath;
    public boolean isLogin;
    LinkedList<Worker> linkedlistMyworker = new LinkedList<>();
    public String name = "om", address = "Dharashiv", surname = "Shingare", mobile = "8767561500", pass,
            email = "omshingare120@gmail.com";
    public String age;

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
    public String workType = "student";
    public Integer experience;
    public String discription = "Hey this is\nOm Shingare";
    public LinkedList nowLinkedListCustomer;
    public Double rating;
    public String timeFree;
    public static int i = 0;

    public Worker() {
        nowLinkedListCustomer = new LinkedList<>();
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

    public void searchWorker(LinkedList<Worker> linkedListWorker) {

        Scanner s = new Scanner(System.in);

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

        }
    }
}

public class Main {
    public static LinkedList<Worker> linkedlistWorker = new LinkedList<>();
    public static LinkedList<Person> linkedlistPerson = new LinkedList<>();
    public static Worker myWorker = null;
    public static Person myPerson = null;
    public static String[] columnNames = { "Name", "Work Type", "Description" };
    public static String[][] result = new String[3][10];
    public static Boolean isHere = false;

    public static void allocatedListFunc(Person person) {

        JFrame frame = new JFrame();
        JTable j = new JTable(result, columnNames);

        System.out.println("HEy!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setBounds(480, 100, 978, 658);
        Container c = frame.getContentPane();
        c.setLayout(null);
        c.add(j);
        frame.setBackground(Color.white);

        JMenuBar bar = new JMenuBar();
        JMenu manageAccountJMenu = createMenu("Manage Account", bar);
        JMenuItem profileItem = createMenuItem("My Account", manageAccountJMenu);
        JMenuItem Item = createMenuItem("Logout", manageAccountJMenu);

        JMenu viewJMenu = createMenu("View", bar);

        JMenuItem newRecord = createMenuItem("allocated list", viewJMenu);

        JMenu searchJMenu = createMenu("Search", bar);
        JMenuItem oldRecordse = createMenuItem("history search", searchJMenu);
        JMenuItem newRecordse = createMenuItem("allocated list search", searchJMenu);

        JMenu projectDetailsJMenu = createMenu("Project Details", bar);
        JMenuItem omShingare = createMenuItem("56 : om shingare", projectDetailsJMenu);

        JMenu videoJMenu = createMenu("Video", bar);

        JMenu aboutJMenu = createMenu("About", bar);
        JMenuItem code = createMenuItem("code", aboutJMenu);
        JMenuItem wworker = createMenuItem("worker", aboutJMenu);
        JMenuItem project = createMenuItem("project", aboutJMenu);

        frame.setJMenuBar(bar);

        Item.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                login();
            }
        });
        profileItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                manageAc(person);
            }
        });

        int count = 0;

        StringBuffer strr = new StringBuffer("");

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setBounds(300, 200, 400, 300);
        textArea.setBackground(Color.getHSBColor(0.0f, 0.0f, 0.9199608f));
        c.add(textArea);

        if (person.linkedlistMyworker.size() != 0) {
            for (int i = 0; i < person.linkedlistMyworker.size(); i++) {

                strr.append(person.linkedlistMyworker.get(i).name + " " + person.linkedlistMyworker.get(i).surname
                        + "  -- " + person.linkedlistMyworker.get(i).workType + "\n");
            }
            textArea.setText(strr.toString());
        } else {
            textArea.setText("");

        }

        frame.setVisible(true);

    }

    public static void tableData(JTextField textField, JFrame frame, JTable j, Container c) {
        String workType;
        int count = 0;

        frame.setVisible(true);
        System.out.println("HEy!");

        workType = textField.getText();
        if (!(linkedlistWorker.size() == 0)) {
            System.out.println("heuu ");
            for (count = 0; count < linkedlistWorker.size(); count++) {
                System.out.println("checking 1,...");
                if (linkedlistWorker.get(count).workType.equalsIgnoreCase(workType)
                        || linkedlistWorker.get(count).discription.contains(workType)) {
                    result[count][0] = linkedlistWorker.get(count).name + " "
                            + linkedlistWorker.get(count).surname;
                    result[count][1] = linkedlistWorker.get(count).workType;
                    result[count][2] = linkedlistWorker.get(count).discription;
                    System.out.println("found . ");
                    isHere = true;

                    JTable table = new JTable(result, columnNames);
                    table.setBounds(110, 100, 110, 110);
                    c.add(table);

                }
            }

        } else {
            System.out.println("Empty list");
            isHere = false;
        }
    }

    public static void workerSearch(Person person) {

        JFrame frame = new JFrame();
        JTable j = new JTable(result, columnNames);

        System.out.println("HEy!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setBounds(480, 100, 978, 658);
        Container c = frame.getContentPane();
        c.setLayout(null);
        c.add(j);
        frame.setBackground(Color.white);

        JMenuBar mb = new JMenuBar();
        JTextField input = new JTextField("Input");

        input.selectAll();
        input.setBounds(390, 150, 150, 30);
        c.add(input);

        JLabel Search = new JLabel();
        Search.setBounds(620, 150, 120, 20);
        Search.setFont(new Font("Berlin Sans FB", 0, 18));
        Search.setBorder((BorderFactory.createLineBorder(Color.getHSBColor(0.0f, 0.0f, 0.9199608f))));

        c.add(Search);

        JButton b1 = new JButton("Search");
        b1.setContentAreaFilled(false);
        b1.setBorder((BorderFactory.createLineBorder(Color.getHSBColor(0.0f, 0.0f, 0.9199608f))));
        b1.setBounds(620, 150, 120, 20);
        c.add(b1);

        JMenuBar bar = new JMenuBar();
        JMenu manageAccountJMenu = createMenu("Manage Account", bar);
        JMenuItem profileItem = createMenuItem("My Account", manageAccountJMenu);
        JMenuItem Item = createMenuItem("Logout", manageAccountJMenu);

        JMenu viewJMenu = createMenu("View", bar);

        JMenuItem newRecord = createMenuItem("allocated list", viewJMenu);

        JMenu searchJMenu = createMenu("Search", bar);
        JMenuItem oldRecordse = createMenuItem("history search", searchJMenu);
        JMenuItem newRecordse = createMenuItem("allocated list search", searchJMenu);

        JMenu projectDetailsJMenu = createMenu("Project Details", bar);
        JMenuItem omShingare = createMenuItem("56 : om shingare", projectDetailsJMenu);

        JMenu videoJMenu = createMenu("Video", bar);

        JMenu aboutJMenu = createMenu("About", bar);
        JMenuItem code = createMenuItem("code", aboutJMenu);
        JMenuItem wworker = createMenuItem("worker", aboutJMenu);
        JMenuItem project = createMenuItem("project", aboutJMenu);

        frame.setJMenuBar(bar);
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setBounds(300, 200, 400, 300);
        textArea.setBackground(Color.getHSBColor(0.0f, 0.0f, 0.9199608f));
        c.add(textArea);

        Item.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                login();
            }
        });
        profileItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                manageAc(person);
            }
        });

        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                input.selectAll();
                StringBuffer strr = new StringBuffer();
                int count = 0;
                int ch = 0;

                LinkedList<Worker> linkedlisttemp = new LinkedList<>();

                String workType = "";

                workType = input.getText();
                if (!(linkedlistWorker.size() == 0)) {
                    System.out.println("heuu ");
                    System.out.println("checking 1,...");
                    for (count = 0; count < linkedlistWorker.size(); count++) {
                        System.out.println(linkedlistWorker.get(count).workType + " and " + workType + "are ");
                        if (linkedlistWorker.get(count).workType.equalsIgnoreCase(workType)
                                || linkedlistWorker.get(count).discription.contains(workType)) {
                            System.out.println(strr + " is seting .. ");
                            strr.append(linkedlistWorker.get(count).name + " " + linkedlistWorker.get(count).surname
                                    + "  -- " + linkedlistWorker.get(count).workType + "\n");
                            linkedlisttemp.add(linkedlistWorker.get(count));
                            ch++;

                            JTextField index = new JTextField();

                            index.setBounds(700, 200, 150, 30);
                            c.add(index);

                            JButton button = new JButton("Add");
                            button.setBounds(700, 250, 150, 30);
                            c.add(button);

                            button.addActionListener(new ActionListener() {
                                public void actionPerformed(ActionEvent e) {

                                    System.out
                                            .println(Integer.parseInt(index.getText()) + "  " + linkedlisttemp.size());
                                    person.linkedlistMyworker
                                            .add(linkedlisttemp.get(Integer.parseInt(index.getText())));
                                }
                            });

                        }
                    }
                    if (ch == 0) {
                        System.out.println(" is set ");
                        textArea.setText("");
                    } else {
                        textArea.setText(strr.toString());
                        System.out.println(" 11 is set ");
                    }

                } else {
                    System.out.println("Empty list");
                    isHere = false;
                }

            }
        });

        frame.setTitle("Search Worker");

        frame.setVisible(true);

    }

    public static void fileChooser(StringBuffer filepath) {
        FileDialog dialog = new FileDialog((Frame) null, "Select File to Open");
        dialog.setResizable(true);
        dialog.setMode(FileDialog.LOAD);
        dialog.setVisible(true);
        String file = dialog.getDirectory() + dialog.getFile();
        dialog.dispose();

        file = file.replace("\\", "\\\\");

        filepath.append(file);
    }

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

    public static JMenuItem createMenuItem(String s, JMenu toMenu) {
        JMenuItem temp = new JMenuItem(s);

        toMenu.add(temp);

        return temp;
    }

    public static JMenu createMenu(String s, JMenuBar toMenuBar) {
        JMenu temp = new JMenu(s);
        toMenuBar.add(temp);
        return temp;
    }

    public static void bar(JFrame frame) {
        JMenuBar bar = new JMenuBar();
        JMenu manageAccountJMenu = createMenu("Manage Account", bar);
        JMenuItem profileItem = createMenuItem("My Account", manageAccountJMenu);
        JMenuItem Item = createMenuItem("Logout", manageAccountJMenu);

        JMenu viewJMenu = createMenu("View", bar);

        JMenuItem newRecord = createMenuItem("allocated list", viewJMenu);

        JMenu searchJMenu = createMenu("Search", bar);

        JMenuItem newRecordse = createMenuItem("allocated list search", searchJMenu);

        JMenu projectDetailsJMenu = createMenu("Project Details", bar);
        JMenuItem omShingare = createMenuItem("56 : om shingare", projectDetailsJMenu);

        JMenu videoJMenu = createMenu("Video", bar);

        JMenu aboutJMenu = createMenu("About", bar);
        JMenuItem code = createMenuItem("code", aboutJMenu);
        JMenuItem wworker = createMenuItem("worker", aboutJMenu);
        JMenuItem project = createMenuItem("project", aboutJMenu);

        frame.setJMenuBar(bar);

    }

    public static void viewNowRecord(Person person) {
        JFrame frame = new JFrame();
        System.out.println("HEy!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setBounds(480, 100, 978, 658);
        Container c = frame.getContentPane();
        c.setLayout(null);
        frame.setBackground(Color.white);
        bar(frame);

        JMenuBar mb = new JMenuBar();

        JLabel history = new JLabel("HISTORY");
        history.setBounds(440, 100, 200, 20);
        history.setFont(new Font("Berlin Sans FB", 0, 20));
        c.add(history);

        JTextArea historyArea = new JTextArea();
        historyArea.setColumns(2);
        historyArea.setRows(3);

        c.add(historyArea);

        JMenuBar bar = new JMenuBar();
        JMenu manageAccountJMenu = createMenu("Manage Account", bar);
        JMenuItem profileItem = createMenuItem("My Account", manageAccountJMenu);
        JMenuItem Item = createMenuItem("Logout", manageAccountJMenu);

        JMenu viewJMenu = createMenu("View", bar);
        JMenuItem oldRecord = createMenuItem("history", viewJMenu);
        JMenuItem newRecord = createMenuItem("allocated list", viewJMenu);

        JMenu searchJMenu = createMenu("Search", bar);
        JMenuItem oldRecordse = createMenuItem("history search", searchJMenu);
        JMenuItem newRecordse = createMenuItem("allocated list search", searchJMenu);

        JMenu projectDetailsJMenu = createMenu("Project Details", bar);
        JMenuItem omShingare = createMenuItem("56 : om shingare", projectDetailsJMenu);

        JMenu videoJMenu = createMenu("Video", bar);

        JMenu aboutJMenu = createMenu("About", bar);
        JMenuItem code = createMenuItem("code", aboutJMenu);
        JMenuItem wworker = createMenuItem("worker", aboutJMenu);
        JMenuItem project = createMenuItem("project", aboutJMenu);

        frame.setJMenuBar(bar);

        Item.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                login();
            }
        });
        profileItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                manageAc(person);
            }
        });
        oldRecord.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();

            }
        });

        JTextArea t1 = new JTextArea("This is text area 1.\n It has scrollbars\n on both sides.  ");

        t1.setBounds(250, 150, 460, 230);

        frame.add(t1);
        t1.append("\nRows in t1 " + t1.getRows() + "\nColumns in t1 " + t1.getColumns());

        t1.setAutoscrolls(true);
        frame.setVisible(true);
    }

    public static void manageAc(Person person) {
        JFrame frame = new JFrame();
        System.out.println("HEy!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setBounds(480, 100, 978, 658);
        Container c = frame.getContentPane();
        c.setLayout(null);
        frame.setBackground(Color.white);
        bar(frame);

        String file = new String();
        file = person.imagePath;
        file = file.replace("\\", "\\\\");
        System.out.println(file + " chosen.");
        ImageIcon icon = new ImageIcon(file);
        JLabel label = new JLabel(icon);
        label.setBounds(640, 100, 170, 220);
        c.add(label);

        JMenuBar mb = new JMenuBar();

        ImageIcon icon2 = new ImageIcon("D:\\OMA\\JAVA\\MicroProject\\src\\imageData\\manageAcC.png");
        JLabel label1 = new JLabel(icon2);
        label1.setBounds(150, 50, icon2.getIconWidth(), icon2.getIconHeight());
        c.add(label1);

        JTextArea discLabel = new JTextArea(person.age);
        discLabel.setBounds(225, 455, 200, 100);
        discLabel.setEditable(false);

        JLabel addressJLabel = new JLabel(person.address);
        addressJLabel.setBounds(190, 235, 100, 20);
        c.add(addressJLabel);

        JLabel phoneJLabel = new JLabel(person.mobile);
        phoneJLabel.setBounds(360, 235, 100, 20);
        c.add(phoneJLabel);

        JLabel mailJLabel = new JLabel(person.email);
        mailJLabel.setBounds(530, 235, 100, 20);
        c.add(mailJLabel);

        JLabel nameJLabel = new JLabel(person.name + " " + person.surname);
        nameJLabel.setBounds(223, 350, 100, 20);
        c.add(nameJLabel);
        JLabel emailLabel = new JLabel(person.email);
        emailLabel.setBounds(400, 350, 200, 20);
        c.add(emailLabel);

        JLabel worktypeLabel = new JLabel(person.age);
        worktypeLabel.setBounds(223, 400, 200, 20);
        c.add(worktypeLabel);

        discLabel.setBackground(Color.getHSBColor(0.0f, 0.0f, 0.9199608f));
        c.add(discLabel);

        frame.setVisible(true);

        JMenuBar bar = new JMenuBar();
        JMenu manageAccountJMenu = createMenu("Manage Account", bar);
        JMenuItem profileItem = createMenuItem("My Account", manageAccountJMenu);
        JMenuItem Item = createMenuItem("Logout", manageAccountJMenu);

        JMenu viewJMenu = createMenu("View", bar);
        JMenuItem oldRecord = createMenuItem("history", viewJMenu);
        JMenuItem newRecord = createMenuItem("allocated list", viewJMenu);

        JMenu searchJMenu = createMenu("Search", bar);
        JMenuItem oldRecordse = createMenuItem("history search", searchJMenu);
        JMenuItem newRecordse = createMenuItem("allocated list search", searchJMenu);

        JMenu projectDetailsJMenu = createMenu("Project Details", bar);
        JMenuItem omShingare = createMenuItem("56 : om shingare", projectDetailsJMenu);

        JMenu videoJMenu = createMenu("Video", bar);

        JMenu aboutJMenu = createMenu("About", bar);
        JMenuItem code = createMenuItem("code", aboutJMenu);
        JMenuItem wworker = createMenuItem("worker", aboutJMenu);
        JMenuItem project = createMenuItem("project", aboutJMenu);

        frame.setJMenuBar(bar);

        Item.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                login();
            }
        });
        profileItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                manageAc(person);
            }
        });

        oldRecord.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();

            }
        });

    }

    public static void homePageCusto(Person person) {
        JFrame frame = new JFrame();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setBounds(480, 100, 978, 658);
        Container c = frame.getContentPane();
        c.setLayout(null);
        frame.setBackground(Color.white);

        String file = new String();
        file = person.imagePath;
        file = file.replace("\\", "\\\\");
        System.out.println(file + " chosen.");
        ImageIcon icon = new ImageIcon(file);
        JLabel label = new JLabel(icon);
        label.setBounds(640, 100, 170, 220);
        c.add(label);

        JMenuBar mb = new JMenuBar();

        ImageIcon icon2 = new ImageIcon("D:\\OMA\\JAVA\\MicroProject\\src\\imageData\\manageAcC.png");
        JLabel label1 = new JLabel(icon2);
        label1.setBounds(150, 50, icon2.getIconWidth(), icon2.getIconHeight());
        c.add(label1);

        JMenuBar bar = new JMenuBar();
        JMenu manageAccountJMenu = createMenu("Manage Account", bar);
        JMenuItem profileItem = createMenuItem("My Account", manageAccountJMenu);

        JMenuItem Item = createMenuItem("Logout", manageAccountJMenu);

        JMenu viewJMenu = createMenu("View", bar);
        JMenuItem oldRecord = createMenuItem("history", viewJMenu);
        JMenuItem newRecord = createMenuItem("allocated list", viewJMenu);

        JMenu searchJMenu = createMenu("Search", bar);
        JMenuItem oldRecordse = createMenuItem("history search", searchJMenu);
        JMenuItem newRecordse = createMenuItem("allocated list search", searchJMenu);
        JMenuItem WorkerSearch = createMenuItem("Worker Search", searchJMenu);

        JMenu projectDetailsJMenu = createMenu("Project Details", bar);
        JMenuItem omShingare = createMenuItem("56 : om shingare",
                projectDetailsJMenu);

        JMenu videoJMenu = createMenu("Video", bar);

        JMenu aboutJMenu = createMenu("About", bar);
        JMenuItem code = createMenuItem("code", aboutJMenu);
        JMenuItem wworker = createMenuItem("worker", aboutJMenu);
        JMenuItem project = createMenuItem("project", aboutJMenu);

        frame.setJMenuBar(bar);

        frame.setVisible(true);

        Item.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                login();
            }
        });
        profileItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                manageAc(person);
            }
        });
        oldRecord.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();

            }
        });

        WorkerSearch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();

                workerSearch(person);

            }
        });

        JLabel addressJLabel = new JLabel(person.address);
        addressJLabel.setBounds(190, 235, 100, 20);
        c.add(addressJLabel);

        JLabel phoneJLabel = new JLabel(person.mobile);
        phoneJLabel.setBounds(360, 235, 100, 20);
        c.add(phoneJLabel);

        JLabel mailJLabel = new JLabel(person.email);
        mailJLabel.setBounds(530, 235, 100, 20);
        c.add(mailJLabel);

        JLabel nameJLabel = new JLabel(person.name + " " + person.surname);
        nameJLabel.setBounds(223, 350, 100, 20);
        c.add(nameJLabel);

        JLabel emailLabel = new JLabel(person.email);
        emailLabel.setBounds(400, 350, 200, 20);
        c.add(emailLabel);

        JLabel worktypeLabel = new JLabel(person.age);
        worktypeLabel.setBounds(223, 400, 200, 20);
        c.add(worktypeLabel);

    }

    public static void viewNowRecord(Worker worker) {
        JFrame frame = new JFrame();
        System.out.println("HEy!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setBounds(480, 100, 978, 658);
        Container c = frame.getContentPane();
        c.setLayout(null);
        frame.setBackground(Color.white);
        bar(frame);

        JMenuBar mb = new JMenuBar();

        JLabel history = new JLabel("HISTORY");
        history.setBounds(440, 100, 200, 20);
        history.setFont(new Font("Berlin Sans FB", 0, 20));
        c.add(history);

        JTextArea historyArea = new JTextArea();
        historyArea.setColumns(2);
        historyArea.setRows(3);

        c.add(historyArea);

        JMenuBar bar = new JMenuBar();
        JMenu manageAccountJMenu = createMenu("Manage Account", bar);
        JMenuItem profileItem = createMenuItem("My Account", manageAccountJMenu);
        JMenuItem Item = createMenuItem("Logout", manageAccountJMenu);

        JMenu viewJMenu = createMenu("View", bar);
        JMenuItem oldRecord = createMenuItem("history", viewJMenu);
        JMenuItem newRecord = createMenuItem("allocated list", viewJMenu);

        JMenu searchJMenu = createMenu("Search", bar);
        JMenuItem oldRecordse = createMenuItem("history search", searchJMenu);
        JMenuItem newRecordse = createMenuItem("allocated list search", searchJMenu);

        JMenu projectDetailsJMenu = createMenu("Project Details", bar);
        JMenuItem omShingare = createMenuItem("56 : om shingare", projectDetailsJMenu);

        JMenu videoJMenu = createMenu("Video", bar);

        JMenu aboutJMenu = createMenu("About", bar);
        JMenuItem code = createMenuItem("code", aboutJMenu);
        JMenuItem wworker = createMenuItem("worker", aboutJMenu);
        JMenuItem project = createMenuItem("project", aboutJMenu);

        frame.setJMenuBar(bar);

        Item.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                login();
            }
        });
        profileItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                manageAc(worker);
            }
        });
        oldRecord.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();

            }
        });

        JTextArea t1 = new JTextArea("This is text area 1.\n It has scrollbars\n on both sides.  ");

        t1.setBounds(250, 150, 460, 230);

        frame.add(t1);
        t1.append("\nRows in t1 " + t1.getRows() + "\nColumns in t1 " + t1.getColumns());

        t1.setAutoscrolls(true);
        frame.setVisible(true);
    }

    public static void manageAc(Worker worker) {
        JFrame frame = new JFrame();
        System.out.println("HEy!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setBounds(480, 100, 978, 658);
        Container c = frame.getContentPane();
        c.setLayout(null);
        frame.setBackground(Color.white);
        bar(frame);

        String file = new String();
        file = worker.imagePath;
        file = file.replace("\\", "\\\\");
        System.out.println(file + " chosen.");
        ImageIcon icon = new ImageIcon(file);
        JLabel label = new JLabel(icon);
        label.setBounds(640, 100, 170, 220);
        c.add(label);

        JMenuBar mb = new JMenuBar();

        ImageIcon icon2 = new ImageIcon("D:\\OMA\\JAVA\\MicroProject\\src\\imageData\\manageAc.png");
        JLabel label1 = new JLabel(icon2);
        label1.setBounds(150, 50, icon2.getIconWidth(), icon2.getIconHeight());
        c.add(label1);

        JTextArea discLabel = new JTextArea(worker.discription);
        discLabel.setBounds(225, 455, 200, 100);
        discLabel.setEditable(false);

        JLabel addressJLabel = new JLabel(worker.address);
        addressJLabel.setBounds(190, 235, 100, 20);
        c.add(addressJLabel);

        JLabel phoneJLabel = new JLabel(worker.mobile);
        phoneJLabel.setBounds(360, 235, 100, 20);
        c.add(phoneJLabel);

        JLabel mailJLabel = new JLabel(worker.email);
        mailJLabel.setBounds(530, 235, 100, 20);
        c.add(mailJLabel);

        JLabel nameJLabel = new JLabel(worker.name + " " + worker.surname);
        nameJLabel.setBounds(223, 350, 100, 20);
        c.add(nameJLabel);

        JLabel emailLabel = new JLabel(worker.email);
        emailLabel.setBounds(400, 350, 200, 20);
        c.add(emailLabel);

        JLabel worktypeLabel = new JLabel(worker.workType);
        worktypeLabel.setBounds(223, 400, 200, 20);
        c.add(worktypeLabel);

        discLabel.setBackground(Color.getHSBColor(0.0f, 0.0f, 0.9199608f));
        c.add(discLabel);

        frame.setVisible(true);

        JMenuBar bar = new JMenuBar();
        JMenu manageAccountJMenu = createMenu("Manage Account", bar);
        JMenuItem profileItem = createMenuItem("My Account", manageAccountJMenu);
        JMenuItem Item = createMenuItem("Logout", manageAccountJMenu);

        JMenu viewJMenu = createMenu("View", bar);
        JMenuItem oldRecord = createMenuItem("history", viewJMenu);
        JMenuItem newRecord = createMenuItem("allocated list", viewJMenu);

        JMenu searchJMenu = createMenu("Search", bar);
        JMenuItem oldRecordse = createMenuItem("history search", searchJMenu);
        JMenuItem newRecordse = createMenuItem("allocated list search", searchJMenu);

        JMenu projectDetailsJMenu = createMenu("Project Details", bar);
        JMenuItem omShingare = createMenuItem("56 : om shingare", projectDetailsJMenu);

        JMenu videoJMenu = createMenu("Video", bar);

        JMenu aboutJMenu = createMenu("About", bar);
        JMenuItem code = createMenuItem("code", aboutJMenu);
        JMenuItem wworker = createMenuItem("worker", aboutJMenu);
        JMenuItem project = createMenuItem("project", aboutJMenu);

        frame.setJMenuBar(bar);

        Item.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                login();
            }
        });
        profileItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                manageAc(worker);
            }
        });

        oldRecord.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();

            }
        });

    }

    public static void homePageMarchant(Worker worker) {
        JFrame frame = new JFrame();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setBounds(480, 100, 978, 658);
        Container c = frame.getContentPane();
        c.setLayout(null);
        frame.setBackground(Color.white);

        String file = new String();
        file = worker.imagePath;
        file = file.replace("\\", "\\\\");
        System.out.println(file + " chosen.");
        ImageIcon icon = new ImageIcon(file);
        JLabel label = new JLabel(icon);
        label.setBounds(640, 100, 170, 220);
        c.add(label);

        JMenuBar mb = new JMenuBar();

        ImageIcon icon2 = new ImageIcon("D:\\OMA\\JAVA\\MicroProject\\src\\imageData\\manageAc.png");
        JLabel label1 = new JLabel(icon2);
        label1.setBounds(150, 50, icon2.getIconWidth(), icon2.getIconHeight());
        c.add(label1);

        JMenuBar bar = new JMenuBar();
        JMenu manageAccountJMenu = createMenu("Manage Account", bar);
        JMenuItem profileItem = createMenuItem("My Account", manageAccountJMenu);

        JMenuItem Item = createMenuItem("Logout", manageAccountJMenu);

        JMenu viewJMenu = createMenu("View", bar);
        JMenuItem oldRecord = createMenuItem("history", viewJMenu);
        JMenuItem newRecord = createMenuItem("allocated list", viewJMenu);

        JMenu searchJMenu = createMenu("Search", bar);
        JMenuItem oldRecordse = createMenuItem("history search", searchJMenu);
        JMenuItem newRecordse = createMenuItem("allocated list search", searchJMenu);

        JMenu projectDetailsJMenu = createMenu("Project Details", bar);
        JMenuItem omShingare = createMenuItem("56 : om shingare",
                projectDetailsJMenu);

        JMenu videoJMenu = createMenu("Video", bar);

        JMenu aboutJMenu = createMenu("About", bar);
        JMenuItem code = createMenuItem("code", aboutJMenu);
        JMenuItem wworker = createMenuItem("worker", aboutJMenu);
        JMenuItem project = createMenuItem("project", aboutJMenu);

        frame.setJMenuBar(bar);

        frame.setVisible(true);

        Item.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                login();
            }
        });
        profileItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                manageAc(worker);
            }
        });
        oldRecord.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();

            }
        });
        newRecord.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();

            }
        });

        JLabel addressJLabel = new JLabel(worker.address);
        addressJLabel.setBounds(190, 235, 100, 20);
        c.add(addressJLabel);

        JLabel phoneJLabel = new JLabel(worker.mobile);
        phoneJLabel.setBounds(360, 235, 100, 20);
        c.add(phoneJLabel);

        JLabel mailJLabel = new JLabel(worker.email);
        mailJLabel.setBounds(530, 235, 100, 20);
        c.add(mailJLabel);

        JLabel nameJLabel = new JLabel(worker.name + " " + worker.surname);
        nameJLabel.setBounds(223, 350, 100, 20);
        c.add(nameJLabel);

        JLabel emailLabel = new JLabel(worker.email);
        emailLabel.setBounds(400, 350, 200, 20);
        c.add(emailLabel);

        JLabel worktypeLabel = new JLabel(worker.workType);
        worktypeLabel.setBounds(223, 400, 200, 20);
        c.add(worktypeLabel);

        JTextArea discLabel = new JTextArea(worker.discription);
        discLabel.setBounds(225, 455, 200, 100);
        discLabel.setEditable(false);

        discLabel.setBackground(Color.getHSBColor(0.0f, 0.0f, 0.9199608f));
        c.add(discLabel);
    }

    public static void signup04(Worker worker) {
        JFrame frame = new JFrame();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(480, 100, 978, 658);
        frame.setResizable(false);
        Container c = frame.getContentPane();
        c.setLayout(null);

        ImageIcon icon2 = new ImageIcon("D:\\OMA\\JAVA\\MicroProject\\src\\imageData\\signup04.png");
        JLabel label1 = new JLabel(icon2);
        label1.setBounds(290, 50, icon2.getIconWidth(), icon2.getIconHeight());
        c.add(label1);

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

                StringBuffer temp = new StringBuffer();
                fileChooser(temp);
                worker.imagePath = temp.toString();
                System.out.println(temp);
                nextt: if (temp != null) {
                    linkedlistPerson.add(worker);
                    frame.dispose();
                    String s[] = { "13", "23" };
                    main(s);
                } else {
                    break nextt;
                }

            }
        });

        JTextArea t1 = new JTextArea("Discription");
        t1.setBorder(BorderFactory.createLineBorder(Color.white));
        t1.selectAll();
        t1.setBounds(370, 228, 190, 100);

        c.add(t1);
        System.out.println("the size is " + linkedlistWorker.size());
        worker.discription = t1.getText();
        linkedlistWorker.add(worker);
        frame.setVisible(true);

    }

    public static void signup03(Boolean isWorker, String email, String mobile, String pass) {

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

        JTextField t3;
        if (isWorker) {
            t3 = new JTextField("WorkType");
        } else {

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

            b.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    frame.dispose();
                    signup04(worker);
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

            b.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e) {

                    StringBuffer temp = new StringBuffer();
                    fileChooser(temp);
                    person.imagePath = temp.toString();
                    System.out.println(temp);
                    nextt: if (temp != null) {
                        linkedlistPerson.add(person);
                        frame.dispose();
                        String s[] = { "13", "23" };
                        main(s);
                    } else {
                        break nextt;
                    }
                }
            });
        }

        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                signup02(pass, mobile);
            }
        });

        frame.setVisible(true);

    }

    public static void signup02(String pass, String mobileNum) {

        JFrame frame = new JFrame();

        Boolean isWorker = false;

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
                signup01();

            }
        });

        JTextField t1 = new JTextField("Email ID");
        t1.setBorder(BorderFactory.createLineBorder(Color.white));
        t1.selectAll();
        t1.setBounds(370, 248, 190, 30);

        c.add(t1);

        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Boolean isWorker = false;
                if (j1bBox.isSelected()) {
                    isWorker = true;
                } else {
                    isWorker = false;
                }

                frame.dispose();

                String email = "";
                email = t1.getText();
                signup03(isWorker, email, mobileNum, pass);

            }
        });

        frame.setVisible(true);

    }

    public static void signup01() {

        String mobileNumber = "null";
        String passWord = "pass";

        JFrame frame = new JFrame();

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

        b.setContentAreaFilled(false);

        JTextField t1 = new JTextField("Mobile number");
        t1.setBorder(BorderFactory.createLineBorder(Color.white));
        t1.selectAll();
        t1.setBounds(370, 250, 190, 30);

        c.add(t1);

        JPasswordField t2 = new JPasswordField("password");
        t2.setBorder(BorderFactory.createLineBorder(Color.white));
        t2.selectAll();
        t2.setBounds(370, 320, 190, 30);

        c.add(t2);

        JTextField t3 = new JTextField("Password again");
        t3.setBorder(BorderFactory.createLineBorder(Color.white));
        t3.selectAll();
        t3.setBounds(370, 390, 190, 30);

        c.add(t3);

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

                    if (t2.getText().equals("") || t3.getText().equals("")) {
                        t2.setText("password not empty!");
                        t2.selectAll();

                    }

                    if (!t2.getText().equals(t3.getText())) {
                        t3.setText("wrong password !");
                        t3.selectAll();
                    } else {

                        frame.dispose();
                        signup02(t2.getText(), t1.getText());

                    }
                }
            }
        });
        frame.setVisible(true);

    }

    public static void login() {
        JFrame frame = new JFrame();

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

        t1.setBackground(Color.getHSBColor(0.0f, 0.0f, 0.9019608f));
        t1.selectAll();
        t1.setBounds(600, 275, 100, 20);

        c.add(t1);

        JTextField t3 = new JTextField("password");
        t3.setBackground(Color.getHSBColor(0.0f, 0.0f, 0.9019608f));

        t3.setBorder(BorderFactory.createLineBorder(Color.getHSBColor(0.0f, 0.0f, 0.9019608f)));

        t3.selectAll();
        t3.setBounds(600, 335, 100, 20);
        t3.setVisible(true);
        c.add(t3);

        JButton b = new JButton("Login");
        b.setBounds(540, 448, 290, 50);
        b.setBackground(Color.LIGHT_GRAY);
        c.add(b);

        b.setContentAreaFilled(false);

        JCheckBox j1bBox = new JCheckBox();
        j1bBox.setBounds(580, 397, 20, 20);
        j1bBox.setBackground(Color.white);
        c.add(j1bBox);

        JButton b2 = new JButton("SignUP");
        b2.setBounds(750, 515, 80, 20);
        b2.setBackground(Color.LIGHT_GRAY);
        c.add(b2);

        b2.setContentAreaFilled(false);

        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                signup01();
            }
        });

        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (linkedlistPerson.size() == 0 && linkedlistWorker.size() == 0) {

                }

                next1: if (j1bBox.isSelected()) {
                    myPerson = isValidPerson(t3.getText(), t1.getText());
                    if (myPerson == null) {
                        break next1;
                    } else {
                        System.out.println("Customer ");
                        homePageCusto(myPerson);
                    }

                } else {
                    myWorker = isValidWorker(t3.getText(), t1.getText());
                    if (myWorker == null) {
                        break next1;
                    }
                    System.out.println("Worker ");
                    frame.dispose();
                    homePageMarchant(myWorker);
                }
            }
        });

        frame.setVisible(true);
    }

    public static Worker isValidWorker(String pass, String mobileNumber) {

        if (!(linkedlistWorker.size() == 0)) {
            for (int i = 0; i < linkedlistWorker.size(); i++) {
                if (!linkedlistWorker.get(i).mobile.equals(mobileNumber)) {
                    return null;
                } else {
                    try {
                        if (linkedlistWorker.get(i).pass.equals(pass)) {
                            return linkedlistWorker.get(i);
                        }
                    } catch (Exception e) {
                    }
                }
            }
        }
        System.out.println(linkedlistWorker.size());
        return null;
    }

    public static Person isValidPerson(String pass, String mobileNumber) {
        if (!(linkedlistPerson.size() == 0)) {
            for (int i = 0; i < linkedlistPerson.size(); i++) {
                System.out.println("htt");
                if (!linkedlistPerson.get(i).mobile.equals(mobileNumber)) {
                    return null;
                } else {
                    try {
                        if (linkedlistPerson.get(i).pass.equals(pass)) {
                            return linkedlistPerson.get(i);
                        }
                    } catch (Exception e) {
                    }
                }
            }
        }
        System.out.println(linkedlistPerson.size());
        return null;
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
        Worker worker = new Worker();
        worker.imagePath = "D:\\OMA\\JAVA\\MicroProject\\src\\faceData[170,220]\\OIP.jpg";

        linkedlistWorker.add(worker);

        Worker worker1 = new Worker();
        worker.imagePath = "D:\\OMA\\JAVA\\MicroProject\\src\\faceData[170,220]\\OIP.jpg";

        linkedlistWorker.add(worker1);

        Worker worker2 = new Worker();
        worker.imagePath = "D:\\OMA\\JAVA\\MicroProject\\src\\faceData[170,220]\\OIP.jpg";

        linkedlistWorker.add(worker2);

        Worker worker3 = new Worker();
        worker.imagePath = "D:\\OMA\\JAVA\\MicroProject\\src\\faceData[170,220]\\OIP.jpg";

        linkedlistWorker.add(worker3);

        Person person = new Person();
        person.name = "om";
        person.surname = "shingare";
        person.address = "dharashiv";
        person.age = "19";
        person.imagePath = "D:\\OMA\\JAVA\\MicroProject\\src\\faceData[170,220]\\OIP.jpg";
        homePageCusto(person);
    }
}