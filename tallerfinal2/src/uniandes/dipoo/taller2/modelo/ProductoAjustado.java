package uniandes.dipoo.taller2.modelo;

import java.util.ArrayList;

public class ProductoAjustado implements Producto
{


	private ProductoMenu base;
	
	private ArrayList<Ingrediente> agregados;
	
	private ArrayList<Ingrediente> eliminados;
	
	
	public ProductoAjustado(ProductoMenu base)
	{
		this.base = base;
		agregados = new ArrayList<Ingrediente>();
		eliminados = new ArrayList<Ingrediente>();
		
		
	}
	
	@Override
	public String darNombre() 
	{
		
		return base.darNombre();
	}

	@Override
	public int darPrecio() 
	{
		int precioBase = base.darPrecio();
		for (int i=0; i<agregados.size();i++)
		{
			Ingrediente actual=agregados.get(i);
			precioBase+=actual.darCostoAdicional();
		}
		
		return precioBase;
	}

	@Override
	public String generarTextoFactura() 
	{
		String texto = base.darNombre()+ ": "+base.darPrecio();
		for (int i = 0; i<agregados.size(); i++)
		{
			Ingrediente actual=agregados.get(i);
			texto+="\n"+ actual.darIngrediente()+": "+actual.darCostoAdicional();
			
		}
		
		return texto;
				
	}
	
	public void agregarAdicion(Ingrediente i)
	{
		agregados.add(i);
	}
	
	public void agregarEliminacion(Ingrediente i)
	{
		eliminados.add(i);
	}
	
	public ArrayList<Ingrediente> darAgregados()
	{
		return agregados;

	}
	
	public ArrayList<Ingrediente> darEliminados()
	{
		return eliminados;

	}
	

}
