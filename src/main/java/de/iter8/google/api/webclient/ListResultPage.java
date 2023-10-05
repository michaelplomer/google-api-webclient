package de.iter8.google.api.webclient;

import java.util.List;

public interface ListResultPage<I> {
    String getNextPageToken();
    String getNextSyncToken();
    List<I> getItems();
    String getKind();
    String getEtag();

}
