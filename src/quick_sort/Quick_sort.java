package quick_sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Quick_sort {

    public static void main(String[] args) {
        ArrayList<Integer> array = new ArrayList<>(List.of(8, 4, 5, 1, 3, 7, 6, 2));
        ArrayList<Integer> response = sort(array);
        for (int i : response) {
            System.out.print(i);
        }
        System.out.println();
    }

    public static ArrayList<Integer> sort(ArrayList<Integer> data) {
        //基準點
        int rPoint = data.get(0);
        int xIndex = 0;
        int yIndex = data.size() - 1;

        while (xIndex != yIndex) {
            //調整位置
            while (data.get(yIndex) >= rPoint && yIndex != xIndex) {
                yIndex--;
            }
            while (data.get(xIndex) <= rPoint && yIndex != xIndex) {
                xIndex++;
            }
            //交換
            if (xIndex != yIndex) {
                Collections.swap(data, xIndex, yIndex);
            } else {
                Collections.swap(data, 0, xIndex);
            }
        }
        ArrayList<Integer> sortData = data;
        if (data.size() > 2) {
            ArrayList<Integer> xArray = sort(new ArrayList<>(data.subList(0, xIndex)));
            //若陣列左邊為空字串則不排序
            ArrayList<Integer> yArray = new ArrayList<>();
            if (xIndex != data.size() - 1) {
                yArray = sort(new ArrayList<>(data.subList(xIndex + 1, data.size())));
            }
            //合併陣列後回傳
            xArray.add(data.get(xIndex));
            xArray.addAll(yArray);
            sortData = xArray;
        }
        return sortData;
    }
}
