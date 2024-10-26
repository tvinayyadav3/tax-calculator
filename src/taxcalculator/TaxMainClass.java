package taxcalculator;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;
import taxcalculator.TaxDatabaseConnection.TaxDbCon;

public class TaxMainClass {

		public static void main(String[] args) throws SQLException {
			Connection con=TaxDbCon.getCon();
			Scanner s=new Scanner(System.in);
			int n;
			do {
				System.out.println("1.Calculate Tax");
				System.out.println("2.Get Tax info");
				System.out.println("3.Pay your tax");
				System.out.println("4.Exit");
				n=s.nextInt();
				switch(n)
				{
				case 1:
					System.out.println("Enter your details");
					System.out.println("Enter your id: ");
					int id=s.nextInt();
					System.out.println("Enter your name: ");
					String name=s.next();
					System.out.println("Enter your income: ");
					double income=s.nextDouble();
					Tax t=new Tax(id,name,income);
					TaxCalculations.addPerson(t,con);
					break;
				case 2:
					System.out.println("Get your details");
					System.out.println("Enter your id:");
					int idd=s.nextInt();
					
					TaxCalculations.getYourTaxDetailsById(con, idd);
					break;
				case 3:
					System.out.println("Pay your tax");
					System.out.println("Enter your id:");
					int yourId=s.nextInt();
					TaxCalculations.payYourTax(con, yourId);
					break;
				case 4:
					System.out.println("Exited");
					break;
				default:
					System.out.println("Invalid option, Enter valid option");
					break;
				}
				
			}while(n!=4);

	}

}
