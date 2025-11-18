package com.github.VitorMarczewski.mapper;

import java.util.ArrayList;
import java.util.List;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;

public class ObjectMapper {
    public static Mapper mapper = DozerBeanMapperBuilder.buildDefault();

    //  Metodo para converter um objeto
    public static <O,D> D parseObject(O origin, Class<D> destination){
        return mapper.map(origin, destination);
    }

    public static <O,D> List<D> parseListObjects(List<O> origin, Class<D> destination){
        List<D> destinationObjects = new ArrayList<D>();

        for(Object o : origin){
            destinationObjects.add(mapper.map(o,destination));
        }

        return destinationObjects;
        
    }
}
