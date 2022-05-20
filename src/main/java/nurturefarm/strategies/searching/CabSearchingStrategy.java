package nurturefarm.strategies.searching;

import java.util.ArrayList;
import java.util.List;
import nurturefarm.dao.Storage;
import nurturefarm.models.User;

public abstract class CabSearchingStrategy {

  Storage storage;

  public abstract boolean searchCabForUser(User user, String userLat, String userLon, String driverLat, String driverLon, String radius);

  public boolean searchCabs(User user, String userLat, String userLon, String driverLat, String driverLon, String radius){
    //Filter geoHashes having radius greater than the given radius
    return false;
  }
}
