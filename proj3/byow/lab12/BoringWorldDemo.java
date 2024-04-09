package byow.lab12;

import byow.TileEngine.TERenderer;
import byow.TileEngine.TETile;
import byow.TileEngine.Tileset;

/**
 *  Draws a world that is mostly empty except for a small region.
 */
public class BoringWorldDemo {

    private static final int WIDTH = 60;
    private static final int HEIGHT = 30;

    public static void main(String[] args) {
        // initialize the tile rendering engine with a window of size WIDTH x HEIGHT
        //创建世界窗口
        TERenderer ter = new TERenderer();
        ter.initialize(WIDTH, HEIGHT);//根据贴图贴图大小生成像素，WIDTH个贴图宽，HEIGHT个贴图高

        // initialize tiles，初始化贴图，依旧是默认1*1，每个贴图是16 * 16像素
        TETile[][] world = new TETile[WIDTH][HEIGHT];
        for (int x = 0; x < WIDTH; x += 1) {
            for (int y = 0; y < HEIGHT; y += 1) {
                world[x][y] = Tileset.NOTHING;
            }
        }

        // fills in a block 14 tiles wide by 4 tiles tall 把部分瓦片设置成墙壁
        for (int x = 20; x < 35; x += 1) {
            for (int y = 5; y < 10; y += 1) {
                world[x][y] = Tileset.WALL;
            }
        }

        // draws the world to the screen
        ter.renderFrame(world);
    }


}
