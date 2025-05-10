package BIND.dandi.Controller;

import BIND.dandi.Domain.WriteDomain;
import BIND.dandi.Repository.WriteRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Controller
public class Controller {

    @Autowired
    WriteRepository writeRepository;

    @GetMapping("/")
    public String login() {
        return "login";
    }

    @GetMapping("/join")
    public String join() {
        return "join";
    }

    @GetMapping("/main")
    public String main(Model model, HttpSession session) {
            String username = (String) session.getAttribute("username");
        List<WriteDomain> writes = writeRepository.findAll();
        model.addAttribute("writes", writes);
        model.addAttribute("username", username);
        return "main";
    }

    @PostMapping("/write")
    public String wirte() {
        return "write";
    }

    @GetMapping("/content/{id}")
    public String content(@PathVariable Long id, Model model) {
        WriteDomain write = writeRepository.findById(id).orElse(null);
        model.addAttribute("write", write);
        return "content";
    }
}