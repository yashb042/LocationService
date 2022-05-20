package nurturefarm.services;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class GeoHashService {

  public static String generateGeoHash(String lan, String lon) {
    return UUID.randomUUID().toString();
  }

  public static List<String> getNeighborGeoHashes(String geoHash, String radius) {
    return new ArrayList<>();
  }
}
