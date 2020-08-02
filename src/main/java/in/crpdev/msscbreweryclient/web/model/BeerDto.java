package in.crpdev.msscbreweryclient.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

/**
 * Created by rajapandian
 * Date: 02/08/20
 * Project: mssc-brewery-client
 * Package: in.crpdev.msscbreweryclient.web.model
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BeerDto {
    private UUID id;
    private Integer version;
    private OffsetDateTime createdDate;
    private OffsetDateTime lastModifiedDate;
    private String beerName;
    private BeerStyle beerStyle;
    private Integer quantityOnHand;
    private BigDecimal price;
    private Integer upc;
}
