package com.system.foodorder.Exceptions;

import com.system.foodorder.Util.PiloteErrorCode;

public class PiloteNumberException extends RuntimeException {
    public PiloteNumberException(){
        super(PiloteErrorCode.INVALID_VALUE);
    }
}
