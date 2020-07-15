package Hajin.Filbehandling;

import Hajin.Avvik.InvalidPersonFormatException;
import Hajin.Person;

public class ParsePerson {
    public static Person parsePerson(String str) throws InvalidPersonFormatException {
        String[] strings = str.split(PersonFormatter.DELIMITER);
        if(strings.length != 5) {
            throw new InvalidPersonFormatException("Feil bruk av spesialtegn");
        }

        String navn = strings[0];
        String fodselsdato = strings[1];
        int alder;
        try {
            alder = Integer.parseInt(strings[2]);
        } catch(NumberFormatException e) {
            throw new InvalidPersonFormatException("Ugyldig alder");
        }
        String epost = strings[3];
        String telefonnr = strings[4];

        return new Person(navn, fodselsdato, alder, epost, telefonnr);
    }
}
