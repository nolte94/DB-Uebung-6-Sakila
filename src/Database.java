import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.function.Consumer;

import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;

import aufgabe_1.Task_1;

/**
 * @author fhldomi
 *
 */
public class Database {
	
	/**
	 * Erstellt eine Anwendung zur Kommunikation mit der Datenbank
	 * @param args Daten fuer die Verbindung zur Datenbank
	 */
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String 	host = args[0], 
				db = args[1],
				pwd = args[2],
				user = db;
		
			//Zeichenkette fuer Verbinding zur Datenbank
			String url = "jdbc:mysql://"+host+"/"+db+"?user="+user+"&password="+pwd;
						
			//Eingabe von der Console ermoeglichen
			Scanner in = new Scanner(System.in);

			
			do {
				
				System.out.println();
				
				//Allgemeine Informationen zur Anwendung
				System.out.println("WS 2016/2017 - Praktikum - Datenbanken - Übung-6");
				System.out.println("\nHost: " + host);
				System.out.println("Datenbank: " + db);
				System.out.println("Benutzer: " + user);
				
				//Menue um Anwendungsfall auszuwaehlen
				System.out.println("\nBitte wählen Sie ein Anwendungsfall");
				System.out.println("Anwendungsfall 1: [1]");
				System.out.println("Anwendungsfall 2: [2]");
				System.out.println("Anwendungsfall 3: [3]");
				System.out.print("Auswahl : ");
				int key = in.nextInt();
				System.out.println();
				//Auswertung der Eingabe im Menue
				switch (key) {
				case 1:
					Task_1 task = new Task_1();
					task.setInput();
					interactWithDatabase(url, task);
					break;
				case 2:

					break;
				case 3:

					break;
				default:
					break;
				}
				System.out.print("Anwendung beenden ? [j/n] ");
			} while (in.next().toLowerCase().equals("n"));
			in.close();
	}
	/**
	 * Erstellt eine Verbindung zur Datenbank und fuehrt dynamisch Logik aus
	 * @param url Adresse der Datenbank
	 * @param task Logik die gegen die Datenbank ausgeführt wird
	 */
	private static void interactWithDatabase(String url,Consumer<ConnectionSource> task){
		try {
			ConnectionSource connectionSource = new JdbcConnectionSource(url);
			task.accept(connectionSource);
			connectionSource.close();
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
	}

}
