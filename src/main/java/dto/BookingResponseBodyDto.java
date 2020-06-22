package dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
//@Builder//(toBuilder = true)
//@AllArgsConstructor
//@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BookingResponseBodyDto {

    @JsonProperty("bookingid")
    public Integer bookingId;

    public BookingDto booking;
}
