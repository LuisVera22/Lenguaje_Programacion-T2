package pe.com.cibertec.Lenguaje_Programacion_T2.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	
	@GetMapping("/registrar_empleado")
	public String mostrarRegistrarEmpleado(Model model) {
		List<AreaEntity> listaAreas = areaService.obtenerAreas();
		model.addAttribute("areas", listaAreas);
		model.addAttribute("empleado",new EmpleadoEntity());
		return "registrar_empleado";
	}
	
	@PostMapping("/registrar_empleado")
	public String registrarEmpleado(@ModelAttribute("empleado")EmpleadoEntity empleadoEntity,
			 Model model) {
		empleadoService.crearEmpleado(empleadoEntity);
		return "redirect:/empleados";
	}
	
}
