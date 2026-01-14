# DTOs - EventDto

## Descripción
Data Transfer Object para recibir eventos desde el endpoint POST /api/events.

## Campos comunes
- eventType: EventType
- licenseId: UUID
- warehouseId: UUID
- itemId: UUID
- quantity: decimal
- createdBy: String
- eventTimestamp: LocalDateTime

## Campos específicos
- CollectionEvent: supplierId
- TransferEvent: sourceWarehouseId, targetWarehouseId
- SaleEvent: customerId, unitPrice
- AdjustmentEvent: adjustmentReason

## Validaciones
- Todos los IDs deben ser válidos UUID
- quantity >= 0
- eventType debe corresponder con los campos específicos presentes
