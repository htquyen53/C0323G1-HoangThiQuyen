package thuat_toan_module2;

public class Exercise_4 {
    /**
     * Chương trình sửa lại xâu kí tự:
     * Cho một xâu kí tự s gồm nhiều từ. Trong đó mỗi từ sẽ được bắt đầu bởi một kí tự in hoa.
     * Vì một lí do gì đó, người ta quên chèn các khoảng trắng giữa các từ.
     * Yêu cầu
     * Hãy viết chương trình sửa lại xâu kí tự đó theo yêu cầu sau:
     * Tách các từ, và thêm 1 kí tự cách (space) giữa 2 từ liên tiếp
     * Chuyển đổi các kí tự in hoa thành kí tự in thường
     */
    public static String amendTheSentence(String s) {
        String[] arrS = s.split("");
        String newString = arrS[0];
        for (int i = 1; i < arrS.length; i++) {
            if (arrS[i] == arrS[i].toUpperCase()) {
                newString += " " + arrS[i];
            } else {
                newString += arrS[i];
            }
        } return newString.toLowerCase();
    }

    public static void main(String[] args) {
        System.out.println("Nhập chuỗi cần định dạng: ");
        String string = "HoangThiQuyenVoDichThienHa";
        System.out.println(amendTheSentence(string));
    }
}
