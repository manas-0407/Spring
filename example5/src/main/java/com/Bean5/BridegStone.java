package com.Bean5;

import org.springframework.stereotype.Component;

import java.util.*;
import java.io.*;

@Component(value = "bridge_stone_tyre")
public class BridegStone implements Tyre{
    @Override
    public void tyreName() {
        System.out.println("BridegStone Tyres");
    }
}
