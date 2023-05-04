package it.atom.msscbrewery.web.model;

import com.sun.istack.internal.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Null;
import javax.validation.constraints.Positive;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder // Lombok will use builder pattern for us and using the anootation we use builder pattern.
public class BeerDto {
    @Null
    private UUID id;

    @NotNull
    private String beerName;
    @NotNull
    private  String beerStyle;
    @Positive
    private Long upc;

}
