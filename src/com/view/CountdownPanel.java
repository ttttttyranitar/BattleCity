package com.view;

import com.util.Util;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class CountdownPanel extends JPanel {
    private JButton confirm_btn=new JButton(Util.confirm);
    //Jtable表头
    Object[] columnNames={"nickname","play date","score"};
    private DefaultTableModel model=new DefaultTableModel(columnNames,10);
    private JTable playerDataTable =new JTable(model);



    public CountdownPanel(){
        this.setLayout(null);
        this.setBounds(0,0,Util.GH_W,Util.GH_H);
        playerDataTable.setBounds(0,0,Util.GH_W,Util.GH_H-200);
        this.add(playerDataTable.getTableHeader(),BorderLayout.NORTH);
        this.add(playerDataTable,BorderLayout.CENTER);
        this.add(confirm_btn);
        confirm_btn.setBounds(Util.GH_W / 2-60 , Util.GH_H -120, 120, 40);
        confirm_btn.setBackground(new Color(111, 248, 240));
        confirm_btn.setFont(new java.awt.Font("华文行楷", 1, 15));


    }

    public JButton getConfirm_btn() {
        return confirm_btn;
    }

    public void setConfirm_btn(JButton confirm_btn) {
        this.confirm_btn = confirm_btn;
    }

    public JTable getPlayerDataTable() {
        return playerDataTable;
    }

    public void setPlayerDataTable(JTable playerDataTable) {
        this.playerDataTable = playerDataTable;
    }

    public DefaultTableModel getModel() {
        return model;
    }

    public void setModel(DefaultTableModel model) {
        this.model = model;
    }
}
