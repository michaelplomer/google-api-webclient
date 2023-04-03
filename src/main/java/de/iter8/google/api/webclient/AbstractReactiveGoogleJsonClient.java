package de.iter8.google.api.webclient;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.web.reactive.function.client.WebClient;

@Getter
@RequiredArgsConstructor
@SuperBuilder(builderMethodName = "clientBuilder")
public class AbstractReactiveGoogleJsonClient {

    @NonNull
    private final String rootUrl;

    @NonNull
    private final String servicePath;

    @NonNull
    private final WebClient webClient;

    @NonNull
    private final String applicationName;

    public final String getBaseUrl() {
        return rootUrl + servicePath;
    }

}
