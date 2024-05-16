public class Biscuit extends Item {
    String description;
    int growTime;
    int sellCost;
    int chanceSeed = 30;

    public Biscuit(String name, String description, int cost, int growTime, int sellCost, int chanceSeed) {
        super(name,cost);
        this.description = description;
        this.growTime = growTime;
        this.sellCost = sellCost;
        this.chanceSeed = chanceSeed;
    }




}
