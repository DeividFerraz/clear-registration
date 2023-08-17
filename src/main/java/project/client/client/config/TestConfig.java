package project.client.client.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import project.client.client.entities.ClientLog;
import project.client.client.entities.PlanoMovel;
import project.client.client.repositories.ClientRepository;
import project.client.client.repositories.PlanoRepository;


@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private PlanoRepository planoRepository;
	
	@Override
	public void run(String... args) throws Exception {

		PlanoMovel p1 = new PlanoMovel(null, "ROBBBU CONTROLE 15GB", "R$49,90/mês", "*ROBBU CONTROLE 15GB*\\n15 *GIGA*\\n(8GB + 7GB BÔNUS)**\\n\\n  Apps Ilimitados\\n     - WHATSAP\\n     - WAZE \\n\\nLigações Ilimitadas\\nPara todo o Brasil\\nR$49,90/mês\\n**8GB no plano + 7GB bônus válidos por 12 meses");
		PlanoMovel p2 = new PlanoMovel(null, "ROBBU CONTROLE 20GB", "R$59,90/mês", "*ROBBU CONTROLE 20GB*\\n20 *GIGA*\\n(10GB + 10GB BÔNUS)**\\n\\n Apps Ilimitados\\n -  FACEBOOK \\n - WHATSAPP \\n - INSTAGRAM \\n - TWITER \\n - WAZE \\n\\nLigações Ilimitadas\\nPara todo o Brasil\\n\\nR$59,90/mês\\n\\n**10GB no plano + 10GB bônus válidos por 12 meses ");
		
		planoRepository.saveAll(Arrays.asList(p1, p2));
		
		ClientLog c1 = new ClientLog(null, "48358111860", "Deivid ferraz", "11968580094", "07144160", "64-A", "Viela 5 n20", "deividferraz20@gmail.com", p2);
		ClientLog c2 = new ClientLog(null, "48358131209", "Weterson ferraz", "11962925014", "00000000", "64-B", null, "wetersonferraz98@gmail.com", p1);
		
		clientRepository.saveAll(Arrays.asList(c1, c2));

		
		
	}

}
