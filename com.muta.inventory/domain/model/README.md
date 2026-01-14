# PARTE 1 — Modelamiento de Base de Datos

## Estrategia de Polimorfismo en Base de Datos

Se eligió una **estrategia de polimorfismo Single Table** para persistir todos los eventos operativos en una única tabla (`operational_events`).

Cada fila representa un **evento inmutable**, identificado por su `event_type`, y contiene:

- Campos comunes a todos los eventos
- Campos específicos por tipo de evento (nullable)

Esta estrategia permite modelar distintos tipos de eventos sin fragmentar los datos ni introducir joins innecesarios en consultas críticas.

---

## Índices
Los índices fueron diseñados priorizando las consultas más costosas y frecuentes.

Índice principal para cálculo de inventario

CREATE INDEX idx_inventory_aggregation
ON operational_events (license_id, warehouse_id, item_id);

Este índice optimiza el GROUP BY utilizado para calcular el inventario actual, permitiendo escalar a millones de registros.

Índice temporal (auditoría y trazabilidad)

CREATE INDEX idx_event_timestamp
ON operational_events (event_timestamp);

Facilita consultas históricas, auditorías y reconstrucción de estado en el tiempo.

Índice por tipo de evento

CREATE INDEX idx_event_type
ON operational_events (event_type);

Optimiza análisis por tipo de operación (ventas, ajustes, transferencias).

## Justificación del Modelo Elegido

El sistema está diseñado bajo un modelo basado en eventos, donde el inventario no se almacena directamente, sino que se deriva mediante agregación SQL a partir de eventos operativos inmutables.

## Tradeoffs

Ventajas: Consultas agregadas rápidas y simples, Sin joins en queries críticas, Fácil extensión a nuevos tipos de eventos

Desventajas: Presencia de columnas nulas, Validaciones dependientes de la capa de aplicación

## Alternativas Consideradas y Descartadas

JOINED

Motivo del descarte: Requiere joins en consultas de inventario, Penaliza rendimiento en agregaciones, Escala peor con millones de filas

TABLE_PER_CLASS

Motivo del descarte: Necesita UNION ALL para consultas globales, Índices fragmentados, Alto costo en queries analíticas



## Esquema de Tablas

### Tabla principal: `operational_events`

```sql
CREATE TABLE operational_events (
    id                  UUID PRIMARY KEY,
    license_id          UUID NOT NULL,
    warehouse_id        UUID NOT NULL,
    item_id             UUID NOT NULL,

    event_type          VARCHAR(30) NOT NULL,
    impact_type         VARCHAR(10) NOT NULL CHECK (impact_type IN ('IN', 'OUT', 'NEUTRAL')),
    quantity            NUMERIC(18, 4) NOT NULL CHECK (quantity >= 0),

    event_timestamp     TIMESTAMP NOT NULL,
    created_at          TIMESTAMP NOT NULL DEFAULT NOW(),
    created_by          VARCHAR(100) NOT NULL,

    -- Collection
    supplier_id         UUID,

    -- Transfer
    source_warehouse_id UUID,
    target_warehouse_id UUID,

    -- Sale
    customer_id         UUID,
    unit_price          NUMERIC(18, 4),

    -- Adjustment
    adjustment_reason   TEXT
);


