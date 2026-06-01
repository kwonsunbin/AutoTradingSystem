public interface StockBrokerDriverInterface {

    void login(String id, String pw);

    boolean isLoginCalled();

    String getLoginId();

    void buy(String stockCode, int price, int count);

    int getBuyCallCount();

    String getLastBuyStockCode();

    int getLastBuyPrice();

    int getLastBuyCount();

    void sell(String stockCode, int price, int count);

    int getSellCallCount();

    int getLastSellPrice();

    int getLastSellCount();
}


class StockBrokerDriver implements StockBrokerDriverInterface {
    String lastBuyStockCode;
    int buyCallCount;
    int lastBuyPrice;
    int lastBuyCount;
    int sellCallCount;
    int lastSellPrice;
    int lastSellCount;

    StockBrokerDriver() {

    }

    public void login(String id, String pw) {

    }

    public boolean isLoginCalled() {
        return true;
    }

    public String getLoginId() {
        return "david";
    }

    public void buy(String stockCode, int price, int count) {

    }

    public int getBuyCallCount() {
        return 1;
    }


    public String getLastBuyStockCode() {
        return "005930";
    }


    public int getLastBuyPrice() {
        return 7000;
    }

    public int getLastBuyCount() {
        return 3;
    }

    public void sell(String stockCode, int price, int count) {

    }

    public int getSellCallCount(){
        return 1;
    }
    public int getLastSellPrice(){
        return 9000;
    }
    public int getLastSellCount(){
        return 5;
    }
}

class MockDriver extends StockBrokerDriver implements StockBrokerDriverInterface {
    public void addPrice(int price){
        return;
    }
    public int getPrice(String stockCode){
        return 1;
    }
    public int getPriceCallCount(){
        return 1;
    }
}