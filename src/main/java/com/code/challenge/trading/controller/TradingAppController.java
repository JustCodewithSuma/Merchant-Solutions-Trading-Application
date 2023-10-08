package com.code.challenge.trading.controller;

import com.code.challenge.trading.service.SignalHandlerImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

/**
 * Controller class for processing the Signal received
 */
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/trading")
public class TradingAppController {

    private final SignalHandlerImpl signalHandler;

    /**
     * Process Signal received for Trading
     */
    @GetMapping(path = "/signal/{number}")
    public void sendSignal(@NotNull @PathVariable Integer number){
        signalHandler.executeSignalHandler(number);
    }
}
