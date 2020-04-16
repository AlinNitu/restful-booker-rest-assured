package dto;

import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.*;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)

public class BookingResponseBodyDto {

    @Setter(onMethod_ = { @JsonSetter("bookingid") })
    public int bookingId;

    @Setter(onMethod_ = { @JsonSetter("booking") })
    public BookingDto booking;
}
