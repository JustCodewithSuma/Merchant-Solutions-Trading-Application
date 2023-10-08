package com.code.challenge.trading.service;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * This gives an abstract implementation of the SignalHandler class.
 * An Object of type Algo is initialized and used by the implemented classes.
 */
public abstract class AbstractSignalHandler implements SignalHandler{

    @Autowired
    Algo algo;

    AbstractSignalHandler(Algo algo){
        this.algo = algo;
    }
}
