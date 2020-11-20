package keretrendszer.model;

import keretrendszer.exceptions.FizetesNegativ;
import keretrendszer.exceptions.NevNemLehetUres;
import keretrendszer.exceptions.RosszSzuletesiDatum;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class Dolgozo {
    private String nev;
    private String id;
    private LocalDate szuletesiDatum;
    private Reszleg reszleg;
    private double fizetes;
    private List<NyelvIsmeret> nyelvIsmeret;

    public Dolgozo() {
        this.id = UUID.randomUUID().toString();
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) throws NevNemLehetUres {
        if(nev.length() == 0) {
            throw new NevNemLehetUres();
        }
        this.nev = nev;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getSzuletesiDatum() {
        return szuletesiDatum;
    }

    public void setSzuletesiDatum(LocalDate szuletesiDatum) throws RosszSzuletesiDatum {
        if(szuletesiDatum.isAfter(LocalDate.now().minusYears(16))){
            throw new RosszSzuletesiDatum("16 évnél fiatalabb: " + szuletesiDatum);
        } else if(szuletesiDatum.isBefore(LocalDate.now().minusYears(100))){
            throw new RosszSzuletesiDatum("100 évnél nem lehet idősebb: " + szuletesiDatum);
        }
        this.szuletesiDatum = szuletesiDatum;
    }

    public Reszleg getReszleg() {
        return reszleg;
    }

    public void setReszleg(Reszleg reszleg) {
        this.reszleg = reszleg;
    }

    public double getFizetes() {
        return fizetes;
    }

    public void setFizetes(double fizetes) throws FizetesNegativ {
        if(fizetes < 0){
            throw new FizetesNegativ(fizetes);
        }
        this.fizetes = fizetes;
    }

    public List<NyelvIsmeret> getNyelvIsmeret() {
        return nyelvIsmeret;
    }

    public void setNyelvIsmeret(List<NyelvIsmeret> nyelvIsmeret) {
        this.nyelvIsmeret = nyelvIsmeret;
    }

    @Override
    public String toString() {
        return "Dolgozo{" +
                "nev='" + nev + '\'' +
                ", id='" + id + '\'' +
                ", szuletesiDatum=" + szuletesiDatum +
                ", reszleg=" + reszleg +
                ", fizetes=" + fizetes +
                ", nyelvIsmeret=" + nyelvIsmeret +
                '}';
    }
}
