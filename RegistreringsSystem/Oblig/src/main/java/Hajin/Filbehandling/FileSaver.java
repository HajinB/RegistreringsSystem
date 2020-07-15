package Hajin.Filbehandling;

import javafx.collections.ObservableList;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public interface FileSaver {

    static void writeString(String objects, Path file) throws IOException {
        Files.write(file, objects.toString().getBytes());
    }
}
