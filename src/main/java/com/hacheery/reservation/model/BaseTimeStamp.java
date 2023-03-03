package com.hacheery.reservation.model;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Created by HachNV on Mar 02, 2023
 */
@Data
public class BaseTimeStamp implements Serializable {
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private int version;
}

