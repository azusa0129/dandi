package B1ND.ToDoList.Controller;

import B1ND.ToDoList.Domain.Tododomain;
import B1ND.ToDoList.Repository.ToDoListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todo")
@RequiredArgsConstructor
public class ToDoListController {
    private final ToDoListRepository toDoListRepository;

    @GetMapping
    public List<Tododomain> getToDoList() {
        return toDoListRepository.findAll();
    }

    @PostMapping
    public Tododomain addToDo(@RequestBody Tododomain toDoList) {
        return toDoListRepository.save(toDoList);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteToDo(@PathVariable Long id) {
        toDoListRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}