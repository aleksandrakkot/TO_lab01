package main;

import java.util.List;

public class Collection {
    private List<Waluta> lista;

    public Collection(List<Waluta> lista) { //pakoanie do listy
        this.lista = lista;
    }

    public Waluta getByCode(String code) //wyszukiwanie waluty poprzez code
    {
        for(var w : lista)
        {
            if(w.getKod().equals(code))
            {
                return w;
            }
        }

        return null;
    }
}
