package main;

public class Waluta {
    private final String nazwa;
    private final Integer przelicznik;
    private final String kod;
    private final Float kursSredni;

    public Waluta(String nazwa, Integer przelicznik, String kod, Float kursSredni) {
        this.nazwa = nazwa;
        this.przelicznik = przelicznik;
        this.kod = kod;
        this.kursSredni = kursSredni;
    }

    String getNazwa(){
        return nazwa;
    }

    Integer getPrzelicznik(){
        return przelicznik;
    }

    String getKod(){
        return kod;
    }

    Float getKursSredni(){
        return kursSredni;
    }
}
