package nurturefarm.strategies.searching;

import java.util.List;
import nurturefarm.dao.Storage;
import nurturefarm.models.User;

public class DefaultCabSearchingStrategy extends CabSearchingStrategy {

  @Override
  public boolean searchCabForUser(User user, String userLat, String userLon, String driverLat,
      String driverLon, String radius) {
    System.out.println("Searching cab using Default strategy");
    return searchCabs(user, userLat, userLon, driverLat, driverLon, radius);
  }

  public DefaultCabSearchingStrategy(Storage s) {
    super();
    this.storage = s;
  }
}
