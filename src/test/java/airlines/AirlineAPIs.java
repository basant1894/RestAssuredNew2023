package airlines;

import io.restassured.response.Response;
import restUtils.RestUtils;

import java.util.HashMap;
import java.util.Map;

public class AirlineAPIs {

    public Response createAirline(Map<String, Object> createAirlinePayload){
        String endPoint = (String) Base.dataFromJsonFile.get("airlineEndPoint");
        return RestUtils.performPostCall(endPoint, createAirlinePayload, new HashMap<>());
    }
}
