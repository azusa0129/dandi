package StelLive.tabi.Repository;

import StelLive.tabi.Domain.Domain;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Repository extends JpaRepository<Domain, Long> {
}