package gae.piaz.modulith.cqrs.command.events;

import java.math.BigDecimal;

import lombok.Builder;

@Builder
public record ProductCreatedEvent(Long id, String name, String description, BigDecimal price, Integer stock, String category) {

}