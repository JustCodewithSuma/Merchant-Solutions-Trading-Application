package com.code.challenge.trading.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Service class for processing the Signal with input as 3.
 * @Qualifier("3") SignalThree - Maps the Signal number 3 to SignalThree
 */
@Service
@Qualifier("3")
public class SignalThree extends AbstractSignalHandler{

    public static Logger logger = LoggerFactory.getLogger(SignalThree.class);

    public SignalThree(Algo algo) {
        super(algo);
    }

    @Override
    public void handleSignal(int signal) {
        logger.info("Signal Three is executed");
        algo.setAlgoParam(1,90);
        algo.setAlgoParam(2,15);
        algo.performCalc();
        algo.submitToMarket();
    }
}
