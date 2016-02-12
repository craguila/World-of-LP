/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.util.Random;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Synthesizer;
import javax.sound.midi.MidiChannel;


public class Music implements Runnable {
    public int channel = 0; // 0 is a piano, 9 is percussion, other channels are for other instruments

    public int volume = 80; // between 0 et 127
    public int duration = 200; // in milliseconds
    public Synthesizer synth;    
    public MidiChannel[] channels;
    
    Music(int channel, int volume, int duration){
        this.channel = channel;
        this.volume = volume;
        this.duration = duration;
    }
    @Override
    public void run(){
        
        try {
            synth = MidiSystem.getSynthesizer();
            synth.open();
            channels = synth.getChannels();
            // --------------------------------------
            // Play a few notes.
            // The two arguments to the noteOn() method are:
            // "MIDI note number" (pitch of the note),
            // and "velocity" (i.e., volume, or intensity).
            // Each of these arguments is between 0 and 127.
            Random  rnd = new Random();
            while (true){
                int nota = 60 + rnd.nextInt(10)*2;
                int duracion = duration + rnd.nextInt(100);
                channels[channel].noteOn( nota, volume );
                Thread.sleep( duracion );
                channels[channel].noteOff( nota );
            }
            //synth.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
