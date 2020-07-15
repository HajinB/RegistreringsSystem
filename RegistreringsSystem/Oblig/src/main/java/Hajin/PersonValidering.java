package Hajin;

public class PersonValidering {

    private static final String EMAIL_VERIFICATION = "^([\\p{L}-.]+){1,64}@([\\w&&[^_]]+){2,255}.[a-zæøå]{2,}$";
    //legg
    // til en optional siste clause for å støtte co.uk (altså .uk er optional)
    //https://stackoverflow.com/questions/10306690/what-is-a-regular-expression-which-will-match-a-valid-domain-name-without-a-subd/30007882#30007882
    public static final String EMAIL_VERIFICATION2 = "^[a-zA-Z0-9]+(?:[_.-][a-zA-Z0-9]+)*@[a-zA-Z0-9]+(?:[_.-][a-zA-Z0-9]+)*\\.[a-zA-Z]{2,3}$";
    private static final String NORSK_PHONE_VERIFICATION = "^((0047)?|(\\+47)?|(47)?)\\d{8}$";
    public static final String CUSTOM_NORSK_PHONE_VERIFICATION = "^([a-z]) $";
    public static final String NORSK_NAVN_VERIFICATION = "^[a-z ,.'-]+$"; //why does this not work
    private static final String VERDENSNAVN_NAVN_VERIFICATION2 = "^[a-zA-Z" +
            "àáâäæøåãåąčćęèéêëėįìíîïłńòóôöõùúûüųūÿýżźñçčšžÀÁÂÄÃÅĄĆČĖĘÈÉÊËÌÍÎÏĮŁŃÒÓÔÖÕØÙÚÛÜŲŪŸÝŻŹÆÑßÇŒČŠŽ∂ð ,.'-]+$";
    public static final String NORSK_NAVN_VERIFICATION3 = "^[a-zæøå ,.-]$";


    //https://stackoverflow.com/questions/20771794/mailrfc822address-regex
    //SAFTIG REGEX HER
    // public static final String EMAIL_VERIFICATION2 = "^[ÆØÅæøåA-Za-z0-9._%+-]+@(?:[ÆØÅæøåA-Za-z0-9-]+\.)
    // +[A-Za-z]{2,6}$";

    //public static final String EMAIL_VERIFICATION2 = ^[ÆØÅæøåA-Za-z0-9._%+-]+@(?:[ÆØÅæøåA-Za-z0-9-]+\.)+[A-Za-z]{2,6}$

    public static boolean erNavnGyldig(String navn) {
        //En enkel løsning som vil støtte alle typer navn, men som sikkert inkluderer en del ugyldige navn, er å
        // tillate minst ett tegn og ikke tillate tall. Tomme navn burde heller ikke tillates.
        //Eksempler på ugyldige navn: "123", "",  "   ", "Per97"

        //if(navn.length()<1 || !navn.matches("\\D")){
        // return navn.length() > 1 || navn.matches("^(?i)([//D])+([//D])+$");
        return navn.length() > 2 && navn.matches(VERDENSNAVN_NAVN_VERIFICATION2) || navn.matches(NORSK_NAVN_VERIFICATION)
                || navn.matches(NORSK_NAVN_VERIFICATION3);
    }

    public static boolean erTelefonnummerGyldig(String telefonnummer) {
        // http://programmeringsbloggen.no/2011/12/23/regex/
        // http://programmeringsbloggen.no/2011/12/23/regex/
        //skriv regex her bruh
        return telefonnummer.matches(NORSK_PHONE_VERIFICATION) || telefonnummer.matches(CUSTOM_NORSK_PHONE_VERIFICATION);
    }
    public static boolean erEpostGyldig(String epost) {
        if (epost.length() < 5) {
            return false; }
        return epost.matches(EMAIL_VERIFICATION) || epost.matches(EMAIL_VERIFICATION2);
    }

    public static boolean ValidEpost(String epost) {
        return true;
    }

    public static String feilmelding(String melding) {
        return melding;
    }
}

