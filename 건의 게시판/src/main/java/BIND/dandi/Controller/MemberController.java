package BIND.dandi.Controller;

import BIND.dandi.Domain.MemberDomain;
import BIND.dandi.Repository.MemberRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MemberController {



    @Autowired
    MemberRepository memberRepository;

    @PostMapping("/join")
    public String join(@RequestParam Long Id, @RequestParam String name, @RequestParam String password, @RequestParam String username) {
        MemberDomain member = new MemberDomain();
        member.setId(Id);
        member.setName(name);
        member.setUsername(username);
        member.setPassword(password);
        memberRepository.save(member);
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password,HttpSession session) {
        MemberDomain find = memberRepository.findByUsernameAndPassword(username,password);
        if(find != null) {
            session.setAttribute("username", find.getUsername());
            return "redirect:/main";
        } else {
            return "login";
        }
    }
}
