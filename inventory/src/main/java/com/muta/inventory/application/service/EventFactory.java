package com.muta.inventory.application.service;

import com.muta.inventory.domain.ImpactType;
import com.muta.inventory.domain.model.*;
import com.muta.inventory.application.dto.EventDto;

import java.time.LocalDateTime;
import java.util.UUID;

public class EventFactory {

    public static OperationalEvent createEvent(EventDto dto) {
        switch (dto.getEventType()) {
            case COLLECTION -> {
                CollectionEvent event = new CollectionEvent();
                event.setId(UUID.randomUUID());
                event.setLicenseId(dto.getLicenseId());
                event.setWarehouseId(dto.getWarehouseId());
                event.setItemId(dto.getItemId());
                event.setQuantity(dto.getQuantity());
                event.setCreatedBy(dto.getCreatedBy());
                event.setEventTimestamp(dto.getEventTimestamp());
                event.setSupplierId(dto.getSupplierId());
                event.setImpactType(ImpactType.NEUTRAL);
                event.setCreatedAt(LocalDateTime.now());
                return event;
            }
            case TRANSFER -> {
                TransferEvent event = new TransferEvent();
                event.setId(UUID.randomUUID());
                event.setLicenseId(dto.getLicenseId());
                event.setWarehouseId(dto.getWarehouseId());
                event.setItemId(dto.getItemId());
                event.setQuantity(dto.getQuantity());
                event.setCreatedBy(dto.getCreatedBy());
                event.setEventTimestamp(dto.getEventTimestamp());
                event.setSourceWarehouseId(dto.getSourceWarehouseId());
                event.setTargetWarehouseId(dto.getTargetWarehouseId());
                event.setImpactType(ImpactType.NEUTRAL);
                event.setCreatedAt(LocalDateTime.now());
                return event;
            }
            case SALE -> {
                SaleEvent event = new SaleEvent();
                event.setId(UUID.randomUUID());
                event.setLicenseId(dto.getLicenseId());
                event.setWarehouseId(dto.getWarehouseId());
                event.setItemId(dto.getItemId());
                event.setQuantity(dto.getQuantity());
                event.setCreatedBy(dto.getCreatedBy());
                event.setEventTimestamp(dto.getEventTimestamp());
                event.setCustomerId(dto.getCustomerId());
                event.setUnitPrice(dto.getUnitPrice());
                event.setImpactType(ImpactType.NEUTRAL);
                event.setCreatedAt(LocalDateTime.now());
                return event;
            }
            case ADJUSTMENT -> {
                AdjustmentEvent event = new AdjustmentEvent();
                event.setId(UUID.randomUUID());
                event.setLicenseId(dto.getLicenseId());
                event.setWarehouseId(dto.getWarehouseId());
                event.setItemId(dto.getItemId());
                event.setQuantity(dto.getQuantity());
                event.setCreatedBy(dto.getCreatedBy());
                event.setEventTimestamp(dto.getEventTimestamp());
                event.setAdjustmentReason(dto.getAdjustmentReason());
                event.setImpactType(ImpactType.NEUTRAL);
                event.setCreatedAt(LocalDateTime.now());
                return event;
            }
            default -> throw new IllegalArgumentException("Tipo de evento inválido: " + dto.getEventType());
        }
    }

}
