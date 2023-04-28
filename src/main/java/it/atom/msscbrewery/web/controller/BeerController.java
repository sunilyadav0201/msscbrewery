package it.atom.msscbrewery.web.controller;

import it.atom.msscbrewery.service.BeerService;
import it.atom.msscbrewery.web.model.BeerDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.ServerRequest;

import java.util.UUID;

@RequestMapping("/api/v1/beer")
@RestController
public class BeerController {



    private final BeerService beerService;

    public BeerController(BeerService beerService) {
        this.beerService = beerService;
    }

    @GetMapping("/{beerId}")
    public ResponseEntity<BeerDto> getBeer(@PathVariable("beerId") UUID beerId){
        return new ResponseEntity<>(beerService.getBeerById(beerId), HttpStatus.OK);

    }

    //POST - create new Beer
    @PostMapping
    public ResponseEntity handlePost(BeerDto beerDto){
        BeerDto saveDto=beerService.saveNewBeer(beerDto);
        HttpHeaders headers=new HttpHeaders();
        // TODO add hostname to URL
        headers.add("location","/api/v1/beer"+saveDto.getId().toString());
        return new ResponseEntity(headers, HttpStatus.CREATED);

    }

    @PutMapping("/{beerId}")
    public ResponseEntity handleUpdate(@PathVariable("beerId") UUID beerId, BeerDto beerDto){
        beerService.updateBeer(beerId,beerDto);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
