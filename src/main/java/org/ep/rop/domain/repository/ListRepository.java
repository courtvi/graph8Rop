package org.ep.rop.domain.repository;

import org.ep.rop.domain.model.Entities.ListEntity;
import org.springframework.data.neo4j.repository.*;

import reactor.core.publisher.Mono;

import java.util.UUID;

public interface ListRepository extends ReactiveNeo4jRepository<ListEntity, UUID> {
    Mono<ListEntity> findById(UUID id);
}
