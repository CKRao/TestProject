package util;

import lombok.extern.slf4j.Slf4j;

import java.io.*;

/**
 * IO工具类
 */
@Slf4j
public class IOUtil {
    public static void listAllFIles(File dir) {
        //如果目录为空或者目录不存在
        if (CommonUtil.isEmpty(dir) || !dir.exists()) {
            return;
        }
        //如果是文件
        if (dir.isFile()) {
            log.info(dir.getName());
            return;
        }
        //递归输出文件名
        for (File file : dir.listFiles()) {
            listAllFIles(file);
        }
    }

    /**
     * 使用字节流操作进行文件复制
     *
     * @param src
     * @param dist
     * @throws IOException
     */
    public static void copyFile(String src, String dist){
        FileInputStream in = null;
        FileOutputStream out = null;
        try {
            in = new FileInputStream(src);
            out =new FileOutputStream(dist);

            byte[] buffer = new byte[20 * 1024];

            // read() 最多读取 buffer.length 个字节
            // 返回的是实际读取的个数
            // 返回 -1 的时候表示读到 eof,即文件末尾
            while (in.read(buffer, 0, buffer.length) != -1) {
                out.write(buffer);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    /**
     * 逐行输出文件内容
     * @param filePath
     * @throws IOException
     */
    public static void readFileContent(String filePath) throws IOException{
        FileReader fileReader = new FileReader(filePath);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        while (CommonUtil.isNotEmpty(line = bufferedReader.readLine())) {
            log.info(line);
        }
        // 装饰者模式使得 BufferedReader 组合了一个 Reader 对象
        // 在调用 BufferedReader 的 close() 方法时会去调用 fileReader 的 close() 方法
        // 因此只要一个 close() 调用即可
        bufferedReader.close();
    }

    public static void main(String[] args) throws IOException {
        //源文件
        String src = "/home/clarkrao/ssFile/config.json";
        //复制后的文件
        String dist = "/home/clarkrao/ssFile/config_test.json";

        //复制文件
        copyFile(src,dist);
        //打印复制文件名
        listAllFIles(new File(dist));
        log.info("------file content------");
        //打印文件内容
        readFileContent(dist);
    }
}
