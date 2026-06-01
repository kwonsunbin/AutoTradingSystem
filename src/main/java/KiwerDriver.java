import java.util.LinkedList;
import java.util.Queue;

public class KiwerDriver implements StockBrokerDriver{

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

    KiwerAPI driver ;
    KiwerDriver(){
        driver = new KiwerAPI();
    }

    public void login(String id, String password){
        driver.login(id, password);
    }

    public void buy(String stockCode, int price, int count){
        driver.buy(stockCode, count, price);
    }

    public void sell(String stockCode, int price, int count){
        driver.sell(stockCode,  count, price);
    }

    public int getPrice(String stockCode){
        return driver.currentPrice(stockCode);
    }

}
