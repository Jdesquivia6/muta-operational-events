package com.muta.inventory.domain.model;

import com.muta.inventory.domain.ImpactType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "event_type", discriminatorType = DiscriminatorType.STRING)
@Table(name = "operational_events")
@Getter
@Setter
@AllArgsConstructor
public abstract class OperationalEvent {

    @Id
    private UUID id;

    private UUID licenseId;
    private UUID warehouseId;
    private UUID itemId;

    @Enumerated(EnumType.STRING)
    private ImpactType impactType;

    private BigDecimal quantity;
    private LocalDateTime eventTimestamp;
    private LocalDateTime createdAt;
    private String createdBy;

    public OperationalEvent() {

    }
}
