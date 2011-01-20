package com.jcertif.presentation.data;

public interface LazyLoadProvider {

    /**
     * Uses reflection to fill all fields of given LazyLoadable that are
     * decorated with the LazyLoad annotation.
     * 
     * @param lazyLoadable
     */
    void lazyLoadFields(LazyLoadable lazyLoadable);
}
