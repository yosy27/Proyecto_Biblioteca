package pe.com.cibertec.Proyecto_biblioteca.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;
import pe.com.cibertec.Proyecto_biblioteca.model.entity.DisponibilidadEntity;
import pe.com.cibertec.Proyecto_biblioteca.model.entity.LibroEntity;
import pe.com.cibertec.Proyecto_biblioteca.service.DisponibilidadService;
import pe.com.cibertec.Proyecto_biblioteca.service.LibroService;

@Controller
@RequiredArgsConstructor
public class LibroController {

	private LibroService libroService;
	
	private DisponibilidadService disponibilidadService;
	
	@GetMapping("/lista_libros")
	public String listarLibro(Model model) {
		List<LibroEntity>listarLibro = libroService.listarLibros();
		model.addAttribute("listalibr", listarLibro);
		return "lista_libro";
	}
	
	@GetMapping("/registrar_libro")
	public String mostrarRegistrarLibro(Model model) {
		List<DisponibilidadEntity>listaDisponibilidad = disponibilidadService.obtenerTodasDisponibilidad();
		model.addAttribute("disponibilidad", listaDisponibilidad);
		model.addAttribute("libro", new LibroEntity());
		return "registrar_libro";
	}
	
	@PostMapping("/registrar_libro")
	public String registrarLibro(@ModelAttribute("libro")LibroEntity libroEntity,
			Model model, @RequestParam("foto")MultipartFile foto) {
		libroService.crearLibro(libroEntity, foto);
		return "redirect:/lista_libro/";
	}
}
