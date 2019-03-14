import java.util.HashSet;
import java.util.Set;

public class Driver {

    int id;
    int[] route;
    Set<Integer> gossips = new HashSet<>();

    public Driver(int id, int[] route) {
        this.id = id;
        this.route = route;
        gossips.add(id);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int[] getRoute() {
        return route;
    }

    public void setRoute(int[] route) {
        this.route = route;
    }

    public Set<Integer> getGossips() {
        return gossips;
    }

    public void setGossips(Set<Integer> gossips) {
        this.gossips = gossips;
    }

    public int getNextStop(int i) {
        return route[i % route.length];
    }
}
