package com.clb.easytools.actions;

import com.clb.easytools.domain.ToolkitCommand;
import com.clb.easytools.service.ToolkitCommandService;
import com.intellij.icons.AllIcons;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.Presentation;
import com.intellij.openapi.components.ServiceManager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ToolkitCommandAction extends AnAction {
    private ToolkitCommandService toolkitCommandService;
    private ToolkitCommand command;

    public ToolkitCommandAction(ToolkitCommand command) {
        this.command = command;
        this.toolkitCommandService = ServiceManager.getService(ToolkitCommandService.class);

        Presentation presentation = getTemplatePresentation();
        presentation.setText(command.getCommand(), false);
        presentation.setIcon(AllIcons.General.ExternalTools);
        presentation.setDescription(command.getDescription());
    }

    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        toolkitCommandService.execute(this.command, e.getDataContext());
    }

    @Nullable
    @Override
    public String getTemplateText() {
        return this.command.getCommand();
    }
}
