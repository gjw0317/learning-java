package com.practice.base;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by junwuguo on 2017/8/4 0004.
 */
public class DataGenerator {
    public static String fileForSort = "src/main/resources/for_sort.txt";

    public static Integer[] generateArray() {
        File file = new File(fileForSort);
        BufferedReader reader = null;
        List<Integer> list = new ArrayList<>();
        try {
            reader = new BufferedReader(new FileReader(file));
            String tmp = null;
            while ((tmp = reader.readLine()) != null) {
                String[] line = tmp.split(" ");
                for (String num: line) {
                    list.add(Integer.valueOf(num));
                }
            }
            Integer[] result = new Integer[list.size()];
            list.toArray(result);
            return result;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Integer[] x = generateArray();
        Base.display(x);
    }
}
