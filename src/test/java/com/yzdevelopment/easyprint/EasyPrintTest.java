package com.yzdevelopment.easyprint;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static com.yzdevelopment.easyprint.EasyPrint.*;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@SuppressWarnings("All")
public class EasyPrintTest {

    private ByteArrayOutputStream myOut;

    @Before
    public void setup() {
        EasyPrint.enable(true);
        myOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(myOut));
    }

    @After
    public void teardown() {
        System.setOut(System.out);
    }

    @Test
    public void test_print() {
        print(123456);

        assertThat(myOut.toString(), containsString("com.yzdevelopment.easyprint.EasyPrintTest"));
        assertThat(myOut.toString(), containsString("test_print:"));
        assertThat(myOut.toString(), containsString("123456"));
    }

    @Test
    public void test_p() {
        p("123456");

        assertThat(myOut.toString(), containsString("com.yzdevelopment.easyprint.EasyPrintTest"));
        assertThat(myOut.toString(), containsString("test_p:"));
        assertThat(myOut.toString(), containsString("123456"));
    }

    @Test
    public void test_class() {
        class SampleTestClass {
            private final int one = 1;
            private final String two = "2";

            @Override
            public String toString() {
                return "Test{" +
                        "one=" + one +
                        ", two='" + two + '\'' +
                        '}';
            }
        }

        print(new SampleTestClass());

        assertThat(myOut.toString(), containsString("com.yzdevelopment.easyprint.EasyPrintTest"));
        assertThat(myOut.toString(), containsString("test_class:"));
        assertThat(myOut.toString(), containsString("Test{one=1, two='2'}"));
    }

    @Test
    public void test_print_null() {
        print(null);

        assertThat(myOut.toString(), containsString("com.yzdevelopment.easyprint.EasyPrintTest"));
        assertThat(myOut.toString(), containsString("test_print_null:"));
        assertThat(myOut.toString(), containsString("null"));
    }

    @Test
    public void test_enable_flag() {
        EasyPrint.enable(false);
        print(123456);

        assertThat(myOut.toString(), is(""));
    }
}