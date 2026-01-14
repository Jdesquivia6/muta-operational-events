package com.muta.inventory.domain.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@DiscriminatorValue("COLLECTION")
@Getter
@Setter
public class CollectionEvent extends OperationalEvent{
    private UUID supplierId;
}
