import java.util.HashMap;
import java.util.Map;

public class MockDriver implements StockBrokerDriver{

    private boolean isLoginCalled = false;
    private String id;
    private int callBuyCnt = 0;
    private String lastBuyStockCode;
    private int lastBuyPirce;
    private int lastBuyCnt;
    private int callSellCnt;
    private String lastSellStockCode;
    private int lastSellPirce;
    private int lastSellCnt;
    private int callPriceCnt;
    private Map<String, Integer> stockPrice = new HashMap<>();


    @Override
    public void login(String id, String pwd) {
        isLoginCalled = true;
        this.id = id;
    }

    @Override
    public void buy(String code, int price, int qty) {
        callBuyCnt++;
        lastBuyStockCode = code;
        lastBuyPirce = price;
        lastBuyCnt = qty;

    }

    @Override
    public void sell(String code, int price, int qty) {
        callSellCnt++;
        lastSellStockCode = code;
        lastSellPirce = price;
        lastSellCnt = qty;

    }

    @Override
    public int getPrice(String code) {
        callPriceCnt++;

        return stockPrice.get(code);
    }

    public boolean isLoginCalled() {
        return isLoginCalled;
    }

    public String getLoginId() {
        return this.id;
    }

    public int getBuyCallCount() {
        return callBuyCnt;
    }

    public String getLastBuyStockCode() {
        return lastBuyStockCode;
    }

    public int getLastBuyPrice() {
        return lastBuyPirce;
    }

    public int getLastBuyCount() {
        return lastBuyCnt;
    }

    public int getSellCallCount() {
        return callSellCnt;
    }

    public int getLastSellPrice() {
        return lastSellPirce;
    }

    public int getLastSellCount() {
        return lastSellCnt;
    }

    public void addPrice(String stockCode, int price) {

        stockPrice.put(stockCode, price);

    }

    public int getPriceCallCount() {
        return callPriceCnt;
    }
}
