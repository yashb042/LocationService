package nurturefarm.dao;

import java.util.ArrayList;
import java.util.List;

public class SqlStorage implements Storage {


  @Override
  public void update(String cabId, String geohash) {

  }

  @Override
  public List<String> search(String geoHash) {
    return new ArrayList<>();

  }
}
