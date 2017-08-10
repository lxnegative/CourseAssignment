/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kadai;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

/**
 *
 * @author C0115140
 */
public class WeakEnemy extends EnemyBase{
    
    //大きさ
    private int sizeX;
    private int sizeY;

    //あたり判定のマージン
    private int margin;
    
    public WeakEnemy() {
        super();

        sizeX = 32;
        sizeY = 32;

        this.getLabel().setBounds(0, 0, sizeX, sizeY);

        margin = 5;
        
        setSpeed(5);
        
    }
    

    public WeakEnemy(int strength) {
        super();

        sizeX = 32;
        sizeY = 32;

        this.getLabel().setBounds(0, 0, sizeX, sizeY);

        margin = 5;
        
        setSpeed(strength);
        
    }

    //更新処理
    @Override
    public void act() {

        setX(getX() - getSpeed());
        
        
        if(getX() < 0 - sizeX - margin){
            setFlag(false);
        }
        
    }
    
    //描画処理
    @Override
    public void Draw(Graphics g) {

        g.setColor(Color.blue);
        g.fillOval(this.getX() - sizeX / 2 - margin, this.getY() - sizeY / 2 - margin, sizeX + margin, sizeY + margin);
        
    }
    
}
