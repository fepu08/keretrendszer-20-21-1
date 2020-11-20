package uni.eszterhazy.keretrendszer.service;

import uni.eszterhazy.keretrendszer.model.Dolgozo;
import uni.eszterhazy.keretrendszer.model.Reszleg;

import java.util.Collection;
import java.util.Map;

public interface DolgozoService {
    void addDolgozo(Dolgozo dolgozo);
    Collection<Dolgozo> readAllDolgozo();
    Dolgozo readDolgozoById(String id);
    void updateDolgozo(Dolgozo dolgozo);
    void removeDolgozo(Dolgozo dolgozo);
    Collection<Dolgozo> readAllDolgozoOfReszleg(Reszleg reszleg);
    double atlagFizetes();
    Map<Reszleg, Double> atlagFizetesReszlegenkent();
}
