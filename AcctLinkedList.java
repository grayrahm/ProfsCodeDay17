import java.util.LinkedList;

public class AcctLinkedList implements IAccountDataStructure {

    LinkedList<Account> accounts;

    public Account findByNumber( int acctNum) throws NullPointerException{
        for (Account acct:accounts) {
            if (acct.checkNumber(acctNum))
                return acct;
        }
        throw new NullPointerException();
    }
}
