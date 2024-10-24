package pe.com.cibertec.Proyecto_biblioteca.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import pe.com.cibertec.Proyecto_biblioteca.model.entity.CategoriaEntity;
import pe.com.cibertec.Proyecto_biblioteca.model.entity.LibroEntity;
import pe.com.cibertec.Proyecto_biblioteca.model.entity.UsuarioEntity;
import pe.com.cibertec.Proyecto_biblioteca.service.CategoriaService;
import pe.com.cibertec.Proyecto_biblioteca.service.LibroService;
import pe.com.cibertec.Proyecto_biblioteca.service.UsuarioService;

@Controller
@RequiredArgsConstructor
public class LibroController {

	private final LibroService libroService;
	
	private final CategoriaService categoriaService;
	
	private final UsuarioService usuarioService;
	
	@GetMapping("/lista_libros")
	public String listarLibro(Model model, HttpSession session) {
		if(session.getAttribute("usuario") == null) {
			return "redirect:/";
		}
		
		String correoSesion = session.getAttribute("usuario").toString();
		UsuarioEntity usuarioEncontrado = usuarioService.buscarUsuarioPorCorreo(
				correoSesion);
		
		List<LibroEntity>listarLibro = libroService.listarLibros();
        model.addAttribute("categorias", categoriaService.obtenerTodasCategorias());
		model.addAttribute("listalibr", listarLibro);
		return "lista_libro";
	}
	
	@GetMapping("/registrar_libro")
	public String mostrarRegistrarLibro(Model model, HttpSession session) {
		if(session.getAttribute("usuario") == null) {
			return "redirect:/";
		}
		List<CategoriaEntity>listaCategoria = categoriaService.obtenerTodasCategorias();
		model.addAttribute("categorias",listaCategoria);
		model.addAttribute("libro", new LibroEntity());
		return "registrar_libro";
	}
	
	@PostMapping("/registrar_libro")
	public String registrarLibro(@ModelAttribute("libro")LibroEntity libroEntity,
			 @RequestParam("foto") MultipartFile foto,
			Model model) {
		libroService.crearLibro(libroEntity, foto);
		return "registrar_libro";
	}
}
