package dto;

import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.*;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)

public class BookingResponseBodyDto {

    @Setter(onMethod_ = { @JsonSetter("bookingid") })
    public Integer bookingId;

    public BookingDto booking;
}
