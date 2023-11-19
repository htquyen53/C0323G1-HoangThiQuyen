package ss3.audit;

public class DemoStringTypesSpeed {
    public static void main(String[] args) {
        int iterations = 10000000;

        // Sử dụng StringBuilder
        long startTime = System.currentTimeMillis();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            stringBuilder.append("Hello World");
        }
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        System.out.println("Thời gian sử dụng StringBuilder: " + duration + "ms");

        // Sử dụng StringBuffer
        startTime = System.currentTimeMillis();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            stringBuffer.append("Hello World");
        }
        endTime = System.currentTimeMillis();
        duration = endTime - startTime;
        System.out.println("Thời gian sử dụng StringBuffer: " + duration + "ms");
    }
}
