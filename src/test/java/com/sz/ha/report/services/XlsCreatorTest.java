package com.sz.ha.report.services;

import com.sz.ha.models.User;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class XlsCreatorTest {

    private static final String fileName = "out.xls";
    private XlsCreator xlsCreator;
    private EntityConverter<User> entityConverter = new EntityConverter<>();

    @Test
    public void createWorkBook() {
        List<User> entityList = Arrays.asList(
//                new User(Long.valueOf(1), "Ivan1", "Ivonov1","City1"),
//                new User(Long.valueOf(2), "Ivan2", "Ivonov2","City1"),
//                new User(Long.valueOf(3), "Ivan3", "Ivonov3","City1"),
//                new User(Long.valueOf(3), "Ivan3", "Ivonov3","City1"),
//                new User(Long.valueOf(3), "Ivan3", "Ivonov3","City1"),
//                new User(Long.valueOf(3), "Ivan3", "Ivonov3","City1"),
//                new User(Long.valueOf(3), "Ivan3", "Ivonov3","City1"),
//                new User(Long.valueOf(3), "Ivan3", "Ivonov3","City1"),
//                new User(Long.valueOf(3), "Ivan3", "Ivonov5","City1"),
//                new User(Long.valueOf(4), "Ivan4", "Ivonov5","City1"),
                new User(Long.valueOf(5), "Ivan5", "Ivonov5","City1"),
                new User(Long.valueOf(5), "Ivan5", "Ivonov5","City1"));

        List<List<String>> rows = entityConverter.entityListToFieldsOfEntityList(entityList);

        xlsCreator = new XlsCreator(fileName);
        xlsCreator.setGroupColumn(3);
        xlsCreator.createWorkBook(rows);
    }
}