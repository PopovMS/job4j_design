package ru.job4j.io;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import java.io.*;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class AnalizyTest {
    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Test
    public void test() throws IOException {
        File source = folder.newFile("source.txt");
        File target = folder.newFile("target.txt");
        try (PrintWriter writerOut = new PrintWriter(source)) {
            writerOut.println("200 10:56:01\n"
                            + "200 10:57:01\n"
                            + "400 10:58:01\n"
                            + "200 10:59:01\n"
                            + "500 11:01:02\n"
                            + "200 11:02:02");
        }
        new Analizy().unavailable("./server_log.txt", target.getAbsolutePath());
        StringBuilder rsl = new StringBuilder();
        try (BufferedReader in = new BufferedReader(new FileReader(target))) {
            in.lines().forEach(rsl::append);
        }
        assertThat(rsl.toString(), is("10:58:01; 10:59:0111:01:02; 11:02:02"));
    }




}
