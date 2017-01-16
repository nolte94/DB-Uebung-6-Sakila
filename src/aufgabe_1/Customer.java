package aufgabe_1;

import java.sql.Timestamp;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "customer")
public class Customer {
	
	@DatabaseField
	private int store_id;
	@DatabaseField
	private String first_name;
	@DatabaseField
	private String last_name;
	@DatabaseField
	private String email;
	@DatabaseField
	private Timestamp last_update;
	@DatabaseField
	private Timestamp create_date;
	@DatabaseField
	private int active;
	@DatabaseField(canBeNull = false,foreign=true,foreignAutoCreate = true)
	private Address address;
	
	public Customer() {
		// ormLite benoetigt leeren Konstruktur
	}
	
	public Customer(int store_id, String first_name,
			String last_name, String email, int active,Timestamp create_date,
			Timestamp last_update,Address address) {
		this.store_id = store_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.active = active;
		this.create_date = create_date;
		this.last_update = last_update;
		this.address = address;
	}
	
	public int getStore_id() {
		return store_id;
	}

	public void setStore_id(int store_id) {
		this.store_id = store_id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Timestamp getLast_update() {
		return last_update;
	}

	public void setLast_update(Timestamp last_update) {
		this.last_update = last_update;
	}

	public Timestamp getCreate_date() {
		return create_date;
	}

	public void setCreate_date(Timestamp create_date) {
		this.create_date = create_date;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
}
