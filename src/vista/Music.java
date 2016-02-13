/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.Personaje;
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
            Random  rnd = new Random();
            int nota;
            int duracion;
            int secondinstrument;
            int nota_drum;
            while (true){
                switch (Juego.jugador.getArea()){
                    case "Pasto":
                        nota = 60 + rnd.nextInt(10);
                        duracion = duration;
                        channels[channel].noteOn( nota, volume-20 );
                        channels[channel].noteOn( nota+4, volume-20 );
                        channels[channel].noteOn( nota+7, volume-20 );

                        secondinstrument = 9;
                        for (int i = 0;i<10;i++){
                            nota_drum = 60 + rnd.nextInt(3);
                            channels[secondinstrument].noteOn( nota_drum, volume );
                            Thread.sleep( duracion/10 );
                            channels[secondinstrument].noteOff( nota_drum );
                        }
                        channels[channel].noteOff( nota );
                        channels[channel].noteOff( nota+4 );
                        channels[channel].noteOff( nota+7 );
                        nota_drum = 60 + rnd.nextInt(3);

                        channels[secondinstrument].noteOn( nota_drum, volume );
                        Thread.sleep( duracion/10 );
                        channels[secondinstrument].noteOff( nota_drum );
                        break;
                    case "Carpa":
                        secondinstrument = 9;
                        channels[secondinstrument].noteOn( 62, volume );
                        channels[secondinstrument].noteOn( 60, volume );
                        Thread.sleep( 250 );
                        channels[secondinstrument].noteOff( 60 );
                        channels[secondinstrument].noteOff( 62 );
                        for (int i = 0;i<3;i++){
                            channels[secondinstrument].noteOn( 60, volume );
                            Thread.sleep( 250 );
                            channels[secondinstrument].noteOff( 60 );
                        }
                        break;
                    default:
                        duracion = duration;

                        secondinstrument = 13;
                        //for (int i = 0;i<15;i++){
                            nota_drum = 80 + rnd.nextInt(2);
                            channels[secondinstrument].noteOn( nota_drum, volume );
                            channels[secondinstrument].noteOn( nota_drum+4, volume );
                            channels[secondinstrument].noteOn( nota_drum+6, volume );
                            Thread.sleep( duracion );
                            channels[secondinstrument].noteOff( nota_drum );
                        //}
                        break;
                        
                }
                
                
                
            }
            //synth.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
