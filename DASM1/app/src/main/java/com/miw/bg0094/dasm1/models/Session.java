
package com.miw.bg0094.dasm1.models;


import java.util.HashMap;
import java.util.Map;

public class Session {

    private Boolean success;
    private String guest_session_id;
    private String expires_at;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     *
     * @return
     * The success
     */
    public Boolean getSuccess() {
        return success;
    }

    /**
     *
     * @param success
     * The success
     */
    public void setSuccess(Boolean success) {
        this.success = success;
    }

    /**
     *
     * @return
     * The guest_session_id
     */
    public String getGuest_session_id() {
        return guest_session_id;
    }

    /**
     *
     * @param guest_session_id
     * The guest_session_id
     */
    public void setGuest_session_id(String guest_session_id) {
        this.guest_session_id = guest_session_id;
    }

    /**
     *
     * @return
     * The expires_at
     */
    public String getExpires_at() {
        return expires_at;
    }

    /**
     *
     * @param expires_at
     * The expires_at
     */
    public void setExpires_at(String expires_at) {
        this.expires_at = expires_at;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }


    @Override
    public String toString() {
        return "Session{" +
                "success=" + success +
                ", guest_session_id='" + guest_session_id + '\'' +
                ", expires_at='" + expires_at + '\'' +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}