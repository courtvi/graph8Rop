package org.ep.rop.domain.repository;

import org.ep.rop.domain.model.Entities.RopEntity;
import org.springframework.data.neo4j.repository.ReactiveNeo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import reactor.core.publisher.Mono;

import java.util.UUID;


public interface RopRepository extends ReactiveNeo4jRepository<RopEntity, UUID> {

    Mono<RopEntity> findById(UUID id);
}
