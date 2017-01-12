package aufgabe_1;

import java.sql.Time;

public class Address {
	private String address;
	private String address2;
	private String district;
	private short city_id;
	private String postal_code;
	private String phone;
	private Time last_update;
	
	public Address(String address, String address2, String district,
			short city_id, String postal_code, String phone, Time last_update) {
		
		this.address = address;
		this.address2 = address2;
		this.district = district;
		this.city_id = city_id;
		this.postal_code = postal_code;
		this.phone = phone;
		this.last_update = last_update;
	}
	
	public String getValues(){
		return
				this.address + "," +
				this.address2 + "," +
				this.district + "," +
				this.city_id + "," +
				this.postal_code + "," +
				this.phone + "," +
				this.last_update;
		}
	
	
	
}
