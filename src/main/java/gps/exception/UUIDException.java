package gps.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
public class UUIDException extends Exception {

    private Logger logger = LoggerFactory.getLogger(UUIDException.class);
    public UUIDException(String userId) {
        super("UUID userId invalid  : " + userId);
        logger.error("UUID userId invalid  : " + userId);
    }
}