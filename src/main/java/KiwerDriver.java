import java.util.LinkedList;
import java.util.Queue;

public class KiwerDriver implements StockBrokerDriver{

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
