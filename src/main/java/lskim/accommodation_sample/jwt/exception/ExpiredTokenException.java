package lskim.accommodation_sample.jwt.exception;

public class ExpiredTokenException extends RuntimeException {
    public ExpiredTokenException() { super("만료된 토큰 입니다."); }
}
