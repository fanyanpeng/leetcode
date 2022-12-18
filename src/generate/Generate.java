package generate;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author fanyanpeng
 * @time 2022/4/22 3:09
 */
public class Generate {
    public  static void main(String[] args) throws IOException {
        int start=101;
        int end=120;
        for(int i=start;i<=end;i++){
            File file=new File("src/generate/classes/T"+i+".java");
            FileWriter fileWriter=new FileWriter(file);
            String content="package generate.classes;\n\n" +
                    "public class T66 {\n" +
                    "    public static void main(String[] args){\n" +
                    "        Solution66 solution=new Solution66();\n" +
                    "\n" +
                    "        System.out.println(solution);\n" +
                    "\n" +
                    "    }\n" +
                    "}\n" +
                    "\n" +
                    "class Solution66 {\n" +
                    "\n" +
                    "\n" +
                    "}";

            fileWriter.write(content.replaceAll("66",i+""));

            fileWriter.close();
        }
    }
}
