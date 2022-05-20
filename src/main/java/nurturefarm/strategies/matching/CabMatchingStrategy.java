package nurturefarm.strategies.matching;

import java.util.List;
import nurturefarm.models.User;

public interface CabMatchingStrategy {

  String matchCabToUser(User user, List<String> candidateCabs);
}
