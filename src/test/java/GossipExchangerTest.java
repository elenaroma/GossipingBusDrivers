import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GossipExchangerTest {

    GossipExchanger gossipExchanger = new GossipExchanger();

    @Test
    public void two_drivers_with_one_same_stop_then_one_stop() {
        List<int[]> driversRoutes = new ArrayList<>();
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

    @Test
    public void two_drivers_with_second_same_stop_then_two_stops() {
        List<int[]> driversRoutes = new ArrayList<int[]>();
        driversRoutes.add(new int[]{1, 3});
        driversRoutes.add(new int[]{2, 3});

        String result = gossipExchanger.gossipEchange(driversRoutes);

        assertEquals("2", result);
    }

    @Test
    public void three_drivers_two_with_one_same_stop_then_never() {
        List<int[]> driversRoutes = new ArrayList<int[]>();
        driversRoutes.add(new int[]{1});
        driversRoutes.add(new int[]{1});
        driversRoutes.add(new int[]{2});

        String result = gossipExchanger.gossipEchange(driversRoutes);

        assertEquals("never", result);
    }

    @Test
    public void example1(){
        List<int[]> driversRoutes = new ArrayList<int[]>();
        driversRoutes.add(new int[]{3, 1, 2, 3});
        driversRoutes.add(new int[]{3, 2, 3, 1});
        driversRoutes.add(new int[]{4, 2, 3, 4, 5});

        String result = gossipExchanger.gossipEchange(driversRoutes);

        assertEquals("5", result);
    }
    @Test
    public void example2(){
        List<int[]> driversRoutes = new ArrayList<int[]>();
        driversRoutes.add(new int[]{2, 1, 2});
        driversRoutes.add(new int[]{5, 2, 8});

        String result = gossipExchanger.gossipEchange(driversRoutes);

        assertEquals("never", result);
    }
}