package StelLive.tabi.Repository;

import StelLive.tabi.Domain.MemberDomain;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<MemberDomain, Long> {
    MemberDomain findByUsernameAndPassword(String username, String password);
}
