public interface StockBrokerDriver {

    void login(String id, String pwd);

    void buy(String code, int qty, int price);

    void sell(String code, int qty, int price);

    int getPrice(String code);

}
