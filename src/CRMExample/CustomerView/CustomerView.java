package CRMExample.CustomerView;

import CRMExample.Control.CustomerList;
import CRMExample.Model.Customer;
import CRMExample.Util.CRMUtility;

import java.time.chrono.MinguoDate;

/**
 * @author
 * @description Menu and UI
 * @create 2021-10-13 7:20 PM
 **/

public class CustomerView {
    private CustomerList customerList = new CustomerList(10);

    public CustomerView() {
        Customer customer = new Customer("A", 'F', 36, "123456", "123@qq.com");
        customerList.addCustomer(customer);
    }

    /**
     * Main menu UI
     */
     public void enterMainMenu() {


         boolean isFlag = true;

         while(isFlag) {
             System.out.println("\n---MainMenu---\n");
             System.out.println("   1. Add Customer   ");
             System.out.println("   2. Modify Customer   ");
             System.out.println("   3. Delete Customer   ");
             System.out.println("   4. List All Customer   ");
             System.out.println("   5. Sign Out\n   ");
             System.out.println("Please select(1 ~ 5): ");

             char menu = CRMUtility.readMenuSelection();

             switch (menu) {
                 case '1':
                     addNewCustomer();
                     break;
                 case '2':
                     modifyCustomer();
                     break;
                 case '3':
                     deleteCustomer();
                     break;
                 case '4':
                     listAllCustomers();
                     break;
                 case '5':
                     System.out.println("Are you sure(Y/N)?");
                     char isExit = CRMUtility.readConfirmSelection();
                     if(isExit == 'Y') {
                         isFlag = false;
                     }
                     //if select n then do nothing, it will back to the while loop again
             }


//             isFlag = false;
         }
     }

    /**
     * Add a new customer
     */
    public void addNewCustomer() {
        System.out.println("---Add a new customer---");
        System.out.println("Name:\n");
        String name = CRMUtility.readString(8);

        System.out.println("Gender:\n");
        char gender = CRMUtility.readChar();

        System.out.println("Age:\n");
        int age = CRMUtility.readInt();

        System.out.println("phone:\n");
        String phone = CRMUtility.readString(10);

        System.out.println("email:\n");
        String email = CRMUtility.readString(20);

        Customer cus = new Customer(name, gender, age, phone, email);
        boolean isSuccess = customerList.addCustomer(cus);

        if(!isSuccess) {
            System.out.println("---List is full, fail to add---");
        } else {
            System.out.println("---Success ---");

        }


     }

    /**
     * Modify a customer
     */
    public void modifyCustomer() {
        System.out.println("Select Index");
        int index;
        Customer c;
        for(;;) {
            System.out.println("Select customer index( -1 to exit): ");
            index = CRMUtility.readInt();

            if(index == -1) {
                return;
            }

            c = customerList.getCustomer(index - 1);
            if(c == null) {
                System.out.println("Not a valid index");
            } else {
                break;
            }
        }

        System.out.println("Replace info");

        System.out.printf("Name:(%s)\n:", c.getName());
        String name = CRMUtility.readString(8, c.getName());

        System.out.printf("Gender:(%c)\n:", c.getGender());
        char gender = CRMUtility.readChar(c.getGender());

        System.out.printf("Age:(%d)\n:", c.getAge());
        int age = CRMUtility.readInt(c.getAge());

        System.out.printf("Phone:(%s)\n:", c.getPhone());
        String phone = CRMUtility.readString(10, c.getPhone());

        System.out.printf("Email:(%s)\n:", c.getEmail());
        String email = CRMUtility.readString(20, c.getEmail());


        Customer cus = new Customer(name, gender, age, phone, email);


        boolean isReplace = customerList.replaceCustomer(index, cus);
        if(isReplace) {
            System.out.println("---Success---");
        } else {
            System.out.println("---Fail---");
        }



    }

    /**
     * Delete a customer
     */
    public void deleteCustomer() {
        System.out.println("---Delete a customer---\n ");
        System.out.println("Select customer index( -1 to exit): ");

        int index;
        for(;;) {
            System.out.println("Select the customer's index");
            index = CRMUtility.readInt();

            if(index == -1) {
                return;
            }

            Customer c = customerList.getCustomer(index - 1);
            if(c == null) {
                System.out.println("Not a valid number");
            } else {
                break;
            }
        }
        System.out.println("Are you sure?(Y/N)");
        char confirm = CRMUtility.readConfirmSelection();

        if(confirm == 'Y') {
            customerList.deleteCustomer(index - 1);
            System.out.println("---Success---");


        } else {
            System.out.println("---Nothing Changed---");

            return;
        }

    }

    /**
     * List all customers
     */
    public void listAllCustomers() {
        System.out.println("---Customer List---\n");

        int total = customerList.getTotal();
        if(total == 0) {
            System.out.println("No customer record");
        } else {
            System.out.println("ID\tName\tGender\tAge\tPhone\tEmail");
            Customer[] cusList = customerList.getAllCustomers();

            for(int i = 0; i < cusList.length; i++) {
                Customer cust = cusList[i];
                System.out.println((i + 1) + "\t" + cust.getName() + "\t\t" + cust.getGender() + "\t\t"
                 + cust.getAge() + "\t" + cust.getPhone() + "\t" + cust.getEmail());
            }
        }
        System.out.println("---Complete List---\n");



    }

    public static void main(String[] args) {
        CustomerView view = new CustomerView();
        view.enterMainMenu();

    }
}
