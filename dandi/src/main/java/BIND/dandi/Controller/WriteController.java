package BIND.dandi.Controller;

import BIND.dandi.Domain.WriteDomain;
import BIND.dandi.Repository.WriteRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class WriteController {

    @Autowired
    WriteRepository writeRepository;


    @PostMapping("/input")
    public String input(@RequestParam String title, @RequestParam String content, Model model, HttpSession session) {
        String username = (String) session.getAttribute("username");
        WriteDomain write = new WriteDomain();
        write.setTitle(title);
        write.setContent(content);
        write.setUsername(username);
        writeRepository.save(write);
        return "redirect:/main";
    }

    @PostMapping("/back")
    public String back() {
        return "redirect:/main";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam Long id, HttpSession session) {
        String username = (String) session.getAttribute("username");
        WriteDomain write = writeRepository.findById(id).orElse(null);
        if (write != null && write.getUsername().equals(username)) {
            writeRepository.delete(write);
        }
        return "redirect:/main";
    }
}
