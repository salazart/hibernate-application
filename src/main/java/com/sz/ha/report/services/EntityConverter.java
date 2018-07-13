package com.sz.ha.report.services;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EntityConverter<Entity extends Object> {

    public List<String> entityToValueListOfFields(Entity entity){
        Field[] fields = entity.getClass().getDeclaredFields();
        List<String> valuesOfFields = new ArrayList<>(fields.length);
        Arrays.stream(fields)
                .forEach(field ->{
                    field.setAccessible(true);
                    try {
                        valuesOfFields.add(String.valueOf(field.get(entity)));
                    } catch (IllegalAccessException e) {
                        System.err.println(e);
                    }
                });

        return valuesOfFields;
    }

    public List<List<String>> entityListToFieldsOfEntityList(List<Entity> entities){
        List<List<String>> lists = new ArrayList<>();
        entities.stream()
                .forEach(entityList -> lists.add(entityToValueListOfFields(entityList)));
        return lists;
    }
}
