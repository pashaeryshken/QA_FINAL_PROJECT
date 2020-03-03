package Watchers;

import com.codeborne.selenide.Screenshots;
import io.qameta.allure.Attachment;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ScreenShooterLog implements TestWatcher {
    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        try {
            getBytes(Screenshots.getLastScreenshot().getName());
        } catch (IOException e) {
            System.err.println(e);
        }
    }
    @Attachment
    public static byte[] getBytes(String resourceName) throws IOException {
        return Files.readAllBytes(Paths.get("build/reports/tests", resourceName));
    }
}
