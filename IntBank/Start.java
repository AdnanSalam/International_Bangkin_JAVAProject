import java.util.Scanner;
import myPackage.accountManagement.*;
import myPackage.employeeCustomerManagement.*;
import myPackage.transectionManagement.*;

public class Start
{
	public static void main(String args[])
	{
		mainMenu();
	}
	public static void mainMenu(){
		try
		{
			Bank bank=new Bank();
			Employee existingEmployee=new Employee();
			Customer existingCustomer=new Customer();
			System.out.println("\n\n A Bank by AIUBians for Everyone!\n\n");
			System.out.println("****************************************** Welcome to the No. 1 Bank ******************************************");
			Scanner input=new Scanner(System.in);
			int option;
			do
			{
				System.out.println("1. Employee Management\n2. Customer Management\n3. Account Management\n4. Account Transactions\n5. Exit");
				option=input.nextInt();
				input.nextLine();
				if(option==1)
				{
					String name;
					String empId;
					double salary;
					Employee newEmployee=new Employee();
					System.out.println("1. Insert New Employee\n2. Remove Existing Employee\n3. Show All Employees\n4. Going Back");
					option=input.nextInt();
					input.nextLine();
					if(option==1)
					{
						System.out.println("Enter the name of employee");
						name=input.nextLine();
						newEmployee.setName(name);
						System.out.println("Enter employee's ID");
						empId=input.nextLine();
						newEmployee.setEmpId(empId);
						System.out.println("Enter employee's salary");
						salary=input.nextDouble();
						newEmployee.setSalary(salary);
						bank.insertEmployee(newEmployee);
					}
					else if(option==2)
					{
						System.out.println("Enter employee's ID");
						empId=input.nextLine();
						bank.removeEmployee(bank.getEmployee(empId));
					}
					else if(option==3)
					{
						bank.showAllEmployees();
					}
					else if(option==4){
						mainMenu();
					}
					else
					{
						System.out.println("No such option\nPlease select another option");
					}
				}
				else if(option==2)
				{
					String name;
					int nid;
					Customer newCustomer=new Customer();
					System.out.println("1. Insert New Customer\n2. Remove Existing Customer\n3. Show All Customer\n 4. Going Back");
					option=input.nextInt();
					input.nextLine();
					if(option==1)
					{
						System.out.println("Enter the name of customer");
						name=input.nextLine();
						newCustomer.setName(name);
						System.out.println("Enter customer's NID");
						nid=input.nextInt();
						input.nextLine();
						newCustomer.setNid(nid);
						bank.insertCustomer(newCustomer);
					}
					else if(option==2)
					{
						System.out.println("Enter customer's NID");
						nid=input.nextInt();
						input.nextLine();
						bank.removeCustomer(bank.getCustomer(nid));
					}
					else if(option==3)
					{
						bank.showAllCustomers();
					}
					else if(option==4){
						mainMenu();
					}
					else
					{
						System.out.println("No such option\nPlease select another option");
					}
				}
				else if(option==3)
				{
					int accountNumber;
					double balance;
					double interestRate;
					int tenureYear;
					System.out.println("1. Insert New Account\n2. Remove Existing Account\n3. Show All Accounts\n 4. Going Back");
					option=input.nextInt();
					input.nextLine();
					if(option==1)
					{
						System.out.println("1. New Account\n2. Going Back");
						option=input.nextInt();
						input.nextLine();
						if(option==1)
						{
							myAccount s=new myAccount();
							System.out.println("Enter account number");
							accountNumber=input.nextInt();
							input.nextLine();
							s.setAccountNumber(accountNumber);
							System.out.println("Enter account's balance");
							balance=input.nextDouble();
							input.nextLine();
							s.setBalance(balance);
							existingCustomer.insertAccount(s);
						}
						
						else if(option==2){
							mainMenu();
						}
					}
					else if(option==2)
					{
						System.out.println("Enter account number");
						accountNumber=input.nextInt();
						input.nextLine();
						existingCustomer.removeAccount(existingCustomer.getAccount(accountNumber));
					}
					else if(option==3)
					{
						existingCustomer.showAllAccounts();
					}
					else if(option==0){
						mainMenu();
					}
					else
					{
						System.out.println("No such option\nPlease select another option");
					}
				}
				else if(option==4)
				{
					int accountNumber;
					double amount;
					System.out.println("1. Deposit Money\n2. Withdraw Money\n3. Going Back");
					option=input.nextInt();
					input.nextLine();
					if(option==1)
					{
						System.out.println("Enter account number in which you want to deposit money");
						accountNumber=input.nextInt();
						input.nextLine();
						System.out.println("Enter amount of money to deposit");
						amount=input.nextDouble();
						input.nextLine();
						(existingCustomer.getAccount(accountNumber)).createDirectory();
						(existingCustomer.getAccount(accountNumber)).deposit(amount);
					}
					else if(option==2)
					{
						System.out.println("Enter account number from which you want to withdraw money");
						accountNumber=input.nextInt();
						input.nextLine();
						System.out.println("Enter amount of money to withdraw");
						amount=input.nextDouble();
						input.nextLine();
						(existingCustomer.getAccount(accountNumber)).createDirectory();
						(existingCustomer.getAccount(accountNumber)).withdraw(amount);
					}
					
					else if(option==3){
						mainMenu();
					}
					else
					{
						System.out.println("No such option\nPlease select the correct option to go back to Main Menu");
					}
				}
				else if(option==0){
					mainMenu();
				}
				else
				{
					if(option!=5)
					{
						System.out.println("No such option\nPlease select the correct option to go back to  Main Menu");
					}
					else if(option==0){
						mainMenu();
					}
					else
					{
						System.out.println("Program exited");
					}
				}

			}while(option!=5);
		}
		catch(Exception ex)
		{
			System.out.println("Wrong input\nProgram exited\n 0. Main Menu");
		}
	}
}
