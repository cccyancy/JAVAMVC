package CRMExample.Control;

import CRMExample.Model.Customer;

/**
 * @Author
 * @description Manage customer object for CRUD. Call by CustomerView
 * @create 2021-10-13 7:18 PM
 **/

public class CustomerList {
    private Customer[] customers;
    private int total;

    /**
     * Initialize customer constructor
     * @param totalCustomer total length of customer
     */
    public CustomerList(int totalCustomer) {
        customers = new Customer[totalCustomer];
    }

    /**
     * Add customer to the list
     * @param customer the customer to be added
     * @return add successfully or not
     */

    public boolean addCustomer(Customer customer){
        if(total >= customers.length) {
            return false;
        }
        customers[total] = customer;
        total++;
        return true;
    }

    /**
     * change a particular customer's info
     * @param index the index of the custome
     * @param customer customer replacement
     * @return successfully change or not.
     */
    public boolean replaceCustomer(int index, Customer customer) {
        if(index < 0 || index > total - 1) {
            return false;
        }
        customers[index] = customer;
        return true;


    }

    /**
     * Delete a particular customer
     * @param index the customer's index
     * @return successfully deleted
     */
    public boolean  deleteCustomer(int index) {
        if(index < 0 || index > total - 1) {
            return false;
        }

        for(int i = index; i < total - 1; i++) {
            customers[i] = customers[i + 1]; //Because of plus one, for loop should end before its total - 1
        }
        customers[total - 1] = null;
        total--;
        return true;
    }

    /**
     * Get all customer's info
     * @return current customer's info
     */
    public Customer[] getAllCustomers() {
        Customer[] currentCus = new Customer[total];
        for(int i = 0; i < total; i++) {
            currentCus[i] = customers[i];
        }
        return currentCus;

    }

    /**
     * Get the particular customer's info
     * @param index the customer's index
     * @return the index customer's info or null
     */
    public Customer getCustomer(int index) {
        if(index < 0 || index > total - 1) {
            return null;
        }
        return customers[index];
    }
    public int getTotal() {
        return total;
    }

}
