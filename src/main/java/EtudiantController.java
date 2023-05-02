
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class EtudiantController {

    @Autowired
    //  @Autowired est une annotation de Spring Framework qui permet d'injecter automatiquement une instance de classe dans une autre classe.
    private EtudiantRepository etudiantRepository;

    @Autowired
    private ClasseRepository classeRepository;

    @Autowired
    private NiveauRepository niveauRepository;

    @GetMapping("/listeEtudiants")
    /* indique que cette méthode doit être déclenchée lorsqu'une requête HTTP GET est effectuée sur l'URL
    "/listeEtudiants".
     */
    public ModelAndView etudiants() {
        ModelAndView mav = new ModelAndView("listeEtudiants");
        List<Etudiant> etudiants = etudiantRepository.findAll();
        mav.addObject("etudiant", etudiants);
        return mav;
    }
}