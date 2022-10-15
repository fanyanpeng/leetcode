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
        int start=0;
        int end=100;
        for(int i=70;i<=71;i++){
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
