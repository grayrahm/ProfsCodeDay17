import java.util.LinkedList;

public class CustomerLinkedList implements ICustDataStructure {

    LinkedList<Customer> customers;

    public Customer findCustomer(String custname, int withPwd) {
        for (Customer cust : customers) {
            if (cust.checkName(custname)) {
                if (cust.checkPassword(withPwd)) {
                    return cust;

                }
            }

        }
        return null;

    }

}
