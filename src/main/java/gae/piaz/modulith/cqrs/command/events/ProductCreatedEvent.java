package gae.piaz.modulith.cqrs.command.events;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.Builder;

@Builder
public record ProductCreatedEvent(
    Long id,
    String name,
    String description,
    BigDecimal price,
    Integer stock,
    String category,
    LocalDateTime createdAt
) {} 