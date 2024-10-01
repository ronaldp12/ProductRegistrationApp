package com.inventario.gui;

import javax.swing.*;
import java.awt.*;
import com.inventario.model.*;

public class ProductRegistrationFrame extends JFrame {
    // Declara los componentes de la UI
    private JTextField idField;
    private JTextField nameField;
    private JTextField priceField;
    private JTextField cantField;

    public ProductRegistrationFrame() {
        setTitle("Registro de Productos");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        initComponents();
    }

    private void initComponents() {
        // Implementa la inicialización de componentes
        // Crear un panel principal
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        // Crear y agregar componentes
        JLabel idLabel = new JLabel("Id del Producto:");
        idField = new JTextField(15);
        JLabel nameLabel = new JLabel("Nombre del Producto:");
        nameField = new JTextField(15);
        JLabel priceLabel = new JLabel("Precio:");
        priceField = new JTextField(15);
        JLabel cantLabel = new JLabel("Cantidad:");
        cantField = new JTextField(15);
        JButton saveButton = new JButton("Guardar");

        // Posicionar componentes en el panel
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(idLabel, gbc);

        gbc.gridx = 1;
        panel.add(idField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(nameLabel, gbc);

        gbc.gridx = 1;
        panel.add(nameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(priceLabel, gbc);

        gbc.gridx = 1;
        panel.add(priceField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(cantLabel, gbc);

        gbc.gridx = 1;
        panel.add(cantField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        panel.add(saveButton, gbc);

        // Agregar el panel al frame
        add(panel);

        // Añadir acción al botón de guardar
        saveButton.addActionListener(e -> saveProduct());
    }
    private void saveProduct() {
        // Implementa la lógica de guardado
        // Validar los datos
        if (idField.getText().isEmpty() || nameField.getText().isEmpty() || priceField.getText().isEmpty() || cantField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            int idProduct = Integer.parseInt(idField.getText());
            String nameProduct= nameField.getText();
            double price = Double.parseDouble(priceField.getText());
            int quantity = Integer.parseInt(cantField.getText());

            // Crear un objeto de producto
            Product product = new Product(idProduct, nameProduct, price, quantity);

            JOptionPane.showMessageDialog(this, "Producto guardado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        }catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor, ingresa valores numéricos válidos para Id, Precio y Cantidad.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    }


