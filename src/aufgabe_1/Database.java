package aufgabe_1;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
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
	
	private static String user = "Mo14a_1", pass = "dDGpq8DXGe4Q",host = "slo.swe.fh-luebeck.de",db=user;
	private static String table = "customer";
	private static String head = "(store_id,first_name,last_name,email,address_id,active,create_date,last_update)";
	private static String insert = "insert into "+table+" "+head+" values ";
	//private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-mm-dd hh:mm:ss");
	private static String date = LocalDate.now().toString();

	public static void main(String[] args) {
		try {
			// DBS‐JDBC‐Treiber laden
			Class.forName("com.mysql.cj.jdbc.Driver");
			// DBS‐Verbindung herstellen
			Connection conn =
			DriverManager.getConnection("jdbc:mysql://"+host+"/"+db+"?user="+user+"&password="+pass);
			// Statement erzeugen and Query ausführen
			String update = insert + "("+new Customer(
					(short)1, 
					"'Max'", 
					"'Mustermann'", 
					"'mm@test.com'", 
					(short)1000, 
					(short)1, 
					//Date.valueOf(date),
					null,
					//Time.valueOf(date)).getValues()
					null).getValues()
					+")";
			Statement stmt = conn.createStatement();
			stmt.execute("SET FOREIGN_KEY_CHECKS=0");
			stmt.close();
			conn.createStatement().executeUpdate(update);
//			Integer columns = res.getMetaData().getColumnCount();
//			// ResultSet verarbelten
//			while (res.next()) {
//			for (int i = 1; i <= columns; i++) {
//			Object o = res.getObject(i);
//			System.out.println(o);
//			}
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
