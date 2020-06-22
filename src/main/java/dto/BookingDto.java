package dto;

import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.*;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BookingDto {

    @Setter(onMethod_ = { @JsonSetter("firstname") })
    public String firstName;

    @Setter(onMethod_ = { @JsonSetter("lastname") })
    public String lastName;

    @Setter(onMethod_ = { @JsonSetter("totalprice") })
    public int totalPrice;

    @Setter(onMethod_ = { @JsonSetter("depositpaid") })
    public boolean depositPaid;

    @Setter(onMethod_ = { @JsonSetter("bookingdates") })
    public BookingDatesDto bookingDatesDto;

    @Setter(onMethod_ = { @JsonSetter("additionalneeds") })
    public String additionalNeeds;
}
