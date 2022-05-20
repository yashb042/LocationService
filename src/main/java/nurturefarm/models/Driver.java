package nurturefarm.models;

public class Driver {

  String driverName;
  String driverId;

  public String getDriverName() {
    return driverName;
  }

  public String getDriverId() {
    return driverId;
  }

  public Driver(String driverName, String driverId) {
    this.driverName = driverName;
    this.driverId = driverId;
  }
}
