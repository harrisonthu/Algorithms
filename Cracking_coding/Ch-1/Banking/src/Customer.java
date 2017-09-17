
//import java.io.PrintStream;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.List;
import javax.swing.JOptionPane;

public class Customer {
	private String lname;
	private String idNumber;
	private double balance;
	private long phone;
	private NumberFormat fmt = NumberFormat.getCurrencyInstance();
	// private final double RATE = 0.045D;

	/**
	 * Default Constructor for Customer
	 * <p>
	 * This method always set the new customer name, idNumber, balance, phone
	 * from user's input
	 *
	 * @param lname
	 *            Last Name of a new Customer
	 * @param phone2
	 *            Phone Number of a new Customer
	 * @param balance
	 *            current amount of money that a new Customer has owned
	 * @param custNumber
	 *            IdNumber of a new Customer
	 * @return
	 */

	public Customer(String lname, long phone2, double balance, String custNumber) {
		this.lname = lname;
		this.idNumber = custNumber;
		this.balance = balance;
		this.phone = phone2;
	}

	/**
	 * Default Constructor for Customer
	 * <p>
	 * 
	 * @return
	 */
	public Customer() {
	}

	/**
	 * Method for withdrawing money
	 * <p>
	 * This method is taking care of withdrawing money from Customer's Account
	 *
	 * @param amount
	 *            the amount of money that withdraw from the specific Customer
	 *            account
	 * @return double type customer balance
	 */
	public double withdraw(double amount) {
		if (amount <= 0.0D) // Withdraw amount is less than 0
		{
			JOptionPane.showMessageDialog(null,
					"Error: Withdrawl must be greater than 0 \nCustomer: " + this.getCustomerName() + "\nRequested: "
							+ this.fmt.format(amount) + "\nAvailable: " + this.fmt.format(balance));
		} else if (amount > balance) // Withdrawal amount is larger than the
										// balance
		{
			JOptionPane.showMessageDialog(null, "Error: Insufficient funds. \nCustomer: " + this.getCustomerName()
					+ "\nRequested: " + this.fmt.format(amount) + "\nAvailable: " + this.fmt.format(balance));
		} else {
			amount += 1.5D;
			balance -= amount;
		}
		return balance;
	}

	/**
	 * Method for depositing money
	 * <p>
	 * This method is taking care of depositing money into Customer's Account,
	 * plus calculating the interest rate.
	 *
	 * @param amount
	 *            the amount of money that withdraw from the specific Customer
	 *            account
	 * @return double type customer balance with interest rate
	 */
	public double deposit(double amount) {
		if (amount < 0.0D) {
			System.out.println();
			System.out.println("Error: Deposit amount is invalid.");
			System.out.println(this.idNumber + "  " + this.fmt.format(amount));

			JOptionPane.showMessageDialog(null, "Error: Deposit amount is invalid. \nCustomer: "
					+ this.getCustomerName() + "\nRequested: " + this.fmt.format(amount));

		} else {
			this.balance += amount;
		}
		return this.balance;
	}

	/**
	 * Method for calculating interest rate
	 * 
	 * @param
	 * @return double type: Add interest rate into customer balance
	 */
	public double addInterest() {
		return this.balance += this.balance * 0.045D;
	}

	/**
	 * Method for returning particular Customer's balance
	 * 
	 * @param
	 * @return double type: customer balance
	 */

	public double getBalance() {
		return this.balance;
	}

	/**
	 * Setter method for particular Customer's balance
	 * 
	 * @param balance:
	 *            current amount of money that a Customer has owned
	 * @return void
	 */
	public void setBalance(double balance) {
		this.balance = balance;
	}

	/**
	 * Getter method for particular Customer's Phone Number
	 * 
	 * @param
	 * @return long type: Particular Customer Phone Number
	 */
	public long getPhoneNumber() {
		return this.phone;
	}

