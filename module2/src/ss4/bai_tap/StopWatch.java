package ss4.bai_tap;

import java.util.Scanner;

public class StopWatch {
    long startTime;
    long endTime;

    public StopWatch(long startTime, long endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public long getStartTime(long startTime) {
        return startTime;
    }

    public long getEndTime(long endTime) {
        return endTime;
    }

    public long getElapsedTime() {
        return this.endTime - this.startTime;
    }

    public static void selectionSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex])
                    minIndex = j;
                int temp = array[minIndex];
                array[minIndex] = array[i];
                array[i] = temp;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập mảng cần sắp xếp chọn: ");
        System.out.println("Nhập độ dài mảng n = ");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 10000 + 1);
        }
        System.out.println("Mảng trước khi săp xếp là: ");
        for (int y : arr) {
            System.out.print(y + "\t");
        }
        long start1 = System.currentTimeMillis();
        selectionSort(arr);
        long end1 = System.currentTimeMillis();
        StopWatch stopWatch = new StopWatch(start1, end1);
        System.out.print("\n");
        System.out.println("Thời gian bắt đầu thực thi thật toán sắp xếp chọn: " + stopWatch.getStartTime(start1));
        System.out.println("Thời gian kết thúc thực thi thật toán sắp xếp chọn: " + stopWatch.getEndTime(end1));
        System.out.println("Thời gian thực thi của thuật toán sắp xếp chọn cho " + n + " số là: " + stopWatch.getElapsedTime());
        System.out.println("Mảng sau khi săp xếp là: ");
        for (int y : arr) {
            System.out.print(y + "\t");

        }
    }
}
