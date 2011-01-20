package com.jcertif.presentation.data;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Defines certain fields to be fetched lazily. May only be applied to getter
 * methods and the class must also provide a corresponding setter method.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface LazyLoad {

    /**
     * Returns the name of the JSON field to be fetched.
     * 
     * @return
     */
    String value();
}
