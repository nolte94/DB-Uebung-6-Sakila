package aufgabe_1;

public class Customer {
	
	private short store_id;
	private String first_name, last_name,email,last_update,create_date;
	private short address_id;
	private short active;
	private Address address;
	
	public Customer(short store_id, String first_name,
			String last_name, String email, short address_id, short active,String create_date,
			String last_update,Address address) {
		this.store_id = store_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.address_id = address_id;
		this.active = active;
		this.create_date = create_date;
		this.last_update = last_update;
		this.address = address;
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
