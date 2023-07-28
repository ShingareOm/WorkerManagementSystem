package Code.PersonWorkerCustomer;

import java.util.LinkedList;
/**
* @Author om shingare
* @Date 02-Mar-23
* @Time 10:18 PM
*/
import java.util.Scanner;

class MyLoginClass {

    String name;
    String mobile;
    String password;

}

class login {
    public void loginPage(LinkedList<Object> linkedListCustomer) {
        String password,mobileNumber;
        Integer test;
        Boolean isWorker = false;
        Scanner s = new Scanner(System.in);
        System.out.println("You are worker or not .");
        String check = s.nextLine();
        if (check.equalsIgnoreCase("yes")) {
            isWorker = true;
        }
        int i = 0;
        System.out.println("Enter mobile number ");
        mobileNumber = s.nextLine();
        try {
            test = Integer.parseInt(mobileNumber);
            for (i = 0; i < map.size(); i++) {
                if (map.get(i).mobile.equals(mobileNumber)) {
                    break;
                }
            }
            if (i == map.size() - 1)
                throw new Exception();
        } catch (Exception e) {
            System.out.println("Enter correct number ");
            mobileNumber = "";
            return;
        }

        System.out.println("Enter the password ");
        password = s.nextLine();
        if (map.get(i).password.equals(password)) {
            System.out.println("Login  sucess! ");
        }
    }
}

// public class LoginPage {

//     public static void main(String[] args) {
//         Scanner s = new Scanner(System.in);

//         // MyTuple1 <Integer> = new MyTuple1<Integer>();
//         // ArrayList <String> a = new ArrayList<>()
//         // LoginPage loginPage = new LoginPage();
//         // loginPage.loginPage();
//         s.close();
//     }
// }
