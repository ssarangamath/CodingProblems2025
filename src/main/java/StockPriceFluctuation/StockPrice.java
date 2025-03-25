package StockPriceFluctuation;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class StockPrice {

    private int latestTimestamp;
    private int latestPrice;
    private TreeMap<Integer, Integer> priceCounts;
    private Map<Integer, Integer> timestampPrice;

    public StockPrice() {
        timestampPrice = new HashMap<>();
        priceCounts = new TreeMap<>();

        latestPrice = Integer.MIN_VALUE;
        latestTimestamp = Integer.MIN_VALUE;
    }

    public void update(int timestamp, int price) {
        if(timestamp >= latestTimestamp){
            latestTimestamp = timestamp;
            latestPrice = price;
        }

        if(timestampPrice.containsKey(timestamp)){
            int oldPrice = timestampPrice.get(timestamp);

            if(priceCounts.containsKey(oldPrice)){
                priceCounts.put(oldPrice, priceCounts.get(oldPrice)-1);

                if(priceCounts.get(oldPrice) == 0){
                    priceCounts.remove(oldPrice);
                }
            }
        }

        timestampPrice.put(timestamp, price);
        priceCounts.put(price, priceCounts.getOrDefault(price, 0)+1);
    }

    public int current() {
        return latestPrice;
    }

    public int maximum() {
        return priceCounts.lastKey();
    }

    public int minimum() {
        return priceCounts.firstKey();
    }
}
