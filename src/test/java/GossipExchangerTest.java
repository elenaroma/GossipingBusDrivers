import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GossipExchangerTest {

    GossipExchanger gossipExchanger = new GossipExchanger();

    @Test
    public void two_drivers_with_one_same_stop_then_one_stop() {
        List<int[]> driversRoutes = new ArrayList<int[]>();
        driversRoutes.add(new int[]{1});
        driversRoutes.add(new int[]{1});

        String result = gossipExchanger.gossipEchange(driversRoutes);

        assertEquals("1", result);
    }

    @Test
    public void two_drivers_with_one_different_stop_then_never() {
        List<int[]> driversRoutes = new ArrayList<int[]>();
        driversRoutes.add(new int[]{1});
        driversRoutes.add(new int[]{2});

        String result = gossipExchanger.gossipEchange(driversRoutes);

        assertEquals("never", result);
    }

}