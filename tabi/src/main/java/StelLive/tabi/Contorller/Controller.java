package StelLive.tabi.Contorller;

import StelLive.tabi.Domain.Domain;
import StelLive.tabi.Repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

@org.springframework.stereotype.Controller
public class Controller {
    @Autowired
    private Repository repository;

    @GetMapping("main")
    public String mainTabi() {
        return "mainTabi";
    }

    @GetMapping("coverTabi")
    public String cover() {
        return "coverTabi";
    }

    @GetMapping("celebrationTabi")
    public String showCelebrationTabi(Model model) {
        List<Domain> tabiList = repository.findAll();
        model.addAttribute("Tabi", tabiList);
        return "celebrationTabi";
    }

    @GetMapping("profileTabi")
    public String profileTabi() {
        return "profileTabi";
    }

/*    @PostMapping("celebrationTabi")
    public String inputTabi(@RequestParam("value") String celebration) {
        Domain Tabi = new Domain();
        Tabi.setValue(celebration);
        repository.save(Tabi);
        return "redirect:/celebrationTabi";
    }*/
}