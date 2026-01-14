package com.muta.inventory.domain.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@DiscriminatorValue("ADJUSTMENT")
@Getter
@Setter
public class AdjustmentEvent extends OperationalEvent {
    private String adjustmentReason;
}
