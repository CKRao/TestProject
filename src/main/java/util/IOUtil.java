package util;

import lombok.extern.slf4j.Slf4j;

import java.io.File;

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

    public static void main(String[] args) {
        //目录路径
        String path = "/home/clarkrao/test";
        listAllFIles(new File(path));
    }
}
