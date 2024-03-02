package com.github.lansheng228.ui;

import com.github.lansheng228.service.IGameAppService;
import com.github.lansheng228.ui.view.PlayerView;
import com.github.lansheng228.ui.view.TableView;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

public class AppFrame extends JFrame {
    private final JPanel mainLayout;
    private final IGameAppService appService;

    public AppFrame(IGameAppService appService) {
        this.appService = appService;

        mainLayout = new JPanel();
        setupLayout();

        showFrame();
    }

    private void showFrame() {
        setVisible(true);
        setResizable(false);
        setLocation(200, 100);
        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private void setupLayout() {
        mainLayout.setPreferredSize(new Dimension(960, 720));
        mainLayout.setBackground(new Color(30, 36, 40));
        mainLayout.setLayout(new BorderLayout());

        // This desktop app supports only dual game play
        var players = appService.getPlayerInfos();
        var playerView1 = new PlayerView(players.get(0), appService);
        var playerView2 = new PlayerView(players.get(1), appService);

        var tableView = new TableView(appService);

        mainLayout.add(playerView1, BorderLayout.SOUTH);
        mainLayout.add(tableView, BorderLayout.CENTER);
        mainLayout.add(playerView2, BorderLayout.NORTH);
        add(mainLayout);
    }
}
