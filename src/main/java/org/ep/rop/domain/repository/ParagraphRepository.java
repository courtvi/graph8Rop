package org.ep.rop.domain.repository;

import org.ep.rop.domain.model.Entities.ArticleEntity;
import org.ep.rop.domain.model.Entities.ParagraphEntity;
import org.springframework.data.neo4j.repository.ReactiveNeo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface ParagraphRepository extends ReactiveNeo4jRepository<ParagraphEntity, UUID> {
    Mono<ParagraphEntity> findById(UUID id);

    @Query("MATCH (a:Article)-[:HAS_PARAGRAPH]->(p:Paragraph) WHERE a.id = $articleId RETURN a ORDER BY a.componentOrder ")
    Flux<ParagraphEntity> findByArticleId(UUID id);
}
