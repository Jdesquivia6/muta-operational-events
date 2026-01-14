# API - Event Controller

## Endpoint
POST /api/events

## Funcionalidad
- Recibe cualquier tipo de evento (Collection, Transfer, Sale, Adjustment)
- Valida licencia, bodega e item
- Aplica impacto en inventario de forma implícita (se calcula a partir de eventos)
- Persiste evento en DB
- Maneja errores coherentes y claros

## Request DTO
- eventType: Enum
- licenseId: UUID
- warehouseId: UUID
- itemId: UUID
- quantity: decimal
- Campos específicos según tipo de evento

## Response
- Devuelve el objeto persistido (OperationalEvent)
- Código HTTP 201 en éxito, 400 para errores de validación
