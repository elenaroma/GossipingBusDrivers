import java.util.*;

public class GossipExchanger {

    private List<Driver> drivers = new ArrayList<>();

    public String gossipEchange(List<int[]> driversRoutes) {

        initializeDrivers(driversRoutes);

        for (int i = 0; i < 480; i++) {
            Map<Integer, List<Driver>> driversByStop = getDriversByStop(i);
            for (List<Driver> driversAtStop : driversByStop.values()) {
                Set<Integer> gossipsAtStop = getGossipsAtStop(driversAtStop);
                driversAtStop.stream().forEach(driver -> driver.setGossips(gossipsAtStop));
            }

            if (drivers.stream().allMatch(driver -> drivers.size() == driver.getGossips().size())) {
                return String.valueOf(i + 1);
            }
        }
        return "never";
    }

    private void initializeDrivers(List<int[]> driversRoutes) {
        driversRoutes.stream().forEach(driverRoute ->
                drivers.add(new Driver(driversRoutes.indexOf(driverRoute), driverRoute)));
    }

    private Map<Integer, List<Driver>> getDriversByStop(int i) {
        Map<Integer, List<Driver>> driversByStop = new HashMap<>();
        for (Driver driver : drivers) {
            if (Objects.isNull(driversByStop.get(driver.getNextStop(i)))) {
                driversByStop.put(driver.getNextStop(i), new ArrayList<>(Arrays.asList(driver)));
            } else {
                driversByStop.get(driver.getNextStop(i)).add(driver);
            }
        }
        return driversByStop;
    }

    private Set<Integer> getGossipsAtStop(List<Driver> driversAtStop) {
        Set<Integer> gossipsAtStop = new HashSet<>();
        for (Driver driver : driversAtStop) {
            gossipsAtStop.addAll(driver.getGossips());
        }
        return gossipsAtStop;
    }
}
