package com.view;

import com.util.Util;

import javax.swing.*;
import java.awt.*;

public class PlayerSettingPanel extends JPanel {
    //图形化标签
    private JLabel levelLable=new JLabel("Select game level");
    private JLabel moveSpeedLable=new JLabel("Set speed");
    private JLabel bulletSpeedLable=new JLabel("Set bulet speed");
    private JLabel enemyMountLable=new JLabel("Set enemy mount");
    //按键
    private JRadioButton normal = new JRadioButton("Nomal game", true);
    private JRadioButton customize = new JRadioButton("Customize");

    private ButtonGroup buttonGroup=new ButtonGroup();
    private JButton confirmButton=new JButton(Util.confirm);
    private JButton cancelButton=new JButton(Util.cancel);

    private JTextField enemyMountField=new JTextField();


    //生成设置选项
    String[] levelStr = { "1", "2", "3" };
    private JComboBox<String> levelComboBox = new JComboBox<String>(levelStr);
    String[] moveSpeedStr = { "5", "10", "25" };
    private JComboBox<String> moveSpeedComboBox = new JComboBox<String>(moveSpeedStr);
    String[] bulletSpeedStr = { "20", "35", "45" };
    private JComboBox<String> bulletSpeedComboBox = new JComboBox<String>(bulletSpeedStr);

    public PlayerSettingPanel(){
        this.setLayout(null);
        this.setBounds(0, 0, 350, 350);

        // 添加单选框
        this.add(normal);
        normal.setBounds(60, 20, 100, 30);
        this.add(customize);
        customize.setBounds(195, 20, 100, 30);
        buttonGroup.add(normal); // 加入按钮组
        buttonGroup.add(customize); // 加入按钮组

        // 选择
        this.add(levelLable); // 选择关卡 标签文字
        levelLable.setBounds(80, 60, 100, 30);
        this.add(levelComboBox); // 选择关卡 下拉框
        levelComboBox.setBounds(180, 60, 80, 30);

        this.add(moveSpeedLable); // 坦克移动速度 标签文字
        moveSpeedLable.setBounds(80, 105, 100, 30);
        this.add(moveSpeedComboBox); // 坦克移动速度 下拉框
        moveSpeedComboBox.setBounds(180, 105, 80, 30);

        this.add(bulletSpeedLable); // 子弹飞行速度 标签文字
        bulletSpeedLable.setBounds(80, 150, 100, 30);
        this.add(bulletSpeedComboBox); // 子弹飞行速度 下拉框
        bulletSpeedComboBox.setBounds(180, 150, 80, 30);

        // 选择坦克数量
        this.add(enemyMountLable); // 坦克数量 标签文字
        enemyMountLable.setBounds(60, 210, 180, 30);
        this.add(enemyMountField); // 坦克数量 文本框
        enemyMountField.setBounds(230, 210, 80, 30);

        this.add(confirmButton); // 确定
        confirmButton.setBounds(90, 270, 70, 30);
        this.add(cancelButton); // 取消
        cancelButton.setBounds(190, 270, 70, 30);

        normal.setSelected(true); // 默认打开自定义时选中正常游戏,除选择关卡外其余皆不可选
        moveSpeedComboBox.setEnabled(false);
        bulletSpeedComboBox.setEnabled(false);
        enemyMountField.setEnabled(false);

    }




    public JLabel getLevelLable() {
        return levelLable;
    }

    public void setLevelLable(JLabel levelLable) {
        this.levelLable = levelLable;
    }

    public JLabel getMoveSpeedLable() {
        return moveSpeedLable;
    }

    public void setMoveSpeedLable(JLabel moveSpeedLable) {
        this.moveSpeedLable = moveSpeedLable;
    }

    public JLabel getBulletSpeedLable() {
        return bulletSpeedLable;
    }

    public void setBulletSpeedLable(JLabel bulletSpeedLable) {
        this.bulletSpeedLable = bulletSpeedLable;
    }

    public JLabel getEnemyMountLable() {
        return enemyMountLable;
    }

    public void setEnemyMountLable(JLabel enemyMountLable) {
        this.enemyMountLable = enemyMountLable;
    }

    public JRadioButton getNormal() {
        return normal;
    }

    public void setNormal(JRadioButton normal) {
        this.normal = normal;
    }

    public JRadioButton getCustomize() {
        return customize;
    }

    public void setCustomize(JRadioButton customize) {
        this.customize = customize;
    }

    public ButtonGroup getButtonGroup() {
        return buttonGroup;
    }

    public void setButtonGroup(ButtonGroup buttonGroup) {
        this.buttonGroup = buttonGroup;
    }

    public JButton getConfirmButton() {
        return confirmButton;
    }

    public void setConfirmButton(JButton confirmButton) {
        this.confirmButton = confirmButton;
    }

    public JButton getCancelButton() {
        return cancelButton;
    }

    public void setCancelButton(JButton cancelButton) {
        this.cancelButton = cancelButton;
    }

    public JTextField getEnemyMountField() {
        return enemyMountField;
    }

    public void setEnemyMountField(JTextField enemyMountField) {
        this.enemyMountField = enemyMountField;
    }

    public String[] getLevelStr() {
        return levelStr;
    }

    public void setLevelStr(String[] levelStr) {
        this.levelStr = levelStr;
    }

    public JComboBox<String> getLevelComboBox() {
        return levelComboBox;
    }

    public void setLevelComboBox(JComboBox<String> levelComboBox) {
        this.levelComboBox = levelComboBox;
    }

    public String[] getMoveSpeedStr() {
        return moveSpeedStr;
    }

    public void setMoveSpeedStr(String[] moveSpeedStr) {
        this.moveSpeedStr = moveSpeedStr;
    }

    public JComboBox<String> getMoveSpeedComboBox() {
        return moveSpeedComboBox;
    }

    public void setMoveSpeedComboBox(JComboBox<String> moveSpeedComboBox) {
        this.moveSpeedComboBox = moveSpeedComboBox;
    }

    public String[] getBulletSpeedStr() {
        return bulletSpeedStr;
    }

    public void setBulletSpeedStr(String[] bulletSpeedStr) {
        this.bulletSpeedStr = bulletSpeedStr;
    }

    public JComboBox<String> getBulletSpeedComboBox() {
        return bulletSpeedComboBox;
    }

    public void setBulletSpeedComboBox(JComboBox<String> bulletSpeedComboBox) {
        this.bulletSpeedComboBox = bulletSpeedComboBox;
    }


}
