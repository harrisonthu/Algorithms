
//****************************************************************
//*Program Name: Project1
//*Author: Han Thu
//*Abstract: Customer Account , looping,
//*    The bank class should have method called runBankTest() method to control 
//*    the invocation of all the required methods
//*    Running the programs from testcases (customer.txt).
//*Note to run this program: click the run button on eclipse
//*----------------------------------------
//*Class: BankDriver
//*Methods: Several methods to process , retrieve and displays the Accounts
//* Must include formulas
//********************************************************************

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.text.NumberFormat;
import java.util.List;
import java.util.StringTokenizer;

import javax.swing.JOptionPane;

/**
 * @author han Class for BankDriver that contains a method called runBankTest()
 *         to control the invocation of all the required methods
 */
public class BankDriver {

	// Declaring Instance Variables
	private NumberFormat fmt = NumberFormat.getCurrencyInstance();
	final double FEE = 1.5D;
	final int MAX = 30;
	Customer[] custsArray = new Customer[30];
	int count = 0;
	int index;
	StringTokenizer tokenizer;
	String line;
	String file = "/home/han/GIT/Cracking_coding/Ch-1/Banking/src/Customer.txt"; // Input file path
	String name;
	long custNumber;
	double balance;
	String phone;
	boolean quit = false;
	int choice;
	String OutPutText = "";
	String xnam;

