public class KiwerDriver implements StockBrokerDriver {
    private final KiwerAPI api = new KiwerAPI();

    @Override
    public void login(String id, String password) {
        api.login(id, password);
    }

    @Override
    public void buy(String stockCode, int price, int count) {
        api.buy(stockCode, count, price);
    }

    @Override
    public void sell(String stockCode, int price, int count) {
        api.sell(stockCode, count, price);
    }

    @Override
    public int getPrice(String stockCode) {
        return api.currentPrice(stockCode);
    }
}
