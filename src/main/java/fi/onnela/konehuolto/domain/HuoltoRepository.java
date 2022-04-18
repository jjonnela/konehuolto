package fi.onnela.konehuolto.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface HuoltoRepository extends CrudRepository<Huolto, Long> {

	
	List<Huolto> findByKone_valmistenumero(String valmistenumero);
	
	
}
