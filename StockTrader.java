public class StockTrader implements Observer {
    private String traderName;
    private double lastPrice;
    private boolean firstUpdate;

    public StockTrader(String traderName) {
        this.traderName = traderName;
        this.firstUpdate = true;
    }

    @Override
    public void update(String symbol, double price) {
        System.out.println("\n[" + traderName + "] Stock Update: ");
        System.out.println("Symbol: " + symbol);
        System.out.println("Price: $" + String.format("%.2f", price));

        if (firstUpdate) {
            System.out.println("Status: Initial price");
            firstUpdate = false;
        } else {
            if (price > lastPrice) {
                double increase = price - lastPrice;
                System.out.println("Status: Price Went Up by $" + String.format("%.2f", increase));
            } else if (price <lastPrice) {
                double decrease = lastPrice - price;
                System.out.println("Status: Price Went Down by $" + String.format("%.2f", decrease));
            } else {
                System.out.println("Status: No change");
            }
        }

        lastPrice = price;
    }
}
