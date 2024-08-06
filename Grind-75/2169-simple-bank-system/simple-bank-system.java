class Bank {
    private long[] bal;

    public Bank(long[] balance) {
        bal = new long[balance.length];
        for (int i = 0; i < balance.length; i++) {
            bal[i] = balance[i];
        }
    }
    
    public boolean transfer(int account1, int account2, long money) {
        if (!isValid(account1, money)) return false;
        if (!isValid(account2)) return false;
        bal[account1 - 1] -= money;
        bal[account2 - 1] += money;
        return true;
    }
    
    public boolean deposit(int account, long money) {
        if (!isValid(account)) return false;
        bal[account - 1] += money;
        return true;
    }
    
    public boolean withdraw(int account, long money) {
        if (!isValid(account, money)) return false;
        bal[account - 1] -= money;
        return true;
    }

    private boolean isValid(int account) {
        return account > 0 && account <= bal.length;
    }

    private boolean isValid(int account, long money) {
        return isValid(account) && bal[account - 1] >= money;
    }
}

/**
 * Your Bank object will be instantiated and called as such:
 * Bank obj = new Bank(balance);
 * boolean param_1 = obj.transfer(account1,account2,money);
 * boolean param_2 = obj.deposit(account,money);
 * boolean param_3 = obj.withdraw(account,money);
 */