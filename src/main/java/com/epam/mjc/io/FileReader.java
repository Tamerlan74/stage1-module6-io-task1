package com.epam.mjc.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;


public class FileReader {

    public Profile getDataFromFile(File file) {
        Profile profile = null;
        try (java.io.FileReader fr = new java.io.FileReader(file);
             BufferedReader br = new BufferedReader(fr)) {
            String line;
            String[] arrs = new String[8];
            int n = 0;
            String[] lines;
            while ((line=br.readLine())!=null) {
                lines=line.split(": ");

                arrs[n] = lines[0];
                n++;
                arrs[n] = lines[1];
                n++;


            }
            profile = new Profile(arrs[1], Integer.parseInt(arrs[3]), arrs[5], Long.parseLong(arrs[7]));

        } catch (IOException e) {
            e.printStackTrace();
        }
        return profile;
    }
}
