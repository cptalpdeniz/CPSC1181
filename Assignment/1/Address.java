/*	-----------------------------
*		  Alp Deniz Senyurt
*			 100342433	
*	-----------------------------
*
*
*	No comments have been addedd as it's only getter and setter methods with a toString() method which is just a override of the String toString() method.
*/

public class Address
{
	private String number;
	private String street;
	private String city;
	private String province;
	private String postalCode;

	public Address()
	{
		this.number = "0";
		this.street = "street";
		this.city = "city";
		this.province = "province";
		this.postalCode = "postalCode";
	}

	public Address(String number, String street, String city, String province, String postalCode)
	{
		this.number = number;
		this.street = street;
		this.city = city;
		this.province = province;
		this.postalCode = postalCode;
	}

	public String getNumber()
	{
		return number;
	}

	public String getStreet()
	{
		return street;
	}

	public String getCity()
	{
		return city;
	}

	public String getProvince()
	{
		return province;
	}
	
	public String getPostalCode()
	{
		return postalCode;
	}

	public void setNumber(String number)
	{
		this.number = number;
	}

	public void setStreet(String street)
	{
		this.street = street;
	}

	public void setCity(String city)
	{
		this.city = city;
	}

	public void setProvince(String province)
	{
		this.province = province;
	}
	
	public void setPostalCode(String postalCode)
	{
		this.postalCode = postalCode;
	}

	public String toString()
	{
		return number + " " + street + "\n" + city + ", " + province + "\n" + postalCode;
	}

}