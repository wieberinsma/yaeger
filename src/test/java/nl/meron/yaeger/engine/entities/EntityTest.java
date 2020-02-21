package nl.meron.yaeger.engine.entities;

import com.google.inject.Injector;
import javafx.geometry.BoundingBox;
import javafx.geometry.Bounds;
import javafx.geometry.Point2D;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Scene;
import nl.meron.yaeger.engine.Timer;
import nl.meron.yaeger.engine.entities.entity.Entity;
import nl.meron.yaeger.engine.entities.entity.Location;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class EntityTest {

    private static final double SCENE_WIDTH = 37d;
    private static final double SCENE_HEIGHT = 42d;
    private static final BoundingBox BOUNDING_BOX = new BoundingBox(0, 0, 10, 10);
    private static final Location ANCHORPOINT = new Location(0, 0);

    private Entity testEntity;
    private Node node;
    private Scene scene;

    @BeforeEach
    void setup() {
        testEntity = new TestEntity();
        node = mock(Node.class, withSettings().withoutAnnotations());
        scene = mock(Scene.class);
        ((TestEntity) testEntity).setNode(node);
    }

    @Test
    void getSceneWidthReturnsSceneWidthFromNode() {
        // Setup
        when(node.getScene()).thenReturn(scene);
        when(scene.getWidth()).thenReturn(SCENE_WIDTH);

        // Test
        double sceneWidth = testEntity.getSceneWidth();

        // Verify
        assertEquals(SCENE_WIDTH, sceneWidth);
    }

    @Test
    void getSceneHeightReturnsSceneHeightFromNode() {
        // Setup
        when(node.getScene()).thenReturn(scene);
        when(scene.getHeight()).thenReturn(SCENE_HEIGHT);

        // Test
        double sceneHeight = testEntity.getSceneHeight();

        // Verify
        assertEquals(SCENE_HEIGHT, sceneHeight);
    }

    @Test
    void setVisibleDelegatesToNode() {
        // Setup

        // Test
        testEntity.setVisible(true);

        // Verify
        verify(node).setVisible(true);
    }

    @Test
    void setCursorDelegatesToScene() {
        // Setup
        when(node.getScene()).thenReturn(scene);

        // Test
        testEntity.setCursor(Cursor.DEFAULT);

        // Verify
        verify(scene).setCursor(Cursor.DEFAULT);
    }

    @Test
    void getBoundsDelegatesToNode() {
        // Setup
        when(node.getBoundsInLocal()).thenReturn(BOUNDING_BOX);

        // Test
        Bounds entityBounds = testEntity.getBounds();

        // Verify
        assertEquals(BOUNDING_BOX, entityBounds);
    }

    @Test
    void getRightSideXDelegatesWork() {
        // Arrange
        when(node.getBoundsInLocal()).thenReturn(BOUNDING_BOX);

        // Act
        double rightSideX = testEntity.getRightX();

        // Assert
        assertEquals(ANCHORPOINT.getX() + BOUNDING_BOX.getWidth(), rightSideX);
    }

    @Test
    void getLeftSideXDelegatesWork() {
        // Arrange
        when(node.getBoundsInLocal()).thenReturn(BOUNDING_BOX);

        // Act
        double leftSideX = testEntity.getLeftX();

        // Assert
        assertEquals(ANCHORPOINT.getX(), leftSideX);
    }

    @Test
    void getBottomSideYDelegatesWork() {
        // Arrange
        when(node.getBoundsInLocal()).thenReturn(BOUNDING_BOX);

        // Act
        double bottomY = testEntity.getBottomY();

        // Assert
        assertEquals(ANCHORPOINT.getY() + BOUNDING_BOX.getHeight(), bottomY);
    }

    @Test
    void getTopSideYDelegatesWork() {
        // Arrange
        when(node.getBoundsInLocal()).thenReturn(BOUNDING_BOX);

        // Act
        double topY = testEntity.getTopY();

        // Assert
        assertEquals(ANCHORPOINT.getY(), topY);
    }


    private class TestEntity implements Entity {

        private Node node;

        @Override
        public void remove() {
            // Not required here.
        }

        @Override
        public Optional<Node> getGameNode() {
            return Optional.of(node);
        }

        @Override
        public void setX(double x) {
            // Not required here.
        }

        @Override
        public void setY(double y) {
            // Not required here.
        }

        void setNode(Node node) {
            this.node = node;
        }

        @Override
        public void init(Injector injector) {
            // Not required here.
        }

        @Override
        public List<Timer> getTimers() {
            return null;
            // Not required here.
        }
    }
}
