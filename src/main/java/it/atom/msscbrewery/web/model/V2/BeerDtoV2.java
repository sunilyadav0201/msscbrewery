package it.atom.msscbrewery.web.model.V2;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder // Lombok will use builder pattern for us and using the anootation we use builder pattern.
public class BeerDtoV2 {
    private UUID id;
    private String beerName;
    private  BeerStyleEnum beerStyle;
    private Long upc;

}
