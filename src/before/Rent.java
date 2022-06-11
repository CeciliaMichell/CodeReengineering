package before;

import java.sql.Date;

public class Rent {
  private String fullName;
  private String identityNumber;
  private Vehicle typeVehicle;
  private Date startRent;
  private Date endRent;

  public Rent(String fullName, String identityNumber, Vehicle typeVehicle, java.util.Date startDate,
      java.util.Date endDate) {
    this.fullName = fullName;
    this.identityNumber = identityNumber;
    this.typeVehicle = typeVehicle;
    this.startRent = (Date) startDate;
    this.endRent = (Date) endDate;
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

  public Date getStartRent() {
    return startRent;
  }

  public void setStartRent(Date startRent) {
    this.startRent = startRent;
  }

  public Date getEndRent() {
    return endRent;
  }

  public void setEndRent(Date endRent) {
    this.endRent = endRent;
  }

  // temporary field - langsung return aja
  static boolean validateName(String name) {
    boolean flag = (name.length() >= 6 && name.length() <= 20) ? true : false;
    return flag;
  }

  static boolean validateIdentityNumber(String identityNumber) {
    return identityNumber.length() >= 16;
  }

}
