package com.ivanbessoltsev.exampleapplication.facade;

import com.ivanbessoltsev.exampleapplication.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class FacadeClient {

    private final UserRepository userRepository;

}
