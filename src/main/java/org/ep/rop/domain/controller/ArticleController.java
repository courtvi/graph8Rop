package org.ep.rop.domain.controller;

import org.ep.rop.domain.model.Entities.*;
import org.ep.rop.domain.repository.ArticleRepository;
import org.ep.rop.domain.dto.ArticlesWrapper;
import org.ep.rop.domain.repository.ParagraphRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController
@RequestMapping("/articles")
public class ArticleController {

    private final ArticleRepository articleRepository;
    private final ParagraphRepository paragraphRepository;

    @Autowired
    public ArticleController(ArticleRepository articleRepository, ParagraphRepository paragraphRepository) {
            this.articleRepository = articleRepository;
            this.paragraphRepository = paragraphRepository;
        }

    @PutMapping
    public Flux<ArticleEntity> createArticles(@RequestBody ArticlesWrapper wrapper) {
        return Flux.fromIterable(wrapper.getArticles())
                .flatMap(articleRepository::save);
    }


    @GetMapping(value = { "", "/" }, produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    Flux<ArticleEntity> getArticles() {
        return articleRepository.findAll();
    }

    @GetMapping("/{id}")
    public Mono<ArticleEntity> byId(@PathVariable UUID id) {
        return articleRepository.findById(id);
    }

    @PutMapping("/{id}")
    public Mono<ArticleEntity> updateArticleHeading(@PathVariable UUID id, @RequestBody ArticleEntity article) {
        return articleRepository.findById(id)
                .flatMap(updateArticle -> {
                    updateArticle.setNum(article.getNum());
                    updateArticle.setHeading(article.getHeading());
                    updateArticle.setComponentOrder(article.getComponentOrder());
                    updateArticle.setParagraphes(article.getParagraphes());
                    updateArticle.setAlineas(article.getAlineas());
                    return articleRepository.save(updateArticle);
                });
    }

    @QueryMapping
    public Flux<ArticleEntity> articles() {
        return articleRepository.findAll();
    }

    @SchemaMapping(typeName = "Article", field = "paragraphes")
    public Flux<ParagraphEntity> getParagraphes(ArticleEntity article) {
        return paragraphRepository.findByArticleId(article.getId());
    }
}