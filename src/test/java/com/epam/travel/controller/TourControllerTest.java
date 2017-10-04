package com.epam.travel.controller;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TourControllerTest {

    @Autowired
    private TourController tourController;

    @Test
    public void firstContactTest() {

        List strings = mock(List.class);
        when(strings.size()).thenReturn(100);

        strings.add("sdasd");

        assertNotNull(tourController);
    }
}
