package aufgabe_2;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.Stream;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.dao.GenericRawResults;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.support.ConnectionSource;

import aufgabe_1.Customer;

/**
 * @author fhldomi
 *
 */
public class Task_2 implements Consumer<ConnectionSource> {

	/**
	 * Selektionswert
	 */
	private int whereValue;

	@Override
	public void accept(ConnectionSource connectionSource) {
		try {
			//Ein DAO (data access object) fuer die Kunden Tabelle erstellen
			Dao<Customer, Integer> daoCustomer = DaoManager.createDao(connectionSource,Customer.class);
			//Ein Objekt zur Anfrageerstellung erzeugen
			QueryBuilder<Customer, Integer> query = daoCustomer.queryBuilder();
			//Select statement erzeugen
			query.selectRaw("store_id", "COUNT(customer_id)");
			query.where().eq("active", this.whereValue);
			query.groupBy("store_id");
			//Antwort der Anfrage nach der Validierung vom sql Statement
			GenericRawResults<String[]> customers = daoCustomer.queryRaw(query.prepareStatementString());
			//Ausgabe formatieren
			Stream.of(customers.getColumnNames()).flatMap(Stream::of).forEach(r -> System.out.print(r+"|"));
			System.out.println();
			for (String[] strings : customers) {
				for (String string : strings) {
					//Jeder zweite Wert (n) ist die Anzahl der Kunden die aktiv sind. Die n-1 ist die store_id.
					System.out.println(string);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Legt den Wert zur Selektion fest
	 */
	public void setWhere() {
		Scanner in = new Scanner(System.in);
		System.out.println("SELECT store_id, COUNT(customer_id) FROM customer WHERE active = [Eingabe] GROUP BY store_id");
		System.out.print("Eingabe : ");
		this.whereValue = in.nextInt();
		in.close();
	}

}
