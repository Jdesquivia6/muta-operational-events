package com.muta.inventory.infrastructure.persistence.entity;

import java.math.BigDecimal;
import java.util.UUID;

public interface InventoryAggregation {
    UUID getLicenseId();
    UUID getWarehouseId();
    UUID getItemId();
    BigDecimal getCurrentInventory();
}
