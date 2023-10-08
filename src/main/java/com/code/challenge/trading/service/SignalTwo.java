package com.code.challenge.trading.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Service class for processing the Signal with input as 2.
 * @Qualifier("2") SignalTwo - Maps the Signal number 2 to SignalTwo
 */
@Service
@Qualifier("2")
public class SignalTwo extends AbstractSignalHandler{

    public static Logger logger = LoggerFactory.getLogger(SignalTwo.class);

    public SignalTwo(Algo algo) {
        super(algo);
    }

    @Override
    public void handleSignal(int signal) {
        logger.info("Signal Two is executed");
        algo.reverse();
        algo.setAlgoParam(1,80);
        algo.submitToMarket();
    }
}
