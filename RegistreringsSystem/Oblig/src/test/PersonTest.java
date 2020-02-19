import Hajin.PersonValidering;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {
    @Test
    void testInvalidNavn() {
        assertFalse(PersonValidering.erNavnGyldig(""));
        assertFalse(PersonValidering.erNavnGyldig("213"));
        assertFalse(PersonValidering.erNavnGyldig("4"));
        assertFalse(PersonValidering.erNavnGyldig("2"));
        assertFalse(PersonValidering.erNavnGyldig("test@"));
        assertFalse(PersonValidering.erNavnGyldig(";botevil.com"));
    }

    @Test
    void testValidNavn() {
        assertTrue(PersonValidering.erNavnGyldig("Tom Basmo"));
        assertTrue(PersonValidering.erNavnGyldig("Tom-Henrik Basmo"));
        assertTrue(PersonValidering.erNavnGyldig("Tom Hænrik Basmo"));
        assertTrue(PersonValidering.erNavnGyldig("Æbæ åBå"));
    }


    @Test
    void testInvalidTelefonnummer() {
        assertFalse(PersonValidering.erTelefonnummerGyldig(""));
        assertFalse(PersonValidering.erTelefonnummerGyldig("222æ345"));
        assertFalse(PersonValidering.erTelefonnummerGyldig("æasfdgh"));
        assertFalse(PersonValidering.erTelefonnummerGyldig("a"));
        assertFalse(PersonValidering.erTelefonnummerGyldig("test@"));
        assertFalse(PersonValidering.erTelefonnummerGyldig(";bot@evil.com"));
    }

    @Test
    void testValidTelefonnummer() {
        assertTrue(PersonValidering.erTelefonnummerGyldig("99410133"));
        assertTrue(PersonValidering.erTelefonnummerGyldig("004799410133"));
        assertTrue(PersonValidering.erTelefonnummerGyldig("4799410133"));
        assertTrue(PersonValidering.erTelefonnummerGyldig("+4799410133"));
    }

    @Test
    public void testValidEpost() {
        assertTrue(PersonValidering.erEpostGyldig("henrik.lieng@oslomet.no"));
        assertTrue(PersonValidering.erEpostGyldig("example@example.com"));
        assertTrue(PersonValidering.erEpostGyldig("uk@domain.co.uk"));
        assertTrue(PersonValidering.erEpostGyldig("user@domain.org"));
    }

    @Test
    public void testInValidEpost() {
        assertFalse(PersonValidering.erEpostGyldig(""));
        assertFalse(PersonValidering.erEpostGyldig("henrik.lieng"));
        assertFalse(PersonValidering.erEpostGyldig("@oslomet.no"));
        //assertFalse(PersonValidering.erEpostGyldig("henrik.lieng@invalid"));
        assertFalse(PersonValidering.erEpostGyldig("test@"));
        assertFalse(PersonValidering.erEpostGyldig(";bot@evil.com"));
    }
}