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
public class GameOver extends BaseScene {
    
    JButton returnButton;
    JLabel titleLabel;
    
    BaseScene requestScene;

    public GameOver() {

    }

    //初期化処理
    @Override
    public void Init() {

        int titleLabelFontSize = 60;
        String titleLabelText = "GameOver";
        int titleLabelTextNum = titleLabelText.length();
        int titleLabelWidth = titleLabelTextNum * titleLabelFontSize / 2;
        int titleLabelHeight = titleLabelFontSize;

        titleLabel = GenerateLabel(MyFrame.getFrameWidth() / 2 - titleLabelWidth / 2, MyFrame.getFrameHeight() * 1 / 3 - titleLabelHeight / 2, titleLabelWidth, titleLabelHeight, titleLabelText);
        titleLabel.setFont(new Font("ＭＳ ゴシック", Font.PLAIN, titleLabelFontSize));

        add_Component(titleLabel);

        int returnButtonFontSize = 20;
        String returnButtonText = "タイトルに戻る";
        int returnButtonTextNum = returnButtonText.length();
        int returnButtonWidth = (returnButtonTextNum + 3) * returnButtonFontSize;
        int returnButtonHeight = returnButtonFontSize + 10;

        returnButton = GenerateButton(MyFrame.getFrameWidth() / 2 - returnButtonWidth / 2, MyFrame.getFrameHeight() * 2 / 3 - returnButtonHeight / 2, returnButtonWidth, returnButtonHeight, returnButtonText);
        returnButton.setFont(new Font("ＭＳ ゴシック", Font.PLAIN, returnButtonFontSize));
        returnButton.setFocusPainted(false);
        returnButton.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                returnButtonClick(event);
            }
        }
        );

        add_Component(returnButton);
        
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

    //ボタンをクリックした場合の処理
    public void returnButtonClick(ActionEvent event) {
        requestScene = new Title();
    }
    
    
}