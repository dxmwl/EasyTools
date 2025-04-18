package com.clb.easytools.domain.executor;

import com.clb.easytools.domain.ToolkitCommand;
import com.clb.easytools.ui.URLEncodeAndDecodeUI;
import com.intellij.icons.AllIcons;
import com.intellij.openapi.actionSystem.DataContext;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.popup.JBPopup;
import com.intellij.util.ui.JBDimension;

import javax.swing.*;

public class URLEncodeAndDecodeToolkitCommandExecutor extends AbstractToolkitCommandExecutor {

    @Override
    public boolean support(ToolkitCommand command) {
        return ToolkitCommand.URLEncode.equals(command) || ToolkitCommand.URLDecode.equals(command);
    }

    @Override
    public void execute(ToolkitCommand command, DataContext dataContext) {
        Project project = getProject(dataContext);

        JPanel panel = new URLEncodeAndDecodeUI(project, command).getPanel();

        JBDimension dimension = new JBDimension(400, 300);
        JBPopup popup = createPopup(command.getDescription(), dimension, AllIcons.FileTypes.Html, panel);
        popup.show(getRelativePoint(dataContext, dimension));
    }
}
