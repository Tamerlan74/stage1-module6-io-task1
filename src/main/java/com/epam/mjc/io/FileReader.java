package com.epam.mjc.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;


public class FileReader {

    public Profile getDataFromFile(File file) {
        Profile result = null;
        try (FileInputStream fis = new FileInputStream(file.getPath())) {
            try(ObjectInputStream ois = new ObjectInputStream(fis)) {
                result = (Profile) ois.readObject();
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }
}
