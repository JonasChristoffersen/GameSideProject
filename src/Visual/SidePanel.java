package Visual;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class SidePanel extends Panels implements Scrollable {
    private static final String defaultTexture = "Assets/stoneWallTexture.png";
    private static final int defaultTileScale = 1;
    private static final int gap = 15; //Space between buttons
    private static final int itemWidth = 180;  //Width of buttons/items

    public SidePanel() {
        this(defaultTexture, defaultTileScale);
    }

    public SidePanel(String texturePath, int tileScale) {
        super(); // No prefixed size set
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(BorderFactory.createEmptyBorder(gap, 10, gap, 10));
        tiledBackGroundImg(texturePath, tileScale);
    }

    public void addItem(JComponent item, int height) {
        if (getComponentCount() > 0) {
            add(Box.createVerticalStrut(gap));
        }
        Dimension size = new Dimension(itemWidth, height);
        item.setPreferredSize(size);
        item.setMinimumSize(size);
        item.setMaximumSize(size);
        item.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(item);
    }

    public void addItems(List<? extends JComponent> items, int height) {
        for (JComponent item : items) {
            addItem(item, height);
        }
    }

    public JScrollPane toScrollPane() {
        JScrollPane scrollPane = new JScrollPane(this);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBorder(null);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        return scrollPane;
    }

    @Override public Dimension getPreferredScrollableViewportSize() { return getPreferredSize(); }
    @Override public int getScrollableUnitIncrement(Rectangle r, int o, int d) { return 20; }
    @Override public int getScrollableBlockIncrement(Rectangle r, int o, int d) { return r.height; }
    @Override public boolean getScrollableTracksViewportWidth() { return true; }

    @Override
    public boolean getScrollableTracksViewportHeight() {
        return getParent() instanceof JViewport
                && getParent().getHeight() > getPreferredSize().height;
    }
}