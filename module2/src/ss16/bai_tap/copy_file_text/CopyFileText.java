package ss16.bai_tap.copy_file_text;

import java.util.List;

public class CopyFileText {
    public static void main(String[] args) {
        ReadAndWriteFile readAndWriteFile = new ReadAndWriteFile();
        List<Character> characters = readAndWriteFile.readFile("module2/src/ss16/bai_tap/copy_file_text/characters.txt");
        readAndWriteFile.writeFile(characters, "module2/src/ss16/bai_tap/copy_file_text/result.txt");
    }
}
