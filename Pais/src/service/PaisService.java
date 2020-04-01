package service;


import model.Pais;
import dao.PaisDAO;


public class PaisService {
    PaisDAO dao = new PaisDAO();

    public int incluirPais(Pais pais) {
        return dao.incluirPais(pais);
    }

    public void upDatePais(Pais pais){
        dao.upDatePais(pais);
    }

    public void deletarPais(int id){
        dao.deletarPais(id);
    }

    public Pais carregarPais(int id){
        return dao.carregarPais(id);
    }

}