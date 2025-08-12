package org.ep.rop.domain.controller;

import org.ep.rop.domain.dto.AnnexesWrapper;
import org.ep.rop.domain.dto.TitleOrderBy;
import org.ep.rop.domain.dto.TitlesWrapper;
import org.ep.rop.domain.model.Entities.*;
import org.ep.rop.domain.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/annexes")
public class AnnexController {

     private final SectionRepository sectionRepository;
     private final AnnexRepository annexRepository;
     private final ArticleRepository articleRepository;

    @Autowired
    public AnnexController(SectionRepository sectionRepository, AnnexRepository annexRepository, ArticleRepository articleRepository) {
       this.sectionRepository = sectionRepository;
       this.annexRepository = annexRepository;
       this.articleRepository = articleRepository;

    }

    //reactive endpoints

    @PutMapping
    public Flux<AnnexEntity> createOrUpdateAnnexes(@RequestBody AnnexesWrapper wrapper) {
        return Flux.fromIterable(wrapper.getAnnexes())
                .flatMap(annexRepository::save);
    }

    @PutMapping("/{id}")
    public Mono<AnnexEntity> updateAnnex(@PathVariable UUID id, @RequestBody AnnexEntity annex) {
        return annexRepository.findById(id)
                .flatMap(updateAnnex -> {
                    updateAnnex.setNum(annex.getNum());
                    updateAnnex.setHeading(annex.getHeading());
                    updateAnnex.setComponentOrder(annex.getComponentOrder());
                    updateAnnex.setSections(annex.getSections());
                    updateAnnex.setParagraphes(annex.getParagraphes());
                    return annexRepository.save(updateAnnex);
                });
    }

    @GetMapping(value = { "", "/" }, produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    Flux<AnnexEntity> getAnnexes() {
        return annexRepository.findAll();
    }

    @GetMapping("/by-heading")
    Mono<AnnexEntity> byHeading(@RequestParam UUID id) {
        return annexRepository.findById(id);
    }

    @DeleteMapping("/{id}")
    Mono<Void> delete(@PathVariable UUID id) {
        return annexRepository.deleteById(id);
    }

    @QueryMapping
    public Flux<AnnexEntity> annexes() {
        return annexRepository.findAll();
    }


    @SchemaMapping(typeName = "Annex", field = "sections")
    public Flux<SectionEntity> getSections(SectionEntity section) {
        return sectionRepository.findByAnnexId(section.getId());
    }

    @SchemaMapping(typeName = "Annex", field = "articles")
    public Flux<ArticleEntity> getArticles(ArticleEntity article) {
        return articleRepository.findByArticleId(article.getId());
    }

}

