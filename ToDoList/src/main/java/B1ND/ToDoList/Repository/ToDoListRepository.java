package B1ND.ToDoList.Repository;

import B1ND.ToDoList.Domain.Tododomain;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoListRepository extends JpaRepository<Tododomain,Long> {
}
