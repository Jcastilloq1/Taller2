package uniandes.dipoo.taller2.modelo;

import java.util.ArrayList;

public class Ingrediente 
{
	
	private String nombre;

	private int costoAdicional;
	
	private ArrayList<Ingrediente>ingredientes;

	public Ingrediente(String nombre, int costoAdicional)
	{
		this.nombre = nombre;
		this.costoAdicional = costoAdicional;
		this.ingredientes = new ArrayList<Ingrediente>();
		
	}

	public String darIngrediente()
	{
		return nombre;
	}


	public int darCostoAdicional()
	{
		return costoAdicional;
	}
	
}