	/**
	 * Setter method for particular Customer's Phone Number
	 * 
	 * @param phoneNumber:
	 *            current Customer's Phone Number
	 * @return void
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phone = Long.valueOf(phoneNumber).longValue();
	}

	/**
	 * Getter method for particular Customer's Phone Number
	 * 
	 * @param
	 * @return long type: Particular Customer Phone Number
	 */
	public long getCustomerNumber() {
		return Long.valueOf(this.idNumber).longValue();
	}

	/**
	 * Setter method for particular Customer's idNumber
	 * 
	 * @param idNumber:
	 *            current Customer's idNumber
	 * @return void
	 */
	public void setID(String idNumber) {
		this.idNumber = idNumber;
	}

	/**
	 * method for returning Customer's Phone Number
	 * 
	 * @param
	 * @return String type: Particular Customer Name
	 */
	public String getCustomerName() {
		return this.lname;
	}

	/**
	 * Setter method for particular Customer's idNumber
	 * 
	 * @param idNumber:
	 *            current Customer's idNumber
	 * @return void
	 */
	public void setName(String name) {
		this.lname = name;
	}

	/**
	 * Method for finding the index in Customer ArrayList The method will return
	 * the index of the customer in the list, or return -1 if the customer is
	 * not in the array
	 * 
	 * @param custsArray:
	 *            Customer's ArrayList
	 * @param xnam:
	 *            the particular index of a Customer
	 * @param count:
	 *            total number of customers
	 * @return int: -1 for name not found
	 * 
	 */
	public int findIndex(Customer[] custsArray, String xnam, int count) {
		// ---------------------------------------------------------------
		if (count <= 0) {
			System.out.println("count is zero");

		}
		for (int index = 0; index < count; index++) // search the entire
		// table until a match is found
		{
			// if (custsArray[index].getName().compareTo(xnam.toUpperCase()) ==
			// 0)
			if (custsArray[index].getCustomerName().compareTo(xnam) == 0)
				return index;

		} // end index < custsArray count

		// return a -1 to imply a matching name- name not found!
		return -1;
	} // end for givenNameGetCustomer

	// ToString method, printing out all of the particular customer's
	// attributes(name, balanc, phone, idnumber)

	public String toString() {
		return (lname + "\t" + idNumber + "\t" + fmt.format(balance) + "\t" + phone);
	}

	/**
	 * Method to sort the customer array in alphabetical order by name. Using
	 * the select sort.
	 * 
	 * @param custsArray:
	 *            Customer's ArrayList
	 * @param count:
	 *            total number of customers
	 * @return void:
	 */
	public static void nameSort(Customer[] custsArray, int count) {

		if (count < 0) {
			System.out.println("hahah");
		}
		for (int i = 0; i < count - 1; i++) {
			boolean exchange = false;
			int smallPos = i;
			for (int j = i + 1; j < count; j++) {
				System.out.println(Arrays.toString(custsArray));
				System.out.println("" + i + j);
				if (custsArray[smallPos].getCustomerName().compareTo(custsArray[j].getCustomerName()) > 0) {
					smallPos = j;
					exchange = true;
				}
			}
			// switch smallest to ith location
			if (exchange) {
				Customer temp = custsArray[i];
				custsArray[i] = custsArray[smallPos];
				custsArray[smallPos] = temp;
				exchange = false;
			}
		} // end for i loop
	} // end method nameSort

	// addNewCustomer method that adds new customer into customers arraylist
	public void addNewCustomer(Customer[] custsArray, int count, String name, long custNumber, double balance2,
			String phone2) {

		Customer newcustomer = new Customer(name, custNumber, balance2, phone2);
		custsArray.toString();
		// custsArray.length +=1;
		System.out.println(newcustomer.lname);
		System.out.println(newcustomer.idNumber);
		// newcustomer.setBalance(fmt.format(balance2));
		System.out.println(newcustomer.balance);
		System.out.println(newcustomer.phone);
	}

}
