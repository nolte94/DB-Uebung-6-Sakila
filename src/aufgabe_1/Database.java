package aufgabe_1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;



public class Database {
	
	private static Timestamp timeStamp = new Timestamp(System.currentTimeMillis());
	private static String 	time = "'"+new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(timeStamp)+"'",
							tablecustomer = "customer",
							tableaddress = "address",
							headaddress = "(address,address2,district,city_id,postal_code,phone,last_update)",
							headcustomer = "(store_id,first_name,last_name,email,address_id,active,create_date,last_update)",
							insertcustomer = "insert into "+tablecustomer+" "+headcustomer+" values ",
							insertaddress = "insert into "+tableaddress+" "+headaddress+" values ";

	public static void main(String[] args) {
		
		String 	host = args[0], 
				db = args[1],
				pwd = args[2],
				user = db;
		try {
			// DBS‐JDBC‐Treiber laden
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// DBS‐Verbindung herstellen
			Connection conn =
			DriverManager.getConnection("jdbc:mysql://"+host+"/"+db+"?user="+user+"&password="+pwd);
			
			// Update der Adresse erstellen
			String updateaddress = insertaddress + 
					"("+ 
					new Address(
					"'Lindenstraße'",
					"'Müllerallee'",
					"'Lübeck'",
					(short)1,
					"'23566'",
					"'01764843232'",
					time).getValues() 
					+")";	
			
			// Statement fuer Adresse erzeugen and Query ausführen
			Statement stmtAddress = conn.createStatement();
			stmtAddress.executeUpdate(updateaddress,Statement.RETURN_GENERATED_KEYS);
			
			//Primary keys der letzten Query
			ResultSet resAddress = stmtAddress.getGeneratedKeys();
			
			// Update des Kunden erstellen
//			String updatecustomer = insertcustomer + 
//					"(" + 
//					new Customer(
//					(short)1, 
//					"'Max'", 
//					"'Mustermann'", 
//					"'mm@test.com'", 
//					(short)(resAddress.next() ? resAddress.getInt(1):-1), 
//					(short)1, 
//					time,
//					time).getValues()
//					+")";
			
			// Statement fuer Kunden erzeugen and Query ausführen
			//conn.createStatement().executeUpdate(updatecustomer);
			
			//Alle IO-Streams der Verbindung schließen
			stmtAddress.close();
			resAddress.close();
			conn.close();

			} catch (SQLException | ClassNotFoundException ex) {
				ex.printStackTrace();
			}
	}

}
