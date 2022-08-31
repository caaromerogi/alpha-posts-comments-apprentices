package com.sofka.alphapostcomments.business.usecases;

import com.sofka.alphapostcomments.Post;
import com.sofka.alphapostcomments.business.gateway.DomainEventRepository;
import com.sofka.alphapostcomments.commands.CreatePost;
import com.sofka.alphapostcomments.events.PostCreated;
import org.springframework.beans.factory.annotation.Autowired;
import reactor.core.publisher.Mono;

import java.util.function.Function;

public class CreatePostUseCase implements Function<Mono<CreatePost>, Mono<PostCreated>> {
    @Autowired
    DomainEventRepository eventRepository;


    @Override
    public Mono<PostCreated> apply(Mono<CreatePost> createPostMono) {
        return createPostMono
                .flatMap(command -> {
            Post post = new Post(command.getPostId(), command.getTitle(), command.getAuthor());
            return eventRepository.save(post.getUncommittedChanges().get(0));
        });
    }
}

