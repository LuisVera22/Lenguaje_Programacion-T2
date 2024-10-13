package pe.com.cibertec.Lenguaje_Programacion_T2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.com.cibertec.Lenguaje_Programacion_T2.main.entity.AreaEntity;

@Repository
public interface AreaRepository extends JpaRepository<AreaEntity, Integer>{

}
