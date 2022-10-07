package Ciclo31.Ciclo31.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import Ciclo31.Ciclo31.Model.Farm;
import Ciclo31.Ciclo31.Service.FarmService;
import java.util.List;

@RestController
@RequestMapping("/api/Farm")
@CrossOrigin(origins = "*",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})

public class FarmController {

    @Autowired
    private FarmService farmService;

    @GetMapping("/all")
    public List<Farm> getFincas(){
        return farmService.getAll();
    }   

    @GetMapping("/{id}")
    public Optional<Farm> getFinca(@PathVariable("id") int id){
        return farmService.getFinca(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Farm save(@RequestBody Farm f){
        return farmService.save(f);
    }

}
