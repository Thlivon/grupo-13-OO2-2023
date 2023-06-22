package com.unla.grupo13OO22023.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.unla.grupo13OO22023.entities.EspacioVerde;

@Repository("espacioVerdeRepository")
public interface IEspacioVerdeRepository extends JpaRepository<EspacioVerde, Serializable> {
	public EspacioVerde findByIdEspacioVerde(int idEspacioVerde);
	public EspacioVerde findByLugar(String lugar);

	@Query("SELECT e FROM EspacioVerde e")
	public List<EspacioVerde> getAllEspaciosVerdes();
}
