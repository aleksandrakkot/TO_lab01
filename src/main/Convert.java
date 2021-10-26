package main;

public class Convert {
    private Waluta waluta1;
    private Waluta waluta2;

    public Convert(Waluta waluta1, Waluta waluta2) {
        this.waluta1 = waluta1;
        this.waluta2 = waluta2;
    }

    public float getResult(float value)
    {
        return (waluta1.getKursSredni() * waluta1.getPrzelicznik() * value) / (waluta2.getKursSredni() * waluta2.getPrzelicznik());


    }

}
