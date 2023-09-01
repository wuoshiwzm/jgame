package com.leon;

import javax.swing.*;

public class Game extends JFrame {

    public Game(){

        // 初始化界面
        initPage();

        // 初始化 菜单
        initMenu();


        this.setVisible(true);
    }

    private void initPage() {
        this.setTitle("Game page");
        this.setSize(600, 680);
        this.setAlwaysOnTop(true);
        // 居中
        this.setLocationRelativeTo(null);
        // 关闭后停止程序
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    /**
     * 初始化 菜单
     */
    private void initMenu() {
        // 菜单栏
        JMenuBar menuBar = new JMenuBar();

        // 菜单项
        JMenu fmenu = new JMenu("功能");
        JMenu aboutmenu = new JMenu("关于我们");

        // 菜单项下面的按钮
        JMenuItem replay = new JMenuItem("重新游戏");
        JMenuItem reLogin = new JMenuItem("重新登录");
        JMenuItem close = new JMenuItem("关闭");

        JMenuItem aboutus = new JMenuItem("关于我们");

        fmenu.add(replay);
        fmenu.add(reLogin);
        fmenu.add(close);

        aboutmenu.add(aboutus);

        menuBar.add(fmenu);
        menuBar.add(aboutmenu);

        this.setJMenuBar(menuBar);
    }
}
