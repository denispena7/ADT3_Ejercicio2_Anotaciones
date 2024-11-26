package es.studium.hibernateEj2;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="personas")
public class Persona
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idPersona")
	private int idPersona;
	@Column(name="nombrePersona")
	private String nombre;
	
	public Persona()
	{
		idPersona = 0;
		nombre = "";
	}

	public Persona(int idPersona, String nombre)
	{
		this.idPersona = idPersona;
		this.nombre = nombre;
	}

	public Persona(String nombre)
	{
		this.nombre = nombre;
	}
	
	public Persona(int i)
	{
		this.idPersona = i;
	}

	public int getIdPersona()
	{
		return idPersona;
	}

	public void setIdPersona(int idPersona)
	{
		this.idPersona = idPersona;
	}

	public String getNombre()
	{
		return nombre;
	}

	public void setNombre(String nombre)
	{
		this.nombre = nombre;
	}
}