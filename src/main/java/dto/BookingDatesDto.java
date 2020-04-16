package dto;

import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.*;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BookingDatesDto {

    @Setter(onMethod_ = { @JsonSetter("checkin") })
    public String checkin;

    @Setter(onMethod_ = { @JsonSetter("checkout") })
    public String checkout;
}
