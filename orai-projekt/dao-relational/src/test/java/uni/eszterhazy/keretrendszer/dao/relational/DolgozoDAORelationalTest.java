package uni.eszterhazy.keretrendszer.dao.relational;

import org.junit.Test;
import uni.eszterhazy.keretrendszer.dao.DolgozoDAO;
import uni.eszterhazy.keretrendszer.exceptions.FizetesNegativ;
import uni.eszterhazy.keretrendszer.exceptions.NevNemLehetUres;
import uni.eszterhazy.keretrendszer.exceptions.RosszSzuletesiDatum;
import uni.eszterhazy.keretrendszer.model.Dolgozo;
import uni.eszterhazy.keretrendszer.model.NyelvIsmeret;
import uni.eszterhazy.keretrendszer.model.Reszleg;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DolgozoDAORelationalTest {
    @Test
    public void test() throws NevNemLehetUres, FizetesNegativ, RosszSzuletesiDatum {
        DolgozoDAO dao = new DolgozoDAORelational();
        Dolgozo dolgozo = new Dolgozo();
        dolgozo.setNev("Nagy Nándor");
        dolgozo.setFizetes(200000);
        dolgozo.setReszleg(Reszleg.BERUGY);
        dolgozo.setSzuletesiDatum(LocalDate.of(1995,3,22));

        NyelvIsmeret ny1 = new NyelvIsmeret("Angol", "C1");
        //NyelvIsmeret ny2 = new NyelvIsmeret("Német", "A1");
        List nyelvek = new ArrayList<>();
        nyelvek.add(ny1);
        //nyelvek.add(ny2);
        dolgozo.setNyelvIsmeret(nyelvek);
        dao.createDolgozo(dolgozo);
        //System.out.println(dao.readAllDolgozoOfReszleg(Reszleg.BERUGY));
        //System.out.println(dao.readDolgozo("746b6d10-370b-4b89-ab66-17f175c215e2"));
    }

}