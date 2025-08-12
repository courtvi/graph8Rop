package org.ep.rop.domain.repository;
import org.ep.rop.domain.model.Entities.ArticleEntity;
import org.springframework.data.neo4j.repository.*;
import org.springframework.data.neo4j.repository.query.Query;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface ArticleRepository extends ReactiveNeo4jRepository<ArticleEntity, UUID> {

    Mono<ArticleEntity> findById(UUID id,int depth);

    Mono<ArticleEntity> findByNum(String num);

    Mono<ArticleEntity> findByHeading(String heading);

    @Query("MATCH (t:Title)-[:HAS_RULE]->(a:Article) WHERE t.id = $titleId RETURN a ORDER BY a.componentOrder")
    Flux<ArticleEntity> findByTitleId(UUID titleId);

    @Query("MATCH (c:Chapter)-[:HAS_RULE]->(a:Article) WHERE c.id = $chapterId RETURN a ORDER BY a.componentOrder ")
    Flux<ArticleEntity> findByChapterId(UUID chapterId);

    @Query("MATCH (s:Section)-[:HAS_RULE]->(a:Article) WHERE s.id = $sectionId RETURN a ORDER BY a.componentOrder ")
    Flux<ArticleEntity> findBySectionId(UUID sectionId);

    @Query("MATCH (a:Annex)-[:HAS_RULE]->(a2:Article) WHERE a.id = $annexId RETURN a ORDER BY a.componentOrder ")
    Flux<ArticleEntity> findByArticleId(UUID id);
}
