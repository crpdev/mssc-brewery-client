package in.crpdev.msscbreweryclient.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
public class CustomerDto {
    private UUID id;
    private String name;
}
