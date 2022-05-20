package nurturefarm.strategies.matching;

import java.util.List;
import nurturefarm.models.User;

public class DefaultMatchingStrategy implements CabMatchingStrategy {

  @Override
  public String matchCabToUser(User user, List<String> candidateCabs) {
    return candidateCabs.get(0);
  }
}
