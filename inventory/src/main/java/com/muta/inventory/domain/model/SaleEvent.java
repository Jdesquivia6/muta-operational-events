package com.muta.inventory.domain.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@DiscriminatorValue("SALE")
@Getter
@Setter
public class SaleEvent extends OperationalEvent {
    private UUID customerId;
    private BigDecimal unitPrice;
}
