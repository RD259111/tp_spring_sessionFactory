package banque;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import banque.persistence.entities.Client;
import banque.persistence.entities.Compte;
import banque.services.ClientService;
import banque.services.CompteService;

public class Main {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("springbean.xml");
		ClientService clientService = ctx.getBean("clientServiceImpl", ClientService.class);
		CompteService compteService = ctx.getBean("compteServiceImpl", CompteService.class);
		
		Client client = new Client();
		client.setNom("Loki");
		Compte compte = new Compte();
		compte.setNomCompte("livret BBBB");
		
		compte.setClient(client);
		clientService.add(client);
		compteService.add(compte);
		
		ctx.close();
	}
}