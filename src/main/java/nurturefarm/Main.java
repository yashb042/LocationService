package nurturefarm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import nurturefarm.dao.RedisStorage;
import nurturefarm.dao.Storage;
import nurturefarm.models.Cab;
import nurturefarm.models.Driver;
import nurturefarm.models.User;
import nurturefarm.services.DemandService;
import nurturefarm.services.SupplyService;

public class Main {

  public static void main(String[] args) {


    List<Cab> cabList = new ArrayList<>();

    List<User> userList = new ArrayList<>();

    Driver driver1 = new Driver("driver1", "driverId1");
    Driver driver2 = new Driver("driver2", "driverId2");
    Driver driver3 = new Driver("driver3", "driverId3");

    Cab cab1 = new Cab(driver1, "cabId1");
    Cab cab2 = new Cab(driver2, "cabId2");
    Cab cab3 = new Cab(driver3, "cabId3");

    User user1 = new User("userId1");
    User user2 = new User("userId2");
    User user3 = new User("userId3");

    cabList.add(cab1);
    cabList.add(cab3);
    cabList.add(cab2);

    userList.add(user1);
    userList.add(user2);
    userList.add(user3);

    Storage storage = new RedisStorage();

    SupplyService supplyService = new SupplyService(storage);
    DemandService demandService = new DemandService(storage);

    //Driver1 submits location
    supplyService.submitLocation(cab1.getCabId(), "lat1", "lon1");

    //Driver2 submits location
    supplyService.submitLocation(cab2.getCabId(), "lat2", "lon2");

    //Driver3 submits location
    supplyService.submitLocation(cab3.getCabId(), "lat3", "lon3");

    //User1 requests for cabs with no given radius
    demandService.findNearByCabs(user1, "userLat1", "userLon1");

    //User2 requests for cabs with radius as 10
    demandService.findNearByCabs(user2, "userLat2", "userLon2", "10km");


  }

}
