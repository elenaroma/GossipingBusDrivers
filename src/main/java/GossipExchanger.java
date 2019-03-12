import java.util.List;

public class GossipExchanger {
    public String gossipEchange(List<int[]> driversRoutes) {

        int[] routeDriver1 = driversRoutes.get(0);
        int[] routeDriver2 = driversRoutes.get(1);
        for (int i = 0; i < 480; i++) {
            if (routeDriver1[i] == routeDriver2[i]) {
                return String.valueOf(i+1);
            }
        }
        return null;
    }
}
