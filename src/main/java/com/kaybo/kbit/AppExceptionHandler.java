package com.kaybo.kbit;

import com.kaybo.kbit.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice("com.kaybo.kbit")
@RestController
public class AppExceptionHandler {

    @ExceptionHandler(AppException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorResponse handleMyRuntimeException(AppException exception) {

        ErrorResponse err = new ErrorResponse();
        err.setErrCode(exception.getErrCode());
        err.setErrMsg(exception.getMessage());
        return err;
    }
}
