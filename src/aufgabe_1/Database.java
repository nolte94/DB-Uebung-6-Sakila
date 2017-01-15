package aufgabe_1;

import java.sql.SQLException;
import java.sql.Timestamp;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;

public class Database {
	
	private static Timestamp timeStamp = new Timestamp(System.currentTimeMillis());

	public static void main(String[] args) {
		
		String 	host = args[0], 
				db = args[1],
				pwd = args[2],
				user = db;
		try {
			// Eine Verbindung zur Datenbank erstellen
			String url = "jdbc:mysql://"+host+"/"+db+"?user="+user+"&password="+pwd;
			ConnectionSource connectionSource = new JdbcConnectionSource(url);
			
			//Ein DAO (data access object) fuer die Kunden Tabelle erstellen
			Dao<Customer,Integer> customerDao = DaoManager.createDao(connectionSource, Customer.class);
			
			//Ein Dao fuer eine Adresse erstellen
			Dao<Address, Integer> addressDao = DaoManager.createDao(connectionSource, Address.class);
			
			//Eine Adresse erstellen
			Address address = new Address("Musterstraße 123","","Maxdistrict",1,"10032","04321/1234567",timeStamp);
			
			//Eine Adresse in Datenbank erstellen
			addressDao.create(address);
			
			//Einen Kunden erstellen
			Customer customer = new Customer(1,"Max","Mustermann","mm@test.com",1,timeStamp,timeStamp,null);
			customer.setAddress(address);
			
			//Einen Kunden in Datenbank speichern
			customerDao.create(customer);
			
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
	}

}
