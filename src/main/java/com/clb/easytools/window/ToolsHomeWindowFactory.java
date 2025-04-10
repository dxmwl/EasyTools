package com.clb.easytools.window;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowFactory;
import com.intellij.ui.content.Content;
import com.intellij.ui.content.ContentFactory;
import org.jetbrains.annotations.NotNull;

/**
 * author : 常利兵
 * github : <a href="https://github.com/dxmwl">github</a>
 * time   : 2025/4/10 23:46
 * file   : null.java
 * desc   :
 */
public class ToolsHomeWindowFactory implements ToolWindowFactory {
    @Override
    public void createToolWindowContent(@NotNull Project project, @NotNull ToolWindow toolWindow) {
        ToolsHomeWindow toolsHomeWindow = new ToolsHomeWindow(project, toolWindow);
        ContentFactory contentFactory = ContentFactory.getInstance();
        Content content = contentFactory.createContent(toolsHomeWindow.getContentPanel(), null, false);
        toolWindow.getContentManager().addContent(content);
    }
}