	@SuppressWarnings("static-access")
	public void runBankTest() {
		System.out.println("Welcome to the ES&L Bank");
		try {
			FileReader fr = new FileReader(this.file);
			BufferedReader inFile = new BufferedReader(fr);

			this.line = inFile.readLine();
			while ((this.line != null) && (this.count < 30)) {
				this.tokenizer = new StringTokenizer(this.line);
				this.name = this.tokenizer.nextToken();
				try {
					this.custNumber = Long.parseLong(this.tokenizer.nextToken());

					this.balance = Double.parseDouble(this.tokenizer.nextToken());

					this.phone = this.tokenizer.nextToken();

					this.custsArray[(this.count++)] = new Customer(this.name, this.custNumber, this.balance,
							this.phone);
				} catch (NumberFormatException exception) {
					System.out.println("Error in input. Line ignored: ");
					System.out.println(this.line);
				}
				this.line = inFile.readLine();
			}
			inFile.close();

			System.out.println(" \t\tUnsorted customer.txt records");
			System.out.println("");
			for (int scan = 0; scan < this.count; scan++) {
				System.out.println(this.custsArray[scan]);
			}
			while (!quit) {

				String strChoice = JOptionPane.showInputDialog(null,
						"Please select an option: \n\t1. Deposit sum to account\n\t2. Withdraw sum from account\n\t3. Create account\n\t4. View all accounts\n\t5. Delete an account\n\t9. Quit",

						"ES&L Bank", 3);
				// System.out.println("this is strChoice: " + strChoice);
				// if (strChoice == null){
				// System.out.println("STRCHOICE IS NULL KWA");
				// strChoice = "5";
				// }
				if (strChoice == "2") {
					System.out.println("I am here");
				}
				this.choice = Integer.parseInt(strChoice);

				
				// Pop up 
				switch (this.choice) {
				
				// Take input form user for any options
				case 1:
					this.xnam = JOptionPane.showInputDialog(null, "Enter the Customer's Name: ", "ES&L Bank System", 3);

					this.index = this.custsArray[0].findIndex(this.custsArray, this.xnam, this.count);
					if (this.index != -1) {
						System.out.println("");

						String strDepositAmt = JOptionPane.showInputDialog(null, "Enter the deposit, e.g., 10000.00: ",
								"ES&L Bank System", 3);

						double depositAmt = Double.parseDouble(strDepositAmt);

						this.custsArray[this.index].deposit(depositAmt);

						JOptionPane.showMessageDialog(null,
								this.xnam + " balance after deposit: "
										+ this.fmt.format(this.custsArray[this.index].getBalance()) + "\n" + this.xnam
										+ " balance after interest is added: "
										+ this.fmt.format(this.custsArray[this.index].addInterest()),
								"ES&L Bank System", 1);
					} else {
						System.out.println("");
						System.out.println(this.xnam + " was not found");
					}
					break;
				case 2:
					this.xnam = JOptionPane.showInputDialog(null, "Enter the Customer's Name: ", "ES&L Bank System", 3);

					this.index = this.custsArray[0].findIndex(this.custsArray, this.xnam, this.count);
					if (this.index != -1) {
						System.out.println("");

						String strWithdrawAmt = JOptionPane.showInputDialog(null, "Enter the withdrawal, e.g., 10.00: ",
								"ES&L Bank System", 3);

						double withdrawAmt = Double.parseDouble(strWithdrawAmt);
						// if ((withdrawAmt -
						// (this.custsArray[this.index].getBalance())) <0){
						// String temp =
						// this.fmt.format(this.custsArray[this.index].withdraw(withdrawAmt));
						// System.out.println("temp:" +temp);
						if (withdrawAmt >= 0) {
							JOptionPane.showMessageDialog(null,
									this.xnam + " balance after withdrawal: "
											+ this.fmt.format(this.custsArray[this.index].withdraw(withdrawAmt)) + "\n"
											+ this.xnam + " balance after interest is added: "
											+ this.fmt.format(this.custsArray[this.index].addInterest()),
									"ES&L Bank System", 1);

						} else {
							JOptionPane.showMessageDialog(null,
									"Error: Withdrawl must be greater than 0 \nCustomer: " + this.xnam + "\nRequested: "
											+ this.fmt.format(withdrawAmt) + "\nAvailable: "
											+ this.fmt.format(balance));
							continue;
						}
					} else {
						System.out.println("");
						System.out.println(this.xnam + " was not found");
					}
					break;
					
					// Check Customer and print out balance
				case 3:
					if (this.count < this.custsArray.length) {
						this.name = JOptionPane.showInputDialog(null, "Enter Customer's name: ", "ES&L Bank System", 3);

						String strCustNum = JOptionPane.showInputDialog(null, "Enter Customer's Number, e.g., 11111: ",
								"ES&L Bank System", 3);

						this.custNumber = Long.parseLong(strCustNum);

						String strBalance = JOptionPane.showInputDialog(null,
								"Enter Customer's Balance, e.g., 1000.00: ", "ES&L Bank System", 3);

						this.balance = Double.parseDouble(strBalance);

						this.phone = JOptionPane.showInputDialog(null, "Enter Customer's phone number: ",
								"ES&L Bank System", 3);

						this.custsArray[this.count] = new Customer(name, custNumber, balance, phone);
						this.custsArray[this.count].addNewCustomer(this.custsArray, this.count, this.name,
								this.custNumber, this.balance, this.phone);
						this.count += 1;
					} else {
						JOptionPane.showMessageDialog(null, "The array is full. No new record added ",
								"ES&L Bank System", 1);
					}
					break;
					
					// Sorting case
				case 4:
					this.custsArray[0].nameSort(this.custsArray, this.count);

					this.OutPutText = "";
					for (int scan = 0; scan < this.count; scan++) {
						this.OutPutText =

								(this.OutPutText + this.custsArray[scan].getCustomerName() + " "
										+ this.custsArray[scan].getCustomerNumber() + " "
										+ this.fmt.format(this.custsArray[scan].getBalance()) + " "
										+ this.custsArray[scan].getPhoneNumber() + "\n");
					}
					JOptionPane.showMessageDialog(null, this.OutPutText, "ES&L Bank System", 1);

					break;
				case 5:
					this.xnam = JOptionPane.showInputDialog(null, "Enter the Customer's Name: ", "ES&L Bank System", 3);

					this.index = this.custsArray[0].findIndex(this.custsArray, this.xnam, this.count);
					if (this.index != -1) {
						if ((this.count >= 1) && (this.count <= this.custsArray.length)) {
							this.custsArray[this.index] = this.custsArray[(this.count - 1)];
							this.count -= 1;

							JOptionPane.showMessageDialog(null, this.xnam + " is deleted. ", "ES&L Bank System", 1);
						}
					} else {
						JOptionPane.showMessageDialog(null, this.xnam + " was not found ", "ES&L Bank System", 1);
					}
					break;
				default:
					this.quit = true;
				}
			}
			Customer.nameSort(this.custsArray, this.count);

			System.out.println("");
			System.out.println(" \t\tSorted updated customer.txt records");
			for (int scan = 0; scan < this.count; scan++) {
				System.out.println(this.custsArray[scan]);
			}
		} catch (FileNotFoundException exception) {
			System.out.println("The file " + this.file + " was not found");
		} catch (IOException exception) {
			System.out.println(exception);
		}
	}

	/**
	 * Main method to run the whole program
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		BankDriver bankTest = new BankDriver();
		// Creating automated testcase
		bankTest.runBankTest();
		System.exit(0);
	}
}
