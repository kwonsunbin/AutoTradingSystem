public class AutoTradingSystem {

    private StockBrokerDriver stockBrokerDriver;

    public void selectStockBroker(StockBrokerDriver stockBrokerDriver) {
        this.stockBrokerDriver = stockBrokerDriver;
    }

    public void login(String id, String password) {
        checkSelected();
        stockBrokerDriver.login(id, password);
    }

    public void buy(String stockCode, int price, int count) {
        checkSelected();
        stockBrokerDriver.buy(stockCode, price, count);
    }

    public void sell(String stockCode, int price, int count) {
        checkSelected();
        stockBrokerDriver.sell(stockCode, price, count);
    }

    public int getPrice(String stockCode) {
        checkSelected();
        return stockBrokerDriver.getPrice(stockCode);
    }

    public void buyNiceTiming(String stockCode, int money) {
        checkSelected();

        int price1 = stockBrokerDriver.getPrice(stockCode);
        int price2 = stockBrokerDriver.getPrice(stockCode);
        int price3 = stockBrokerDriver.getPrice(stockCode);
        int currentPrice = stockBrokerDriver.getPrice(stockCode);

        if (!(price1 < price2 && price2 < price3 && price3 < currentPrice)) {
            return;
        }

        int count = money / currentPrice;

        if (count > 0) {
            stockBrokerDriver.buy(stockCode, currentPrice, count);
        }
    }

    public void sellNiceTiming(String stockCode, int count) {
        checkSelected();

        int price1 = stockBrokerDriver.getPrice(stockCode);
        int price2 = stockBrokerDriver.getPrice(stockCode);
        int price3 = stockBrokerDriver.getPrice(stockCode);
        int currentPrice = stockBrokerDriver.getPrice(stockCode);

        if (!(price1 > price2 && price2 > price3 && price3 > currentPrice)) {
            return;
        }

        stockBrokerDriver.sell(stockCode, currentPrice, count);
    }

    private void checkSelected() {
        if (stockBrokerDriver == null) {
            throw new IllegalStateException("Stock broker is not selected");
        }
    }
}