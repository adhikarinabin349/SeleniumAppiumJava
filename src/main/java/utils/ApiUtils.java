// This class contains methods to send GET, POST, PUT and DELETE requests to the API
// It uses the RestAssured library to send HTTP requests and receive responses
// The sendGetRequest method sends a GET request to the specified endpoint and returns the response
// The sendPostRequest method sends a POST request to the specified endpoint with the given body and returns the response
// The sendPutRequest method sends a PUT request to the specified endpoint with the given body and returns the response
// The sendDeleteRequest method sends a DELETE request to the specified endpoint and returns the response
package utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ApiUtils {
    public static Response sendGetRequest(String endpoint) {
        return RestAssured.get(endpoint);
    }

    public static Response sendPostRequest(String endpoint, String body) {
        return RestAssured.given().header("Content-Type", "application/json").body(body).post(endpoint);
    }

    public static Response sendPutRequest(String endpoint, String body) {
        return RestAssured.given().header("Content-Type", "application/json").body(body).put(endpoint);
    }

    public static Response sendDeleteRequest(String endpoint) {
        return RestAssured.delete(endpoint);
    }
}