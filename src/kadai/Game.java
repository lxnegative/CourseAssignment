/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kadai;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Random;

/**
 *
 * @author C0115140
 */
public class Game extends BaseScene {

    private World world;

    private int count;

    private int enemyCnt;

    public Game() {

        

    }
    
    //初期化処理
    @Override
    public void Init() {
        
        world = new World();

        world.setPanel(super.getPanel());

        world.addObject(new Hero(), MyFrame.getFrameWidth() / 2, MyFrame.getFrameHeight() / 2);

        count = 0;

        enemyCnt = 200;
        
    }

    //更新処理
    @Override
    public BaseScene Update() {

        world.act();

        enemyCreate();

        count++;
        
        if(count % 1000 == 0){
            enemyCnt -= 20;
            if(enemyCnt < 10){
                enemyCnt = 10;
            }
        }
        
        if(world.getIsGameover() == true){
            return new GameOver();
        }
        
        return this;
    }
    
    //描画処理
    @Override
    public void Draw(Graphics g) {

        /*
        g.setColor(Color.red);
        g.fillRect(40, 20, 200, 120);

        g.setColor(Color.blue);
        g.drawString("Hello Java2D", x, y);
         */
        world.Draw(g);

    }
    
    //終了処理
    @Override
    public void Close() {
        super.Close();
    }

    //敵の生成
    public void enemyCreate() {

        if (count % enemyCnt == 0) {
            Random rnd = new Random();

            world.addObject(new WeakEnemy(count / 10000 + 1), MyFrame.getFrameWidth() + 50, rnd.nextInt(MyFrame.getFrameHeight() - 50) + 25);
            
        }

    }

}
