package co.camcar.aop.aspectos;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import co.camcar.aop.Cliente;

@Aspect
@Component
@Order(2)
public class LoginConAspecto {
	
	//@Pointcut("execution(public * insertaCliente(..))") //actua sobre metodo especifico
	@Pointcut("execution(* co.camcar.aop.dao.*.*(..))")// actua sobre todos los metodos en el paquete dado
	public void paraClientes() {}

	
	@Before("paraClientes()")
	public void antesInsertarCliente(JoinPoint joinpoint) {
		System.out.println("El usuario se ha logeado");
		System.out.println("El perfil es valido");
		
		Object[] argumentos =  joinpoint.getArgs();
		
		for(Object temp: argumentos) {
			if(temp instanceof Cliente){
				Cliente cliente = (Cliente) temp;

				System.out.println("Nombre: "+cliente.getNombre()+" - tipo: "+cliente.getTipo());
			}
		}
	}
}
