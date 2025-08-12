package org.ep.rop.domain.repository;
import org.ep.rop.domain.model.Entities.AlineaEntity;
import org.springframework.data.neo4j.repository.*;

import reactor.core.publisher.Mono;

import java.util.UUID;

public interface AlineaRepository extends ReactiveNeo4jRepository<AlineaEntity, UUID> {
    Mono<AlineaEntity> findById(UUID id);
}
