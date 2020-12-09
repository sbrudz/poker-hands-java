package com.defmethod.pokerhands;

import org.junit.Before;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.PrintStream;


abstract public class PrintStreamCapturingIntegrationTest {
    private PipedInputStream inputStream;
    private PipedOutputStream outputStream;

    
    @Before
    public void beforeTest() throws IOException {
        inputStream = new PipedInputStream();
        outputStream = new PipedOutputStream(inputStream);
    }


    protected String consoleOutputAsString() {
        try {
            outputStream.flush();
            final int availableInputBytes = inputStream.available();
            final byte[] outputBytes = new byte[availableInputBytes];
            final int outputBytesRead = inputStream.read(outputBytes, 0, availableInputBytes);
            if(outputBytesRead != availableInputBytes) {
                throw new RuntimeException("Could not read all available output bytes");
            }
            return new String(outputBytes);
        } catch (IOException e) {
            throw new RuntimeException("Error", e);
        }
    }

    protected PrintStream printStreamForTest() {
        return new PrintStream(outputStream);
    }
}
