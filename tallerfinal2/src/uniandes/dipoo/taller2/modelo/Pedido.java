package uniandes.dipoo.taller2.modelo;

import java.io.File;
import java.util.ArrayList;

public class Pedido {
	
	private static int numeroPedidos;
	
	private int idPedido;

	private String nombreCliente;
	
	private String direccionCliente;
	
	private ArrayList<Producto> itemsPedido;
	

	public Pedido(int idPedido, String nombreCliente, String direccionCliente)
	{
		this.idPedido = idPedido;
		this.nombreCliente = nombreCliente;
		this.direccionCliente = direccionCliente;
		numeroPedidos +=1;
		this.itemsPedido = new ArrayList<Producto>();
		
	}
	
	

	public int darIdPedido()
	{
		return idPedido;
	}
	
	public void agregarProducto(Producto nuevoItem)
	{
		itemsPedido.add(nuevoItem);
		
	}
	
	private int getPrecioNetoPedido()
	{
		return idPedido;
		
	}
	
	private int getPrecioTotalPedido()
	{
		return idPedido;
		
	}
	
	private int getPrecioIVAPedido()
	{
		return idPedido;
		
	}
	
	private String generarTextoFactura()
	{
		return null;
		
	}
	
	public void guardarFactura(File Archivo)
	{
		
	}
	
	


}
