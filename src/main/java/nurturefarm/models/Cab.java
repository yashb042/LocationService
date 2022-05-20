package nurturefarm.models;

public class Cab {

  Driver driver;
  String cabId;

  public Cab(Driver driver, String cabId) {
    this.driver = driver;
    this.cabId = cabId;
  }

  public Driver getDriver() {
    return driver;
  }

  public String getCabId() {
    return cabId;
  }
}
