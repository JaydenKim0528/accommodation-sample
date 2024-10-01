package lskim.accommodation_sample.domain.exceptions;

public class NotFoundAccommodationException extends RuntimeException{
    public NotFoundAccommodationException() { super("등록되지 않은 숙소입니다."); }
}
