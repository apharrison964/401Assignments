package lec21.v4;

public class Account {

	private int balance;

	public Account(int init) {
		balance = init;
	}

	public void deposit(int amt) {
		try {
			int current_balance = balance;
			System.out.println("Deposit method reads balance as: " + current_balance);
			Thread.sleep(2000);

			current_balance += amt;
			System.out.println("Deposit method calculates new balance as: " + current_balance);

			Thread.sleep(2000);

			balance = current_balance;
			System.out.println("Deposit stored new balance as: " + balance);
		} catch (Exception e) {
		}
	}

	public void withdraw(int amt) {
		try {
			int current_balance = balance;
			System.out.println("Withdraw method reads balance as: " + current_balance);

			Thread.sleep(2000);

			current_balance -= amt;
			System.out.println("Withdraw method calculates new balance as: " + current_balance);

			Thread.sleep(2000);

			balance = current_balance;
			System.out.println("Withdraw stored new balance as: " + balance);
		} catch (Exception e) {
		}
	}

	public int getBalance() {
		return balance;
	}
}
