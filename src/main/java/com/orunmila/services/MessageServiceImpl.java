package com.orunmila.services;


import com.orunmila.models.Message;
import com.orunmila.net.API;
import com.orunmila.net.resources.PostMessageResource;

import java.io.IOException;

/**
 * @author Perfect<perfect@kudi.ai>
 *         Created on 7/27/16.
 */
public class MessageServiceImpl implements MessageService {

    public String sendMessage(String userId, String message) {
        try {
            return API.makeRequest(new PostMessageResource(userId, message));
        } catch (IOException e) {
            e.printStackTrace();
            return "An error occurred: " + e.getMessage();
        }
    }
}
