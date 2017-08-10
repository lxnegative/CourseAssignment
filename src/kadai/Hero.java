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
public class Hero extends Actor {
    
    //大きさ
    private int sizeX;
    private int sizeY;

    //あたり判定のマージン
    private int margin;
    
    //速さ
    private int speed;
    

    public Hero() {
        super();

        sizeX = 32;
        sizeY = 32;

        this.getLabel().setBounds(0, 0, sizeX, sizeY);

        margin = 5;
        
        speed = 3;
        
    }
    
    //更新処理
    @Override
    public void act() {

        if (KeyBoard.getPushKey(KeyEvent.VK_UP) == 1) {
            setY(getY() - speed);
        }

        if (KeyBoard.getPushKey(KeyEvent.VK_DOWN) == 1) {
            setY(getY() + speed);
        }

        if (KeyBoard.getPushKey(KeyEvent.VK_LEFT) == 1) {
            setX(getX() - speed);
        }

        if (KeyBoard.getPushKey(KeyEvent.VK_RIGHT) == 1) {
            setX(getX() + speed);
        }
        
        
        if(isTouching(EnemyBase.class) == true){
            setFlag(false);
        }
        
    }
    
    //描画処理
    @Override
    public void Draw(Graphics g) {

        g.setColor(Color.red);
        g.fillOval(this.getX() - sizeX / 2 - margin, this.getY() - sizeY / 2 - margin, sizeX + margin, sizeY + margin);

    }

}
