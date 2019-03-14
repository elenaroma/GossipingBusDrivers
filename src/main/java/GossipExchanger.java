import java.util.ArrayList;
import java.util.List;

public class GossipExchanger {

    List<Driver> drivers = new ArrayList<>();

    public String gossipEchange(List<int[]> driversRoutes) {

        driversRoutes.stream().forEach(driverRoute ->
                drivers.add(new Driver(driversRoutes.indexOf(driverRoute), driverRoute)));

        for (int i = 0; i < 480; i++) {
            if (drivers.get(0).getNextStop(i) == drivers.get(1).getNextStop(i)) {
                return String.valueOf(i + 1);
            }
        }
        return "never";
    }
}
