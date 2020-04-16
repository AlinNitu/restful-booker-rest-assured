package utils;

public enum HttpRequestType {

    POST("POST"),
    GET("GET"),
    PUT("PUT"),
    DELETE("DELETE");

    private String type;

    HttpRequestType(String type) {
        this.type = type;
    }

    public String getRequestType() {
        return type;
    }
}
