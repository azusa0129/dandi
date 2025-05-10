package BIND.dandi.Domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class MemberDomain {
    @Id
    private Long Id; // 학번
    private String Name; // 이름
    private String password; //비번
    private String username; // 아이디
}
