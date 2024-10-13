package pe.com.cibertec.Lenguaje_Programacion_T2.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import pe.com.cibertec.Lenguaje_Programacion_T2.main.entity.EmpleadoEntity;
import pe.com.cibertec.Lenguaje_Programacion_T2.repository.EmpleadoRepository;
import pe.com.cibertec.Lenguaje_Programacion_T2.service.EmpleadoService;

@Service
@RequiredArgsConstructor
public class EmpleadoServiceImpl implements EmpleadoService{
	
	private final EmpleadoRepository empleadoRepository;
	
	@Override
	public List<EmpleadoEntity> listarEmpleados() {
		// TODO Auto-generated method stub
		return empleadoRepository.findAll();
	}

	@Override
	public void crearEmpleado(EmpleadoEntity empleadoEntity) {
		empleadoRepository.save(empleadoEntity);
		// TODO Auto-generated method stub
		
	}
	
}
