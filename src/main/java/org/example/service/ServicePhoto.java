package org.example.service;

import java.io.IOException;
import java.util.List;

public interface ServicePhoto {
     void savePhoto(byte[] fileBytes);

     List<String> getOptions() throws IOException;
}
