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
import pe.com.cibertec.Proyecto_biblioteca.utils.Utilitarios;

@Controller
@RequiredArgsConstructor
public class LibroController {

	private final LibroService libroService;
	
	private final CategoriaService categoriaService;
	
	private final UsuarioService usuarioService;
	
	@GetMapping("/lista_libros")
	public String listarLibro(Model model, HttpSession session) {
	    if (session.getAttribute("usuario") == null) {
	        System.out.println("No hay usuario en la sesión. Redirigiendo a la página de inicio.");
	        return "redirect:/";
	    }

	    String correoSesion = session.getAttribute("usuario").toString();
	    System.out.println("Usuario encontrado: " + correoSesion);

	    UsuarioEntity usuarioEncontrado = usuarioService.buscarUsuarioPorCorreo(correoSesion);

	    if (session.getAttribute("libro") == null) {
	        System.out.println("No hay libro en la sesión. Redirigiendo a la página de inicio.");
	        return "redirect:/registrar_libro"; // O redirige a una página de error o información
	    }

	    String libroSesion = session.getAttribute("libro").toString();
	    Integer libroId = Integer.parseInt(libroSesion);
	    LibroEntity libroEncontrado = libroService.buscarLibroPorId(libroId); 

	    model.addAttribute("foto", libroEncontrado.getUrLImagenLibro());

	    List<LibroEntity> listarLibro = libroService.listarLibros();
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
	public String registrarLibro(@ModelAttribute("libro") LibroEntity libroEntity,
	                             @RequestParam("foto") MultipartFile foto,
	                             Model model,
	                             HttpSession session) {
	    // Guardar la imagen y obtener el nombre del archivo
	    String nombreArchivo = Utilitarios.guardarImagen(foto);
	    
	    // Asignar la URL de la imagen al libro (asumiendo que la carpeta se llama "foto_libro")
	    if (nombreArchivo != null) {
	        libroEntity.setUrLImagenLibro("/foto_libro/" + nombreArchivo); // Asegúrate de que esta ruta sea correcta
	    } else {
	        model.addAttribute("mensaje", "Error al guardar la imagen.");
	        return "registrar_libro"; // O redirige a donde sea apropiado
	    }

	    // Crea el libro utilizando el servicio
	    libroService.crearLibro(libroEntity, foto);
	    
	    // Agrega el ID del libro a la sesión
	    session.setAttribute("libro", libroEntity.getIdLibro());
	    
	    model.addAttribute("mensaje", "Libro registrado exitosamente.");
	    
	    // Redirige a la página de listado de libros
	    return "redirect:/lista_libros";
	}



}
