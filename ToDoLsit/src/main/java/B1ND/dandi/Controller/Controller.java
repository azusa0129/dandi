package B1ND.dandi.Controller;

import B1ND.dandi.Domain.TodoDomain;
import B1ND.dandi.Repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ToDoList")
@RequiredArgsConstructor
public class Controller {
    private final TodoRepository todoRepository;

    @GetMapping
    public List<TodoDomain> getAll() {
        return todoRepository.findAll();
    }

    @PostMapping
    public TodoDomain create(@RequestBody TodoDomain domain) {
        return todoRepository.save(domain);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return todoRepository.findById(id)
                .map(todoDomain -> {
                    todoRepository.delete(todoDomain);
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
