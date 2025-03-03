package gae.piaz.modulith.cqrs.shared.events;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record ProductCreatedEvent(
    Long id,
    String name,
    String description,
    BigDecimal price,
    Integer stock,
    String category,
    LocalDateTime createdAt
) {} 