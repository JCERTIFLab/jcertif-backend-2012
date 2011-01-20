package com.jcertif.presentation.data;


/**
 * LazyLoadable provides an URI for lazily loading more details via REST API.
 * 
 * @see LazyLoad
 * @see LazyLoadProxyFactory
 */
public interface LazyLoadable {

    /**
     * Returns an URI for loading more JSON data though a REST API.
     * 
     * @return
     */
    String getLazyLoadingUri();
}
