public interface StockBrokerDriver {
    void login(String id, String password);

    void buy(String stockCode, int price, int count);

    void sell(String stockCode, int price, int count);

    int getPrice(String stockCode);
}