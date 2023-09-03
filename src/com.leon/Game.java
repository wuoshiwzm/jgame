package com.leon;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Game extends GameFrame implements KeyListener {

    // 空白方块在二维数组中的位置
    int x;
    int y;

    // 位置数组
    int[][] posArr = new int[][]{{0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}};

    // 游戏图片
    String imgDir;

    public Game() {

        // 初始化 菜单
        initMenu();

        // 初始化位置数组
        initPosArr();

        // 初始化游戏图片
        initImgDir();

        // 根据 位置数组 初始化图片
        initImage();

        this.addKeyListener(this);

        // 界面渲染
        this.setVisible(true);
    }

    private void initImage() {

        initGameImg();

        initBg();
    }

    // 添加背景
    private void initBg() {
        // 背景图片
        ImageIcon bgImg = new ImageIcon("image/background.png");
        JLabel bgLabel = new JLabel(bgImg);
        bgLabel.setBounds(40, 40, 508, 560);
        this.getContentPane().add(bgLabel);
    }

    // 添加游戏图片
    private void initGameImg() {

        // 清空图片
        this.getContentPane().removeAll();

        for (int[] ints : posArr) {
            System.out.println(Arrays.toString(ints));
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int imgId = posArr[i][j];
                // 选择图片
                ImageIcon image = new ImageIcon(imgDir + imgId + ".jpg");

                // 创建 JLabel
                JLabel label = new JLabel(image);
                label.setBounds(j * 105 + 85, i * 105 + 135, 105, 105);
                label.setBorder(new BevelBorder(BevelBorder.RAISED));

                this.getContentPane().add(label);
            }
        }
        this.getContentPane().repaint();
    }


    private void initPosArr() {

        Random r = new Random();

        ArrayList<Integer> imgNums = new ArrayList<Integer>();
        for (int i = 0; i < 16; i++) {
            imgNums.add(i);
        }
        System.out.println("imgNums" + imgNums);

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                // 获取图片编号 （随机）
                int ind = r.nextInt(imgNums.size());

                posArr[i][j] = imgNums.get(ind);
                System.out.println(imgNums.get(ind));
                if (imgNums.get(ind) == 0) {
                    x = i;
                    y = j;
                }
                imgNums.remove(ind);
            }
        }
    }


    private void initImgDir() {
        Random r = new Random();
        imgDir = "image/animal/animal" + (r.nextInt(8) + 1) + "/";
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


    @Override
    public void keyTyped(KeyEvent e) {


    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("type keyReleased::" + e.getKeyCode());

        // 左37 上38 右39 下40
        int code = e.getKeyCode();

        switch (code) {
            case 37: // 左
                if (y < 3) {
                    posArr[x][y] = posArr[x][y + 1];
                    posArr[x][y + 1] = 0;
                    // 重新加载图片
                    y++;
                    initImage();
                }

                break;

            case 38: // 上
                if (x < 3) {
                    posArr[x][y] = posArr[x + 1][y];
                    posArr[x + 1][y] = 0;
                    // 重新加载图片
                    x++;
                    initImage();
                }
                break;

            case 39: // 右
                if (y > 0) {
                    posArr[x][y] = posArr[x][y - 1];
                    posArr[x][y - 1] = 0;
                    // 重新加载图片
                    y--;
                    initImage();
                }
                break;

            case 40: // 下
                if (x > 0) {
                    posArr[x][y] = posArr[x - 1][y];
                    posArr[x - 1][y] = 0;
                    // 重新加载图片
                    x--;
                    initImage();
                }

                break;
        }
    }
}
