package fi.onnela.konehuolto;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.onnela.konehuolto.domain.Huolto;
import fi.onnela.konehuolto.domain.HuoltoRepository;
import fi.onnela.konehuolto.domain.Kone;
import fi.onnela.konehuolto.domain.KoneRepository;

@SpringBootApplication
public class KonehuoltoApplication {

	public static void main(String[] args) {
		SpringApplication.run(KonehuoltoApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner testi(KoneRepository konerepo, HuoltoRepository huoltorepo) {
		return (args) -> {
			Kone testi1 = new Kone("A1B2-Z123", "Valmet", "Mega 8400", "Traktori", 2002);
			Kone testi2 = new Kone("B2C3-G456", "Valtra", "T5", "Traktori", 2021);
			konerepo.save(testi1);
			konerepo.save(testi2);
			
			Huolto testihuolto1 = new Huolto("05.04.2022", "Öljyt ja suodatin vaihdettu", konerepo.findById("A1B2-Z123").get());
			Huolto testihuolto2 = new Huolto("12.02.2022", "Kaikki rasvanipat käyty läpi", konerepo.findById("A1B2-Z123").get());
			Huolto testihuolto3 = new Huolto("22.10.2023", "Ilmansuodatin vaihdettu uuteen", konerepo.findById("B2C3-G456").get());
			Huolto testihuolto4 = new Huolto("25.11.2023", "Hydrauliikkaöljyä lisätty", konerepo.findById("B2C3-G456").get());
			
			huoltorepo.save(testihuolto1);
			huoltorepo.save(testihuolto2);
			huoltorepo.save(testihuolto3);
			huoltorepo.save(testihuolto4);
			
		};
	}

}
