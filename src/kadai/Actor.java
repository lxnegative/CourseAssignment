/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kadai;

import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author C0115140
 */
public class Actor {

    protected String ImagePath;

    private JLabel label;
    
    //角度
    private double angle;
    
    private World world;
    
    //中心座標
    private int centerX;
    private int centerY;
    
    //存在しているかどうか
    private boolean flag;

    public Actor() {

        ImagePath = "";
        
        angle = 0.0;
        
        ImageIcon icon1 = new ImageIcon(ImagePath);

        label = new JLabel(icon1); // JlabelにImageIconをセット

        label.setBounds(0, 0, icon1.getIconWidth(), icon1.getIconHeight());
        
        centerX = label.getX() + label.getWidth() / 2;
        centerY = label.getY() + label.getHeight() / 2;
        
        flag = true;

    }
    
    //更新処理を書く　各継承先でオーバーライドする
    public void act() {

    }
    
    //描画処理を書く　各継承先でオーバーライドする
    public void Draw(Graphics g){
        
    }
    
    //X位置の設定
    public void setX(int x) {
        this.label.setLocation(x - getLabel().getWidth() / 2, this.label.getY());
        centerX = label.getX() + label.getWidth() / 2;
        centerY = label.getY() + label.getHeight() / 2;
    }
    
    //Y位置の設定
    public void setY(int y) {
        this.label.setLocation(this.label.getX(), y - getLabel().getHeight() / 2);
        centerX = label.getX() + label.getWidth() / 2;
        centerY = label.getY() + label.getHeight() / 2;
    }
    
    //X位置の取得
    public int getX(){
        return centerX;
    }
    
    //Y位置の取得
    public int getY(){
        return centerY;
    }
    
    //画像の参照先の設定
    public void setImagePath(String str) {
        
        ImagePath = str;
        
        ImageIcon icon1 = new ImageIcon(ImagePath);

        label = new JLabel(icon1); // JlabelにImageIconをセット

        label.setBounds(0, 0, icon1.getIconWidth(), icon1.getIconHeight());
        
        centerX = label.getX() + label.getWidth() / 2;
        centerY = label.getY() + label.getHeight() / 2;
        
        
    }
    
    //画像の参照先の取得
    public String getImagePath() {
        return this.ImagePath;
    }
    
    //このActorのLabelの取得
    public JLabel getLabel() {
        return this.label;
    }

    //Actorを向いている方向にdistance分だけ動かす
    public void move(int distance) {
        
        double dx = Math.cos(Math.toRadians(angle)) * distance;
        double dy = Math.sin(Math.toRadians(angle)) * distance;

        this.label.setLocation(this.label.getX() + (int)dx, this.label.getY() + (int)dy);
        
        centerX = label.getX() + label.getWidth() / 2;
        centerY = label.getY() + label.getHeight() / 2;

    }
    
    //回転させる
    public void turn(double angle){
        this.angle += angle;
    }
    
    //向いている角度の設定
    public void setRotation(double angle){
        this.angle = angle;
    }
    
    //他のActorと重なっているか判定　引数にクラスを渡すとそのクラスのみ判定する
    public boolean isTouching(java.lang.Class<?> cls){
        
        boolean is;
        
        is = world.isOverLapForClass(cls,this);
        
        return is;
        
    }
    
    //他のActorと重なっているか判定し、重なっているActorのリストを返す　引数にクラスを渡すとそのクラスのみ判定する
    public <T> java.util.List<T> getIntersectingObjects(java.lang.Class<T> cls){
        
        java.util.List<T> list;
        
        list = world.OverLapListForClass(cls,this);
        
        return list;
        
    }
    
    
    
    public void setWorld(World w){
        world = w;
    }
    
    public World getWorld(){
        return this.world;
    }
    
    public void setFlag(boolean flag){
        this.flag = flag;
    }
    
    public boolean getFlag(){
        return this.flag;
    }
    

}
