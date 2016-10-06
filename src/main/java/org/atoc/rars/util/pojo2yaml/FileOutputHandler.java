package org.atoc.rars.util.pojo2yaml;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by radu on 06.10.2016.
 */
public class FileOutputHandler extends OutputHandler {
    PrintWriter printWriter;

    public FileOutputHandler(String path) throws IOException {
        printWriter = new PrintWriter(new FileWriter(path));
    }

    @Override
    public void out(String msg) {
        printWriter.print(msg);
    }

    @Override
    public void close() {
        printWriter.flush();
        printWriter.close();
    }
}
