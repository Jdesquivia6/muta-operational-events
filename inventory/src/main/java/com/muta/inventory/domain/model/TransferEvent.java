package com.muta.inventory.domain.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@DiscriminatorValue("TRANSFER")
@Getter
@Setter
public class TransferEvent extends OperationalEvent {
    private UUID sourceWarehouseId;
    private UUID targetWarehouseId;
}
