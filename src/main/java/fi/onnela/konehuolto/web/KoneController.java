package fi.onnela.konehuolto.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fi.onnela.konehuolto.domain.Huolto;
import fi.onnela.konehuolto.domain.HuoltoRepository;
import fi.onnela.konehuolto.domain.Kone;
import fi.onnela.konehuolto.domain.KoneRepository;

@Controller
public class KoneController {

	@Autowired
	private KoneRepository konerepo;

	@Autowired
	private HuoltoRepository huoltorepo;
	
	// Kirjaudu sisään
	@RequestMapping(value="/kirjaudu")
	public String kirjaudu() {
		return "kirjaudu";
	}

	// Listaa koneet
	@RequestMapping("/koneet")
	public String koneListaus(Model model) {
		model.addAttribute("koneet", konerepo.findAll());
		return "konelistaus";
	}

	// Lisää kone
	@RequestMapping(value = "/lisaakone")
	public String lisaaKone(Model model) {
		model.addAttribute("kone", new Kone());
		return "lisaakone";
	}

	// Tallenna kone
	@RequestMapping(value = "/tallennakone", method = RequestMethod.POST)
	public String tallennaKone(Kone kone) {
		konerepo.save(kone);
		return "redirect:muokkaakone";
	}

	// Koneiden muokkaus
	@RequestMapping("/muokkaakone")
	public String muokkaaKone(Model model) {
		model.addAttribute("koneet", konerepo.findAll());
		return "muokkaakone";
	}

	// Poista kone
	@RequestMapping(value = "/poista/{valmistenumero}", method = RequestMethod.GET)
	public String poistaKone(@PathVariable("valmistenumero") String valmistenumero, Model model) {
		konerepo.deleteById(valmistenumero);
		return "redirect:../muokkaakone";
	}

	// Päivitä koneen tietoja
	@RequestMapping(value = "/muokkaa/{valmistenumero}")
	public String paivitaKone(@PathVariable("valmistenumero") String valmistenumero, Model model) {
		model.addAttribute("kone", konerepo.findById(valmistenumero));
		return "paivitakone";
	}

	// Listaa huollot koneen mukaan
	@RequestMapping(value = "/huollot/{valmistenumero}")
	public String haeHuollot(@PathVariable("valmistenumero") String valmistenumero, Model model) {
		model.addAttribute("kone", konerepo.findById(valmistenumero).get());
		model.addAttribute("huollot", huoltorepo.findByKone_valmistenumero(valmistenumero));
		return "huoltolista";
	}

	// Lisää huolto
	@RequestMapping(value = "/lisaahuolto/{valmistenumero}")
	public String lisaaHuolto(@PathVariable("valmistenumero") String valmistenumero, Model model) {
		model.addAttribute("huolto", new Huolto());
		model.addAttribute("kone", konerepo.findById(valmistenumero).get());
		return "lisaahuolto";
	}
	
	// Tallenna huolto
	@RequestMapping(value = "/tallennahuolto", method = RequestMethod.POST)
	public String tallennaHuolto(Huolto huolto) {
		huoltorepo.save(huolto);
		return "redirect:konelistaus";
	}

}
