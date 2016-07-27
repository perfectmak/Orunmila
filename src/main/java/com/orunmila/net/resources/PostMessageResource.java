package com.orunmila.net.resources;

import com.orunmila.net.RequestMethod;

import javax.validation.constraints.NotNull;

/**
 * @author Perfect<perfect@kudi.ai>
 *         Created on 7/27/16.
 */
public class PostMessageResource implements Resource {

    private final String userId;
    private final String message;

    public PostMessageResource(@NotNull String userId, @NotNull String message) {
        this.userId = userId;
        this.message = message;
    }

    public RequestMethod getMethod() {
        return RequestMethod.POST;
    }

    public String getPath() {
        return "/users/" + userId + "/messages/" + message;
    }

    public Object getPayload() {
        return "";
    }
}
