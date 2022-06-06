package after;

public class Rent {
	private String fullName;
	private String identityNumber;
	private Vehicle typeVehicle;
	private rentDateRange DateRange;

	public Rent(String fullName, String identityNumber, Vehicle typeVehicle, rentDateRange dateRange) {
		super();
		this.fullName = fullName;
		this.identityNumber = identityNumber;
		this.typeVehicle = typeVehicle;
		DateRange = dateRange;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getIdentityNumber() {
		return identityNumber;
	}

	public void setIdentityNumber(String identityNumber) {
		this.identityNumber = identityNumber;
	}

	public Vehicle getTypeVehicle() {
		return typeVehicle;
	}

	public void setTypeVehicle(Vehicle typeVehicle) {
		this.typeVehicle = typeVehicle;
	}

	public rentDateRange getDateRange() {
		return DateRange;
	}

	public void setDateRange(rentDateRange dateRange) {
		DateRange = dateRange;
	}

	public static boolean validateName(String name) {
		return name.length() >= 6 && name.length() <= 20;
	}

	public static boolean validateIdentityNumber(String identityNumber) {
	    return identityNumber.length() >= 16;
	}

}
