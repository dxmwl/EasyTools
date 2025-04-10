package com.clb.easytools.window;

import com.clb.easytools.data.ToolsCenter;
import com.clb.easytools.data.ToolsDto;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.util.Arrays;
import java.util.List;

/**
 * author : 常利兵
 * github : <a href="https://github.com/dxmwl">github</a>
 * time   : 2025/4/10 23:45
 * file   : ToolsHomeWindow.java.java
 * desc   :
 */
public class ToolsHomeWindow {

    private JPanel contentPanel;
    private JList<ToolsDto> tools_list;
    private DefaultListModel<ToolsDto> listModel;

    public ToolsHomeWindow(Project project, ToolWindow toolWindow) {
        contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));

// 初始化 DefaultListModel 和 JList
        listModel = new DefaultListModel<>();
        tools_list = new JList<>(listModel);

        // 设置自定义渲染器
        tools_list.setCellRenderer(new ToolsListCellRenderer());

        // 设置 JList 的布局为 GridLayout，每行两列
        tools_list.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        tools_list.setVisibleRowCount(-1); // 显示所有行
        tools_list.setFixedCellWidth(200); // 设置每个单元格的宽度
        tools_list.setFixedCellHeight(80); // 设置每个单元格的高度

        // 将 ToolsCenter.tools 数组的内容添加到 DefaultListModel
        for (ToolsDto tool : ToolsCenter.tools) {
            listModel.addElement(tool); // 假设 ToolsDto 有一个 getName() 方法
        }

        // 添加 JList 到 JScrollPane
        JScrollPane scrollPane = new JScrollPane(tools_list);
        contentPanel.add(scrollPane);

        // 添加选择事件监听器
        tools_list.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    ToolsDto selectedValue = tools_list.getSelectedValue();
                    if (selectedValue != null) {
                        System.out.println("Selected: " + selectedValue.getToolName() + " - " + selectedValue.getDescription());
                    }
                }
            }
        });
    }

    public JPanel getContentPanel() {
        return contentPanel;
    }
}
