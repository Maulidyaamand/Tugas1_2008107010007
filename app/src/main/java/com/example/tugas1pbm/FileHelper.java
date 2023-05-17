package com.example.tugas1pbm;



import android.content.Context;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileHelper {
    public static void saveToFile(Context context, String data, String filePath) {
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = context.openFileOutput(filePath, Context.MODE_PRIVATE);
            fileOutputStream.write(data.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
