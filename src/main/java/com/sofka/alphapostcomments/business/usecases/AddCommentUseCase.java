package com.sofka.alphapostcomments.business.usecases;

import com.sofka.alphapostcomments.Post;
import com.sofka.alphapostcomments.business.gateway.DomainEventRepository;
import com.sofka.alphapostcomments.commands.AddComment;
import com.sofka.alphapostcomments.events.CommentAdded;
import com.sofka.alphapostcomments.values.Author;
import com.sofka.alphapostcomments.values.CommentId;
import com.sofka.alphapostcomments.values.Content;
import com.sofka.alphapostcomments.values.PostId;
import org.springframework.beans.factory.annotation.Autowired;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.function.Function;
import java.util.stream.Collectors;

public class AddCommentUseCase implements Function<Mono<AddComment>, Mono<CommentAdded>> {

    @Autowired
    DomainEventRepository eventRepository;

    @Override
    public Mono<CommentAdded> apply(Mono<AddComment> addCommentMono) {
        return addCommentMono.flatMap(command ->{
            Post post = Post.from(PostId.of(command.getPostId()), eventRepository
                    .getAllPostEventsById(command.getPostId())
                    .toStream()
                    .collect(Collectors.toList()));
            post.addComment(
                    CommentId.of(command.getCommentId()),
                    new Author(command.getAuthor()),
                    new Content(command.getContent())
            );
            return eventRepository.addComment(post.getUncommittedChanges().get(0));
        });
    }
}
