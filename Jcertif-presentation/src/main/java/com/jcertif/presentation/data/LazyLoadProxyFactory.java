package com.jcertif.presentation.data;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Factory for creating proxies to handle lazy loading.
 * 
 * @see LazyLoad
 */
public class LazyLoadProxyFactory {

    /**
     * Returns a proxy for the given LazyLoadable that automatically takes care
     * of all lazy loading more data when required.
     * 
     * @param lazyLoadable
     * @param lazyLoadProvider
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <V extends LazyLoadable> V getProxy(final V lazyLoadable, final LazyLoadProvider lazyLoadProvider) {
        return (V) Proxy.newProxyInstance(lazyLoadable.getClass()
                .getClassLoader(), lazyLoadable.getClass().getInterfaces(),
                new LazyLoadProxy(lazyLoadable, lazyLoadProvider));
    }

    private static class LazyLoadProxy implements InvocationHandler {

        private final LazyLoadable lazyLoadable;
        private final LazyLoadProvider lazyLoadProvider;
        private volatile boolean lazyLoaded;

        public LazyLoadProxy(final LazyLoadable lazyLoadable, final LazyLoadProvider lazyLoadProvider) {
            this.lazyLoadable = lazyLoadable;
            this.lazyLoadProvider = lazyLoadProvider;
        }

        public Object invoke(final Object proxy, final Method method, final Object[] args) throws Throwable {

            final Method actualMethod = lazyLoadable.getClass().getMethod(method.getName(), method.getParameterTypes());
            if (!lazyLoaded && actualMethod.isAnnotationPresent(LazyLoad.class)) {
                lazyLoadProvider.lazyLoadFields(lazyLoadable);
                lazyLoaded = true;
            }
            return method.invoke(lazyLoadable, args);
        }
    }
}
