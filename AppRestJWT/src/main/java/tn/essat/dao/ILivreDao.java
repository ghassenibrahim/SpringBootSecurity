package tn.essat.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.essat.model.Livre;
@Repository
public interface ILivreDao extends JpaRepository<Livre, Integer>{

}
