package com.muta.inventory.infrastructure.persistence.repository;

import com.muta.inventory.domain.model.OperationalEvent;
import com.muta.inventory.infrastructure.persistence.entity.InventoryAggregation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface OperationalEventRepository extends JpaRepository<OperationalEvent, UUID> {

    @Query("""
    SELECT e.licenseId AS licenseId,
           e.warehouseId AS warehouseId,
           e.itemId AS itemId,
           SUM(
             CASE
               WHEN e.impactType = 'IN' THEN e.quantity
               WHEN e.impactType = 'OUT' THEN -e.quantity
               ELSE 0
             END
           ) AS currentInventory
    FROM OperationalEvent e
    GROUP BY e.licenseId, e.warehouseId, e.itemId
    """)
    List<InventoryAggregation> getCurrentInventory();
}
