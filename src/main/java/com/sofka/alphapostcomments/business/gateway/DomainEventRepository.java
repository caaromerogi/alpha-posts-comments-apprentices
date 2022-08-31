package com.sofka.alphapostcomments.business.gateway;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.alphapostcomments.Post;
import com.sofka.alphapostcomments.events.CommentAdded;
import com.sofka.alphapostcomments.events.PostCreated;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface DomainEventRepository {
    Mono<CommentAdded> addComment(DomainEvent domainEvent);
    Mono<PostCreated> save(DomainEvent domainEvent);

    Flux<DomainEvent> getAllPostEventsById(String id);
}
