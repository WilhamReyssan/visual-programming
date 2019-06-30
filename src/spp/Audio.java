/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spp;
import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;

/**
 *
 * @author Lenovo
 */
public class Audio {
    private static AudioClip musik ;
    
    public void mainMusik(String source){
        URL url = this.getClass().getResource(source) ;
        musik = Applet.newAudioClip(url);
        musik.play();
    }
    
}
