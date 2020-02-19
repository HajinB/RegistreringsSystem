package Hajin;

import javafx.collections.ObservableList;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public interface FileOpener {
    static List<Person> readPeople(String path) throws IOException {
        ArrayList<Person> list = new ArrayList<>();

        try (BufferedReader reader = Files.newBufferedReader(Paths.get(path))) {
            String line;

            while((line = reader.readLine()) != null) {
                Person p = ParsePerson.parsePerson(line);
                list.add(p);
            }
        }

        return list;
    }
}

//Velge et bestemt sted å åpne filer fra setInitialDirectory(new File("navn på adressen"));
