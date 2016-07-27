package com.orunmila.services;

import com.orunmila.models.Message;

import java.io.IOException;

/**
 * @author Perfect<perfect@kudi.ai>
 *         Created on 7/27/16.
 */
public interface MessageService {
    public String sendMessage(String userId, String message);
}
