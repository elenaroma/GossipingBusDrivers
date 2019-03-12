import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GossipExchangerTest {

    GossipExchanger gossipExchanger = new GossipExchanger();

    @Test
    public void two_drivers_with_one_same_stop_then_one_stop() {
        List<int[]> driversRoutes = new ArrayList<int[]>();
        int[] route = new int[1];
        driversRoutes.add(route);
        driversRoutes.add(route);

        String result = gossipExchanger.gossipEchange(driversRoutes);

        assertEquals("1", result);
    }

}