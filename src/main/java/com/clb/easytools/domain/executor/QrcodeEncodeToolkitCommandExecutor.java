package com.clb.easytools.domain.executor;

import com.clb.easytools.domain.ToolkitCommand;
import com.clb.easytools.ui.IPAndPhoneAddressUI;
import com.clb.easytools.ui.QrcodeEncodeUI;
import com.intellij.icons.AllIcons;
import com.intellij.openapi.actionSystem.DataContext;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.popup.JBPopup;
import com.intellij.util.ui.JBDimension;

import javax.swing.*;

public class QrcodeEncodeToolkitCommandExecutor extends AbstractToolkitCommandExecutor {
    @Override
    public boolean support(ToolkitCommand command) {
        return ToolkitCommand.QRCodeEncode.equals(command);
    }

    @Override
    public void execute(ToolkitCommand command, DataContext dataContext) {
        Project project = getProject(dataContext);

        JPanel panel = new QrcodeEncodeUI(project).getPanel();

        JBDimension dimension = new JBDimension(530, 500);
        JBPopup popup = createPopup(command.getDescription(), dimension, AllIcons.Actions.Search, panel);
        popup.show(getRelativePoint(dataContext, dimension));
    }
}
