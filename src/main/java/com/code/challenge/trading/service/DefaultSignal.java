package com.code.challenge.trading.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Service class for processing the DefaultSignal with input as 0.(Assumption as 0.We can change it later)
 * @Qualifier("0") DefaultSignal - Maps the Signal number 0 to DefaultSignal
 */
@Service
@Qualifier("0")
public class DefaultSignal extends AbstractSignalHandler {

    public static Logger logger = LoggerFactory.getLogger(DefaultSignal.class);

    public DefaultSignal(Algo algo) {
        super(algo);
    }

    @Override
    public void handleSignal(int signal) {
        logger.info("Default Signal is executed");
        algo.cancelTrades();
    }
}
