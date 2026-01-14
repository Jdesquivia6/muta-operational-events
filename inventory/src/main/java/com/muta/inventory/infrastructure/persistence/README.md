# Repositories & Persistence

## Repositorios
- `OperationalEventRepository` extiende `JpaRepository<OperationalEvent, UUID>`
- Permite CRUD y queries agregadas para inventario

## Query crítica
```java
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
