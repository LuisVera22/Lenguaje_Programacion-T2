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

	@Override
	public EmpleadoEntity buscarEmpleadoPorId(String dni) {
		// TODO Auto-generated method stub
		return empleadoRepository.findById(dni).get();
	}

	@Override
	public void actualizarEmpleado(String dni, EmpleadoEntity empleadoActualizado) {
		// TODO Auto-generated method stub
		EmpleadoEntity empleadoEncontrado = buscarEmpleadoPorId(dni);
		if(empleadoEncontrado == null) {
			throw new RuntimeException("Empleado no encontrado");
		}
		try {
			empleadoEncontrado.setDni_empleado(empleadoActualizado.getDni_empleado());
			empleadoEncontrado.setNombre_empleado(empleadoActualizado.getNombre_empleado());
			empleadoEncontrado.setApellido_empleado(empleadoActualizado.getApellido_empleado());
			empleadoEncontrado.setFecha_nacimiento(empleadoActualizado.getFecha_nacimiento());
			empleadoEncontrado.setDireccion(empleadoActualizado.getDireccion());
			empleadoEncontrado.setCorreo(empleadoActualizado.getCorreo());
			empleadoEncontrado.setArea(empleadoActualizado.getArea());
			empleadoRepository.save(empleadoEncontrado);
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException("Error al actualizar");
		}
	}

	@Override
	public void eliminarEmpleado(String dni) {
		// TODO Auto-generated method stub
		EmpleadoEntity empleadoEncontrado = buscarEmpleadoPorId(dni);
		if(empleadoEncontrado == null) {
			throw new RuntimeException("Empleado no encontrado");
		}
		empleadoRepository.delete(empleadoEncontrado);
	}
	
}
