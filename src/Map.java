import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class Map {
    int width;
    int num_mine;
    int[][] mineMap;
    int[][] displayMap;
    HashMap<Integer, Integer> minePosition;

    public Map(int width, int num_mine) {
        // 맵 크기 & 지뢰 개수 초기화
        this.width = width;
        this.num_mine = num_mine;

        // mineMap 2차원 배열 생성 (지뢰 유무 표시 맵)
        mineMap = new int[width][width];
        // displayMap 2차원 배열 생성 (게임 플레이용)
        displayMap = new int[width][width];
        for (int i=0; i<width*width; i++) {
            mineMap[i/width][i%width] = 0;
            displayMap[i/width][i%width] = 0;
        }

        // create mines
        Random r = new Random();    // 난수
        minePosition = new HashMap<>(); // HashMap 타입 객체 생성
        // 지뢰 개수만큼 반복문을 돌면서 minePostion 에 지뢰 위치를 초기화.
        for (int i = 0; i < num_mine; i++) {
            int position = r.nextInt(width * width);    // 지뢰 위를치 난수로 추첨
            while (minePosition.containsValue(position))   // check repetition
                position = r.nextInt(width * width);    // 이미 해당 위치에 지뢰가 있다면 다시 추첨
            minePosition.put(i, position);      // i 번째 인덱스 (key) : 지뢰위치 (value)    => why??
        }

        // deploy mines
        for (int i = 0; i < num_mine; i++) {
            int x = minePosition.get(i) / width;
            int y = minePosition.get(i) % width;
            System.out.println(x+", "+y);
            mineMap[x][y] = 1;
        }

        printMap(mineMap);
        printMap(displayMap);

    }

    public int checkMine(int x, int y) {
        int pos = (x*width) + y;

        if (minePosition.containsValue(pos)) {
            System.out.println("   Find mine at ("+x+", "+y+")");
            return pos;
        }
        else {
            System.out.println("   No mine at ("+x+", "+y+")");
            return -1;
        }

    }

    public void printMap(int[][] a) {
        System.out.println();
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i][0]);
            for (int j = 1; j < a[0].length; j++)
                System.out.print(" " + a[i][j]);
            System.out.println();
        }
    }

    public void updateMap(int x, int y) {
        displayMap[x][y]=1;
        printMap(displayMap);
    }



}
