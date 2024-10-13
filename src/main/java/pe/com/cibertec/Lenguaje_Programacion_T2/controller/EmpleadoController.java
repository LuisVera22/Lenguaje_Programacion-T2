package pe.com.cibertec.Lenguaje_Programacion_T2.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.ui.Model;

import lombok.RequiredArgsConstructor;
import pe.com.cibertec.Lenguaje_Programacion_T2.main.entity.AreaEntity;
import pe.com.cibertec.Lenguaje_Programacion_T2.main.entity.EmpleadoEntity;
import pe.com.cibertec.Lenguaje_Programacion_T2.service.AreaService;
import pe.com.cibertec.Lenguaje_Programacion_T2.service.EmpleadoService;

@Controller
@RequiredArgsConstructor
public class EmpleadoController {
	
	private final AreaService areaService;
	private final EmpleadoService empleadoService;
	
	
	@GetMapping("/lista_empleados")
	public String listarEmpleados(Model model) {
		List<EmpleadoEntity> listaEmpleados = empleadoService.listarEmpleados();
		model.addAttribute("listaEmpleados", listaEmpleados);
		return "lista_empleados";
	}
	
	@GetMapping("/empleados/registrar_empleado")
	public String mostrarRegistrarEmpleado(Model model) {
		List<AreaEntity> listaAreas = areaService.obtenerAreas();
		model.addAttribute("areas", listaAreas);
		model.addAttribute("empleado",new EmpleadoEntity());
		return "registrar_empleado";
	}
	
	@PostMapping("/empleados/registrar_empleado")
	public String registrarEmpleado(@ModelAttribute("empleado")EmpleadoEntity empleadoEntity) {
		empleadoService.crearEmpleado(empleadoEntity);
		return "redirect:/lista_empleados";
	}
	
	
	@GetMapping("/empleados/editar_empleado/{dni}")
	public String mostrarEditarEmpleado(@PathVariable("dni")String dni,Model model) {
		EmpleadoEntity empleado = empleadoService.buscarEmpleadoPorId(dni);
		List<AreaEntity> listaAreas = areaService.obtenerAreas();
		model.addAttribute("empleado",empleado);
		model.addAttribute("areas", listaAreas);
		return "editar_empleado";
	}
	
	@PostMapping("/empleados/editar_empleado/{dni}")
	public String editarEmpleado(@PathVariable("dni")String dni,@ModelAttribute("empleado") EmpleadoEntity empleado, Model model) {
		try {
	        empleadoService.actualizarEmpleado(dni, empleado);
	        model.addAttribute("successMessage", "Empleado actualizado con éxito.");
	    } catch (Exception e) {
	        model.addAttribute("errorMessage", "Error al actualizar el empleado.");
	    }
	    return "redirect:/lista_empleados";
	}
	
	@GetMapping("/empleados/info_empleado/{dni}")
	public String infoEmpleado(@PathVariable("dni")String dni,Model model) {
		EmpleadoEntity empleado = empleadoService.buscarEmpleadoPorId(dni);
		List<AreaEntity> listaAreas = areaService.obtenerAreas();
		model.addAttribute("empleado",empleado);
		model.addAttribute("areas", listaAreas);
		return "info_empleado";
	}
	
	@GetMapping("/eliminar/{dni}")
	public String eliminarEmpleado(Model model,@PathVariable("dni") String dni) {
		empleadoService.eliminarEmpleado(dni);
		return "redirect:/lista_empleados";
	}
}
