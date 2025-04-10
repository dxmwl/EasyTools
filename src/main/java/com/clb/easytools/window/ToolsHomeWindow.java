package com.clb.easytools.window;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;

import javax.swing.*;

/**
 *    author : 常利兵
 *    github : <a href="https://github.com/dxmwl">github</a>
 *    time   : 2025/4/10 23:45
 *    file   : ToolsHomeWindow.java.java
 *    desc   :
 */public class ToolsHomeWindow {
    private JPanel contentPanel;
    private JTable tools_list;

    public ToolsHomeWindow(Project project, ToolWindow toolWindow) {

    }

    public JPanel getContentPanel() {
        return contentPanel;
    }
}
