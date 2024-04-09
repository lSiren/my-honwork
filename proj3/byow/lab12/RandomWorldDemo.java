package byow.lab12;

import byow.TileEngine.TERenderer;
import byow.TileEngine.TETile;
import byow.TileEngine.Tileset;

import java.util.Random;

/**
 * Draws a world that contains RANDOM tiles.
 *翻译：这段代码生成了一个大小为 50x50 的游戏世界，并在其中随机放置了墙壁、花和空白空间，然后将这个随机生成的游戏世界渲染到屏幕上。
 */
public class RandomWorldDemo {////这个类包含了生成随机游戏世界的方法和主方法。
    private static final int WIDTH = 50;//定义游戏世界的宽度
    private static final int HEIGHT = 50;//高度

    private static final long SEED = 2873123;//用于生成随机数的种子，把它定下来了，我们生成的世界就是一样的了，如果没有它，每次运行的世界都长的不一样
    private static final Random RANDOM = new Random(SEED);// Random 对象

    /**
     * Fills the given 2D array of tiles with RANDOM tiles.
     * @param tiles
     */
    public static void fillWithRandomTiles(TETile[][] tiles) {
        int height = tiles[0].length;
        int width = tiles.length;
        for (int x = 0; x < width; x += 1) {
            for (int y = 0; y < height; y += 1) {
                tiles[x][y] = randomTile();
            }
        }
    }

    /** Picks a RANDOM tile with a 33% change of being
     *  a wall, 33% chance of being a flower, and 33%
     *  chance of being empty space.
     *  翻译：这个方法用于返回一个随机的瓦片，根据随机生成的数字决定返回哪种类型的瓦片。这里有三种类型：墙壁（WALL）、花（FLOWER）和空白（NOTHING）
     */
    private static TETile randomTile() {
        int tileNum = RANDOM.nextInt(3);//返回一个大于等于 0 且小于指定边界 bound 的随机整数
        switch (tileNum) {
            case 0: return Tileset.WALL;
            case 1: return Tileset.FLOWER;
            case 2: return Tileset.NOTHING;
            default: return Tileset.NOTHING;
        }
    }

    public static void main(String[] args) {//这个方法是程序的入口点。它初始化了一个 TERenderer 对象，设置了游戏世界的大小，然后创建了一个二维数组 randomTiles，并用随机瓦片填充它，最后使用 TERenderer 对象将游戏世界渲染到屏幕上。
        TERenderer ter = new TERenderer();
        ter.initialize(WIDTH, HEIGHT);

        TETile[][] randomTiles = new TETile[WIDTH][HEIGHT];//瓦片数组大小，一个瓦片等于1*1
        fillWithRandomTiles(randomTiles);

        ter.renderFrame(randomTiles);//将游戏世界渲染到窗口上的函数
    }


}
