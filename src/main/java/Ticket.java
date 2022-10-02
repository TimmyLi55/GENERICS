public class Ticket implements Comparable<Ticket> {
    private int id;
    private int cost;
    private String aerOut;
    private String aerIn;
    private int timeWay;

    public Ticket(int id, int cost, String aerOut, String aerIn, int timeWay) {
        this.id = id;
        this.cost = cost;
        this.aerOut = aerOut;
        this.aerIn = aerIn;
        this.timeWay = timeWay;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getAerOut() {
        return aerOut;
    }

    public void setAerOut(String aerOut) {
        this.aerOut = aerOut;
    }

    public String getAerIn() {
        return aerIn;
    }

    public void setAerIn(String aerIn) {
        this.aerIn = aerIn;
    }

    public int getTimeWay() {
        return timeWay;
    }

    public void setTimeWay(int timeWay) {
        this.timeWay = timeWay;
    }

    @Override
    public int compareTo(Ticket o) {
        if (this.getCost() > o.getCost()) {
            return 1;
        } else if (this.getCost() < o.getCost()) {
            return -1;
        } else {
            return 0;
        }
    }
}
