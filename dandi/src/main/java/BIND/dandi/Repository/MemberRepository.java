package BIND.dandi.Repository;

import BIND.dandi.Domain.MemberDomain;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<MemberDomain, Long> {

    MemberDomain findByUsernameAndPassword(String username, String password);
}