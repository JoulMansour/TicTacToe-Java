/**
 * Factory for building the renderer.
 */
public class RendererFactory {
    /**
     * Default constructor for the renderer factory class.
     */
    public RendererFactory() {}

    /**
     * Method to build the renderer.
     * @param type a string with the type of renderer.
     * @param size the size of the renderer.
     * @return a new renderer of the wanted type.
     */
    public static Renderer  buildRenderer(String type, int size) {
        switch(type) {
            case "void":
                return new VoidRenderer();
            case "console":
                return new ConsoleRenderer(size);
        }
        return null;
    }
}
