package Hajin.Filbehandling;

import Hajin.Person;

import java.util.List;

public class PersonFormatter {
    public static String DELIMITER = ";";

    public static String formatPerson(Person p) {
        return p.getNavn() + DELIMITER + p.getFodselsdato() + DELIMITER + p.getAlder() + DELIMITER + p.getEpost() + DELIMITER + p.getTelefonnr();
    }

    public static String formatPeople(List<Person> plist) {
        StringBuffer str = new StringBuffer();
        for(Person p : plist) {
            str.append(formatPerson(p));
            str.append("\n");
        }

        return str.toString();
    }
}
