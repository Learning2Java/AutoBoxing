import java.util.ArrayList;

public class Branch {
    private ArrayList<Customer> customers;
    private String branchName;

    public Branch(String branchName) {
        this.branchName = branchName;
        this.customers = new ArrayList<Customer>();
    }

    public String getBranchName() {
        return branchName;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public boolean addCustomer(String customerName, double initialAmount) {
        if(findCustomer(customerName) >= 0) {
            System.out.println("Customer already exists");
            return false;
        }
        System.out.println("adding customer: " + customerName);
        System.out.println("Customer list is " + this.customers.size());
        this.customers.add(new Customer(customerName, initialAmount));

        System.out.println(this.customers.get(0).getName());
        return true;

    }

    public boolean transaction(String customerName, double deposit) {
        Customer customer = new Customer(customerName, deposit);


        if(findCustomer(customerName)>=0) {
            System.out.println("Customer in system: Depositing " + deposit);
            if(balance(customerName)< 0) {
                System.out.println("Not enough money for withdrawal");
                return false;
            }
            customer.setTransaction(deposit);
            return true;
        }
        System.out.println("Customer not in system");
        return false;
    }

    public double balance(String customerName) {
        Customer customer = new Customer(customerName, 0);
        double balance = 0;
        ArrayList<Double> transaction = customer.getTransaction();
        double currentBalance = transaction.get(transaction.size() - 1);
        if(balance + currentBalance< 0) {
            System.out.println("Not enough money for withdrawal");
            return -1;
        }
        balance += currentBalance;
        return balance;
    }

    private int findCustomer(String customerName) {
        System.out.println(this.customers.size());
        for(int i = 0; i < this.customers.size(); i++) {
            Customer customer = this.customers.get(i);
            System.out.println(customer.getName() + "here");
            if(this.customers.get(i).getName().equals(customerName)) {
                return i;
            }
        }
        return -1;

    }
}
