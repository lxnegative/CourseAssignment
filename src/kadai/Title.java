/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kadai;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author C0115140
 */
public class Title extends BaseScene {

    JButton startButton;
    JLabel titleLabel;
    
    BaseScene requestScene;

    public Title() {

    }

    //初期化処理
    @Override
    public void Init() {

        int titleLabelFontSize = 40;
        String titleLabelText = "避けゲー（仮）";
        int titleLabelTextNum = titleLabelText.length();
        int titleLabelWidth = titleLabelTextNum * titleLabelFontSize;
        int titleLabelHeight = titleLabelFontSize;

        titleLabel = GenerateLabel(MyFrame.getFrameWidth() / 2 - titleLabelWidth / 2, MyFrame.getFrameHeight() * 1 / 3 - titleLabelHeight / 2, titleLabelWidth, titleLabelHeight, titleLabelText);
        titleLabel.setFont(new Font("ＭＳ ゴシック", Font.PLAIN, titleLabelFontSize));

        add_Component(titleLabel);

        int startButtonFontSize = 20;
        String startButtonText = "Start";
        int startButtonTextNum = startButtonText.length();
        int startButtonWidth = startButtonTextNum * startButtonFontSize;
        int startButtonHeight = startButtonFontSize + 10;

        startButton = GenerateButton(MyFrame.getFrameWidth() / 2 - startButtonWidth / 2, MyFrame.getFrameHeight() * 2 / 3 - startButtonHeight / 2, startButtonWidth, startButtonHeight, startButtonText);
        startButton.setFont(new Font("ＭＳ ゴシック", Font.PLAIN, startButtonFontSize));
        startButton.setFocusPainted(false);
        startButton.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                startButtonClick(event);
            }
        }
        );

        add_Component(startButton);
        
        requestScene = null;
        
    }

    //更新処理
    @Override
    public BaseScene Update() {
        
        
        
        
        
        if(requestScene != null){
            return requestScene;
        }
        
        return this;
    }

    //描画処理
    @Override
    public void Draw(Graphics g) {
        
    }

    //終了処理
    @Override
    public void Close() {
        super.Close();
    }

    //ボタンを押した場合の処理
    public void startButtonClick(ActionEvent event) {
        requestScene = new Game();
    }

}
