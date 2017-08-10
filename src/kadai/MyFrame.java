/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kadai;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author C0115140
 */
public class MyFrame extends JFrame {
    
    private MyPanel panel;
    
    private SceneManager sceneMgr;
    
    private static int FrameWidth;
    private static int FrameHeight;
    
    public static KeyBoard keyBoard;
    
    public MyFrame() {
        
        String title = "避けゲー（仮）";

        setTitle(title);
        
        FrameWidth = 1000;
        FrameHeight = 800;
        
        setBounds(300, 100, FrameWidth, FrameHeight);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setResizable(false);
        
        panel = new MyPanel();
        
        

        panel.setLayout(null);
        
        setFocusable(true);
        

        Container contentPane = getContentPane();
        contentPane.add(panel, BorderLayout.CENTER);
        
        BaseScene.setPanel(panel);
        
        sceneMgr = new SceneManager();
        
        panel.setSceneMgr(sceneMgr);
        
        keyBoard = new KeyBoard();
        
        addKeyListener(keyBoard);

    }
    
    //プログラムの開始処理
    public void Run(){
        
        Timer timer = new Timer(); //タイマーインスタンス作成
        
        timer.scheduleAtFixedRate(new FrameTask(this), 0, 10);
        
    }
    
    //更新処理
    public void act(){
        
        
        sceneMgr.act();
        
        
        panel.repaint();
        
    }
    
    //ウインドウの横の大きさを取得
    public static int getFrameWidth(){
        return FrameWidth;
    }
    
    //ウインドウの縦の大きさを取得
    public static int getFrameHeight(){
        return FrameHeight;
    }
    
    
    
}
