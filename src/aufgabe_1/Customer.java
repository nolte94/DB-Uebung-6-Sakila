package aufgabe_1;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

public class Customer {
	
	private short store_id;
	private String first_name;
	private String last_name;
	private String email;
	private short address_id;
	private short active;
	private Date create_date;
	private Time last_update;
	
	public Customer(short store_id, String first_name,
			String last_name, String email, short address_id, short active, Date create_date, 
			Time last_update) {
		this.store_id = store_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.address_id = address_id;
		this.active = active;
		this.create_date = create_date;
		this.last_update = last_update;
	}
	
	public String getValues(){
		return
				this.store_id + "," +
				this.first_name + "," +
				this.last_name + "," +
				this.email + "," +
				this.address_id + "," +
				this.active + "," +
				this.create_date + "," +
				this.last_update;
	}
}
