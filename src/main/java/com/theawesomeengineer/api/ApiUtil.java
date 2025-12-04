package com.theawesomeengineer.api;

import org.springframework.web.context.request.NativeWebRequest;

public class ApiUtil {

    public static void setExampleResponse(
            NativeWebRequest request,
            String contentType,
            String example
    ) {
        try {
            request.setAttribute("org.openapitools.api.example", example, 0);
        } catch (Exception ignored) {
        }
    }
}
