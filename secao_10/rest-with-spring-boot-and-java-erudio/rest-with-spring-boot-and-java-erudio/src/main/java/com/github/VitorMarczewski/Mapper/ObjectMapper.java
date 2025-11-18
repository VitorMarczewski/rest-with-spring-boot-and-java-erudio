package com.github.VitorMarczewski.Mapper;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;

import java.util.List;
import java.util.ArrayList;

public class ObjectMapper {

    private static Mapper mapper = DozerBeanMapperBuilder.buildDefault();

    public static <O, D> D parseObject(O origin, Class<D> destination) {
        return mapper.map(origin, destination);
    }

    public static <O, D> List<D> parseListObjects(List<O> objectsOrigin, Class<D> destinationClass) {
        List<D> destinationObjects = new ArrayList<>();

        for (O origin : objectsOrigin) {
            destinationObjects.add(mapper.map(origin, destinationClass));
        }

        return destinationObjects;
    }
}
