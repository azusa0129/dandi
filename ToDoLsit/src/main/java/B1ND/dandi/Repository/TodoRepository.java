package B1ND.dandi.Repository;

import B1ND.dandi.Domain.TodoDomain;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<TodoDomain, Long> {
}
