package Hajin;

import Hajin.Avvik.InvalidDatoException;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class DatoNY {
    int dag;
    int mnd;
    int aar;

    private static final int[] dagIMnd = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public static boolean erSkuddaar(int aar) {
        return new GregorianCalendar().isLeapYear(aar);
    }

    public static boolean erGyldig(int dag, int mnd, int aar) throws InvalidDatoException {
        if (mnd < 1 || mnd > 12) {
            return false;
        }
        int detteAar = Calendar.getInstance().get(Calendar.YEAR);
        if (aar < 1900 || aar > detteAar) {
            return false;
        }
        int mndDag = dagIMnd[mnd - 1] + (mnd == 2 && erSkuddaar(aar) ? 1 : 0);
        return 1 <= dag && dag <= mndDag;
    }

    public DatoNY(int dag, int mnd, int aar) {
        this.dag = dag;
        this.mnd = mnd;
        this.aar = aar;
    }

    public void setDato(int dag, int mnd, int aar) throws InvalidDatoException {
        if (!(erGyldig(dag, mnd, aar))) throw new InvalidDatoException("Feil dag, måned eller år! Prøv igjen.");
    }


    public int getDag() {
        return dag;
    }

    public void setDag(int dag) throws InvalidDatoException {
        if (dag < 0 || dag > 31) {
            throw new InvalidDatoException("Dag må være mellom 1 og 31. Prøv igjen.");
        }
        this.dag = dag;
    }

    public int getMnd() {
        return mnd;
    }

    public void setMnd(int mnd) throws InvalidDatoException {
        if (mnd < 1 || mnd > 12) {
            throw new InvalidDatoException("Månedsnummer må være mellom 1 og 12. Prøv igjen.");
        }
        this.mnd = mnd;
    }

    public int getAar() {
        return aar;
    }

    public void setAar(int aar) throws InvalidDatoException {
        int detteAar = Calendar.getInstance().get(Calendar.YEAR);
        if (aar < 1900 || aar > detteAar) {
            throw new InvalidDatoException("År må være mellom 1920 og " + detteAar + " prøv igjen");
        }
        this.aar = aar;
    }

    @Override
    public String toString() {
        if (dag < 10 && mnd < 10) {
            setDato(dag, mnd, aar);
            return "0" + dag + ".0" + mnd + "." + aar;
        } else if (dag > 10 && mnd < 10) {
            setDato(dag, mnd, aar);
            return dag + ".0" + mnd + "." + aar;
        } else if (dag < 10 && mnd > 10) {
            setDato(dag, mnd, aar);
            return "0" + dag + "." + mnd + "." + aar;
        } else {
            setDato(dag, mnd, aar);
            return dag + "." + mnd + "." + aar;
        }
    }
}