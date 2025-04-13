package com.clb.easytools.listener.action;

import com.clb.easytools.notification.ToolkitNotifier;
import com.clb.easytools.utils.SystemUtils;
import com.intellij.ui.EditorTextField;
import org.apache.commons.lang3.StringUtils;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * CopyContentAction
 */
public class CopyContentActionListener implements ActionListener {
    private EditorTextField editorTextField;

    public CopyContentActionListener(EditorTextField editorTextField) {
        this.editorTextField = editorTextField;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String editorContent = editorTextField.getText();

        if (StringUtils.isNotBlank(editorContent)) {
            SystemUtils.copyToClipboard(editorContent);
            ToolkitNotifier.success("Copy content to Clipboard success.");
        }
    }
}
