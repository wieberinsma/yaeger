package nl.meron.yaeger.engine;

/**
 * A {@link Size} encapsulates the {@code width} and {@code height}.
 */
public class Size {

    private int width;
    private int height;

    /**
     * Creates a new instance of {@code Size}.
     *
     * @param width  the width of the {@code Size}
     * @param height the height of the {@code Size}
     */
    public Size(final int width, final int height) {
        this.width = width;
        this.height = height;
    }

    /**
     * @return The height the height of the {@code Size}
     */
    public int getHeight() {
        return height;
    }

    /**
     * @return The width the height of the {@code Size}
     */
    public int getWidth() {
        return width;
    }
}