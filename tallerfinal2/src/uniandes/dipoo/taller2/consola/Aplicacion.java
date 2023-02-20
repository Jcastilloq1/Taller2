package uniandes.dipoo.taller2.consola;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import uniandes.dipoo.taller2.modelo.Combo;
import uniandes.dipoo.taller2.modelo.Ingrediente;
import uniandes.dipoo.taller2.modelo.Pedido;
import uniandes.dipoo.taller2.modelo.ProductoAjustado;
import uniandes.dipoo.taller2.modelo.ProductoMenu;
import uniandes.dipoo.taller2.modelo.Restaurante;

public class Aplicacion {

	
	private static Restaurante restaurante;
	
	public static void main(String[] args) 
	{
		restaurante = new Restaurante();
		System.out.println("combosÑ"+restaurante.getCombos().size());
		System.out.println("Bienvenido a Restaurante\n");

		boolean continuar = true;
		while (continuar)
		{
			try
			{
				mostrarMenu();
				int opcion_seleccionada = Integer.parseInt(input("Por favor seleccione una opción"));
				if (opcion_seleccionada == 1)
					ejecutarOpcion1();
				else if (opcion_seleccionada == 2)
					ejecutarOpcion2();
				else if (opcion_seleccionada == 3)
					ejecutarOpcion3();
				else if (opcion_seleccionada == 4)
					ejecutarOpcion4();
				else if (opcion_seleccionada == 5)
				{
					System.out.println("Saliendo de la aplicación ...");
					continuar = false;
				}
				else
				{
					System.out.println("Por favor seleccione una opción válida.");
				}
			}
			catch (NumberFormatException e)
			{
				System.out.println("Debe seleccionar uno de los números de las opciones.");
			}
		}
		

	}
	
	public static void mostrarMenu()
	{
			
		System.out.println("\nOpciones de la aplicación\n");
		System.out.println("1. Iniciar un nuevo pedido");
		System.out.println("2. Agregar un elemento a un pedido");
		System.out.println("3. Cerrar un pedido y guardar la factura");
		System.out.println("4. Consultar la información de un pedido dado su id");
		System.out.println("5. Cerrar aplicación");
	}
	
	
	public static String input(String mensaje)
	{
		try
		{
			System.out.print(mensaje + ": ");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			return reader.readLine();
		}
		catch (IOException e)
		{
			System.out.println("Error leyendo de la consola");
			e.printStackTrace();
		}
		return null;
	}
	
	public static void ejecutarOpcion1()
	{
		System.out.println("\n" + "Realice su pedido" + "\n");
		System.out.println("\n" + "Digite los siguientes datos" + "\n");
		
		String nombreCliente = input("Digite su nombre: ");
		String direccionCliente = input("Digite la dirección de envío: ");
		
		restaurante.iniciarPedido(nombreCliente, direccionCliente);
		int ID = restaurante.darPedidoEnCurso().darIdPedido();
		
		System.out.println("Su pedido se ha generado con el siguiente Id: "+ ID);
		
		
	}
	
	public static void ejecutarOpcion2()
	{
		
		System.out.println("Si desea agregar un combo escriba Combo, si desea agregar únicamente un pedido escriba Producto: ");
		String ComboOPedido = input("Combo o Producto: ");
		
		if (ComboOPedido.equals("Combo"))
		{
			System.out.println("Los Combos son: ");
			
			ArrayList<Combo> listaCombo = restaurante.getCombos();
			for (int i=0; i<listaCombo.size(); i++)
			{
				Combo actual = listaCombo.get(i);
				System.out.println(actual.darNombre());
			
			}
			
			String ComboElegido = input("Ingrese el combo deseado: ");
			Combo elegido = restaurante.buscarCombo(ComboElegido);
			
			restaurante.agregarelementoAPedido(elegido);
		}
		
		else if (ComboOPedido.equals("Producto"))
			
		{
			System.out.println("Nuestro Menú es: ");
			
			ArrayList<ProductoMenu> listaMenu = restaurante.getMenuBase();
			for (int i=0; i<listaMenu.size(); i++)
				{
					ProductoMenu actual = listaMenu.get(i);
					System.out.println(actual.darNombre()+" cuesta "+actual.darPrecio());
				}
			
			String ProductoElegido = input("Ingrese el producto elegido: ");
			ProductoMenu elegido = restaurante.buscarProducto(ProductoElegido);
			ProductoAjustado ajuste = new ProductoAjustado(elegido);
			
			int decicion=1;
			while (decicion!=3)
			{
				String eleccionProducto = input("Si desea agregar una adición a su producto escriba 1, "
						+ "si desea eliminar un ingrediente escriba 2, si desea dejarlo como se encuentra 3: ");
				
				decicion =Integer.parseInt(eleccionProducto);
				
				if (decicion == 1)
				{
					System.out.println("Estas son nuestras adiciones: ");
					
					ArrayList<Ingrediente> listaIngrediente = restaurante.getIngrediente();
					for (int i=0; i<listaIngrediente.size(); i++)
					{
						Ingrediente actual = listaIngrediente.get(i);
						System.out.println(actual.darIngrediente()+ actual.darCostoAdicional());
					
					}
					
					String IngredienteElegido = input("Ingrese el ingrediente deseado: ");
					Ingrediente ingelegido = restaurante.buscarIngrediente(IngredienteElegido);
					
	
					
					ajuste.agregarAdicion(ingelegido);;
				}
				
				else if (decicion == 2)
				{

					
					String IngredienteElegido = input("Ingrese el ingrediente que quiere retirar: ");
					Ingrediente ingelegido = restaurante.buscarIngrediente(IngredienteElegido);
					
					ajuste.agregarEliminacion(ingelegido);;
				}

			}
			if(ajuste.darAgregados().size()== 0 && ajuste.darEliminados().size()==0)
			{
				restaurante.agregarelementoAPedido(elegido);
			}
			
			else
			{
				restaurante.agregarelementoAPedido(ajuste);
			}
						
			
		}
		
		
		
	}
	
	public static void ejecutarOpcion3()
	{
		
		
		File file = new File(“/path/to/file.txt”);
		if(file.createNewFile())
		   System.out.println("File created: " + file.getName());
		else
		   System.out.println("File already exists.");
		BufferedWriter writer = new BufferedWriter(new FileWriter(“/path/to/file.txt”));
		writer.write(message);
		writer.close();
		//generar la factura implementando generar factura de cada productomenu, producto ajustado y combo y pedido. y guardar en archivo
		//agregar el pedido a la lista de pedidos del restaurante
		//pedido en curso = null
		
	}
	
	public static void ejecutarOpcion4()
	{
		String idAConsultarUsuario = input("Ingrese el Id del pedido a consultar: ");
		ArrayList<Pedido> listaPedidos = restaurante.getPedidos();
		for (int i=0; i<listaPedidos.size(); i++)
			{
				Pedido actual = listaPedidos.get(i);
				System.out.println(actual.darIdPedido());
			}
		
		
	}
	
	

}
