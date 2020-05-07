package com.view;

import com.util.Util;

import javax.swing.*;

public class PlayerRegisterPanel extends JPanel {
    private JLabel namedLabel = new JLabel("your nickname：");
    private JLabel requireLabel = new JLabel("（2-10 letters）");

    private JTextField namedTF = new JTextField();

    private JButton confirm_btn = new JButton(Util.confirm);


    public PlayerRegisterPanel() {

        this.setLayout(null);
        this.setBounds(0, 0, 250, 150);
        // 添加标题
        this.add(namedLabel);
        namedLabel.setBounds(10, 10, 150, 30);
        // 输 入 昵 称
        this.add(namedTF);
        namedTF.setBounds(10, 40, 150, 30);
        // 添加要求
        this.add(requireLabel);
        requireLabel.setBounds(160, 40, 100, 30);

        // 添加按钮
        this.add(confirm_btn); // 确 定
        confirm_btn.setBounds(60, 90, 60, 25);

    }



    public JLabel getNamedLabel() {
        return namedLabel;
    }

    public void setNamedLabel(JLabel namedLabel) {
        this.namedLabel = namedLabel;
    }

    public JLabel getRequireLabel() {
        return requireLabel;
    }

    public void setRequireLabel(JLabel requireLabel) {
        this.requireLabel = requireLabel;
    }

    public JTextField getNamedTF() {
        return namedTF;
    }

    public void setNamedTF(JTextField namedTF) {
        this.namedTF = namedTF;
    }

    public JButton getConfirm_btn() {
        return confirm_btn;
    }

    public void setConfirm_btn(JButton confirm_btn) {
        this.confirm_btn = confirm_btn;
    }


}
