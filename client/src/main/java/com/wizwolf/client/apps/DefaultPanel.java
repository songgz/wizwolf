package com.wizwolf.client.apps;

import com.wizwolf.client.swing.CComboBox;
import com.wizwolf.client.swing.CLabel;
import com.wizwolf.client.swing.CPanel;

import javax.swing.*;
import java.awt.*;

public class DefaultPanel extends CPanel {
    private final CLabel roleLabel;
    private final CComboBox roleCombo;
    private final CLabel clientLabel;
    private final CComboBox clientCombo;
    private final CLabel orgLabel;
    private final CComboBox orgCombo;
    private final CLabel warehouseLabel;
    private final CComboBox warehouseCombo;
    private final GridBagLayout defaultPanelLayout;


    public DefaultPanel() {
        roleLabel = new CLabel();
        roleCombo = new CComboBox();
        clientLabel = new CLabel();
        clientCombo = new CComboBox();
        orgLabel = new CLabel();
        orgCombo = new CComboBox();
        warehouseLabel = new CLabel();
        warehouseCombo = new CComboBox();
        defaultPanelLayout = new GridBagLayout();

    }

    public void render() {
        roleLabel.setRequestFocusEnabled(false);
        roleLabel.setText("Role");
        roleLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        roleLabel.setLabelFor(roleCombo);

        clientLabel.setRequestFocusEnabled(false);
        clientLabel.setText("Client");
        clientLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        clientLabel.setLabelFor(clientCombo);

        orgLabel.setRequestFocusEnabled(false);
        orgLabel.setText("Organization");
        orgLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        orgLabel.setLabelFor(orgCombo);

        warehouseLabel.setRequestFocusEnabled(false);
        warehouseLabel.setText("Warehouse");
        warehouseLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        warehouseLabel.setLabelFor(warehouseCombo);

        setLayout(defaultPanelLayout);
        add(roleLabel, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(12, 12, 5, 5), 0, 0));
        add(roleCombo, new GridBagConstraints(1, 0, 1, 1, 1.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(12, 0, 5, 12), 0, 0));
        add(clientLabel, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(5, 12, 5, 5), 0, 0));
        add(clientCombo, new GridBagConstraints(1, 1, 1, 1, 1.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(5, 0, 5, 12), 0, 0));
        add(orgLabel, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0, GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(0, 12, 5, 5), 0, 0));
        add(orgCombo, new GridBagConstraints(1, 2, 1, 1, 1.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 5, 12), 0, 0));
        add(warehouseLabel, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0, GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(5, 12, 5, 5), 0, 0));
        add(warehouseCombo, new GridBagConstraints(1, 3, 1, 1, 1.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(5, 0, 5, 12), 0, 0));

    }

}
