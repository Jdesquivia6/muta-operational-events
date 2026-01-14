package com.muta.inventory.application.dto;

import com.muta.inventory.domain.EventType;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class EventDto {

    private EventType eventType;
    private UUID licenseId;
    private UUID warehouseId;
    private UUID itemId;
    private BigDecimal quantity;
    private String createdBy;
    private LocalDateTime eventTimestamp;

    private UUID supplierId;
    private UUID sourceWarehouseId;
    private UUID targetWarehouseId;
    private UUID customerId;
    private BigDecimal unitPrice;
    private String adjustmentReason;

}
