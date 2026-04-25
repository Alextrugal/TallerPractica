# Taller Práctico

## Autores
- Jeison Alexander Anchico
- Miguel Angel Londoño

## Descripción
Este proyecto es un taller práctico desarrollado en Java. La estructura del proyecto sigue un diseño modular con paquetes que representan diferentes capas de la aplicación, como controlador, modelo, vista, servicio y dao.

## Estructura del Proyecto
```
config.properties
pom.xml
src/
	main/
		java/
			com/
				taller/
					Main.java
					config/
						ConexionMySQLDatabase.java
					controlador/
						ControladorDocente.java
						ControladorGrupo.java
						ControladorInscripcionCurso.java
						ControladorMateria.java
					dao/
						DocenteDao.java
						GrupoDao.java
						InscripcionCursoDao.java
						MateriaDao.java
					modelo/
						Docente.java
						Grupo.java
						InscripcionCurso.java
						Materia.java
					servicio/
						DocenteService.java
						GrupoService.java
						InscripcionCursoService.java
						MateriaService.java
					vista/
						VistaDocente.java
						VistaGrupo.java
						VistaInscripcionCurso.java
						VistaMateria.java
		resources/
	test/
		java/
target/
		classes/
			com/
				taller/
					config/
					controlador/
					dao/
					modelo/
					servicio/
					vista/
		generated-sources/
			annotations/
		maven-status/
			maven-compiler-plugin/
				compile/
					default-compile/
						createdFiles.lst
						inputFiles.lst
		test-classes/
```

## Requisitos
- Java Development Kit (JDK) 8 o superior
- Maven

## Ejecución
1. Clonar el repositorio.
2. Configurar la base de datos en el archivo `config.properties`.
3. Ejecutar el comando `mvn clean install` para compilar el proyecto.
4. Ejecutar la clase principal `Main.java`.

## Licencia
Este proyecto está bajo la licencia MIT.