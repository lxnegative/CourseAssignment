/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kadai;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author C0115140
 */
public class MyPanel extends JPanel{
    
    private SceneManager sceneMgr;
    
    
    public MyPanel(){
        
        setFocusable(true);
        
    }
    
    public void setSceneMgr(SceneManager sceneMgr){
        this.sceneMgr = sceneMgr;
    }
    
    //描画処理
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        if(sceneMgr != null){
            sceneMgr.Draw(g);
        }
        
    }
    
}
