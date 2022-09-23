package com.dh.serieservice.shared;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public abstract class GenericRestController<T,ID extends Serializable> {
    private final GenericServiceAPI<T,ID> serviceAPI;

    protected GenericRestController(GenericServiceAPI<T, ID> serviceAPI) { //se necesita que sea heredada
        this.serviceAPI = serviceAPI;
    }
    @GetMapping("/all")
    public List<T> getAll() {
        return serviceAPI.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<T> find(@PathVariable ID id) {
        var entity = serviceAPI.getOne(id);
        if (entity == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(entity);
    }
    @PostMapping("/save")
    public ResponseEntity<Object> save(@Valid @RequestBody T entity, BindingResult result){
        if(result.hasErrors()){
            return this.validate(result);
        }
        return ResponseEntity.status(HttpStatus.OK).body(serviceAPI.save(entity));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> delete(@PathVariable ID id) {
        var entity = serviceAPI.getOne(id);
        if (entity != null){
            serviceAPI.delete(id);
        }else {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(entity);

    }

    private ResponseEntity<Object> validate(BindingResult result) {
        Map<String,Object> errors = new HashMap<>();
        result.getFieldErrors().forEach(e -> errors.put(e.getField(),
                " el campo " + e.getField()+" "+ e.getDefaultMessage()));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }
}
