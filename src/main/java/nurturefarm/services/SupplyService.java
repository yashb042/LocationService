package nurturefarm.services;

import nurturefarm.dao.Storage;

public class SupplyService {

  Storage storage;

  public SupplyService(Storage storage) {
    this.storage = storage;
  }

  public void submitLocation(String cabId, String lat, String lon) {
    String generateGeoHash = GeoHashService.generateGeoHash(lat, lon);

    storage.update(cabId, generateGeoHash);
  }
}
