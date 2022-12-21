package co.camcar.aop.dao;

import org.springframework.stereotype.Component;

import co.camcar.aop.Cliente;

@Component
public class ClienteDao {

	public void insertaCliente(Cliente cliente, String tipo) {
		System.out.println("Cliente insertado correctamente.");
	}

}
