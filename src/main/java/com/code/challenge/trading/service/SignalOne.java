package com.code.challenge.trading.service;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


/**
 * Service class for processing the Signal with input as 1.
 * @Qualifier("1") SignalOne - Maps the Signal number 1 to SignalOne
 */
@Service
@Qualifier("1")
@Slf4j
public class SignalOne extends AbstractSignalHandler{

    public static Logger logger = LoggerFactory.getLogger(SignalOne.class);
    public SignalOne(Algo algo) {
        super(algo);
    }

    @Override
    public void handleSignal(int signal) {
        logger.info("Signal One is executed");
        algo.setUp();
        algo.setAlgoParam(1,60);
        algo.performCalc();
        algo.submitToMarket();
    }
}
