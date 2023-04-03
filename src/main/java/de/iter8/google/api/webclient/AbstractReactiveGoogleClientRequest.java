package de.iter8.google.api.webclient;

import com.google.api.client.http.UriTemplate;
import com.google.api.client.util.GenericData;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import reactor.core.publisher.Mono;


@Accessors(fluent = true)
@RequiredArgsConstructor
public class AbstractReactiveGoogleClientRequest<T> extends GenericData {
    private final AbstractReactiveGoogleJsonClient abstractGoogleClient;
    private final Class<T> responseClass;
    private final HttpMethod requestMethod;
    private final String uriTemplate;

    private final Object requestBody;

    public Mono<T> execute() {
        var reqSpec = abstractGoogleClient.getWebClient()
                .method(requestMethod)
                .uri(UriTemplate.expand(abstractGoogleClient.getBaseUrl(), uriTemplate, this, true));
        if (requestBody != null) {
            reqSpec.contentType(MediaType.APPLICATION_JSON).body(BodyInserters.fromValue(requestBody));
        }
        return reqSpec.retrieve().bodyToMono(responseClass);
    }

}
