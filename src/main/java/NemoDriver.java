public class NemoDriver implements  StockBrokerDriver{

    NemoAPI nemoApi;
    public NemoDriver() {
        nemoApi = new NemoAPI();
    }



    @Override
    public void login(String id, String password) {
        nemoApi.certification(id, password);
    }

    @Override
    public void buy(String stockCode, int price, int count) {
        nemoApi.purchasingStock(stockCode, price, count);
    }

    @Override
    public void sell(String stockCode, int price, int count) {
        nemoApi.sellingStock(stockCode, price, count);
    }

    @Override
    public int getPrice(String stockCode) {
         throw new IllegalArgumentException();
    }

    @Override
    public int getPrice(String stockCode, int min) throws InterruptedException {
            return nemoApi.getMarketPrice(stockCode, min);

    }
}
