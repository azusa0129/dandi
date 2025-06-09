package StelLive.tabi.Contorller;

import StelLive.tabi.Repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import StelLive.tabi.Domain.MemberDomain;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MemberController {

    @Autowired
    MemberRepository memberRepository;


    @GetMapping("/join")
    public String member() {
        return "join";
    }

    @GetMapping("/")
    public String index() {
        return "login";
    }

    @PostMapping("/join")
    public String join(@RequestParam String username, @RequestParam String password, @RequestParam String email, Model model) {
        MemberDomain member = new MemberDomain();
        member.setUsername(username);
        member.setPassword(password);
        member.setEmail(email);
        memberRepository.save(member);
        return "login";
    }

    @PostMapping("/")
    public String login(@RequestParam String username, @RequestParam String password) {
        MemberDomain member = new MemberDomain();
        member.setUsername(username);
        member.setPassword(password);
        MemberDomain found = memberRepository.findByUsernameAndPassword(username, password);
        if (found != null) {
            return "mainTabi";
        } else {
            return "join";
        }
    }
}
