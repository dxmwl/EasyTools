package com.clb.easytools.service;

import com.clb.easytools.domain.ToolkitCommand;
import com.intellij.openapi.actionSystem.DataContext;

public interface ToolkitCommandService {
    void execute(ToolkitCommand command, DataContext dataContext);
}
