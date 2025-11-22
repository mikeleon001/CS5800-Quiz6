import java.util.Random;

public class StockMarketDriver {
    public static void main(String[] args) {
        Random random = new Random();

        Stock teslaStock = new Stock("TSLA", 391.09);

        StockTrader trader1 = new StockTrader("Anna");
        StockTrader trader2 = new StockTrader("Boris");
        StockTrader trader3 = new StockTrader("Chiril");

        System.out.println("    Stock Market Day Trading Application    ");
        System.out.println("Initial Stock: " + teslaStock.getSymbol() + " at $" + teslaStock.getPrice());
        System.out.println("\n Registering traders...");

        teslaStock.attach(trader1);
        teslaStock.attach(trader2);
        teslaStock.attach(trader3);

        System.out.println("Traders registered: Anna, Boris, Chiril");

        System.out.println("\n    Simulating Stock Price Changes    ");

        for (int i = 1; i <= 8; i++) {
            double priceChange = (random.nextDouble() * 20) - 10;
            double newPrice = teslaStock.getPrice() + priceChange;

            if (newPrice < 0) {
                newPrice = teslaStock.getPrice() + Math.abs(priceChange);
            }

            System.out.println("\n    Price Change Event #" + i + "   ");
            teslaStock.setPrice(newPrice);

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("\n   Boris stops watching the stock   ");
        teslaStock.detach(trader2);

        System.out.print("\n    Final Price Change   ");
        double finalChange = (random.nextDouble() * 10) - 5;
        teslaStock.setPrice(teslaStock.getPrice() + finalChange);

        System.out.println("\n   Trading is over   ");
    }
}
