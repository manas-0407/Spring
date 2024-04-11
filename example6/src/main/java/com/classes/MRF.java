package com.classes;

import com.interfaces.Tyre;
import org.springframework.stereotype.Component;

@Component
public class MRF implements Tyre {

    @Override
    public String rotate() {
        return "Rotating on MRF";
    }

    @Override
    public String stop() {
        return "Stopping on MRF";
    }
}
