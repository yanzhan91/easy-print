package com.yzdevelopment.easyprint;

import java.util.Map;

@SuppressWarnings("All")
public final class EasyPrint {
    private EasyPrint() {}

    private static boolean showPrint = true;
    private static boolean showLineNumber = true;
    private static boolean showType = true;

    public static void enable(boolean enable) {
        EasyPrint.showPrint = enable;
    }

    public static void setShowLineNumber(boolean showLineNumber) {
        EasyPrint.showLineNumber = showLineNumber;
    }

    public static void setShowType(boolean showType) {
        EasyPrint.showType = showType;
    }

    private static boolean enabled(boolean configEnabled, String envName) {
        Map<String, String> env = System.getenv();
        return Boolean.parseBoolean(env.get(envName)) || configEnabled;
    }

    public static <T> T print(T t) {
        print(t, 3);
        return t;
    }

    public static <T> T p(T t) {
        print(t, 3);
        return t;
    }

    private static <T> void print(T t, int callerIndex) {
        if (enabled(showPrint, "easyprint.enabled")) {

            StringBuilder sb = new StringBuilder();

            if (enabled(showLineNumber, "easyprint.showLineNumber")) {
                StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
                StackTraceElement caller = stackTraceElements[callerIndex];

                sb.append(String.format("%s > %s:%s", caller.getClassName(), caller.getMethodName(), caller.getLineNumber()));
            }

            if (enabled(showType, "easyprint.showType")) {
                sb.append(" (" + t.getClass().getName() + ")");
            }

            sb.append(" - ").append(t.toString());
            System.out.println(sb.toString());
        }
    }
}
