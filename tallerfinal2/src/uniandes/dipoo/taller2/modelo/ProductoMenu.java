package uniandes.dipoo.taller2.modelo;

import java.util.ArrayList;

public class ProductoMenu implements Producto
{
	
	private String nombre;

	private int Precio;
	
	private ArrayList<ProductoMenu> menu;
	

	public ProductoMenu(String nombre, int Precio)
	{
		this.nombre = nombre;
		this.Precio = Precio;
		this.menu = new ArrayList<ProductoMenu>();
		
	}


	public String darNombre()
	{
		return nombre;
	}


	public int darPrecio()
	{
		return Precio;
	}
	
	public String generarTextoFactura()
	{
		String textoFactura = nombre + Precio;
		
		return textoFactura;
	}

	
	
	

}
