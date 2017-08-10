/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kadai;

import java.awt.Graphics;
import java.util.ConcurrentModificationException;

/**
 *
 * @author C0115140
 */
public class SceneManager {
    
    BaseScene nowScene;
    
    public SceneManager(){
        
        nowScene = new Title();
        nowScene.Init();
        
    }
    
    //更新処理
    public void act(){
        
        BaseScene nextScene = nowScene.Update();
        //nowScene.Draw();
        
        if(nextScene != nowScene){
            
            nowScene.Close();
            nowScene = nextScene;
            nowScene.Init();
            
        }
        
    }
    
    //描画処理
    public void Draw(Graphics g){
        
        if(nowScene != null){
            nowScene.Draw(g);
        }
        
    }

}
