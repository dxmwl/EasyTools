package com.clb.easytools.domain.executor;

import com.clb.easytools.domain.ToolkitCommand;
import com.intellij.openapi.actionSystem.DataContext;

public interface ToolkitCommandExecutor {
    boolean support(ToolkitCommand command);

    void execute(ToolkitCommand command, DataContext dataContext);
}
