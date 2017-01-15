package aufgabe_1;

import java.sql.Timestamp;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "address")
public class Address {
	
	@DatabaseField(generatedId = true)
	private int address_id;
	@DatabaseField
	private String address;
	@DatabaseField
	private String address2;
	@DatabaseField
	private String district;
	@DatabaseField
	private String postal_code;
	@DatabaseField
	private String phone;
	@DatabaseField
	private Timestamp last_update;
	@DatabaseField
	private int city_id;
	
	public Address() {
		// ormLite benoetigt leeren Konstruktur
	}
	
	public Address(String address, String address2, String district,
			int city_id, String postal_code, String phone, Timestamp last_update) {
		
		this.address = address;
		this.address2 = address2;
		this.district = district;
		this.city_id = city_id;
		this.postal_code = postal_code;
		this.phone = phone;
		this.last_update = last_update;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getPostal_code() {
		return postal_code;
	}

	public void setPostal_code(String postal_code) {
		this.postal_code = postal_code;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Timestamp getLast_update() {
		return last_update;
	}

	public void setLast_update(Timestamp last_update) {
		this.last_update = last_update;
	}

	public int getCity_id() {
		return city_id;
	}

	public void setCity_id(short city_id) {
		this.city_id = city_id;
	}
}
