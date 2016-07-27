package com.orunmila.net.resources;

import com.orunmila.net.RequestMethod;

/**
 * @author Perfect<perfect@kudi.ai>
 *         Created on 7/27/16.
 */
public interface Resource {
    RequestMethod getMethod();
    String getPath();
    Object getPayload();
}
