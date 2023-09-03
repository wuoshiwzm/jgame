package com.leon;

import javax.swing.*;
import java.awt.event.*;

public class GameFrame extends JFrame {
    public GameFrame(){
        this.setTitle("Game page");
        this.setSize(600, 680);
        this.setAlwaysOnTop(true);

        // 居中
        this.setLocationRelativeTo(null);

        // 关闭后停止程序
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // 默认样式为居中  getContentPane
        this.setLayout(null);
    }

}
