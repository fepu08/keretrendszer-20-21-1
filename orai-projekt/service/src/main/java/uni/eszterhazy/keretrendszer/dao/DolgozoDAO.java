package uni.eszterhazy.keretrendszer.dao;


import uni.eszterhazy.keretrendszer.model.Dolgozo;
import uni.eszterhazy.keretrendszer.model.Reszleg;

import java.util.Collection;

/**
 * Az adatbázisunk funkcionalitását írja le
 * */
public interface DolgozoDAO {
    void createDolgozo(Dolgozo dolgozo);
    Collection<Dolgozo> readAllDolgozo();
    Dolgozo readDolgozo(String id);
    void updateDolgozo(Dolgozo dolgozo);
    void deleteDolgozo(Dolgozo dolgozo);
    Collection<Dolgozo> readAllDolgozoOfReszleg(Reszleg reszleg);
}
