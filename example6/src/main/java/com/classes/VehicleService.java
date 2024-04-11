package com.classes;

import com.model.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VehicleService {

//    @Autowired
    MRF tyre;

//    @Autowired
    JBL speaker;

    @Autowired
    VehicleService(MRF mrf , JBL jbl){
        this.tyre = mrf;
        this.speaker = jbl;
    }

    Song song= new Song("MockingBird" , "Eminem");

//    VehicleService(Song song){
//        this.song = song;
//    }

    String brake(){
        return tyre.stop();
    }
    String move(){
        return tyre.rotate();
    }

    String play() { return speaker.play(song);}
}
