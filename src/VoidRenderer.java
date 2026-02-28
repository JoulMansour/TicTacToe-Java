/**
 * A renderer that does not show a board for games without
 * visual output.
 */
public class VoidRenderer implements Renderer {
    @Override
    public void renderBoard(Board board) {
        // Does nothing.
    }
}
