import java.util.ArrayDeque;
import java.util.Queue;

public class MockDriver implements StockBrokerDriver {

    private boolean loginCalled = false;
    private String loginId;

    private int buyCallCount = 0;
    private String lastBuyStockCode;
    private int lastBuyPrice;
    private int lastBuyCount;

    private int sellCallCount = 0;
    private int lastSellPrice;
    private int lastSellCount;

    private int priceCallCount = 0;
    private final Queue<Integer> priceQueue = new ArrayDeque<>();

    public void addPrice(int price) { priceQueue.add(price); }

    @Override
    public void login(String id, String password) {
        loginCalled = true;
        loginId = id;
    }

    @Override
    public void buy(String stockCode, int price, int count) {
        buyCallCount++;
        lastBuyStockCode = stockCode;
        lastBuyPrice = price;
        lastBuyCount = count;
    }

    @Override
    public void sell(String stockCode, int price, int count) {
        sellCallCount++;
        lastSellPrice = price;
        lastSellCount = count;
    }

    @Override
    public int getPrice(String stockCode) {
        priceCallCount++;
        return priceQueue.poll();
    }

    public boolean isLoginCalled()        { return loginCalled; }
    public String getLoginId()            { return loginId; }
    public int getBuyCallCount()          { return buyCallCount; }
    public String getLastBuyStockCode()   { return lastBuyStockCode; }
    public int getLastBuyPrice()          { return lastBuyPrice; }
    public int getLastBuyCount()          { return lastBuyCount; }
    public int getSellCallCount()         { return sellCallCount; }
    public int getLastSellPrice()         { return lastSellPrice; }
    public int getLastSellCount()         { return lastSellCount; }
    public int getPriceCallCount()        { return priceCallCount; }
}
