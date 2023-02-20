package uniandes.dipoo.taller2.modelo;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Restaurante 
{
	
	private ArrayList<Pedido> pedidos;
	
	private Pedido pedidoEnCurso;
	
	private ArrayList<Ingrediente> ingredientes;
	
	private ArrayList<Combo> combos;
	
	private ArrayList<ProductoMenu> menuBase;
	
	public Restaurante ()
	
	{
		pedidos = new ArrayList<Pedido>();
		pedidoEnCurso = null;
		ingredientes = new ArrayList<Ingrediente>();
		combos = new ArrayList<Combo>();
		menuBase = new ArrayList<ProductoMenu>();	
		
		
		cargarInformacionRestaurante(new File("./data/ingredientes.txt"), new File ("./data/menu.txt"), new File("./data/combos.txt"));
		
	}
	
	private void cargarIngredientes(File archivoIngredientes)
	
	{
		try
		{


			BufferedReader br = new BufferedReader(new FileReader(archivoIngredientes));
			String linea = br.readLine();

			while (linea != null)
			{
				String[] partes = linea.split(";");
				String nombreIngrediente = partes[0];
				int precioAumento = Integer.parseInt(partes[1]);

				Ingrediente elIngrediente = new Ingrediente(nombreIngrediente, precioAumento);
				ingredientes.add(elIngrediente);

				linea = br.readLine();


			}
			br.close();

		}
		catch (Exception e)
		{

		}
		
	}
	
	private void cargarCombos(File archivoCombos)
	
	{
		try
		{


			BufferedReader br = new BufferedReader(new FileReader(archivoCombos));
			String linea = br.readLine();

			while (linea != null)
			{
				String[] partes = linea.split(";");
				String nombreCombo = partes[0];
				double descuento = Double.parseDouble(partes[1].replace("%",""));

				Combo elCombo = new Combo(nombreCombo, descuento);
				elCombo.agregarItemACombo(buscarProducto(partes[2]));
				elCombo.agregarItemACombo(buscarProducto(partes[3]));
				elCombo.agregarItemACombo(buscarProducto(partes[4]));
				
				combos.add(elCombo);
				

				linea = br.readLine();


			}
			br.close();

		}
		catch (Exception e)
		{

		}
		
	}
	
	public ProductoMenu buscarProducto(String nombreProducto)
	{
		ProductoMenu Buscado = null;
		
		for (int i=0; i<menuBase.size(); i++)
		{
			if (menuBase.get(i).darNombre().equals(nombreProducto))
			{
				Buscado = menuBase.get(i);
			}
				
		}
				
		return Buscado;
	}
	
	private void cargarMenu(File archivoMenu)
	
	{
		try
		{


			BufferedReader br = new BufferedReader(new FileReader(archivoMenu));
			String linea = br.readLine();

			while (linea != null)
			{
				String[] partes = linea.split(";");
				String nombreProducto = partes[0];
				int precio = Integer.parseInt(partes[1]);

				ProductoMenu elProducto = new ProductoMenu(nombreProducto, precio);
				
				
				
				menuBase.add(elProducto);

				linea = br.readLine();


			}
			br.close();

		}
		catch (Exception e)
		{

		}
		
	}

	public void cargarInformacionRestaurante(File archivoIngredientes, File archivoMenu, File archivoCombos)
	{
		cargarIngredientes(archivoIngredientes);
		cargarMenu(archivoMenu);
		cargarCombos(archivoCombos);
		
	}
	
	public Ingrediente buscarIngrediente(String nombreIngrediente)
	{
		Ingrediente elIngrediente = null;

		for (int i=0; i<ingredientes.size(); i++)
		{
			Ingrediente unIngrediente = ingredientes.get(i);
			if (unIngrediente.darIngrediente().equals(nombreIngrediente))
			{
				elIngrediente = unIngrediente;
			}
		}

		return elIngrediente;
	}

	
	public ArrayList<Ingrediente> getIngrediente()
	{
		
		return ingredientes;
	}
	
	public ArrayList<ProductoMenu> getMenuBase()
	{
		return menuBase;
	}
	
	public ArrayList<Combo> getCombos()
	{
		return combos;
	}
	
	public ArrayList<Pedido> getPedidos()
	{
		return pedidos;
	}
	
	public int generarIdPedido()
	{
			int numero = (int)(Math.random()*10000);

		return numero;
	}
	

	
	public void iniciarPedido(String nombreCliente, String direccionCliente)
	{
		int ID = generarIdPedido();
		pedidoEnCurso = new Pedido(ID, nombreCliente, direccionCliente);
		
		
	}
	
	public Pedido darPedidoEnCurso()
	{
		return pedidoEnCurso;
	}
	
	public void agregarelementoAPedido(Producto p)
	{
		pedidoEnCurso.agregarProducto(p);
	}
	
	public Combo buscarCombo(String c)
	{
		Combo Buscado = null;
		
		for (int i=0; i<combos.size(); i++)
		{
			if (combos.get(i).darNombre().equals(c))
			{
				Buscado = combos.get(i);
			}
				
		}
		
		return Buscado;
	}
		
		
	
	

}
