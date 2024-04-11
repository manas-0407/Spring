package com.classes;

import com.interfaces.Speaker;
import com.model.Song;
import org.springframework.stereotype.Component;

@Component
public class JBL implements Speaker {

    @Override
    public String play(Song song){
        return "Playing "+song.song+" by "+song.singer+" on JBL";
    }
}
