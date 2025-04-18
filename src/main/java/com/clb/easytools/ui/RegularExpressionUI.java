package com.clb.easytools.ui;

import com.clb.easytools.domain.RegularExample;
import com.clb.easytools.listener.action.RegularMatchListener;
import com.intellij.openapi.editor.EditorFactory;
import com.intellij.openapi.editor.EditorSettings;
import com.intellij.openapi.fileTypes.FileTypes;
import com.intellij.openapi.project.Project;
import com.intellij.ui.ColoredListCellRenderer;
import com.intellij.ui.EditorSettingsProvider;
import com.intellij.ui.EditorTextField;
import com.intellij.ui.JBColor;
import com.intellij.ui.components.JBList;
import com.intellij.util.ui.JBUI;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RegularExpressionUI {
    private JPanel panel;
    private JBList<RegularExample> list;
    private JCheckBox ignore;
    private JButton match;
    private EditorTextField textField;
    private EditorTextField regularTextField;
    private EditorTextField resultTextField;

    private Project project;

    public RegularExpressionUI(Project project) {
        this.project = project;
        this.match.addActionListener(new RegularMatchListener(textField, regularTextField, resultTextField, ignore));
    }

    @NotNull
    private ColoredListCellRenderer<RegularExample> getCellRenderer() {
        return new ColoredListCellRenderer<RegularExample>() {
            @Override
            protected void customizeCellRenderer(@NotNull JList<? extends RegularExample> list, RegularExample regularExample,
                                                 int index, boolean selected, boolean hasFocus) {
                this.append(regularExample.getName());
            }
        };
    }

    @NotNull
    private MouseAdapter selectRegularFromList() {
        return new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                RegularExample regularExample = list.getSelectedValue();
                regularTextField.setText(regularExample.getRegular());
            }
        };
    }

    public JPanel getPanel() {
        return panel;
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        this.textField = new EditorTextField(EditorFactory.getInstance().createDocument(""), project, FileTypes.PLAIN_TEXT, false, false);
        this.textField.addSettingsProvider(getEditorSettingsProvider(true));

        this.regularTextField = new EditorTextField(EditorFactory.getInstance().createDocument(""), project, FileTypes.PLAIN_TEXT, false, true);
        this.regularTextField.addSettingsProvider(getEditorSettingsProvider(false));

        this.resultTextField = new EditorTextField(EditorFactory.getInstance().createDocument(""), project, FileTypes.PLAIN_TEXT, true, false);
        this.resultTextField.addSettingsProvider(getEditorSettingsProvider(true));

        DefaultListModel<RegularExample> listMode = new DefaultListModel<>();
        RegularExample.getUsuallyRegulars().forEach(listMode::addElement);
        this.list = new JBList<>(listMode);
        list.setBorder(JBUI.Borders.customLine(JBColor.border(), 1));
        list.setCellRenderer(getCellRenderer());
        list.addMouseListener(selectRegularFromList());
    }

    @NotNull
    private EditorSettingsProvider getEditorSettingsProvider(boolean lineNumbersShown) {
        return editor -> {
            EditorSettings settings = editor.getSettings();
            settings.setIndentGuidesShown(true);
            settings.setLineNumbersShown(lineNumbersShown);
            settings.setWheelFontChangeEnabled(true);
        };
    }
}
