package com.HttpClientExplore.controller;

import com.HttpClientExplore.service.PostalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/postal")
public class PostalCodesController {

    @Autowired
    PostalService postalService;

    @GetMapping(path = "/byPin")
    public String getPostalByPinCode() throws URISyntaxException,
            IOException, InterruptedException {
        String response =postalService.getPostalDetails();

        return response;
    }

}
