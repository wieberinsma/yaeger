package nl.meron.yaeger.engine.entities.entity;

import nl.meron.yaeger.engine.entities.entity.events.system.RemoveEntityEvent;

/**
 * A {@code Removeable} denotes an {@code Object}, most likely an {@link Entity}, that is eligible for
 * removance from its parent.
 */
public interface Removeable extends NodeProvider {

    /**
     * Perform all necessary actions to remove the entity.
     */
    void remove();

    /**
     * Send a {@link javafx.event.Event} to notify all {@code Listeners} that this {@link Removeable}
     * should be removed.
     */
    default void notifyRemove() {
        var removeEvent = new RemoveEntityEvent(this);
        getGameNode().ifPresent(node -> node.fireEvent(removeEvent));
    }
}
