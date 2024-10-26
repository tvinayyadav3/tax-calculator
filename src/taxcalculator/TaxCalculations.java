package taxcalculator;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TaxCalculations {
	
		Tax obj;
		static double taxAmount;
		static double taxRate;
		static void taxCalc(Tax obj)
		{
			if(obj.income<30000)
			{
				taxRate=0;
				taxAmount=obj.getIncome()*taxRate;
			}
			else if(obj.income>30000 && obj.income<60000)
			{
				taxRate=0.1;
				taxAmount=obj.getIncome()*taxRate;
			}
			else if(obj.income>60000 && obj.income<120000)
			{
				taxRate=0.2;
				taxAmount=obj.getIncome()*taxRate;
			}
			else if(obj.income>60000 && obj.income<100000)
			{
				taxRate=0.3;
				taxAmount=obj.getIncome()*taxRate;
			}
			else if( obj.income>100000)
			{
				taxRate=0.3;
				taxAmount=obj.getIncome()*taxRate;
			}
		}
		public static void addPerson(Tax obj,Connection con) throws SQLException
		{
			taxCalc(obj);
		    double amt=taxAmount;
		    double rate=taxRate;
			PreparedStatement ps=con.prepareStatement("insert into tax_details values(?,?,?,?,?)");
			ps.setInt(1,obj.getId());
			ps.setString(2, obj.getName());
			ps.setDouble(3, obj.getIncome());
			ps.setDouble(4, rate);
			ps.setDouble(5, amt);
			ps.execute();
			
			
		}
		
		public static void removePersonByName(Connection con,int id) throws SQLException
		{
			PreparedStatement ps=con.prepareStatement("delete from tax_details where id=?");
			ps.setInt(1, id);
			ps.execute();
			
		}
		
		public static void getYourTaxDetailsById(Connection con,int id) throws SQLException 
		
		{

			Statement s=con.createStatement();
			
			ResultSet rs=s.executeQuery("select * from tax_details where id= "+id);
			while(rs.next())
			{
					System.out.println("Name: "+rs.getString("name"));
					System.out.println("Income: "+rs.getString("income"));
					System.out.println("Tax rate: "+rs.getString("taxRate"));
					System.out.println("Tax Amount to be paid: "+rs.getString("taxAmount"));
					if(rs.getDouble("taxAmount")>0)
					{
						System.out.println("You need to pay your tax");
//						payYourTax(con,id);
					}
					else if(rs.getDouble("income")<30000)
					{
						System.out.println("No need to pay any tax,As you are an eligible user of Zero percent tax");
					}
					else
					{
						removePersonByName(con,id);
						System.out.println("You have already paid your tax");
					}
			}
			
		}
		
		public static void payYourTax(Connection con,int id) throws SQLException 
		
		{
			if(taxAmount>0)
			{
			PreparedStatement ps=con.prepareStatement("update tax_details set taxRate=0,taxAmount=0 where id= ?");
			ps.setInt(1, id);
			ps.execute();
			System.out.println("Payment is successfull you can check your tax info");
			}
//			if(taxAmount==0)
//			{
//				
//				removePersonByName(con,id);
//				System.out.println("Tax paid successfully");
//			}

		}

}
