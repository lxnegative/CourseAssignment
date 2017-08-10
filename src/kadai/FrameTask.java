/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kadai;

import java.util.TimerTask;

/**
 *
 * @author C0115140
 */
public class FrameTask extends TimerTask {
    
    MyFrame myFrame;
    
    
    
    public FrameTask(MyFrame myFrame){
        this.myFrame = myFrame;
    }
    
    @Override
    public void run() {
        // ここに繰り返し処理を書く
        myFrame.act();
    }
    
}
