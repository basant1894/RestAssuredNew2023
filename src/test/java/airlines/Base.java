package airlines;

import utils.JSONUtils;

import java.io.IOException;
import java.util.Map;

public class Base {

    public static Map<String, Object> dataFromJsonFile;

    static {
        String env = System.getProperty("env") == null ? "qa" : System.getProperty("env");
        try {
            dataFromJsonFile = JSONUtils.getJsonDataAsMap("airlines/"+env+"/airlinesAppData.json");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
