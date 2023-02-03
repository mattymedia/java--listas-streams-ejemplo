/*
- Datos estructurados en [listas, arrays, colecciones, ect...]

Los datos estructurados son datos organizados en una estructura de datos como una matriz, 
una tabla de base de datos, un árbol, etc. Esta estructura de datos permite almacenar 
información de forma organizada y fácil de acceder. Esto permite a los programadores realizar 
operaciones sobre los datos de forma más eficiente. 

- Listas en java

Una lista en Java es una de las colecciones de Java que permite almacenar una secuencia 
ordenada de elementos. Las listas son similares a los arrays en Java, con la diferencia 
de que permiten almacenar elementos de diferentes tipos. También se pueden agregar y eliminar 
elementos de una lista.

- Streams en java

Stream es una característica de Java 8 que proporciona una nueva manera de trabajar con 
datos estructurados. Esta nueva API le permite realizar operaciones de alto nivel como 
filtrado, transformación y agrupación sobre una colección de datos. Esto le permite tener 
un código más conciso y eficiente.
*/

package co.com.liststreams;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import co.com.liststreams.entity.Estudiante;
import co.com.liststreams.repository.IEstudianteRepository;

@SpringBootApplication
public class ListstreamsApplication {

	private static IEstudianteRepository repository;

	ListstreamsApplication(IEstudianteRepository repository) {
		ListstreamsApplication.repository = repository;
	}

	public static void main(String[] args) {
		SpringApplication.run(ListstreamsApplication.class, args);
		
		//Listas
		List<Estudiante> estudiantes = new ArrayList<>();
		estudiantes.addAll(repository.findAll());
		estudiantes.add(new Estudiante("Jhon", "Marroco", "jhon@email.com", 3157822289L, LocalDate.of(1991, 9, 11)));

		for (Estudiante estudiante : estudiantes) {
			System.out.println("Nombre: " + estudiante.getApellido().concat(" " + estudiante.getNombre()));
		}
		
		//stream, filtrar objeto por apellido y mostrar sus datos.
		List<Estudiante> estudiante = estudiantes.stream().filter(filtro -> filtro.getApellido().contains("Jimenez"))
				.collect(Collectors.toList());

		System.out.println("filtro por apellido: " + estudiante.get(0).getEstudiante());
		
		//stream con map para transformacion de datos (lista a string)
		List<String> apellido = estudiantes.stream().filter(filtro -> filtro.getApellido().contains("Jimenez")).map(mayuscula -> mayuscula.getApellido().toUpperCase())
				.collect(Collectors.toList());

		System.out.println("filtro por apellido: " + apellido.toString());
	}

}
