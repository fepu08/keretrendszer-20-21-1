package uni.eszterhazy.keretrendszer.dao.relational;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import uni.eszterhazy.keretrendszer.dao.DolgozoDAO;
import uni.eszterhazy.keretrendszer.model.Dolgozo;
import uni.eszterhazy.keretrendszer.model.Reszleg;

import java.util.Collection;

public class DolgozoDAORelational implements DolgozoDAO {
    private static SessionFactory factory;

    public DolgozoDAORelational() {
        factory = new Configuration().configure().buildSessionFactory();
    }

    @Override
    public void createDolgozo(Dolgozo dolgozo) {

    }

    @Override
    public Collection<Dolgozo> readAllDolgozo() {
        return null;
    }

    @Override
    public Dolgozo readDolgozo() {
        return null;
    }

    @Override
    public void updateDolgozo(Dolgozo dolgozo) {

    }

    @Override
    public void deleteDolgozo(Dolgozo dolgozo) {

    }

    @Override
    public Collection<Dolgozo> readAllDolgozoOfReszleg(Reszleg reszleg) {
        return null;
    }
}
