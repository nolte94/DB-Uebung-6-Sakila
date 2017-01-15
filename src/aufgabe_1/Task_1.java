package aufgabe_1;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Scanner;
import java.util.function.Consumer;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.support.ConnectionSource;

/**
 * @author fhldomi
 *
 */
public class Task_1 implements Consumer<ConnectionSource> {
	
	/**
	 * Daten fuer die Adresse und den Kunden
	 */
	private Timestamp timeStamp = new Timestamp(System.currentTimeMillis());
	
	/**
	 * Daten fuer die Adresse und den Kunden
	 */
	private String 	first_name,
					last_name,
					email,
					address,
					address2,
					district,
					postal_code,
					phone;
	/**
	 * Daten fuer die Adresse und den Kunden
	 */
	private int city_id,store_id,active;
	
	@Override
	public void accept(ConnectionSource connectionSource) {
		try {
			//Ein DAO (data access object) fuer die Kunden Tabelle erstellen
			Dao<Customer,Integer> customerDao = DaoManager.createDao(connectionSource, Customer.class);
			
			//Ein Dao fuer eine Adresse erstellen
			Dao<Address, Integer> addressDao = DaoManager.createDao(connectionSource, Address.class);
			
			//Eine Adresse erstellen
			Address address = new Address(this.address,this.address2,this.district,this.city_id,this.postal_code,this.phone,timeStamp);
			
			//Eine Adresse in Datenbank erstellen
			addressDao.create(address);
			
			//Einen Kunden erstellen
			Customer customer = new Customer(this.store_id,this.first_name,this.last_name,this.email,this.active,timeStamp,timeStamp,null);
			customer.setAddress(address);
			
			//Einen Kunden in Datenbank speichern
			customerDao.create(customer);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Liest die Daten fuer die Adresse und den Kunden von der Konsole ein
	 * @param in2 
	 */
	public void setInput() {
		Scanner in = new Scanner(System.in);
		System.out.println("Kunden erfassen");
		System.out.print("Vorname : ");
		this.first_name = in.nextLine();
		System.out.print("Nachname : ");
		this.last_name = in.nextLine();
		System.out.print("Email : ");
		this.email = in.nextLine();
		System.out.print("Telefon : ");
		this.phone = in.nextLine();
		System.out.print("Adresse : ");
		this.address = in.nextLine();
		System.out.print("Adresse 2 : ");
		this.address2 = in.nextLine();
		System.out.print("Bezirk : ");
		this.district = in.nextLine();
		System.out.print("Postleitzahl : ");
		this.postal_code = in.nextLine();
		System.out.print("Stadt : ");
		this.city_id = in.nextInt();
		System.out.print("Filliale : ");
		this.store_id = in.nextInt();
		System.out.print("Aktivität : ");
		this.active = in.nextInt();
		in.close();
	}

}
