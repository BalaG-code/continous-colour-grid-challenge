public class javachallenge{

    public static int areaSize(int pallets[][], int x, int y){
        if(x < 0 || y < 0 || x >= pallets.length || y >= pallets[x].length){
            return 0;
        }
        if (pallets[x][y] == 0){
            return 0;
        }
        pallets[x][y] = 0;
        int size = 1;
        for (int r = x -1; r <= x + 1; r++){
            for (int  c = y - 1;  c <= y +1; c++){
                if (r != x || c != y){
                    size += areaSize(pallets, x, y);
                }
            }
        }
        return size;
    }

    public static int areaOfConnectingBlock(int pallets[][]){
        int area = 0;

        for (int x = 0; x < pallets.length; x++){
            for(int y = 0; y < pallets[x].length; y++){
                if (pallets[x][y] == 1){
                    int size = areaSize(pallets, x, y);
                    area = Math.max(size, area);
                }
            }
        }

        return area;
    }
}