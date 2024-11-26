package es.studium.hibernateEj2;

public class Principal
{
	public static void main(String[] args)
	{
		Persona p1 = new Persona("Denis");
		Persona p2 = new Persona(2, "Asrael");
		
	//	FactoryCrud.crear(p1);
	//	FactoryCrud.crear(p2);
		
		Persona p4 = new Persona(1);
		Pelicula m1 = new Pelicula(1, "John Wick Parabellum", 2017, 2, p4);
	//	Pelicula m2 = new Pelicula(1, "John Wick Parabellum", 2017, 2, p4);
		
	//	FactoryCrud.crear(m1);
	//	FactoryCrud.crear(m2);
		
		System.out.println("Personas actuales");
		FactoryCrud.leerPersona();
		
		System.out.println();
		
		System.out.println("Peliculas actuales");
		FactoryCrud.leerPelicula();
		
	//	FactoryCrud.actualizarPersona(p2);
		FactoryCrud.actualizarPelicula(m1);
		
	//	Persona p3 = new Persona(2);
	//	Pelicula m3 = new Pelicula(2);
		
	//	FactoryCrud.eliminarPersona(p2);
	//	FactoryCrud.eliminarPelicula(m2);
		
		System.out.println("Personas después de la actualización");
		FactoryCrud.leerPersona();
		
		System.out.println();
		
		System.out.println("Peliculas después de la actualización");
		FactoryCrud.leerPelicula();
	
	}
}