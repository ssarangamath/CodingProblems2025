package LoggerRateLimiter;

import java.util.HashMap;
import java.util.Map;

public class Logger {
    private Map<String, Integer> msgTimestamps;

    public Logger() {
        msgTimestamps = new HashMap<>();
    }

    public boolean shouldPrintMessage(int timestamp, String message) {
        if(!msgTimestamps.containsKey(message)){
            msgTimestamps.put(message, timestamp);
            return true;
        }

        int oldTimestamp = msgTimestamps.get(message);

        if(timestamp >= oldTimestamp+10){
            msgTimestamps.put(message, timestamp);
            return true;
        }

        return false;
    }
}
