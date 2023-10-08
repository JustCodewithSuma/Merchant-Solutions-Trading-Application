package com.code.challenge.trading.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Service class for processing the Signal received.
 * Here the Signal would be processed based on the number and
 * equivalent name fetched from the Qualifier DeclaredAnnotations.
 * Each Signal would be represented by a class and identified by Qualifier name.
 * Ex: @Qualifier("1") SignalOne
 *     @Qualifier("2") SignalTwo ..so on
 *     Default Signal is assigned 0 Value.Can be changed if required
 */
@Service
@Slf4j
public class SignalHandlerImpl  {

    // Strategies are the different Strategies which are (implementations of SignalHandler for different Signal inputs)
    // mentioned with the @Qualifier annotations
    private final Map<String, SignalHandler> strategies;

    public SignalHandlerImpl(List<SignalHandler> signalHandlers){
        this.strategies = signalHandlers.stream().collect(Collectors.toUnmodifiableMap(k -> k.getClass().getDeclaredAnnotation(Qualifier.class).value(), Function.identity()));
    }

    /**
     * Execute method would be responsible to invoke different
     * SignalHandlers based on the input Signal number
     */
    public void executeSignalHandler(int signal){
        String signalName = String.valueOf(signal);
            if(!strategies.containsKey(signalName)){
                throw new IllegalArgumentException("Signal Handling not supported");
            }
            strategies.get(signalName).handleSignal(signal);
    }
}
