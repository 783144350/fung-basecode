package fung.apache.commons.test.exec;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;
import org.junit.Test;

import java.io.IOException;

public class ExecTest {

    @Test
    public void testExec() throws IOException {
        final CommandLine cmdLine = new CommandLine("ping");
        cmdLine.addArgument("www.baidu.com");
        cmdLine.addArgument("-t");
        DefaultExecutor executor = new DefaultExecutor();
        int exitValue = executor.execute(cmdLine);
    }

    @Test
    public void testParseExec() throws IOException {
        final CommandLine cmdLine = CommandLine.parse("ping www.baidu.com");
        new DefaultExecutor().execute(cmdLine);
    }

}
