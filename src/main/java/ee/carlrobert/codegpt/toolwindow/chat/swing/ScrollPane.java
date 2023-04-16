package ee.carlrobert.codegpt.toolwindow.chat.swing;

import com.intellij.ui.components.JBScrollPane;
import java.awt.Adjustable;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import javax.swing.JComponent;
import javax.swing.JScrollBar;
import javax.swing.ScrollPaneConstants;

public class ScrollPane extends JBScrollPane {

  public ScrollPane(JComponent scrollablePanel) {
    super(scrollablePanel);
    setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
    setBorder(null);
    setViewportBorder(null);
  }

  public void scrollToBottom() {
    JScrollBar verticalBar = getVerticalScrollBar();
    verticalBar.addAdjustmentListener(new AdjustmentListener() {
      public void adjustmentValueChanged(AdjustmentEvent e) {
        Adjustable adjustable = e.getAdjustable();
        adjustable.setValue(adjustable.getMaximum());
        verticalBar.removeAdjustmentListener(this);
      }
    });
  }
}