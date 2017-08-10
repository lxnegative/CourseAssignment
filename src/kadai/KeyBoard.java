/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kadai;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author C0115140
 */
public class KeyBoard implements KeyListener {
    //各矢印キーの状態を保存する変数
    private static int upKeyPressCount;
    private static int upKeyReleaseCount;

    private static int downKeyPressCount;
    private static int downKeyReleaseCount;

    private static int leftKeyPressCount;
    private static int leftKeyReleaseCount;

    private static int rightKeyPressCount;
    private static int rightKeyReleaseCount;

    public KeyBoard() {

        upKeyPressCount = 0;
        upKeyReleaseCount = 0;

        downKeyPressCount = 0;
        downKeyReleaseCount = 0;

        leftKeyPressCount = 0;
        leftKeyReleaseCount = 0;

        rightKeyPressCount = 0;
        rightKeyReleaseCount = 0;

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    //キーを押した場合の処理
    @Override
    public void keyPressed(KeyEvent e) {
        int keycode = e.getKeyCode();

        if (keycode == KeyEvent.VK_UP) {
            upKeyPressCount = 1;
            upKeyReleaseCount = 0;
        }
        if (keycode == KeyEvent.VK_DOWN) {
            downKeyPressCount = 1;
            downKeyReleaseCount = 0;
        }
        if (keycode == KeyEvent.VK_LEFT) {
            leftKeyPressCount = 1;
            leftKeyReleaseCount = 0;
        }
        if (keycode == KeyEvent.VK_RIGHT) {
            rightKeyPressCount = 1;
            rightKeyReleaseCount = 0;
        }

    }

    //キーを話した場合の処理
    @Override
    public void keyReleased(KeyEvent e) {
        int keycode = e.getKeyCode();

        if (keycode == KeyEvent.VK_UP) {
            upKeyPressCount = 0;
            upKeyReleaseCount = 1;
        }
        if (keycode == KeyEvent.VK_DOWN) {
            downKeyPressCount = 0;
            downKeyReleaseCount = 1;
        }
        if (keycode == KeyEvent.VK_LEFT) {
            leftKeyPressCount = 0;
            leftKeyReleaseCount = 1;
        }
        if (keycode == KeyEvent.VK_RIGHT) {
            rightKeyPressCount = 0;
            rightKeyReleaseCount = 1;
        }

    }
    
    //現在のキーの状況を取得する
    public static int getPushKey(int keycode){
        
        if (keycode == KeyEvent.VK_UP) {
            return upKeyPressCount;
        }
        if (keycode == KeyEvent.VK_DOWN) {
            return downKeyPressCount;
        }
        if (keycode == KeyEvent.VK_LEFT) {
            return leftKeyPressCount;
        }
        if (keycode == KeyEvent.VK_RIGHT) {
            return rightKeyPressCount;
        }
        
        return -1;
        
    }
    

}
