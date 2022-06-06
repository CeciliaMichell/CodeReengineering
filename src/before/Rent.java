package before;

import java.sql.Date;

public class Rent {
  private String fullName;
  private String identityNumber;
  private Vehicle typeVehicle;
  // data clumps
  private Date startRent;
  private Date endRent;

  public Rent(String fullName, String identityNumber, Vehicle typeVehicle, Date startRent, Date endRent) {
    this.fullName = fullName;
    this.identityNumber = identityNumber;
    this.typeVehicle = typeVehicle;
    this.startRent = startRent;
    this.endRent = endRent;
  }

  public static boolean validateName(String name) {
    return name.length() >= 6 && name.length() <= 20;
  }

  public static boolean validateIdentityNumber(String identityNumber) {
    return identityNumber.length() >= 16;
  }

}
