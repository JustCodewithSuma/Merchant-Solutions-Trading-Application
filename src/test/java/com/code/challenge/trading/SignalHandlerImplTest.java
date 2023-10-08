package com.code.challenge.trading;

import com.code.challenge.trading.service.*;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;


@SpringBootTest
public class SignalHandlerImplTest {

    @Autowired
    SignalHandlerImpl signalHandlerImpl;

    @MockBean
    @Qualifier("1")
    SignalOne signalOne;

    @MockBean
    @Qualifier("2")
    SignalTwo signalTwo;

    @MockBean
    @Qualifier("3")
    SignalThree signalThree;

    @MockBean
    @Qualifier("0")
    DefaultSignal defaultSignal;

    @Autowired
    Algo algo = Mockito.mock(Algo.class);

    @Test()
    public void testHandleSignal(){
        List<SignalHandler> signalHandlers = Arrays.asList(signalOne,signalTwo,signalThree,defaultSignal);
        signalHandlerImpl = new SignalHandlerImpl(signalHandlers);
        signalHandlerImpl.executeSignalHandler(2);
        signalHandlerImpl.executeSignalHandler(2);
        signalHandlerImpl.executeSignalHandler(2);
        Exception exception = Assert.assertThrows(IllegalArgumentException.class,() -> { signalHandlerImpl.executeSignalHandler(100);});
        Assert.assertTrue(exception.getMessage().equalsIgnoreCase("Signal Handling not supported"));
    }

}
