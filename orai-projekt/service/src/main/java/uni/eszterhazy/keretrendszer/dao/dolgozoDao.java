package uni.eszterhazy.keretrendszer.dao;


import keretrendszer.model.Dolgozo;
import keretrendszer.model.Reszleg;

import java.util.Collection;

/**
 * Az adatbázisunk funkcionalitását írja le
 * */
public interface dolgozoDao {
    void createDolgozo(Dolgozo dolgozo);
    Collection<Dolgozo> readAllDolgozo();
    Dolgozo readDolgozo();
    void updateDolgozo(Dolgozo dolgozo);
    void deleteDolgozo(Dolgozo dolgozo);
    Collection<Dolgozo> readAllDolgozoOfReszleg(Reszleg reszleg);
}
