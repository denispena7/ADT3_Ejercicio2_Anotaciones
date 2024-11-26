package es.studium.hibernateEj2;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class FactoryCrud
{
	private static Session getSession()
	{
		SessionFactory sessionFactory = new
				Configuration().addAnnotatedClass(Persona.class).addAnnotatedClass(Pelicula.class).configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		return session;
	}
	
	public static void crear(Persona persona)
	{
		Session sessionObj = getSession();
		Transaction tx = sessionObj.beginTransaction();
		sessionObj.persist(persona);
		tx.commit();
		sessionObj.close();
		System.out.println(
				"Persona con ID: " + persona.getIdPersona() + " y nombre: " + persona.getNombre()
				+ " se ha insertado correctamente en la tabla personas de la base de datos ad.");
	}
	
	public static void crear(Pelicula pelicula)
	{
		Session sessionObj = getSession();
		Transaction tx = sessionObj.beginTransaction();
		sessionObj.persist(pelicula);
		tx.commit();
		sessionObj.close();
		System.out.println(
				"Pelicula con ID: " + pelicula.getIdPelicula() + " - titulo: " + pelicula.getTitulo()
				+ " - año: " + pelicula.getAnio() + " - y duración: " + pelicula.getDuracion()
				+ " se ha insertado correctamente en la tabla movies de la base de datos ad.");
	}
	
	public static List<Pelicula> leerPelicula()
	{
		/* Podemos expresar así la consulta o también indicando
		directamente el nombre de la clase POJO: "FROM Usuario";*/
		String consulta = "FROM " + Pelicula.class.getName();
		Session sessionObj = getSession();
		List<Pelicula> listaResultado = sessionObj.createQuery(consulta, Pelicula.class).list();
		for(Pelicula p : listaResultado) 
		{
			System.out.println(p.getIdPelicula() + " - " +
					p.getTitulo() + " - " + p.getAnio() + " - " + p.getDuracion());
		}
		sessionObj.close();
		return listaResultado;
	}

	public static List<Persona> leerPersona()
	{
		/* Podemos expresar así la consulta o también indicando
		directamente el nombre de la clase POJO: "FROM Usuario";*/
		String consulta = "FROM " + Persona.class.getName();
		Session sessionObj = getSession();
		List<Persona> listaResultado = sessionObj.createQuery(consulta, Persona.class).list();
		for(Persona p : listaResultado) 
		{
			System.out.println(p.getIdPersona() + " - " +
					p.getNombre());
		}
		sessionObj.close();
		return listaResultado;
	}
	
	public static void actualizarPersona(Persona p) 
	{
		Session sessionObj = getSession();
		Transaction transObj = sessionObj.beginTransaction();
		/* Actualizamos el objeto */
		sessionObj.merge(p);
		transObj.commit();
		sessionObj.close();
		System.out.println("Actualizado correctamente la persona de id: " + p.getIdPersona());
	}
	
	public static void actualizarPelicula(Pelicula p) 
	{
		Session sessionObj = getSession();
		Transaction transObj = sessionObj.beginTransaction();
		/* Actualizamos el objeto */
		sessionObj.merge(p);
		transObj.commit();
		sessionObj.close();
		System.out.println("Actualizado correctamente la persona de id: " + p.getIdPelicula());
	}

	public static void eliminarPersona(Persona p) 
	{
		Session sessionObj = getSession();
		Transaction transObj = sessionObj.beginTransaction();
		sessionObj.remove(p);
		transObj.commit();
		sessionObj.close();
		System.out.println("Eliminado correctamente la persona de id:" + p.getIdPersona());
	}
	
	public static void eliminarPelicula(Pelicula p) 
	{
		Session sessionObj = getSession();
		Transaction transObj = sessionObj.beginTransaction();
		sessionObj.remove(p);
		transObj.commit();
		sessionObj.close();
		System.out.println("Eliminado correctamente la persona de id:" + p.getIdPelicula());
	}
}