package com.hacheery.reservation.payload.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by HachNV on Mar 01, 2023
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageResponse {
    private Integer status;
    private Object data;
    private String message;

    public MessageResponse(int status, String message) {
        this.status = status;
        this.message = message;
    }
}
