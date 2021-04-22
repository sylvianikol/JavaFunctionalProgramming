package com.syn.higherorderfunction;

public class HigherOrderFunctionClass {

    public <T> Factory<T> createFactory(Producer<T> producer, Configurator<T> configurator) {
        return () -> {
            T instance = producer.produce();
            configurator.configure(instance);
            return instance;
        };
    }
}
