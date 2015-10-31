package com.miw.bg0094.dasm1.models;


import java.util.HashMap;
import java.util.Map;

public class RatingResponse {

    private Integer status_code;
    private String status_message;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     *
     * @return
     * The status_code
     */
    public Integer getStatus_code() {
        return status_code;
    }

    /**
     *
     * @param status_code
     * The status_code
     */
    public void setStatus_code(Integer status_code) {
        this.status_code = status_code;
    }

    /**
     *
     * @return
     * The status_message
     */
    public String getStatus_message() {
        return status_message;
    }

    /**
     *
     * @param status_message
     * The status_message
     */
    public void setStatus_message(String status_message) {
        this.status_message = status_message;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return "RatingResponse{" +
                "status_code=" + status_code +
                ", status_message='" + status_message + '\'' +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}