package co.camcar.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import co.camcar.aop.dao.ClienteDao;
import co.camcar.aop.dao.ClienteVipDao;

public class ClasePrincipal {

	public static void main(String[] args) {
		// Leer configuración de Spring
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Configuracion.class);
		
		//obtener el bean del contenedor de Spring
		
		ClienteDao cliente = context.getBean("clienteDao", ClienteDao.class);
		ClienteVipDao clienteVip = context.getBean("clienteVipDao", ClienteVipDao.class);
				
		//llamar al método
		
		Cliente cliente1 = new Cliente();
		cliente1.setNombre("Camilo");
		cliente1.setTipo("NO-VIP");
		
		cliente.insertaCliente(cliente1, cliente1.getTipo());//nombre de metodo que debe coincidir con la anotación @Before
		clienteVip.insertaClienteVIP();
		
		//Cerrar el contexto
		context.close();

	}

}
