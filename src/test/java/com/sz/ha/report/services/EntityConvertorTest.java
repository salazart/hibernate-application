package com.sz.ha.report.services;

import com.sz.ha.models.User;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class EntityConvertorTest {

    private EntityConverter<User> entityConvertor = new EntityConverter<>();

    @Test
    public void entityToValueListOfFieldsTest(){
        User user = new User(Long.valueOf(1), "Ivan", "Ivonov");
        List<String> fields = entityConvertor.entityToValueListOfFields(user);
        System.out.println(fields);
        assertTrue(fields.size() == 4);
    }

    @Test
    public void entityListToFieldsOfEntityListTest(){
        List<User> entityList = Arrays.asList(
                new User(Long.valueOf(1), "Ivan1", "Ivonov1"),
                new User(Long.valueOf(2), "Ivan2", "Ivonov2"),
                new User(Long.valueOf(3), "Ivan3", "Ivonov3"),
                new User(Long.valueOf(4), "Ivan4", "Ivonov4"));
        List<List<String>> listOfEntityFieldsList = entityConvertor.entityListToFieldsOfEntityList(entityList);
        assertTrue(listOfEntityFieldsList.size() == 4);
    }
}