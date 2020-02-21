package nl.meron.yaeger.engine.entities.entity.events.userinput;

import javafx.scene.Node;
import javafx.scene.input.MouseButton;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class MouseReleasedListenerTest {

    @Test
    void attachMousePressedListenerAttachesMouseListener() {
        // Setup
        var node = mock(Node.class, withSettings().withoutAnnotations());
        var mouseListeningEntity = new MouseReleasedListeningInstancee();
        mouseListeningEntity.setNode(node);

        // Test
        mouseListeningEntity.attachMouseReleasedListener();

        // Verify
        verify(node).setOnMouseReleased(any());
    }

    private class MouseReleasedListeningInstancee implements MouseReleasedListener {

        private Node node;

        @Override
        public Optional<Node> getGameNode() {
            return Optional.of(node);
        }

        void setNode(Node node) {
            this.node = node;
        }

        @Override
        public void onMouseReleased(MouseButton button) {

        }
    }
}
