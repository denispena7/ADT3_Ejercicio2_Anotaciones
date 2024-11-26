package es.studium.hibernateEj2;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="movies")
public class Pelicula
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idPelicula")
	private int idPelicula;
	@Column(name="tituloPelicula")
	private String titulo;
	@Column(name="anioPelicula")
	private int anio;
	@Column(name="duracionPelicula")
	private int duracion;
//  @ManyToMany
	@ManyToOne
	@JoinColumn(name="directorPelicula")
	private Persona director;
	
	public Pelicula()
	{
		idPelicula = 0;
		titulo = "";
		anio = 0;
		duracion = 0;
		director = new Persona();
	}

	public Pelicula(int idPelicula, String titulo, int anio, int duracion, Persona director)
	{
		this.idPelicula = idPelicula;
		this.titulo = titulo;
		this.anio = anio;
		this.duracion = duracion;
		this.director = director;
	}
	
	public Pelicula(String titulo, int anio, int duracion, Persona director)
	{
		this.titulo = titulo;
		this.anio = anio;
		this.duracion = duracion;
		this.director = director;
	}

	public Pelicula(int i)
	{
		this.idPelicula = i;
	}

	public int getIdPelicula()
	{
		return idPelicula;
	}

	public void setIdPelicula(int idPelicula)
	{
		this.idPelicula = idPelicula;
	}

	public String getTitulo()
	{
		return titulo;
	}

	public void setTitulo(String titulo)
	{
		this.titulo = titulo;
	}

	public int getAnio()
	{
		return anio;
	}

	public void setAnio(int anio)
	{
		this.anio = anio;
	}

	public int getDuracion()
	{
		return duracion;
	}

	public void setDuracion(int duracion)
	{
		this.duracion = duracion;
	}

/*	public Persona getDirector()
	{
		return director;
	}

	public void setDirector(Persona director)
	{
		this.director = director;
	}*/
}
