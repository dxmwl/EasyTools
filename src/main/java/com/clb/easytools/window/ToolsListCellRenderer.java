package com.clb.easytools.window;

import com.clb.easytools.data.ToolsDto;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class ToolsListCellRenderer extends JPanel implements ListCellRenderer<ToolsDto> {
    private JLabel nameLabel;
    private JLabel descriptionLabel;

    public ToolsListCellRenderer() {
        setLayout(new GridBagLayout());
        setOpaque(true);

        // 创建圆角边框
        Border roundedBorder = BorderFactory.createCompoundBorder(
            BorderFactory.createEmptyBorder(5, 5, 5, 5),
            BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1, true),
                new EmptyBorder(10, 10, 10, 10)
            )
        );

        setBorder(roundedBorder);

        nameLabel = new JLabel();
        nameLabel.setFont(new Font("SimSun", Font.BOLD, 14));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        add(nameLabel, gbc);

        descriptionLabel = new JLabel();
        descriptionLabel.setFont(new Font("SimSun", Font.PLAIN, 12));
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        add(descriptionLabel, gbc);
    }

    @Override
    public Component getListCellRendererComponent(JList<? extends ToolsDto> list, ToolsDto value, int index, boolean isSelected, boolean cellHasFocus) {
        if (value != null) {
            nameLabel.setText(value.getToolName());
            descriptionLabel.setText(value.getDescription());
        } else {
            nameLabel.setText("");
            descriptionLabel.setText("");
        }

        if (isSelected) {
            setBackground(list.getSelectionBackground());
            setForeground(list.getSelectionForeground());
        } else {
            setBackground(list.getBackground());
            setForeground(list.getForeground());
        }

        return this;
    }
}
