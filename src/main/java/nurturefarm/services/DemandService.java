package nurturefarm.services;

import java.util.List;
import java.util.stream.Collectors;
import nurturefarm.dao.Storage;
import nurturefarm.models.User;
import nurturefarm.strategies.searching.CabSearchingStrategy;
import nurturefarm.strategies.searching.DefaultCabSearchingStrategy;
import nurturefarm.strategies.searching.RadiusBasedCabSearchingStrategy;

public class DemandService {

  Storage storage;

  public DemandService(Storage storage) {
    this.storage = storage;
  }

  public List<String> findNearByCabs(User user, String lat, String lon) {
    //Query all neighbours
    List<String> neighborHashes = GeoHashService.getNeighborGeoHashes(lat, lon);

    CabSearchingStrategy cabSearchingStrategy = new DefaultCabSearchingStrategy(storage);

    List<String> totalDriverList = neighborHashes.stream().map(geoHashOfUser -> {
      return storage.search(geoHashOfUser);
    }).flatMap(List::stream).collect(Collectors.toList());

    //Filter based on searching strategy
    return totalDriverList.stream().filter(driver -> {
      String driverLon = ""; // Get this using driver info
      String driverLat = ""; // Get this using driver info
      return cabSearchingStrategy.searchCabForUser(user, lat, lon, driverLat, driverLon, "5km");
    }).collect(Collectors.toList());
  }

  public List<String> findNearByCabs(User user, String lat, String lon, String radius) {
    //Query all neighbours
    List<String> neighborHashes = GeoHashService.getNeighborGeoHashes(lat, lon);

    CabSearchingStrategy cabSearchingStrategy = new RadiusBasedCabSearchingStrategy(storage);

    List<String> totalDriverList = neighborHashes.stream().map(geoHashOfUser -> {
      return storage.search(geoHashOfUser);
    }).flatMap(List::stream).collect(Collectors.toList());

    //Filter based on searching strategy
    return totalDriverList.stream().filter(driver -> {
      String driverLon = ""; // Get this using driver info
      String driverLat = ""; // Get this using driver info
      return cabSearchingStrategy.searchCabForUser(user, lat, lon, driverLat, driverLon, radius);
    }).collect(Collectors.toList());
  }
}
