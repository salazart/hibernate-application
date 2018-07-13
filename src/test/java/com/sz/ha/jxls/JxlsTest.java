package com.sz.ha.jxls;

import com.sz.ha.models.Place;
import com.sz.ha.models.User;
import org.jxls.common.Context;
import org.jxls.util.JxlsHelper;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.List;

public class JxlsTest {
    public static void main(String[] args) {
//        List<City> sities = Arrays.asList(new City("Kyiv"), new City("Khmelnytskyi"), new City("Lviv"));

//        List<User> users = Arrays.asList(
////                new User(Long.valueOf(1), "Ivan1", "Ivonov1","City1"),
////                new User(Long.valueOf(2), "Ivan2", "Ivonov2","City1"),
////                new User(Long.valueOf(3), "Ivan3", "Ivonov3","City1"),
////                new User(Long.valueOf(3), "Ivan3", "Ivonov3","City1"),
////                new User(Long.valueOf(3), "Ivan3", "Ivonov3","City1"),
////                new User(Long.valueOf(3), "Ivan3", "Ivonov3","City1"),
////                new User(Long.valueOf(3), "Ivan3", "Ivonov3","City1"),
////                new User(Long.valueOf(3), "Ivan3", "Ivonov3","City1"),
//                new User(Long.valueOf(3), "Ivan3", "Ivonov4","City1"),
//                new User(Long.valueOf(4), "Ivan4", "Ivonov4","City1"),
//                new User(Long.valueOf(5), "Ivan5", "Ivonov5","City1"),
//                new User(Long.valueOf(5), "Ivan5", "Ivonov5","City1"));

        List<Place> places = Arrays.asList(
                new Place("счет1", "Ошибка инкассаторов", 1, 49000, "БФ1 (в раскрывающемся списке перечень счетов и сумм)"),
                new Place("счет2", "Ошибка инкассаторов", 2, 50000, "БФ1 (в раскрывающемся списке перечень счетов и сумм)"),
                new Place("счет1", "Ошибка кассовых работников при формировании кассет", 4, 30000, "БФ1 (в раскрывающемся списке перечень счетов и сумм)"),
                new Place("счет2", "Ошибка кассовых работников при формировании кассет", 3, 20000, "БФ1 (в раскрывающемся списке перечень счетов и сумм)"),
                new Place("счет1", "Ошибка инкассаторов2", 4, 10000, "РОО1")
        );

        JxlsTest jxlsTest = new JxlsTest();
        try(InputStream is = jxlsTest.getClass().getResourceAsStream("/template12.xls")) {
            try (OutputStream os = new FileOutputStream("object_collection_output.xls")) {
                Context context = new Context();
                context.putVar("places", places);
//                context.putVar("user", new User("Alex", "Syd"));
                JxlsHelper.getInstance().processTemplate(is, os, context);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
