package uniandes.dipoo.taller2.modelo;

import java.util.ArrayList;

public class Combo implements Producto

{
	
	private String nombre;

	private double descuento;
	
	private int costoInicial;
	
	private ArrayList<Producto>itemsCombo;


	public Combo(String nombre, double descuento)
	{
		this.nombre = nombre;
		this.descuento = descuento;
		this.costoInicial = costoInicial;
		this.itemsCombo = new ArrayList<Producto>();
		
	}

	public String darNombre()
	{
		return nombre;
	}

	public int darPrecio()
	{
		return costoInicial;
	}
	
	public double darDescuento()
	
	{
		return descuento;
	}
	
	
	public void agregarItemACombo(Producto itemCombo)
	{
		itemsCombo.add(itemCombo);
	}
	
	
	public String generarTextoFactura()
	{
		String textoFactura = nombre;
		
		return textoFactura;
	}

	
}
