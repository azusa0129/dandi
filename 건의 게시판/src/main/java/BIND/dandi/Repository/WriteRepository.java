package BIND.dandi.Repository;

import BIND.dandi.Domain.WriteDomain;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WriteRepository extends JpaRepository<WriteDomain, Long> {

    List<WriteDomain> findByUsernameAndTitle(String username, String title);

    List<WriteDomain> findByUsername(String username);
}