package com.exercicio.comercio.Controller;

import com.exercicio.comercio.Entity.Comerce;
import com.exercicio.comercio.Repository.CommerceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StatusController {

    @Autowired
    private CommerceRepository commerceRepository;

    @GetMapping("/teste")
    public String teste(){
        return "online";
    }

    @GetMapping("/teste/{nome}")
    public Optional<Comerce> x(@PathVariable("nome") String nome){
        return commerceRepository.findById(Integer.valueOf(nome));
    }
    /*
    @GetMapping("teste/{nome}")
    public List<Comerce> listar(@PathVariable("nome") String nome){
        return commerceRepository.findByTeste(nome);
    } */

    // PARA EXIBIR TODOS OS COMERCIOS
    @GetMapping("/comercios/all")
    public List<Comerce> exibirAll(){
        List<Comerce> comerces = commerceRepository.findAll();
        return comerces;
    }

    // PARA EXIBIR TODOS OS COMERCIOS EM ORDEM DESCRESCENTE
    @GetMapping("/comercios")
    public List<Comerce> exibirOrderByDesc(){
        List<Comerce> comerces = commerceRepository.findAllComercios();
        return comerces;
    }

    // PARA EXIBIR COMERCIO POR ID
    @GetMapping("/comercios/{id}")
    public ResponseEntity<Comerce> exibirPorId(@PathVariable("id") Integer id){
        return commerceRepository.findById(id)
                .map(comerce -> ResponseEntity.ok().body(comerce))
                .orElse(ResponseEntity.notFound().build());
    }
    // PARA EXIBIR SHOPPINGS
    @GetMapping("/comercios/shopping")
    public List<Comerce> exibirShopping(){
        List<Comerce> comerces = commerceRepository.findAllShop();
        return comerces;
    }
    // PARA EXIBIR SUPERMERCADOS
    @GetMapping("/comercios/supermercados")
    public List<Comerce> exibirSupermercado(){
        List<Comerce> comerces = commerceRepository.findAllSupermercado();
        return comerces;
    }
    // PARA EXIBIR ACADEMIAS
    @GetMapping("/comercios/academias")
    public List<Comerce> exibirAcademias(){
        List<Comerce> comerces = commerceRepository.findAllAcademia();
        return comerces;
    }
    // PARA EXIBIR BARES
    @GetMapping("/comercios/bares")
    public List<Comerce> exibirBares(){
        List<Comerce> comerces = commerceRepository.findAllBares();
        return comerces;
    }
    // PARA SALVAR UM NOVO COMERCIO
    @PostMapping("/comercios/salvar")
    public Comerce salvarNovoComercio(@RequestBody Comerce comerce){
        return commerceRepository.save(comerce);
    }
    // PARA DELETAR POR ID
    @DeleteMapping("/comercios/delete/{codigo}")
    public void delete(@PathVariable("codigo") Integer codigo){
        if (commerceRepository.existsById(codigo)){
            commerceRepository.deleteById(codigo);
        }
    }
    // PARA PARA DELETAR TODOS
    @DeleteMapping("/comercios/delete/todos")
    public void deletarTodos(){
        commerceRepository.deleteAll();
    }
}
