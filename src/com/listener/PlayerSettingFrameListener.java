package com.listener;

import com.util.Util;
import com.view.PlayererSettingFrame;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class PlayerSettingFrameListener extends WindowAdapter implements WindowListener {
    private PlayererSettingFrame playererSettingFrame;

    public PlayerSettingFrameListener(PlayererSettingFrame playererSettingFrame){
        super();
        this.playererSettingFrame=playererSettingFrame;
    }

    @Override
    public void windowClosing(WindowEvent e) {
        Util.window_pause=true;
        this.playererSettingFrame.setVisible(false);
        Util.window_pause=false;
    }
}
