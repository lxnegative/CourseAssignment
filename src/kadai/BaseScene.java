/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kadai;

import java.awt.Component;
import java.awt.Graphics;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author C0115140
 */
public class BaseScene {
    
    private static JPanel panel;
    
    public void BaseScene(){
        
    }
    
    //初期化処理
    public void Init(){
        
    }
    
    //更新処理
    public BaseScene Update(){
        return this;
    }
    
    //描画処理
    public void Draw(Graphics g){
        
    }
    
    //終了処理
    public void Close(){
        panel.removeAll();
    }
    
    public static void setPanel(JPanel panel){
        BaseScene.panel = panel;
    }
    
    //JComponentをパネルに登録する
    public void add_Component(Component cmp){
        panel.add(cmp);
    }
    
    //JButtonを生成
    public JButton GenerateButton(int x,int y,int width,int height,String text){
        
        JButton b = new JButton();
        
        b.setBounds(x, y, width, height);
        
        b.setText(text);
        
        return b;
        
    }
    
    //JLabelを生成
    public JLabel GenerateLabel(int x,int y,int width,int height,String text){
        
        JLabel l = new JLabel();
        
        l.setBounds(x, y, width, height);
        
        l.setText(text);
        
        return l;
        
    }
    
    public JPanel getPanel(){
        return panel;
    }
    
}
