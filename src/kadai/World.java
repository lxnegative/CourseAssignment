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
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author C0115140
 */
public class World{

    private List<Actor> actors;
    private JPanel panel;
    
    private boolean isGameover;
    
    
    public World() {

        actors = new ArrayList<>();
        
        isGameover = false;
        
    }

    //更新処理
    public void act() {
        
        for (int i=0;i<actors.size();i++) {
            Actor actor = actors.get(i);
            //actor.setWorld(this);
            actor.act();
            //actor.getLabel().repaint();
        }
        
        
        deleteObject();

        //panel.repaint();

    }
    
    //描画処理
    public void Draw(Graphics g){
        
        //g.drawLine(0, groundY, MyFrame.getFrameWidth(), groundY);
        
        for (int i=0;i<actors.size();i++) {
            Actor actor = actors.get(i);
            actor.Draw(g);
        }
        
    }

    //このWorldにActorを追加する
    public void addObject(Actor actor, int x, int y) {

        actor.setX(x);
        actor.setY(y);

        actors.add(actor);

        panel.add(actor.getLabel());
        
        actor.setWorld(this);

    }
    
    //このWorldからActorを削除する
    public void deleteObject(){
        
        for (int i=0;i<actors.size();i++) {
            Actor actor = actors.get(i);
            if(actor.getFlag() == false){
                
                if(Hero.class.isInstance(actor)){
                    isGameover = true;
                }
                
                panel.remove(actor.getLabel());
                actors.remove(actor);
            }
        }
        
    }
    
    //引数のActorと重なっているActorがないか判定する　引数にクラスを渡すとそのクラスのみ判定する
    public boolean isOverLapForClass(java.lang.Class<?> cls, Actor actor) {

        for (Actor act : actors) {
            boolean is;
            if (act != actor) {
                is = checkHit(actor, act);
                if (is == true) {
                    if (cls == null) {
                        return true;
                    } else if (cls.isInstance(act)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    //引数のActorと重なっているActorがないか判定し、重なっているActorをリストにして返す　引数にクラスを渡すとそのクラスのみ判定する
    @SuppressWarnings("unchecked")
    public <T> java.util.List<T> OverLapListForClass(java.lang.Class<T> cls, Actor actor) {

        if (cls == null) {
            java.util.List<T> list = new ArrayList<>();
            
            for (Actor act : actors) {
                boolean is;
                if (act != actor) {
                    is = checkHit(actor, act);
                    if (is == true) {
                        list.add((T)act);
                    }
                }
            }
            
            return list;
            
        } else {
            
            java.util.List<T> list = new ArrayList<>();

            for (Actor act : actors) {
                boolean is;
                if (act != actor) {
                    is = checkHit(actor, act);
                    if (is == true) {
                        if (cls.isInstance(act)) {
                            list.add(cls.cast(act));
                        }
                    }
                }
            }
            
            return list;

        }

    }

    //二つのActorが重なっているかを調べる
    public boolean checkHit(Actor actor1, Actor actor2) {

        int a1x = actor1.getLabel().getX();
        int a1y = actor1.getLabel().getY();
        int a1w = actor1.getLabel().getWidth();
        int a1h = actor1.getLabel().getHeight();

        int a2x = actor2.getLabel().getX();
        int a2y = actor2.getLabel().getY();
        int a2w = actor2.getLabel().getWidth();
        int a2h = actor2.getLabel().getHeight();

        if (a1x < a2x + a2w && a1x + a1w > a2x) {
            if (a1y < a2y + a2h && a1y + a1h > a2y) {
                return true;
            }
        }

        return false;
    }
    
    public void setPanel(JPanel panel){
        
        this.panel = panel;
        
    }
    
    public boolean getIsGameover(){
        return isGameover;
    }

}
