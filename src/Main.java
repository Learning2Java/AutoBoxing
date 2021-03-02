public class Main {

    public static void main(String[] args) {

        Bank bank = new Bank("National Australia Bank");

        bank.addBranch("Adelaide");

        bank.addCustomer("Adelaide", "Tim", 50);

        bank.listCustomers("Adelaide", false);
        bank.addCustomer("Adelaide", "Mike", 50);
        bank.addCustomer("Adelaide", "Percy", 50);

        bank.addBranch("Sydney");
        bank.addCustomer("Sydney", "Bob", 1500);

/*        bank.addTransaction("Adelaide", "Tim", 44);
        bank.addTransaction("Adelaide", "Tim", 30);
        bank.addTransaction("Adelaide", "Mike", 44);*/

        bank.listCustomers("Adelaide", false);
    }
}
