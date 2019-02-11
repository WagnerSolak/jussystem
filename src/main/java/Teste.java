import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jussystem.model.Endereco;
import com.jussystem.model.Pessoa;
import com.jussystem.model.TipoPessoa;

public class Teste {
	
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("JusSystemPU");
		EntityManager manager = factory.createEntityManager();
		
		EntityTransaction trx = manager.getTransaction();
		trx.begin();
		
		Pessoa pessoa = new Pessoa();
		pessoa.setNome("Wagner Felipe Martins");
		pessoa.setEmail("wwwagnerww@gmail.com");
		pessoa.setDocumentoReceitaFederal("049.123.123-58");
		pessoa.setTipo(TipoPessoa.FISICA);
		pessoa.setDataNascimento(null);
		pessoa.setSexo(null);
		
		
		Endereco endereco = new Endereco();
		endereco.setLogradouro("Rua Florianopolis");
		endereco.setNumero("321");
		endereco.setCidade(null);
		endereco.setCep("87200344");
		endereco.setPessoa(pessoa);
		
		
		pessoa.getEnderecos().add(endereco);
		
		
		
		
		manager.persist(pessoa);
		
		trx.commit();
		
	}
}
