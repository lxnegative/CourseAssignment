/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kadai;

/**
 *
 * @author C0115140
 */
public class EnemyBase extends Actor{
    
    //速さ
    protected int speed;
    
    public EnemyBase(){
        super();
        
        speed = 3;
        
    }
    
    //速さの取得
    public int getSpeed(){
        return speed;
    }
    
    //速さの設定
    public void setSpeed(int s){
        this.speed = s;
    }
    
    
}
