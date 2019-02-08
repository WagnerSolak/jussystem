import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jussystem.model.Pessoa;
import com.jussystem.model.TipoPessoa;

public class Teste {
	
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("JusSystemPU");
		EntityManager manager = null;
		
		EntityTransaction trx = manager.getTransaction();
		trx.begin();
		
		Pessoa pessoa = new Pessoa();
		pessoa.setNome("Wagner Felipe Martins");
		pessoa.setEmail("wwwagnerww@gmail.com");
		pessoa.setDocumentoReceitaFederal("049.123.123-58");
		pessoa.setTipo(TipoPessoa.FISICA);
		
		manager.persist(pessoa);
		
		trx.commit();
		
	}
}
