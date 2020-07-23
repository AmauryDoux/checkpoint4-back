package com.sabso.advertisement.Controllers;

import com.sabso.advertisement.Entities.Advert;
import com.sabso.advertisement.Services.AdvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/adverts")
public class AdvertController {

    @Autowired
    AdvertService service;

    @GetMapping("/")
    public List<Advert> getAdverts() {
        return service.getAdverts();
    }

    @PostMapping("/")
    public void postAdverts(@RequestBody Advert advert) {
        service.save(advert);
    }

    @PutMapping("/{id}")
    public Advert updateAdvert(@RequestBody Advert newAdvert, @PathVariable Long id) {
        return service.updateAdvert(newAdvert, id);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id)
    {
        service.deleteById(id);
    }
}
