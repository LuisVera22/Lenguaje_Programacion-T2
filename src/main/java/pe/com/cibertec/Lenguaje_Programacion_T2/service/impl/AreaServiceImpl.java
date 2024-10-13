package pe.com.cibertec.Lenguaje_Programacion_T2.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.cibertec.Lenguaje_Programacion_T2.main.entity.AreaEntity;
import pe.com.cibertec.Lenguaje_Programacion_T2.repository.AreaRepository;
import pe.com.cibertec.Lenguaje_Programacion_T2.service.AreaService;

@Service
public class AreaServiceImpl implements AreaService{

	@Autowired
	private AreaRepository areaRepository;
	
	@Override
	public List<AreaEntity> obtenerAreas() {
		// TODO Auto-generated method stub
		return areaRepository.findAll();
	}
	
}
