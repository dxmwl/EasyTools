package com.clb.easytools.service.impl;

import com.clb.easytools.domain.ToolkitCommand;
import com.clb.easytools.domain.executor.ToolkitCommandExecutor;
import com.clb.easytools.domain.executor.ToolkitCommandExecutorComposite;
import com.clb.easytools.service.ToolkitCommandService;
import com.intellij.openapi.actionSystem.DataContext;

public class ToolkitCommandServiceImpl implements ToolkitCommandService {
    private ToolkitCommandExecutor toolkitCommandExecutor = new ToolkitCommandExecutorComposite();

    @Override
    public void execute(ToolkitCommand command, DataContext dataContext) {
        toolkitCommandExecutor.execute(command, dataContext);
    }
}
