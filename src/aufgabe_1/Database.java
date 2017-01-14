package aufgabe_1;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Calendar;


public class Database {
	
	private static String tablecustomer = "customer";
	private static String tableaddress = "address";
	private static String headaddress = "(address,address2,district,city_id,postal_code,phone,last_update)";
	private static String headcustomer = "(store_id,first_name,last_name,email,address_id,active,create_date,last_update)";
	private static String insertcustomer = "insert into "+tablecustomer+" "+headcustomer+" values ";
	//private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-mm-dd hh:mm:ss");
	private static String date = LocalDate.now().toString();
	private static String insertaddress = "insert into "+tableaddress+" "+headaddress+" values ";

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
			// Statement erzeugen and Query ausführen
			String updateaddress = insertaddress + "("+new Address(
					"'Lindenstraße'",
					"'Müllerallee'",
					"'Lübeck'",
					(short)1,
					"'23566'",
					"'01764843232'",
					null).getValues() +")";	

			Statement stmtAddress = conn.createStatement();
			stmtAddress.executeUpdate(updateaddress,Statement.RETURN_GENERATED_KEYS);
			ResultSet resAddress = stmtAddress.getGeneratedKeys();
			
			String updatecustomer = insertcustomer + "("+new Customer(
					(short)1, 
					"'Max'", 
					"'Mustermann'", 
					"'mm@test.com'", 
					(short)(resAddress.next() ? resAddress.getInt(1):-1), 
					(short)1, 
					//Date.valueOf(date),
					null,
					//Time.valueOf(date)).getValues()
					null).getValues()
					+")";
			
			conn.createStatement().executeUpdate(updatecustomer);
			Statement stmt1 = conn.createStatement();
			stmt1.execute("SET FOREIGN_KEY_CHECKS=1");
			stmt1.close();
			conn.close();
			//}
			//res.close();
			//stmt.close();
			} catch (SQLException | ClassNotFoundException ex) {
				ex.printStackTrace();
			}
	}

}
