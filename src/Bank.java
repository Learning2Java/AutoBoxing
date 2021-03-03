import java.util.ArrayList;

public class Bank {
    private String bankName;
    private ArrayList<Branch> branches;

    public Bank(String bankName) {
        this.bankName = bankName;
        this.branches = new ArrayList<Branch>();
    }


    public boolean addBranch(String branchName) {
        if(findBranch(branchName) < 0) {
            this.branches.add(new Branch(branchName));
            return true;
        }
        return false;
    }

    public boolean addCustomer(String branchName, String customer, double initialAmount) {
        int branchIdx = findBranch(branchName);
        if(branchIdx >= 0) {
            return this.branches.get(branchIdx).addCustomer(customer, initialAmount);
        }
        return false;
    }

    public boolean addTransaction(String branchName, String customer, double deposit) {
        Branch theBranch = new Branch(branchName);
        if(findBranch(branchName) >= 0) {
            theBranch.transaction(customer, deposit);
            return true;
        }
        return false;
    }

    public void listCustomers(String branchName, boolean showTransaction) {
        Branch branch = new Branch(branchName);
        if(findBranch(branchName) >= 0) {
            ArrayList<Customer> branchCustomer = branch.getCustomers();
            for(int i = 0; i < branchCustomer.size(); i++) {
                Customer customer = branchCustomer.get(i);
                System.out.println("Person " + i +1 + ": " + branchCustomer.get(i));
                if(showTransaction) {
                    ArrayList<Double> transaction = customer.getTransaction();
                    for(int j = 0; j < transaction.size(); j++) {
                        System.out.println("Customer: " + (i+1) + transaction.get(i));
                    }
                }
            }

        }
    }

    private int findBranch(String branchName) {
        for(int i = 0; i < this.branches.size(); i++) {
            Branch branch = this.branches.get(i);
            if(branch.getBranchName().equals(branchName)) {
                return i;
            }
        }
        return -1;
    }
}
