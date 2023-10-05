package de.iter8.google.api.webclient;

import reactor.core.publisher.Mono;

public interface ListRequest<I, P extends ListResultPage<I>, ME extends ListRequest<I, P, ME>> {
    ME pageToken(String pageToken);

    default ME syncToken(String syncToken) {
        return (ME) this;
    }

    ME maxResults(Integer maxResults);

    Mono<P> execute();
}
