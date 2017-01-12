import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Database {
	
	private static String user = "Mo14a_1", pass = "dDGpq8DXGe4Q",host = "slo.swe.fh-luebeck.de",db=user;

	public static void main(String[] args) {
		try {
			// DBS‐JDBC‐Treiber laden
			Class.forName("com.mysql.cj.jdbc.Driver");
			// DBS‐Verbindung herstellen
			Connection conn =
			DriverManager.getConnection("jdbc:mysql://"+host+"/"+db+"?user="+user+"&password="+pass);
//			// Statement erzeugen and Query ausführen
//			Statement stmt = conn.createStatement();
//			ResultSet res = stmt.executeQuery("SELECT isbn, title FROM book");
//			Integer columns = res.getMetaData().getColumnCount();
//			// ResultSet verarbelten
//			while (res.next()) {
//			for (int i = 1; i <= columns; i++) {
//			Object o = res.getObject(i);
//			System.out.println(o);
//			}
			conn.close();
			//}
			//res.close();
			//stmt.close();
			} catch (SQLException | ClassNotFoundException ex) {
				ex.printStackTrace();
			}
	}

}
