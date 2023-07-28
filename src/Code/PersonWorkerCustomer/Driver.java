package Code.PersonWorkerCustomer;

import java.sql.Date;
import java.util.LinkedList;
import java.util.Scanner;

import javax.print.attribute.standard.Chromaticity;
import javax.swing.ImageIcon;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.SystemMenuBar;
import javax.swing.text.html.HTMLDocument.HTMLReader.BlockAction;

class Person {
    boolean isLogin;
    String name, address, surname, mobile, pass, email;
    Integer age;
    // Date d;
    static int i = 0;

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

    public Integer getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setAge(Integer age) {
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
    String workType;
    Integer experience;
    String discription;
    LinkedList nowLinkedListCustomer;
    LinkedList oldLinkedListCustomer;
    Double rating;
    String timeFree;
    static int i = 0;

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

class login {
    public void WorkCustLoginPage(LinkedList<Customer> linkedListCustomer, LinkedList<Worker> linkedListWorker) {
        String password, mobileNumber;
        Integer test;
        Boolean found = false;
        Boolean isWorker = false;
        Scanner s = new Scanner(System.in);

        System.out.println("You are worker or not .");
        String check = s.nextLine();
        if (check.equalsIgnoreCase("yes")) {
            isWorker = true;
        }
        System.out.println("Enter mobile number ");
        mobileNumber = s.nextLine();

        if (!isWorker) {
            int i = 0;
            try {
                test = Integer.parseInt(mobileNumber);
                for (i = 0; i < linkedListCustomer.size(); i++) {
                    if (linkedListCustomer.get(i).mobile.equals(mobileNumber)) {
                        found = true;
                        break;
                    }
                }
                if (!found)
                    throw new Exception();
            } catch (Exception e) {
                System.out.println("Enter correct number ");
                mobileNumber = "";
                return;
            }

            System.out.println("Enter the password ");
            password = s.nextLine();
            if (linkedListCustomer.get(i).pass.equals(password)) {
                System.out.println("custo Login  sucess! ");
            } else {
                System.out.println("Enter the pass again");
            }
        } else {
            int i = 0;
            try {
                test = Integer.parseInt(mobileNumber);
                for (i = 0; i < linkedListWorker.size(); i++) {
                    if (linkedListWorker.get(i).mobile.equals(mobileNumber)) {
                        found = true;
                        break;
                    }
                }
                if (!found)
                    throw new Exception();
            } catch (Exception e) {
                System.out.println("Enter correct number ");
                mobileNumber = "";
                return;
            }

            System.out.println("Enter the password ");
            password = s.nextLine();
            if (linkedListWorker.get(i).pass.equals(password)) {
                System.out.println("worker Login  sucess! ");
            } else {
                System.out.println("Enter the pass again");
            }
        }
    }
}

public class Driver {
    public static void main(String[] args) {
        System.out.println("Worked!");
        ImageIcon icon = new ImageIcon("C:\\Users\\omshi\\OneDrive\\Pictures\\Screenshots\\Screenshot (133).png");
    }
}
