package lskim.accommodation_sample.jwt.exception;

public class InvalidTokenException extends RuntimeException {
    public InvalidTokenException() { super("비정상적인 토큰입니다."); }
}
