package org.ep.rop.domain.controller;

import org.ep.rop.domain.dto.TitleOrderBy;
import org.ep.rop.domain.dto.TitlesWrapper;
import org.ep.rop.domain.model.Entities.*;
import org.ep.rop.domain.repository.ArticleRepository;
import org.ep.rop.domain.repository.ChapterRepository;
import org.ep.rop.domain.repository.TitleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/titles")
public class TitleController {

    private final TitleRepository titleRepository;
    private final ChapterRepository chapterRepository;
    private final ArticleRepository articleRepository;

    @Autowired
    public TitleController(TitleRepository titleRepository, ChapterRepository chapterRepository, ArticleRepository articleRepository) {
        this.titleRepository = titleRepository;
        this.chapterRepository = chapterRepository;
        this.articleRepository = articleRepository;
    }

    //reactive endpoints

    @PutMapping
    public Flux<TitleEntity> createOrUpdateTitles(@RequestBody TitlesWrapper wrapper) {
        return Flux.fromIterable(wrapper.getTitles())
                .flatMap(titleRepository::save);
    }

    @PutMapping("/{id}")
    public Mono<TitleEntity> updateTitle(@PathVariable UUID id, @RequestBody TitleEntity title) {
        return titleRepository.findById(id)
                .flatMap(updateTitle -> {
                    updateTitle.setNum(title.getNum());
                    updateTitle.setHeading(title.getHeading());
                    updateTitle.setComponentOrder(title.getComponentOrder());
                    updateTitle.setChapters(title.getChapters());
                    updateTitle.setArticles(title.getArticles());
                    return titleRepository.save(updateTitle);
                });
    }

    @GetMapping(value = { "", "/" }, produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    Flux<TitleEntity> getTitles() {
        return titleRepository.findAll();
    }

    @GetMapping("/by-heading")
    Mono<TitleEntity> byHeading(@RequestParam UUID id) {
        return titleRepository.findById(id);
    }

    @DeleteMapping("/{id}")
    Mono<Void> delete(@PathVariable UUID id) {
        return titleRepository.deleteById(id);
    }

    @QueryMapping
    public Flux<TitleEntity> titles(@Argument Optional<TitleOrderBy> orderBy) {
        return titleRepository.findAll();
    }

    @SchemaMapping(typeName = "Title", field = "chapters")
    public Flux<ChapterEntity> getChapters(TitleEntity title) {
        return chapterRepository.findByTitleId(title.getId());
    }

    @SchemaMapping(typeName = "Title", field = "articles")
    public Mono<List<ArticleEntity>> getArticles(TitleEntity title) {
        return articleRepository.findByTitleId(title.getId())
                .collectList()
                .flatMap(articles -> {
                    if (articles.isEmpty()) {
                        return Mono.empty(); // Ne renvoie rien => pas dans le JSON
                    }
                    return Mono.just(articles);
                });
    }


    @SchemaMapping(typeName = "Title", field = "hasArticles")
    public Mono<Boolean> hasArticles(TitleEntity chapter) {
        return articleRepository.findByTitleId(chapter.getId())
                .hasElements();
    }
}