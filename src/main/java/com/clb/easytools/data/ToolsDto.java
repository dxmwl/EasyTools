package com.clb.easytools.data;

/**
 * author : 常利兵
 * github : <a href="https://github.com/dxmwl">github</a>
 * time   : 2025/4/11 0:10
 * file   : null.java
 * desc   :
 */
public class ToolsDto {

    private String toolName;
    private String description;

    public ToolsDto(String toolName, String description) {
        this.toolName = toolName;
        this.description = description;
    }

    public String getToolName() {
        return toolName;
    }

    public void setToolName(String toolName) {
        this.toolName = toolName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
