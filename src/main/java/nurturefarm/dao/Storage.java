package nurturefarm.dao;

import java.util.List;

public interface Storage {

  public void update(String cabId, String geohash);

  public List<String> search(String geoHash);
}
