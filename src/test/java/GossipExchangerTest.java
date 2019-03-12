import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GossipExchangerTest {

    GossipExchanger gossipExchanger = new GossipExchanger();

    @Test
    public void two_drivers_with_one_same_stop_then_one_stop() {
        List<int[]> driversRoutes = new ArrayList<int[]>();
        int[] route = {1};
        driversRoutes.add(route);
        driversRoutes.add(route);

        String result = gossipExchanger.gossipEchange(driversRoutes);

        assertEquals("1", result);
    }

    @Test
    public void two_drivers_with_one_different_stop_then_never() {
        List<int[]> driversRoutes = new ArrayList<int[]>();
        int[] route1 = {1};
        driversRoutes.add(route1);
        int[] route2 = {2};
        driversRoutes.add(route2);

        String result = gossipExchanger.gossipEchange(driversRoutes);

        assertEquals("never", result);
    }

}