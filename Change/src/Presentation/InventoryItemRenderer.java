package Presentation;

import java.awt.Component;
import java.util.Map.Entry;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

class InventoryItemRenderer extends InventoryItem implements ListCellRenderer {

    public InventoryItemRenderer() {
        setOpaque(true);
    }

    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        Entry<String, Integer> entry = (Entry<String, Integer>) value;
        setData(entry.getKey(), entry.getValue());
        return this;
    }
}
