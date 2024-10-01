package com.inventario.model;

import javax.swing.table.AbstractTableModel;
import java.util.List;
import java.util.ArrayList;

public class ProductTableModel extends AbstractTableModel {
    private final List<Product> productList;
    private final String[] columnNames = {"ID", "Nombre", "Precio", "Cantidad"};

    public ProductTableModel() {
        this.productList = new ArrayList<>();
    }

    // Implementa los métodos requeridos (getRowCount, getColumnCount, getValueAt)
    @Override
    public int getRowCount() {
        return productList.size();  // Devuelve el número de productos
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;  // Devuelve el número de columnas
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        // Obtiene el producto en la fila correspondiente
        Product product = productList.get(rowIndex);

        // Devuelve el valor apropiado según la columna
        switch (columnIndex) {
            case 0:
                return product.getId();        // Columna ID
            case 1:
                return product.getName();      // Columna Nombre
            case 2:
                return product.getPrice();     // Columna Precio
            case 3:
                return product.getQuantity();  // Columna Cantidad
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        // Devuelve el nombre de la columna correspondiente
        return columnNames[column];
    }
    // Agrega el método addProduct
    // Método para agregar un producto a la lista
    public void addProduct(Product product) {
        // Añadir producto a la lista
        productList.add(product);

        // Notificar que una nueva fila ha sido añadida
        fireTableRowsInserted(productList.size() - 1, productList.size() - 1);
    }

    // Método para obtener el producto en una fila específica
    public Product getProductAt(int rowIndex) {
        return productList.get(rowIndex);
    }
}






