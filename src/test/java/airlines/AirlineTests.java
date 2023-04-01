package airlines;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import restUtils.RestUtils;
import utils.JSONUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class AirlineTests extends AirlineAPIs {

    @Test
    public void createAirline() throws IOException {
        /*System.out.println(System.getProperty("env") + " Env Value");
        String env = System.getProperty("env") == null ? "qa" : System.getProperty("env");
        Map<String, Object> data = JSONUtils.getJsonDataAsMap("airlines/"+env+"/airlinesAppData.json");
        //String endPoint = "https://api.instantwebtools.net/v1/airlines";
        String endPoint = data.get("airlineEndPoint");*/
        Map<String, Object> payload = Payloads.getCreateAirlinePayloadFromStringFromMap("444444413", "AirAsia", "IN", "ABC logo", "ABC slogan", "Mumbai", "abc.com", "1993");
        Response response = createAirline(payload);
        Assert.assertEquals(response.statusCode(), 200);

    }
}
