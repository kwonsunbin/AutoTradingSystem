public class NemoDriver implements StockBrokerDriver {

    private final NemoAPI api = new NemoAPI();

    @Override
    public void login(String id, String password) {
        api.certification(id, password);
    }

    @Override
    public void buy(String stockCode, int price, int count) {
        api.purchasingStock(stockCode, price, count);
    }

    @Override
    public void sell(String stockCode, int price, int count) {
        api.sellingStock(stockCode, price, count);
    }

    @Override
    public int getPrice(String stockCode) {
        try {
            return Math.abs(api.getMarketPrice(stockCode, 1));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }
}