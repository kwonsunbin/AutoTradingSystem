import java.util.LinkedList;
import java.util.Queue;

public class MockDriver implements StockBrokerDriver {

    private boolean loginCalled;
    private String loginId;

    private int buyCallCount;
    private String lastBuyStockCode;
    private int lastBuyPrice;
    private int lastBuyCount;

    private int sellCallCount;
    private String lastSellStockCode;
    private int lastSellPrice;
    private int lastSellCount;

    private int priceCallCount;
    private final Queue<Integer> prices = new LinkedList<>();

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
        lastSellStockCode = stockCode;
        lastSellPrice = price;
        lastSellCount = count;
    }

    @Override
    public int getPrice(String stockCode) {
        priceCallCount++;

        if (prices.isEmpty()) {
            return 0;
        }

        return prices.poll();
    }

    @Override
    public int getPrice(String stockCode, int min) {
        throw new IllegalArgumentException();
    }

    public void addPrice(int price) {
        prices.add(price);
    }

    public boolean isLoginCalled() {
        return loginCalled;
    }

    public String getLoginId() {
        return loginId;
    }

    public int getBuyCallCount() {
        return buyCallCount;
    }

    public String getLastBuyStockCode() {
        return lastBuyStockCode;
    }

    public int getLastBuyPrice() {
        return lastBuyPrice;
    }

    public int getLastBuyCount() {
        return lastBuyCount;
    }

    public int getSellCallCount() {
        return sellCallCount;
    }

    public String getLastSellStockCode() {
        return lastSellStockCode;
    }

    public int getLastSellPrice() {
        return lastSellPrice;
    }

    public int getLastSellCount() {
        return lastSellCount;
    }

    public int getPriceCallCount() {
        return priceCallCount;
    }
}