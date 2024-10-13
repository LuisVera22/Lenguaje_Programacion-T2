package pe.com.cibertec.Lenguaje_Programacion_T2.service;

import java.util.List;

import pe.com.cibertec.Lenguaje_Programacion_T2.main.entity.EmpleadoEntity;

public interface EmpleadoService {
	List<EmpleadoEntity>listarEmpleados();
	void crearEmpleado(EmpleadoEntity empleadoEntity);
	EmpleadoEntity buscarEmpleadoPorId(String dni);
	void actualizarEmpleado(String dni, EmpleadoEntity empleadoEntity);
	void eliminarEmpleado(String dni);
}
